package nucleo.excecoes;

public class ValorInvalidoException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ValorInvalidoException(String causa){
		super(causa);
	}

}
