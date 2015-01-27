package classes;

/**
 * Classe que representa um quarto do tipo
 * Luxo Triplo do Hotel
 * @author Hugo Gabriel
 *
 */

public class QuartoLuxoTriplo extends Quarto{
	public static final double VALOR_DA_DIARIA = 620.00;
	public static final int CAPACIDADE = 3;
	
	/**
	 * Cria o quarto Luxo Triplo
	 * @param hospede 	
	 * 		O nome completo do hospede deste quarto
	 * @param numeroDoQuarto
	 * 		O numero relativo ao quarto
	 * @param camaExtra
	 * 		Boolean indicando a existencia (ou nao) de cama extra no quarto
	 * @throws Exception
	 * 		O hospede deve ser identificado no minimo com nome e sobrenome
	 * 		O numero do quarto deve ser sempre inteiro positivo
	 */
	public QuartoLuxoTriplo(String hospede, int numeroDoQuarto, boolean camaExtra) throws Exception{
		super(hospede, numeroDoQuarto, camaExtra);
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
	public boolean isCapacidadeValida(int capacidade){
		if (capacidade > CAPACIDADE)
			return false;
		return true;
	}

	@Override
	public double valor() {
		return VALOR_DA_DIARIA;
	}
	
	/**
	 * Fornece uma representacao do quarto Luxo Triplo como String
	 */
	@Override
	public String toString() {
		return "Quarto Luxo Triplo " + super.toString();
	}

	/**
	 * Verifica se o quarto Luxo Triplo e um objeto dado como parametro sao iguais
	 * 
	 * Dois objetos da classe QuartoLuxoTriplo sao iguais se possuem
	 * mesmo numero do quarto e mesmo hospede
	 * @param obj
	 * 		O objeto a ser comparado
	 * @return
	 * 		true, se os objetos forem iguais
	 */
	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof QuartoLuxoTriplo))
			return false;
		return super.equals(obj);
	}
}
