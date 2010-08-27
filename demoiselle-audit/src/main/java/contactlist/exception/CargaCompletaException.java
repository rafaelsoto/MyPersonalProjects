package contactlist.exception;

import br.gov.demoiselle.exception.ApplicationException;

@ApplicationException
@SuppressWarnings("serial")
public class CargaCompletaException extends Exception {

	public CargaCompletaException() {
		super("Nada mais para carregar");
	}
}
