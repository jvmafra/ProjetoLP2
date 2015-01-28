package classes;

/**
 * Classe que representa um quarto do tipo
 * Luxo Simples do Hotel
 * @author Hugo Gabriel
 *
 */

public class QuartoLuxoSimples extends Quarto{
	public static final double VALOR_DA_DIARIA = 520.00;
	public static final double VALOR_DA_DIARIA_COM_CAMA_EXTRA = 540.00;
	public static final int CAPACIDADE = 1;
	private boolean camaExtra;
	
	/**
	 * Cria o quarto Luxo Simples
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
	public QuartoLuxoSimples(String hospede, int numeroDoQuarto, boolean camaExtra) throws Exception{
		super(hospede, numeroDoQuarto);
		this.camaExtra = camaExtra;
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

	/**
	 * Verifica se o quarto possui uma cama extra
	 * @return
	 * 		True, se o quarto possuir cama extra
	 * 		False, se nao houver cama extra no quarto
	 */
	
	public boolean isCamaExtra() { return camaExtra; }
	
	/**
	 * Retorna o valor da diaria do quarto
	 */
	@Override
	public double valor() {
		if (camaExtra)
			return VALOR_DA_DIARIA_COM_CAMA_EXTRA;
		return VALOR_DA_DIARIA;
	}
	
	/**
	 * Fornece uma representacao do quarto Luxo Simples como String
	 */
	@Override
	public String toString() {
		return "Quarto Luxo Simples " + super.toString();
	}
	
	/**
	 * Verifica se o quarto Luxo Simples e um objeto dado como parametro sao iguais
	 * 
	 * Dois objetos da classe QuartoLuxoSimples sao iguais se possuem
	 * mesmo numero do quarto e mesmo hospede
	 * @param obj
	 * 		O objeto a ser comparado
	 * @return
	 * 		true, se os objetos forem iguais
	 */
	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof QuartoLuxoSimples))
			return false;
		return super.equals(obj);
	}

}
