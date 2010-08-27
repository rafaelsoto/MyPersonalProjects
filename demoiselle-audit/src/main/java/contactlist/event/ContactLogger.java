package contactlist.event;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PostPersist;
import javax.persistence.PostUpdate;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import contactlist.bean.Contact;

public class ContactLogger {

	@Inject
	private EntityManager entityManager;

	@PostPersist
	public void postPersist(final Object o) {

		System.out.println("ContactLogger.postPersist()");
	}

	@PostUpdate
	public void postUpdate(final Object o) {

		System.out.println("ContactLogger.postUpdate()");

		Contact contact = (Contact) this.entityManager.find(o.getClass(), ((Contact) o).getId());

		System.out.println(contact);
	}

	@PrePersist
	public void prePersist(final Object o) {

		System.out.println("ContactLogger.prePersist()");

	}

	@PreUpdate
	public void preUpdate(final Object o) {

		System.out.println("ContactLogger.preUpdate()");

	}
}
