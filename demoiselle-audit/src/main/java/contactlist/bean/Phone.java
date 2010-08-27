package contactlist.bean;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import br.gov.demoiselle.audit.AuditEntityListener;

@Entity
@SuppressWarnings("serial")
@EntityListeners(AuditEntityListener.class)
public class Phone implements Serializable {

	@Id
	@GeneratedValue
	private Long id;

	@ManyToOne
	@NotNull
	private Contact contact;

	private String number;

	@Enumerated(EnumType.STRING)
	private PhoneType type;

	public Phone() {
	}

	public Phone(final String number, final PhoneType type) {
		this.number = number;
		this.type = type;
	}

	public Contact getContact() {
		return this.contact;
	}

	public Long getId() {
		return this.id;
	}

	public String getNumber() {
		return this.number;
	}

	public PhoneType getType() {
		return this.type;
	}

	public void setContact(final Contact contact) {
		this.contact = contact;
	}

	public void setId(final Long id) {
		this.id = id;
	}

	public void setNumber(final String number) {
		this.number = number;
	}

	public void setType(final PhoneType type) {
		this.type = type;
	}
}
