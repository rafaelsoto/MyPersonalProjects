package contactlist.persistence;

import java.util.List;

import javax.persistence.Query;

import br.gov.demoiselle.annotation.PersistenceController;
import br.gov.demoiselle.template.EntityManagerCrud;
import contactlist.bean.Contact;
import contactlist.bean.Phone;

@PersistenceController
@SuppressWarnings("serial")
public class PhoneDAO extends EntityManagerCrud<Phone> {

	@SuppressWarnings("unchecked")
	public List<Phone> find(final Contact contact) {
		Query query = createQuery("select p from Phone p where p.contact.id = :contactId");
		query.setParameter("contactId", contact.getId());

		return query.getResultList();
	}
}
