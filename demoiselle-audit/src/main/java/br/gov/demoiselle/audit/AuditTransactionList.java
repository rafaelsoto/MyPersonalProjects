package br.gov.demoiselle.audit;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;

import br.gov.demoiselle.audit.appender.AuditAppender;


public class AuditTransactionList {

	@Inject
	private Logger log;

	private List<AuditLog> list = null;

	public void add(final AuditLog auditLog) {

		this.list.add(auditLog);
	}

	public void clear() {
		this.list.clear();
	}

	public void init() {

		this.list = Collections.synchronizedList(new ArrayList<AuditLog>());

	}

	public void processAuditLog(final AuditAppender processor) {

		processor.processAuditLogList(this.list);

	}

	public Object remove() {
		return this.list.remove(0);
	}

}
