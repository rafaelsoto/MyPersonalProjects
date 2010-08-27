package br.gov.demoiselle.audit;

public class ThreadLocalAuditTransactionList {

	private static ThreadLocal<AuditTransactionList> threadLocal = new ThreadLocal<AuditTransactionList>();

	public synchronized static AuditTransactionList get() {

		if (threadLocal.get() == null)
			threadLocal.set(new AuditTransactionList());

		return threadLocal.get();
	}

}
