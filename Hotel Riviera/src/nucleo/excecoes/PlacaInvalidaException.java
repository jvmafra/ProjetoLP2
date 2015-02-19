package nucleo.excecoes;


public class PlacaInvalidaException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PlacaInvalidaException (String causa){
		super(causa);
	}

}
