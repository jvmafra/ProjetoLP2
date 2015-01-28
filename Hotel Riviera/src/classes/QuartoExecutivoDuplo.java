package classes;

/**
 * Classe que representa um quarto do tipo
 * Executivo Duplo do Hotel
 * @author Hugo Gabriel
 *
 */
public class QuartoExecutivoDuplo extends Quarto {

	public static final double VALOR_DA_DIARIA = 385.00;
	public static final double VALOR_DA_DIARIA_COM_CAMA_EXTRA = 405.00;
	public static final int CAPACIDADE = 2;
	private boolean camaExtra;
	
	/**
	 * Cria o quarto Executivo Duplo
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
	public QuartoExecutivoDuplo(String hospede, int numeroDoQuarto, boolean camaExtra) throws Exception{
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
	public boolean isCapacidadeValida(int capacidade) {
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
	 * Fornece uma representacao do quarto Executivo Duplo como String
	 */
	@Override
	public String toString() {
		return "Quarto Executivo Duplo - Diaria = "+ VALOR_DA_DIARIA  
				+ " Capacidade Maxima" + CAPACIDADE + super.toString();
	}
	
	/**
	 * Verifica se o quarto Executivo Duplo e um objeto dado como parametro sao iguais
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
		if (!(obj instanceof QuartoExecutivoDuplo))
			return false;
		return super.equals(obj);
	}

}
