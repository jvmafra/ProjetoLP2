package nucleo.excecoes;

public class CarroInvalidoException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CarroInvalidoException(String causa){
		super(causa);
	}
}
