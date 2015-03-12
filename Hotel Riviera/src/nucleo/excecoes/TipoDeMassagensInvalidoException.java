package nucleo.excecoes;

public class TipoDeMassagensInvalidoException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public TipoDeMassagensInvalidoException(String causa){
		super(causa);
	}
}
