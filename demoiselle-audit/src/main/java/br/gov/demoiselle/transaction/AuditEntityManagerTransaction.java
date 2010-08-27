package br.gov.demoiselle.transaction;

import javax.enterprise.inject.Alternative;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.Status;
import javax.transaction.SystemException;

@Alternative
public class AuditEntityManagerTransaction implements Transaction {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager entityManager;

	@Override
	public void begin() throws NotSupportedException, SystemException {

		getEntityManager().getTransaction().begin();

	}

	@Override
	public void commit() throws RollbackException, HeuristicMixedException, HeuristicRollbackException,
			SecurityException, IllegalStateException, SystemException {
		getEntityManager().getTransaction().commit();

	}

	protected EntityManager getEntityManager() {
		return this.entityManager;
	}

	@Override
	public int getStatus() throws SystemException {
		int result = Status.STATUS_NO_TRANSACTION;

		if (getEntityManager().getTransaction().isActive()) {
			result = Status.STATUS_ACTIVE;
		}

		return result;
	}

	@Override
	public boolean isActive() throws SystemException {
		return getEntityManager().getTransaction().isActive();
	}

	@Override
	public boolean isMarkedRollback() throws SystemException {
		return getEntityManager().getTransaction().getRollbackOnly();
	}

	@Override
	public void rollback() throws IllegalStateException, SecurityException, SystemException {
		getEntityManager().clear();
		getEntityManager().getTransaction().rollback();
	}

	@Override
	public void setRollbackOnly() throws IllegalStateException, SystemException {
		getEntityManager().getTransaction().setRollbackOnly();
	}

	@Override
	public void setTransactionTimeout(final int seconds) throws SystemException {
		throw new SystemException("Operation not supported");
	}
}
