package nucleo.classes.quartos;

import java.util.ArrayList;
import java.util.List;

import nucleo.classes.hotel.Periodo;

/**
 * Classe que representa um quarto do tipo
 * Luxo Triplo do Hotel
 * @author Hugo Gabriel
 *
 */

public class QuartoLuxoTriplo extends Quarto{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final double VALOR_DA_DIARIA = 620.00;
	public static final int CAPACIDADE = 3;
	
	/**
	 * Cria o quarto Luxo Triplo
	 * @param numeroDoQuarto
	 * 		O numero relativo ao quarto
	 * @param camaExtra
	 * 		Boolean indicando a existencia (ou nao) de cama extra no quarto
	 * @throws Exception
	 * 		O numero do quarto deve ser sempre inteiro positivo
	 */
	public QuartoLuxoTriplo(int numeroDoQuarto) throws Exception{
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
		if (capacidade > CAPACIDADE)
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
	 * Fornece uma representacao do quarto Luxo Triplo como String
	 */
	@Override
	public String toString() {
		return  super.toString() + " - Luxo Triplo";  
				
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
		if (!(obj instanceof QuartoLuxoTriplo))
			return false;
		return super.equals(obj);
	}
}