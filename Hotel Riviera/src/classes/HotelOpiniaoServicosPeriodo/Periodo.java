package classes.HotelOpiniaoServicosPeriodo;

import java.util.Calendar;

import excecoes.PeriodoInvalidoException;

/**
 * Um periodo de tempo possui uma data inicial e uma data final.
 * Pode estar presente no contrato, no babysitter e no aluguel de carro.
 * @author Joao Victor Barroso Mafra
 */

public class Periodo{
	private Calendar data_inicial;
	private Calendar data_final;
	
	/**
	 * Construtor que recebe as duas datas do periodo (inicio e fim)
	 * @param data_inicial
	 * 			A data inicial do servico/hospedagem
	 * @param data_final
	 * 			A data final do servico/hospedagem
	 */
	public Periodo (Calendar data_inicial, Calendar data_final) throws Exception{
		if (data_inicial == null || data_final == null)
			throw new PeriodoInvalidoException("Datas nulas");
		
		if (data_final.get(Calendar.YEAR) < data_inicial.get(Calendar.YEAR))
			throw new PeriodoInvalidoException("Selecione anos de entrada e saida validos");
		
		if (data_final.get(Calendar.YEAR) == data_inicial.get(Calendar.YEAR)){
			if (data_final.get(Calendar.MONTH) < data_inicial.get(Calendar.MONTH)){
				throw new PeriodoInvalidoException("Selecione meses de entrada e saida validos");
			}
			
			else {
				if (data_final.get(Calendar.MONTH) == data_inicial.get(Calendar.MONTH) && data_final.get(Calendar.DATE) <= data_inicial.get(Calendar.DATE))
					throw new PeriodoInvalidoException("Selecione dias de entrada e saida validos");
			}
		}
		
		
		
		
		this.data_inicial = data_inicial;
		this.data_final = data_final;
	}

	/**
	 * @return 
	 * 			Inicio do periodo
	 */
	public Calendar getData_inicial() {
		return data_inicial;
	}
	
	/**
	 * @return 
	 * 			Final do periodo
	 */
	public Calendar getData_final() {
		return data_final;
	}
	
	/**
	 * @return 
	 * 			Numero de dias totais da hospedagem
	 */
	public int getNumeroDias(){
		 long m1 = data_inicial.getTimeInMillis();
	     long m2 = data_final.getTimeInMillis();
	     return (int) ((m2 - m1) / (24*60*60*1000));
	}
	
	private int getAnoFinal() {
		int ano_final = data_final.get(Calendar.YEAR);
		return ano_final;
	}
	
	
	private int getMesFinal() {
		int mes_final = data_final.get(Calendar.MONTH) + 1;
		return mes_final;
	}

	private int getDiaFinal() {
		int dia_final = data_final.get(Calendar.DATE);
		return dia_final;
	}

	private int getAnoInicial() {
		int ano_inicial = data_inicial.get(Calendar.YEAR);
		return ano_inicial;
	}

	private int getMesInicial() {
		int mes_inicial = data_inicial.get(Calendar.MONTH) + 1;
		return mes_inicial;
	}

	private int getDiaInicial() {
		int dia_inicial = data_inicial.get(Calendar.DATE);
		return dia_inicial;
	}
	
	private String getDataInicial() {
		String inicio = getDiaInicial() + "/" + getMesInicial() + "/" + getAnoInicial();
		return inicio;
	}
	
	private String getDataFinal() {
		String fim = getDiaFinal() + "/" + getMesFinal() + "/" + getAnoFinal();
		return fim;
	}
	
	/** Compara dois periodos de tempo e verifica se ha choque de datas
	 */
	
	public boolean periodoCoincide(Periodo outroPeriodo){
		if(outroPeriodo == null)
			return false;
	 
		return outroPeriodo.data_inicial.compareTo(data_final) <= 0 &&
					(outroPeriodo.data_final.compareTo(data_inicial) >= 0 || outroPeriodo.data_inicial.compareTo(data_inicial) >= 0);
	}
	
	public boolean dataIsContida(Calendar data){
		if(data == null) 
			return false;
		
		return data.compareTo(data_inicial) >= 0 && data.compareTo(data_final) <= 0;
	}
	
	
	/**
	 * @return 
	 * 			Uma String contendo as informacoes do determinado periodo (data inicial e final)
	 */
	@Override
	public String toString(){
		return getDataInicial() + " ate " + getDataFinal();	
	}

	
	/** Compara dois periodos verificando se os mesmos sao iguais
	 * @return 
	 * 			True ou False dependendo se dois periodos sao iguais ou nao.
	 */
	@Override
	public boolean equals(Object obj){
		if (!(obj instanceof Periodo))
			return false;
		
		Periodo p = (Periodo) obj;
		
		return periodoCoincide(p);
	}
	
}
