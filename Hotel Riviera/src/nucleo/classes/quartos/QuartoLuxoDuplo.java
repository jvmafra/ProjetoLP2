package nucleo.classes.quartos;

import java.util.ArrayList;
import java.util.List;

import nucleo.classes.hotel.Periodo;

/**
 * Classe que representa um quarto do tipo
 * Luxo Duplo do Hotel
 * @author Hugo Gabriel
 *
 */

public class QuartoLuxoDuplo extends Quarto{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final double VALOR_DA_DIARIA = 570.00;
	public static final double VALOR_DA_DIARIA_COM_CAMA_EXTRA = 590.00;
	public static final int CAPACIDADE = 2;
	
	/**
	 * Cria o quarto Luxo Duplo
	 * @param numeroDoQuarto
	 * 		O numero relativo ao quarto
	 * @param camaExtra
	 * 		Boolean indicando a existencia (ou nao) de cama extra no quarto
	 * @throws Exception
	 * 		O numero do quarto deve ser sempre inteiro positivo
	 */
	public QuartoLuxoDuplo(int numeroDoQuarto) throws Exception{
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
		return true;
	}

	
	/**
	 * Retorna o valor da diaria do quarto
	 */
	@Override
	public double valor() {
		if (isCamaExtra())
			return VALOR_DA_DIARIA_COM_CAMA_EXTRA * getPeriodoAtual().getNumeroDias();
		return VALOR_DA_DIARIA * getPeriodoAtual().getNumeroDias();
	}
	
	
	/**
	 * Fornece uma representacao do quarto Executivo Duplo como String
	 */
	@Override
	public String toString() {
		return  super.toString() + " - Luxo Duplo";  
				
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
		if (!(obj instanceof QuartoLuxoDuplo))
			return false;
		return super.equals(obj);
	}

}