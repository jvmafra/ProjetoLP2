package excecoes;

public class PeriodoInvalidoException extends Exception{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PeriodoInvalidoException(String causa) {
		super(causa);
	}
}
