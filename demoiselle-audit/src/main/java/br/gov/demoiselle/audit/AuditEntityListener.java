package br.gov.demoiselle.audit;

import javax.persistence.PostPersist;
import javax.persistence.PostRemove;
import javax.persistence.PostUpdate;
import javax.persistence.PrePersist;
import javax.persistence.PreRemove;
import javax.persistence.PreUpdate;

public class AuditEntityListener {

	private AuditTransactionList list = ThreadLocalAuditTransactionList.get();

	@PostPersist
	public void postPersist(final Object o) {

		this.list.add(new AuditLog(o, OperationType.CREATE));

	}

	@PostRemove
	public void postRemove(final Object o) {

		this.list.add(new AuditLog(o, OperationType.DELETE));
	}

	@PostUpdate
	public void postUpdate(final Object o) {

		this.list.add(new AuditLog(o, OperationType.UPDATE));
	}

	@PrePersist
	public void prePersist(final Object o) {

	}

	@PreRemove
	public void preRemove(final Object o) {

	}

	@PreUpdate
	public void preUpdate(final Object o) {

	}

}
