package excecoes;

public class ContratoFechadoException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ContratoFechadoException (String causa){
		super(causa);
	}
}
