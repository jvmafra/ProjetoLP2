package nucleo.excecoes;

public class TipoDeMassagensInvalidaException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public TipoDeMassagensInvalidaException(String causa){
		super(causa);
	}
}
