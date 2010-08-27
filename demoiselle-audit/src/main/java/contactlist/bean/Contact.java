package contactlist.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import br.gov.demoiselle.annotation.Cpf;
import br.gov.demoiselle.audit.AuditEntityListener;

@Entity
@SuppressWarnings("serial")
@EntityListeners(AuditEntityListener.class)
public class Contact implements Serializable {

	@Id
	@GeneratedValue
	private Long id;

	@NotNull
	@Size(min = 1, max = 100)
	private String name;

	@Embedded
	private Birthday birthday;

	@OneToMany(mappedBy = "contact")
	private List<Phone> phones;

	@Cpf
	private String cpf;

	public void addPhone(final Phone phone) {
		if (this.phones == null) {
			this.phones = new ArrayList<Phone>();
		}

		this.phones.add(phone);
	}

	public Birthday getBirthday() {
		return this.birthday;
	}

	public String getCpf() {
		return this.cpf;
	}

	public Long getId() {
		return this.id;
	}

	public String getName() {
		return this.name;
	}

	public List<Phone> getPhones() {
		return this.phones;
	}

	public void setBirthday(final Birthday birthday) {
		this.birthday = birthday;
	}

	public void setCpf(final String cpf) {
		this.cpf = cpf;
	}

	public void setId(final Long id) {
		this.id = id;
	}

	public void setName(final String name) {
		this.name = name;
	}

	public void setPhones(final List<Phone> phones) {
		this.phones = phones;
	}
}
