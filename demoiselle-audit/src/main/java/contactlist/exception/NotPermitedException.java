package contactlist.exception;

import java.util.ResourceBundle;

import br.gov.demoiselle.exception.ApplicationException;
import br.gov.demoiselle.exception.SeverityType;

@ApplicationException(rollback = true, severity = SeverityType.ERROR)
@SuppressWarnings("serial")
public class NotPermitedException extends RuntimeException {

	private ResourceBundle bundle;

	public NotPermitedException(final ResourceBundle bundle) {
		this.bundle = bundle;
	}

	@Override
	public String getMessage() {
		return this.bundle.getString("error.NotPermited");
	}
}
