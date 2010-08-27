package contactlist.business;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import br.gov.demoiselle.annontation.AuditEntityManager;
import br.gov.demoiselle.annotation.BusinessController;
import br.gov.demoiselle.audit.appender.databaseimpl.AuditTable;

@BusinessController
public class AuditBC {

	@Inject
	@AuditEntityManager
	private EntityManager em;

	public List<AuditTable> findAll() {
		CriteriaBuilder cb = this.em.getCriteriaBuilder();
		CriteriaQuery<AuditTable> cq = cb.createQuery(AuditTable.class);
		TypedQuery<AuditTable> query = this.em.createQuery(cq);

		return query.getResultList();
	}
}
