package br.gov.demoiselle.transaction;

import javax.decorator.Decorator;
import javax.decorator.Delegate;
import javax.enterprise.inject.Any;
import javax.inject.Inject;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;

import br.gov.demoiselle.audit.ThreadLocalAuditTransactionList;
import br.gov.demoiselle.audit.appender.AuditAppender;

@Decorator
public abstract class DecoratorAuditTransaction implements Transaction {

	private static final long serialVersionUID = 1L;

	@Inject
	@Delegate
	@Any
	private Transaction transaction;

	@Inject
	private AuditAppender appender;

	@Override
	public void begin() throws NotSupportedException, SystemException {

		this.transaction.begin();

		ThreadLocalAuditTransactionList.get().init();

	}

	@Override
	public void commit() throws RollbackException, HeuristicMixedException, HeuristicRollbackException,
			SecurityException, IllegalStateException, SystemException {

		this.transaction.commit();

		ThreadLocalAuditTransactionList.get().processAuditLog(this.appender);

	}

	@Override
	public void rollback() throws IllegalStateException, SecurityException, SystemException {

		this.transaction.rollback();

		ThreadLocalAuditTransactionList.get().clear();

	}

}
