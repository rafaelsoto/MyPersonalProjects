package contactlist.managedbean;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.SystemException;

import br.gov.demoiselle.annotation.ViewController;
import br.gov.demoiselle.template.AbstractListPageBean;
import br.gov.demoiselle.transaction.Transaction;
import br.gov.demoiselle.transaction.Transactional;
import contactlist.bean.Contact;
import contactlist.business.ContactBC;
import contactlist.exception.CargaCompletaException;

@ViewController
@SuppressWarnings("serial")
public class ContactListMB extends AbstractListPageBean<Contact> {

	@Inject
	private ContactBC bc;

	@Inject
	private Transaction transaction;

	@Transactional
	public void carga() throws CargaCompletaException {
		this.bc.loadData();
		clear();
	}

	@Transactional
	public void cargaComRollBack() throws IllegalStateException, SecurityException, SystemException,
			CargaCompletaException {
		this.bc.loadData();
		clear();

		this.transaction.rollback();
	}

	@Override
	protected List<Contact> handleResultList() {
		return this.bc.findAll();
	}

	@Transactional
	public void clearTelephones() {

		this.bc.removeAllTelephonesFromContacts();
	}

}
