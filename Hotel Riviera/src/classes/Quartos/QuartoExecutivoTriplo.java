package classes.Quartos;

import java.util.ArrayList;
import java.util.List;

import classes.HotelOpiniaoServicosPeriodo.Periodo;

/**
 * Classe que representa um quarto do tipo
 * Executivo Triplo do Hotel
 * @author Hugo Gabriel
 *
 */
public class QuartoExecutivoTriplo extends Quarto{
	public static final double VALOR_DA_DIARIA = 440.00;
	public static final int CAPACIDADE = 3;
	private List<Periodo> periodos = new ArrayList<>();
	
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
	public boolean isCapacidadeValida(int capacidade){
		if (capacidade > CAPACIDADE)
			return false;
		return true;
	}
	
	
	/**
	 * Retorna o valor da diaria do quarto
	 */
	@Override
	public double valor() {
		return VALOR_DA_DIARIA;
	}
	
	/**
	 * Adiciona um objeto do tipo Periodo na lista de periodos do quarto
	 * @param p Periodo a ser adicionado
	 * @return true se a operacao foi realizada corretamente
	 */
	public boolean adicionaPeriodo(Periodo p) {
		return periodos.add(p);
		
	}
	/**
	 * Remove um objeto do tipo periodo da lista de periodos do quarto 
	 * @param p Periodo a ser removido
	 * @return trua se a operacao foi realizada
	 */
	public boolean removePeriodo(Periodo p){
		return periodos.remove(p);
				
	}
	
	/**
	 * Fornece uma representacao do quarto Executivo Triplo como String
	 */
	@Override
	public String toString() {
		return super.toString() + " - Executivo Triplo";
	}

	/**
	 * Verifica se o quarto Executivo Triplo e um objeto dado como parametro sao iguais
	 * 
	 * Dois objetos da classe QuartoExecutivoTriplo sao iguais se possuem
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
	
	@Override
	public List<Periodo> getPeriodos() {
		return periodos;
	}
}
