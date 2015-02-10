package classes.Quartos;

import java.util.ArrayList;
import java.util.List;

import classes.HotelOpiniaoServicosPeriodo.Periodo;
/**
 * Classe que representa um objeto do tipo
 * Executivo Simples
 * @author Hugo Gabriel
 *
 */
public class QuartoExecutivoSimples extends Quarto{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final double VALOR_DA_DIARIA = 360.00;
	public static final double VALOR_DA_DIARIA_COM_CAMA_EXTRA = 380.00;
	public static final int CAPACIDADE = 1;
	
	/**
	 * Cria o quarto Executivo Simples
	 * @param numeroDoQuarto
	 * 		O numero relativo ao quarto
	 * @param camaExtra
	 * 		Boolean indicando a existencia (ou nao) de cama extra no quarto
	 * @throws Exception
	 * 		O numero do quarto deve ser sempre inteiro positivo
	 */
	public QuartoExecutivoSimples(int numeroDoQuarto) throws Exception{
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
	 * Fornece uma representacao do quarto Executivo Simples como String
	 */
	@Override
	public String toString() {
		return  super.toString() + " - Executivo Simples";  
				
	}
	
	/**
	 * Verifica se o quarto Executivo Simples e um objeto dado como parametro sao iguais
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
		if (!(obj instanceof QuartoExecutivoSimples))
			return false;
		return super.equals(obj);
	}
	
	
}