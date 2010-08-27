package br.gov.demoiselle.audit.appender.databaseimpl;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Revision {

	@Id
	@GeneratedValue
	private long id;

	@Temporal(TemporalType.TIMESTAMP)
	private Date revisionTimeStamp;

	public long getId() {
		return this.id;
	}

	public Date getRevisionTimeStamp() {
		return this.revisionTimeStamp;
	}

	public void setId(final long id) {
		this.id = id;
	}

	public void setRevisionTimeStamp(final Date revisionTimeStamp) {
		this.revisionTimeStamp = revisionTimeStamp;
	}

}
