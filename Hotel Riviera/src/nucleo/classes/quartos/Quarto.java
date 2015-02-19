package nucleo.classes.quartos;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import nucleo.classes.hotel.Alugavel;
import nucleo.classes.hotel.Periodo;
import nucleo.classes.hotel.Servico;

/**
 * Classe abstrata que representa
 * um quarto default do Hotel
 * @author Hugo Gabriel
 *
 */
public abstract class Quarto implements Servico, Serializable, Alugavel{
	/**
	 * 
	 */
	
	private static final long serialVersionUID = 1L;
	private int numeroDoQuarto;
	private List<Periodo> periodos;
	private Periodo periodoAtual;
	boolean camaExtra;
	
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
		periodos = new ArrayList<>();
		camaExtra = false;
	}
	
	/**
	 * Busca o numero associado ao quarto
	 * @return
	 * 		O numero do quarto
	 */
	public int getNumeroDoQuarto(){ return numeroDoQuarto;	}
	
	/**
	 * Modifica o numero do quarto
	 * @throws Exception
	 * 		O numero do quarto deve ser sempre inteiro positivo
	 */
	public void setNumeroDoQuarto(int numeroDoQuarto) throws Exception {
		if (numeroDoQuarto <= 0)
			throw new Exception("Numero do Quarto invalido");
		
		this.numeroDoQuarto = numeroDoQuarto;
	}
	
	/**
	 * Verifica se o quarto possui uma cama extra
	 * @return
	 * 		True, se o quarto possuir cama extra
	 * 		False, se nao houver cama extra no quarto
	 */
	public boolean isCamaExtra() {
		return camaExtra;
	}

	
	/**
	 * Muda a cama extra de um quarto
	 * @return
	 * 		True, caso a mudanca seja feita
	 * 		False, caso o quarto nao permita a presenca de cama extra
	 */
	public boolean setCamaExtra(boolean camaExtra) {
		if (permiteCamaExtra()){
			this.camaExtra = camaExtra;
			return true;
		}
		
		return false;
	}

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
	
	/**
	 * Verifica se determinado permite uma cama extra
	 */
	public abstract boolean permiteCamaExtra();
	
	/**
	 * Adiciona um objeto do tipo Periodo na lista de periodos do quarto
	 * @param p Periodo a ser adicionado
	 * @return true se a operacao foi realizada corretamente
	 */
	public void adicionaPeriodo(Periodo p){
		periodos.add(p);
	}
	
	/**
	 * Remove um objeto do tipo periodo da lista de periodos do quarto 
	 * @param p Periodo a ser removido
	 * @return trua se a operacao foi realizada
	 */
	public void removePeriodo(Periodo p){
		periodos.remove(p);
	}
	
	/**
	 * Retorna a lista de periodos do quarto
	 */
	public List<Periodo> getPeriodos(){
		return periodos;
	}

	
	/** Modifica o periodo atual do quarto  */
	public void setPeriodoAtual(Periodo periodo){
		this.periodoAtual = periodo;
	}
	
	/**
	 * Retorna o periodo atual do quarto
	 */
	public Periodo getPeriodoAtual() {
		return periodoAtual;
	}

	/**
	 * Fornece uma representacao do quarto como String
	 */
	@Override
	public String toString() {
		return "N: " + getNumeroDoQuarto();
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