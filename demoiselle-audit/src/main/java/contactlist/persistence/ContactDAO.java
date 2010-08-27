package contactlist.persistence;

import java.util.List;

import javax.persistence.Query;

import br.gov.demoiselle.annotation.PersistenceController;
import br.gov.demoiselle.template.EntityManagerCrud;
import contactlist.bean.Contact;

@PersistenceController
@SuppressWarnings("serial")
public class ContactDAO extends EntityManagerCrud<Contact> {

	@SuppressWarnings("unchecked")
	public List<Contact> findByName(String name) {
		Query query = getEntityManager().createQuery("select c from Contact c where c.name = :name ");
		query.setParameter("name", name);

		return query.getResultList();
	}
}
