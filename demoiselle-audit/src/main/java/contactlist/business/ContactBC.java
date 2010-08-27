package contactlist.business;

import java.util.List;
import java.util.ResourceBundle;

import javax.enterprise.inject.Instance;
import javax.inject.Inject;

import br.gov.demoiselle.annotation.BusinessController;
import br.gov.demoiselle.template.Crud;
import br.gov.demoiselle.transaction.Transactional;
import contactlist.bean.Birthday;
import contactlist.bean.Contact;
import contactlist.bean.Phone;
import contactlist.bean.PhoneType;
import contactlist.exception.CargaCompletaException;
import contactlist.exception.NotPermitedException;
import contactlist.persistence.ContactDAO;

@BusinessController
@SuppressWarnings("serial")
public class ContactBC implements Crud<Contact> {

	@Inject
	private Instance<ResourceBundle> bundle;

	@Inject
	private PhoneBC phoneBC;

	@Inject
	private ContactDAO dao;

	@Override
	@Transactional
	public void delete(final Object id) {
		Contact contact = load(id);

		for (Phone phone : this.phoneBC.find(contact)) {
			this.phoneBC.delete(phone.getId());
		}

		this.dao.delete(id);
	}

	@Override
	public List<Contact> findAll() {
		return this.dao.findAll();
	}

	public List<Contact> findByName(final String name) {
		return this.dao.findByName(name);
	}

	@Override
	@Transactional
	public void insert(final Contact contact) {
		this.dao.insert(contact);

		for (Phone phone : contact.getPhones()) {
			phone.setContact(contact);
			this.phoneBC.insert(phone);
		}
	}

	@Override
	public Contact load(final Object id) {
		Contact contact = this.dao.load(id);
		contact.setPhones(this.phoneBC.find(contact));

		return contact;
	}

	// @Load(priority = 1)
	@Transactional
	public void loadData() throws CargaCompletaException {
		boolean carregou = false;
		List<Contact> list = null;
		Contact contact;

		contact = new Contact();
		contact.setName("Cleverson Sacramento");
		list = this.dao.findByName(contact.getName());
		if (list.isEmpty()) {
			contact.setCpf("11111111111");
			contact.setBirthday(new Birthday(0, 12, 18));
			contact.addPhone(new Phone("(71) 8888-0000", PhoneType.MOBILE));
			contact.addPhone(new Phone("(71) 3333-0000", PhoneType.HOME));
			insert(contact);
			carregou = true;
		}

		contact = new Contact();
		contact.setName("Marlon Carvalho");
		list = this.dao.findByName(contact.getName());
		if (list.isEmpty()) {
			contact.setCpf("22222222222");
			contact.setBirthday(new Birthday(0, 8, 17));
			contact.addPhone(new Phone("(71) 9999-1111", PhoneType.MOBILE));
			contact.addPhone(new Phone("(71) 2121-0000", PhoneType.WORK));
			insert(contact);
			carregou = true;
		}

		if (!carregou) {
			throw new CargaCompletaException();
		}
	}

	@Transactional
	public void removeAllTelephonesFromContacts() {

		for (Contact contact : this.dao.findAll()) {

			if (contact.getPhones() != null) {

				for (Phone phone : contact.getPhones()) {

					this.phoneBC.delete(phone.getId());

				}
			}
		}

	}

	@Override
	@Transactional
	public void update(final Contact bean) {
		if (bean.getName().toLowerCase().indexOf("x") > -1) {
			throw new NotPermitedException(this.bundle.get());
		}

		this.dao.update(bean);
	}

}
