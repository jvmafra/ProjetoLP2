package nucleo.classes.quartos;

/**
 * Classe que representa um objeto do tipo
 * Executivo Triplo
 * @author Hugo Gabriel
 *
 */
public class QuartoExecutivoTriplo extends Quarto{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final double VALOR_DA_DIARIA = 360.00;
	public static final int CAPACIDADE = 1;
	
	/**
	 * Cria o quarto Executivo Triplo
	 * @param numeroDoQuarto
	 * 		O numero relativo ao quarto
	 * @param camaExtra
	 * 		Boolean indicando a existencia (ou nao) de cama extra no quarto
	 * @throws Exception
	 * 		O numero do quarto deve ser sempre inteiro positivo
	 */
	public QuartoExecutivoTriplo(int numeroDoQuarto) throws Exception{
		super(numeroDoQuarto);	
	}

	/**
	 * Verifica se o quarto comporta um dado numero de pessoas
	 * @param numeroDePessoas
	 * 		Quantidade de pessoas que se deseja hospedar no quarto
	 * @return
	 * 		false, se a capacidade maxima do quarto for excedida
	 * 		true, se o quarto suportar o numero de pessoas desejado
	 */
	@Override
	public boolean isCapacidadeValida(int capacidade) {
		if (capacidade > CAPACIDADE + 1) // permite cama extra
			return false;
		return true;
	}
	


	@Override
	public boolean permiteCamaExtra() {
		return false;
	}

	
	/**
	 * Retorna o valor da diaria do quarto
	 */
	@Override
	public double valor() {
		return VALOR_DA_DIARIA * getPeriodoAtual().getNumeroDias();
	}
	
	
	/**
	 * Fornece uma representacao do quarto Executivo Simples como String
	 */
	@Override
	public String toString() {
		return  super.toString() + " - Executivo Triplo";  
				
	}
	
	/**
	 * Verifica se o quarto Executivo Triplo e um objeto dado como parametro sao iguais
	 * 
	 * Dois objetos da classe QuartoExecutivoDuplo sao iguais se possuem
	 * mesmo numero do quarto e mesmo hospede
	 * @param obj
	 * 		O objeto a ser comparado
	 * @return
	 * 		true, se os objetos forem iguais
	 */
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof QuartoExecutivoTriplo))
			return false;
		return super.equals(obj);
	}
	
	
}