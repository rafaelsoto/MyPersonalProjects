package br.gov.demoiselle.audit;

import java.util.Date;

public class AuditLog {

	private Object entity;

	private OperationType operationType;

	private Date date;

	public AuditLog(final Object o, final OperationType operationType) {

		this.entity = o;
		this.operationType = operationType;
		this.date = new Date();
	}

	public Date getDate() {
		return this.date;
	}

	public Object getEntity() {
		return this.entity;
	}

	public OperationType getOperationType() {
		return this.operationType;
	}

	public void setDate(final Date date) {
		this.date = date;
	}

	public void setEntity(final Object entity) {
		this.entity = entity;
	}

	public void setOperationType(final OperationType operationType) {
		this.operationType = operationType;
	}

}
