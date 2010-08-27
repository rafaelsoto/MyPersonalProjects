package br.gov.demoiselle.audit.appender.databaseimpl;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import br.gov.demoiselle.annontation.AuditEntityManager;
import br.gov.demoiselle.audit.AuditLog;
import br.gov.demoiselle.audit.appender.AuditAppender;
import br.gov.demoiselle.exception.AuditException;

@Default
public class DatabaseAuditAppender implements AuditAppender {

	private static final long serialVersionUID = 8862367130628885251L;

	@Inject
	@AuditEntityManager
	private EntityManager em;

	private List<AuditValues> getAuditValuers(final AuditLog auditLog, final AuditTable auditTable) {

		List<AuditValues> list = new ArrayList<AuditValues>();
		AuditValues auditValues = null;

		for (Method method : auditLog.getEntity().getClass().getDeclaredMethods()) {

			if (method.getAnnotation(Transient.class) != null)
				continue;

			if (!method.getName().contains("get"))
				continue;

			auditValues = new AuditValues();
			auditValues.setAuditTable(auditTable);
			// FIXME Utilizar uma função para verificar se existe a anotação column
			auditValues.setName(method.getName());

			Object value;
			try {
				value = method.invoke(auditLog.getEntity(), null);
			} catch (Throwable e) {

				throw new AuditException("Error to invoke method " + method.getName());
			}

			if (value == null)
				auditValues.setValue(null);
			else
				auditValues.setValue(value.toString());

			list.add(auditValues);

		}

		return list;

	}

	private String getEntityIdentifier(final AuditLog auditLog) {

		Object idValue = null;

		for (Field field : auditLog.getEntity().getClass().getDeclaredFields()) {

			if (field.getAnnotation(Id.class) != null) {

				for (Method method : auditLog.getEntity().getClass().getMethods()) {

					if (method.getName().toUpperCase().contains(field.getName().toUpperCase())) {

						try {
							idValue = method.invoke(auditLog.getEntity(), null);
						} catch (Throwable e) {

							throw new AuditException("Error to invoke @Id method in "
									+ auditLog.getClass().getSimpleName() + " entity", e);
						}

						break;

					}
				}

				break;

			}
		}

		if (idValue == null) {
			for (Method method : auditLog.getEntity().getClass().getMethods()) {

				if (method.getAnnotation(Id.class) != null) {

					try {
						idValue = method.invoke(auditLog.getEntity(), null);
					} catch (Throwable e) {

						throw new AuditException("Error to invoke @Id method in " + auditLog.getClass().getSimpleName()
								+ " entity", e);
					}

					break;

				}
			}
		}

		if (idValue == null)
			throw new AuditException("Entity " + auditLog.getEntity().getClass().getSimpleName()
					+ " does not have a @Id annontation");
		else
			return idValue.toString();

	}

	private String getTableName(final AuditLog auditLog) {

		Table table = auditLog.getEntity().getClass().getAnnotation(Table.class);

		if (table == null) {
			return auditLog.getEntity().getClass().getSimpleName();
		} else {
			return table.name();
		}

	}

	@Override
	public void processAuditLogList(final List<AuditLog> logList) throws AuditException {

		List<AuditTable> auditTableList = new ArrayList<AuditTable>();

		AuditTable auditTable = null;

		this.em.getTransaction().begin();

		Revision revision = new Revision();
		revision.setRevisionTimeStamp(new Date());

		revision = this.em.merge(revision);

		try {
			for (AuditLog auditLog : logList) {

				auditTable = new AuditTable();
				auditTable.setOperation(auditLog.getOperationType());
				auditTable.setRevision(revision);
				auditTable.setTableName(getTableName(auditLog));
				auditTable.setEntityIdentifier(new Long(getEntityIdentifier(auditLog)));
				auditTable.setUser("Anonymous");
				auditTable.setValues(getAuditValuers(auditLog, auditTable));

				auditTableList.add(auditTable);

			}

			for (AuditTable auditTable2 : auditTableList) {

				auditTable2 = this.em.merge(auditTable2);

				for (AuditValues auditValue : auditTable2.getValues()) {

					this.em.persist(auditValue);

				}

			}

			this.em.getTransaction().commit();

		} catch (Throwable e) {

			this.em.getTransaction().rollback();
			throw new AuditException("Error processing audit log ", e);
		}

	}
}
