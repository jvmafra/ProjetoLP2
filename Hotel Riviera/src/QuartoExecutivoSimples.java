/**
 * Classe que representa um objeto do tipo
 * Executivo Simples
 * @author Hugo Gabriel
 *
 */
public class QuartoExecutivoSimples extends Quarto{
	public static final double VALOR_DA_DIARIA = 360.00;
	public static final int CAPACIDADE = 1;
	
	/**
	 * Cria o quarto Executivo Simples
	 * @param hospede 	
	 * 		O nome completo do hospede deste quarto
	 * @param numeroDoQuarto
	 * 		O numero relativo ao quarto
	 * @throws Exception
	 * 		O hospede deve ser identificado no minimo com nome e sobrenome
	 * 		O numero do quarto deve ser sempre inteiro positivo
	 */
	public QuartoExecutivoSimples(String hospede, int numeroDoQuarto) throws Exception{
		super(hospede, numeroDoQuarto);
		
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
	 * Fornece uma representacao do quarto Executivo Duplo como String
	 */
	@Override
	public String toString() {
		return "Quarto Executivo Simples " + super.toString();
	}

	/**
	 * Verifica se o quarto Executivo Simples e um objeto dado como parametro sao iguais
	 * 
	 * Dois objetos da classe QuartoExecutivoSimples sao iguais se possuem
	 * mesmo numero do quarto e mesmo hospede
	 * @param obj
	 * 		O objeto a ser comparado
	 * @return
	 * 		true, se os objetos forem iguais
	 */
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof QuartoExecutivoSimples))
			return false;
		return super.equals(obj);
	}
	
	
}
