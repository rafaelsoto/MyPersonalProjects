package contactlist.managedbean;

import java.util.List;

import javax.faces.convert.LongConverter;
import javax.inject.Inject;

import br.gov.demoiselle.annotation.IdConverter;
import br.gov.demoiselle.annotation.ViewController;
import br.gov.demoiselle.audit.appender.databaseimpl.AuditTable;
import br.gov.demoiselle.template.AbstractListPageBean;
import contactlist.business.AuditBC;

@ViewController
@IdConverter(LongConverter.class)
public class AuditListMB extends AbstractListPageBean<AuditTable> {

	private static final long serialVersionUID = 1L;

	@Inject
	private AuditBC bc;

	@Override
	protected List<AuditTable> handleResultList() {
		return this.bc.findAll();
	}

}
