package nucleo.classes.servicos;

import java.io.Serializable;
import java.util.Calendar;

import nucleo.classes.hotel.Servico;
import nucleo.excecoes.PeriodoInvalidoException;
import nucleo.excecoes.ValorInvalidoException;

/**
 * Serviço de refeicao, que tem que receber uma data e um valor
 * Implementa a interface servicos, tendo portanto um valor a ser adicionado ao montante
 * do hospede
 * 
 * @author Adiel Andrade
 *
 */

public class Refeicao implements Servico, Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private double valor;
	private Calendar data;
	
	/**
	 * Construtor da calsse Refeicao Que recebe um valor e uma data
	 * @param valor
	 * 		valor da refeicao feita
	 * @param data
	 * 		data a qual foi feita a refeicao
	 * @throws ValorInvalidoException 
	 * 		Caso o valor passado seja negativo
	 * @throws PeriodoInvalidoException 
	 * 		caso a data passada seja invalida
	 *
	 */
	public Refeicao(double valor, Calendar data) throws ValorInvalidoException, PeriodoInvalidoException  {
		if(valor < 0) {
			throw new ValorInvalidoException("Valor da conta invalido.");
		}
		if (data == null){
			throw new PeriodoInvalidoException("Data nula");
		}
		
		
		if (data.get(Calendar.HOUR_OF_DAY) < 6 || data.get(Calendar.HOUR_OF_DAY) > 22){
			throw new PeriodoInvalidoException("O restaurante nao estava funcionando nesse horario");
		}
		this.valor = valor;
		this.data = data;
	}
	
	
	/**
	 * Retorna a data em que foi feita a refeicao
	 * @return
	 * 		 um calendar data em que foi feita a refeicao
	 */
	public Calendar getData() {
		return data;
	}
	
	
	private String getDataString() {
		int dia = getData().get(Calendar.DATE);
		int mes = getData().get(Calendar.MONTH);
		int ano = getData().get(Calendar.YEAR);
		
		return dia + "/" + mes + "/" + ano;
	}

	
	
	/**
	 * Mostra a data do consumo e seu valor
	 */
	@Override
	public String toString() {
		return "RESTAURANTE: " + "\nData: " + getDataString() + "\nValor: R$ "  + valor();
	}
	
	/**
	 * Verifica se um servico refeicao eh igual a outro
	 */
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Refeicao))
			return false;
		
		Refeicao rf = (Refeicao) obj;
		
		return getDataString().equals(rf.getDataString()) && valor() == rf.valor();
		
	}

	/**
	 * Retorna o valor consumido pelo hospede
	 */
	@Override
	public double valor() {
		return valor;
	}
	
	
}
