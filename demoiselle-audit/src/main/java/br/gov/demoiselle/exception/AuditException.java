package br.gov.demoiselle.exception;

public class AuditException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public AuditException() {
		super();

	}

	public AuditException(final String arg0) {
		super(arg0);

	}

	public AuditException(final String arg0, final Throwable arg1) {
		super(arg0, arg1);

	}

	public AuditException(final Throwable arg0) {
		super(arg0);

	}

}
