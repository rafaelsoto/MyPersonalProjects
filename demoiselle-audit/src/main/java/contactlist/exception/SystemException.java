package contactlist.exception;

import br.gov.demoiselle.exception.Redirect;

@Redirect(viewId = "/system_error.xhtml")
public class SystemException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public SystemException() {
		super();
	}

	public SystemException(final String arg0) {
		super(arg0);
	}

	public SystemException(final String arg0, final Throwable arg1) {
		super(arg0, arg1);
	}

	public SystemException(final Throwable arg0) {
		super(arg0);
	}

}
