package nucleo.excecoes;


public class DescricaoInvalidaException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DescricaoInvalidaException(String causa){
		super(causa);
	}
	
}
