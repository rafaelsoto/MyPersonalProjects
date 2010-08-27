package br.gov.demoiselle.audit.appender;

import java.io.Serializable;
import java.util.List;

import br.gov.demoiselle.audit.AuditLog;
import br.gov.demoiselle.exception.AuditException;

public interface AuditAppender extends Serializable {

	public void processAuditLogList(List<AuditLog> logList) throws AuditException;

}
