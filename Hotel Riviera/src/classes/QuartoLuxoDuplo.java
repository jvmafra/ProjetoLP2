package classes;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe que representa um quarto do tipo
 * Luxo Duplo do Hotel
 * @author Hugo Gabriel
 *
 */

public class QuartoLuxoDuplo extends Quarto{
	public static final double VALOR_DA_DIARIA = 570.00;
	public static final double VALOR_DA_DIARIA_COM_CAMA_EXTRA = 590.00;
	public static final int CAPACIDADE = 2;
	private boolean camaExtra;
	private List<Periodo> periodo = new ArrayList<>();
	
	/**
	 * Cria o quarto Luxo Duplo
	 * @param numeroDoQuarto
	 * 		O numero relativo ao quarto
	 * @param camaExtra
	 * 		Boolean indicando a existencia (ou nao) de cama extra no quarto
	 * @throws Exception
	 * 		O numero do quarto deve ser sempre inteiro positivo
	 */
	public QuartoLuxoDuplo(int numeroDoQuarto, boolean camaExtra) throws Exception{
		super(numeroDoQuarto);
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
	 * Adiciona um objeto do tipo Periodo na lista de periodos do quarto
	 * @param p Periodo a ser adicionado
	 * @return true se a operacao foi realizada corretamente
	 */
	public boolean adicionaPeriodo(Periodo p) {
		return periodo.add(p);
		
	}
	/**
	 * Remove um objeto do tipo periodo da lista de periodos do quarto 
	 * @param p Periodo a ser removido
	 * @return trua se a operacao foi realizada
	 */
	public boolean removePeriodo(Periodo p){
		return periodo.remove(p);
				
	}
	
	/**
	 * Fornece uma representacao do quarto Luxo Duplo como String
	 */
	@Override
	public String toString() {
		return "Quarto Luxo Duplo " + super.toString();
	}
	
	/**
	 * Verifica se o quarto Luxo Duplo e um objeto dado como parametro sao iguais
	 * 
	 * Dois objetos da classe QuartoLuxoDuplo sao iguais se possuem
	 * mesmo numero do quarto e mesmo hospede
	 * @param obj
	 * 		O objeto a ser comparado
	 * @return
	 * 		true, se os objetos forem iguais
	 */
	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof QuartoLuxoDuplo))
			return false;
		return super.equals(obj);
	}

}