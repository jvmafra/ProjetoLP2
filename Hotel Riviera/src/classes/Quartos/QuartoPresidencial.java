package classes.Quartos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import classes.HotelOpiniaoServicosPeriodo.Periodo;

/**
 * Classe que representa um Quarto Presidencial
 * @author Hugo Gabriel
 *
 */
public class QuartoPresidencial extends Quarto{
	public static final double VALOR_DA_DIARIA = 1200.00;
	public static final int CAPACIDADE = 4;
	private List<Periodo> periodos = new ArrayList<>();
	
	/**
	 * Cria o quarto Presidencial
	 * @param numeroDoQuarto
	 * 		O numero relativo ao quarto
	 * @throws Exception
	 * 		O numero do quarto deve ser sempre inteiro positivo
	 */
	public QuartoPresidencial(int numeroDoQuarto) throws Exception{
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
	 * Fornece uma representacao do quarto Presidencial como String
	 */
	@Override
	public String toString() {
		return super.toString() + " - Presidencial";
	}
	
	/**
	 * Verifica se o quarto Presidencial e um objeto dado como parametro sao iguais
	 * 
	 * Dois objetos da classe QuartoPresidencial sao iguais se possuem
	 * mesmo numero do quarto e mesmo hospede
	 * @param obj
	 * 		O objeto a ser comparado
	 * @return
	 * 		true, se os objetos forem iguais
	 */
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof QuartoPresidencial))
			return false;
		return super.equals(obj);
	}
	
	@Override
	public List<Periodo> getPeriodos() {
		return periodos;
	}


}
