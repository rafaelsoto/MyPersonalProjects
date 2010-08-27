package br.gov.demoiselle.audit.appender.databaseimpl;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import br.gov.demoiselle.audit.OperationType;

@Entity
public class AuditTable {

	@Id
	@GeneratedValue
	private long id;

	private long entityIdentifier;

	private String tableName;

	@Enumerated(EnumType.STRING)
	private OperationType operation;

	private Revision revision;

	@OneToMany(mappedBy = "auditTable")
	private List<AuditValues> values;

	private String user;

	public long getEntityIdentifier() {
		return this.entityIdentifier;
	}

	public long getId() {
		return this.id;
	}

	public OperationType getOperation() {
		return this.operation;
	}

	public Revision getRevision() {
		return this.revision;
	}

	public String getTableName() {
		return this.tableName;
	}

	public String getUser() {
		return this.user;
	}

	public List<AuditValues> getValues() {
		return this.values;
	}

	public void setEntityIdentifier(final long entityIdentifier) {
		this.entityIdentifier = entityIdentifier;
	}

	public void setId(final long id) {
		this.id = id;
	}

	public void setOperation(final OperationType operation) {
		this.operation = operation;
	}

	public void setRevision(final Revision revision) {
		this.revision = revision;
	}

	public void setTableName(final String tableName) {
		this.tableName = tableName;
	}

	public void setUser(final String user) {
		this.user = user;
	}

	public void setValues(final List<AuditValues> values) {
		this.values = values;
	}

}
