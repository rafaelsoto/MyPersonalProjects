package contactlist.business;

import java.util.List;

import br.gov.demoiselle.template.DelegateCrud;
import contactlist.bean.Contact;
import contactlist.bean.Phone;
import contactlist.persistence.PhoneDAO;

@SuppressWarnings("serial")
public class PhoneBC extends DelegateCrud<Phone, PhoneDAO> {

	public List<Phone> find(final Contact contact) {
		return getDelegate().find(contact);
	}
}
