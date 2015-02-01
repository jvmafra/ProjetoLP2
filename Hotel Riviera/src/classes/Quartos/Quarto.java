package classes.Quartos;

import java.io.Serializable;

import classes.HotelOpiniaoServicosPeriodo.Periodo;
import classes.HotelOpiniaoServicosPeriodo.Servicos;

/**
 * Classe abstrata que representa
 * um quarto default do Hotel
 * @author Hugo Gabriel
 *
 */
public abstract class Quarto implements Servicos, Serializable{
	private int numeroDoQuarto;
	
	/**
	 * 
	 * Cria um quarto
	 * @param numeroDoQuarto
	 * 		O numero relativo ao quarto
	 * @throws Exception
	 * 		O numero do quarto deve ser sempre inteiro positivo
	 */
	public Quarto(int numeroDoQuarto) throws Exception{
		if (numeroDoQuarto <= 0)
			throw new Exception("Numero do Quarto invalido");
		this.numeroDoQuarto = numeroDoQuarto;
	}
	
	/**
	 * Busca o numero associado ao quarto
	 * @return
	 * 		O numero do quarto
	 */
	public int getNumeroDoQuarto(){ return numeroDoQuarto;	}

	/**
	 * Verifica se o quarto comporta um dado numero de pessoas
	 * @param numeroDePessoas
	 * 		Quantidade de pessoas que se deseja hospedar no quarto
	 * @return
	 * 		false, se a capacidade maxima do quarto for excedida
	 * 		true, se o quarto suportar o numero de pessoas desejado
	 */
	public abstract boolean isCapacidadeValida(int numeroDePessoas);

	/**
	 * Retorna o valor da diaria do quarto
	 */
	public abstract double valor();
	
	public abstract boolean adicionaPeriodo(Periodo p);
	
	public abstract boolean removePeriodo(Periodo p);
	
	/**
	 * Fornece uma representacao do quarto como String
	 */
	@Override
	public String toString() {
		return "[Numero do Quarto = " + numeroDoQuarto + "]";
	}
	
	/**
	 * Verifica se o quarto e um objeto dado como parametro sao iguais
	 * 
	 * Dois objetos da classe Quarto sao iguais se possuem
	 * mesmo numero do quarto
	 * @param obj
	 * 		O objeto a ser comparado
	 * @return
	 * 		true, se os objetos forem iguais
	 */
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Quarto))
			return false;
		Quarto q = (Quarto) obj;
		return getNumeroDoQuarto() == q.getNumeroDoQuarto();
	}
	
	

}