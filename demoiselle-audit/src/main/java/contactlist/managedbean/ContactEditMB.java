package contactlist.managedbean;

import javax.faces.convert.LongConverter;
import javax.inject.Inject;

import br.gov.demoiselle.annotation.IdConverter;
import br.gov.demoiselle.annotation.ViewController;
import br.gov.demoiselle.template.AbstractEditPageBean;
import contactlist.bean.Contact;
import contactlist.business.ContactBC;

@ViewController
@SuppressWarnings("serial")
@IdConverter(LongConverter.class)
public class ContactEditMB extends AbstractEditPageBean<Contact> {

	// @Inject
	// private ResourceBundle resourceBundle;

	@Inject
	private ContactBC contactBC;

	@Override
	public String getCurrentView() {
		return "/contact_edit.xhtml";
	}

	@Override
	public String getPreviousView() {
		return "/contact_list.xhtml";
	}

	@Override
	protected String handleDelete() {
		this.contactBC.delete(getId());
		return getPreviousView();
	}

	@Override
	protected String handleInsert() {
		this.contactBC.insert(getBean());
		return getPreviousView();
	}

	@Override
	protected Contact handleLoad() {
		return this.contactBC.load(getId());
	}

	@Override
	protected String handleUpdate() {
		this.contactBC.update(getBean());
		return getPreviousView();
	}

	// @Override
	// public String handleUnexpectedException(Throwable unexpected) {
	// String error = resourceBundle.getString("system.error");
	// getFacesContext().addMessage(null, new FacesMessage(error));
	// return "/contact_edit.xhtml";
	// }

}
