package nucleo.excecoes;

public class BabaInvalidaException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public BabaInvalidaException(String causa){
		super(causa);
	}

}
