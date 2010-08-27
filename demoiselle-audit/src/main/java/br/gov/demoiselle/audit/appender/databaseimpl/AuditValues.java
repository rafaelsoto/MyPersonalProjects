package br.gov.demoiselle.audit.appender.databaseimpl;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class AuditValues {

	@Id
	@GeneratedValue
	private Long id;

	private String name;

	private String value;

	private AuditTable auditTable;

	public AuditTable getAuditTable() {
		return this.auditTable;
	}

	public Long getId() {
		return this.id;
	}

	public String getName() {
		return this.name;
	}

	public String getValue() {
		return this.value;
	}

	public void setAuditTable(final AuditTable auditTable) {
		this.auditTable = auditTable;
	}

	public void setId(final Long id) {
		this.id = id;
	}

	public void setName(final String name) {
		this.name = name;
	}

	public void setValue(final String value) {
		this.value = value;
	}

}
