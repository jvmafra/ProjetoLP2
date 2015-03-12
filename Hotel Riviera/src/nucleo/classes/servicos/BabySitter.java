package nucleo.classes.servicos;

import java.io.Serializable;
import java.util.Calendar;

import nucleo.classes.hotel.Periodo;
import nucleo.classes.hotel.Servico;
import nucleo.excecoes.BabaInvalidaException;
import nucleo.excecoes.PeriodoInvalidoException;

/**
 * Servico BabySitter, que deve ter um periodo e claro, uma baba.
 * Implementa a interface servicos, tendo portanto um valor a ser adicionado ao montante
 * do hospede
 * 
 * @author Joao Victor Barroso Mafra e Adiel Andrade e Hugo Gabriel
 */

public class BabySitter implements Servico, Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final int VALOR_HORA_NORMAL = 25;
	private static final int VALOR_HORA_DOBRADA = 50;
	private int horaDeInicio;
	private int horaDeTermino;
	private int horas;
	private Baba baba;
	private Periodo periodo;
	
	/**
	 * Construtor de BabySitter onde e recebido uma Baba e um Periodo
	 * @param baba
	 * 		Uma Baba
	 * @param periodo
	 * 		Um periodo	
	 * @throws PeriodoInvalidoException 
	 * 		Caso o periodo passado seja invalido ou a baba nao esteja disponivel em tal periodo
	 * @throws BabaInvalidaException
	 * 		Caso a baba passada seja null
	 */
	public BabySitter(Baba baba, Periodo periodo)throws BabaInvalidaException, PeriodoInvalidoException{
		if ( baba == null ){
			throw new BabaInvalidaException("Baba passada invalida");
			
		}
		if ( periodo == null ){
			throw new PeriodoInvalidoException("Datas nulas");
			
		}
		
		if (!(baba.isDisponivel(periodo))){
			throw new PeriodoInvalidoException("Baba esta indisponivel nesse periodo");
		}
		this.periodo = periodo;
		this.baba = baba;
		this.horaDeInicio = periodo.getData_inicial().get(Calendar.HOUR_OF_DAY);
		this.horaDeTermino = periodo.getData_final().get(Calendar.HOUR_OF_DAY);
		getBaba().adicionaPeriodo(periodo);
	}

	
	@Override
	public double valor() {
		
		int diasCompletos = getHoras() / 24;
		int horasRemanescentes = getHoras() % 24;
		int valorDobrado = diasCompletos * 13 * VALOR_HORA_DOBRADA;
		int valorNormal = diasCompletos * 11 * VALOR_HORA_NORMAL;

		if (horasRemanescentes > 0){
			if (horaDeInicio >= 18){
				horasRemanescentes -=  (24 - horaDeInicio);
				valorDobrado += (24 - horaDeInicio) * VALOR_HORA_DOBRADA;
			}
			if (horaDeTermino < 7){
				horasRemanescentes -= horaDeTermino;
				valorDobrado += horaDeTermino * VALOR_HORA_DOBRADA;
				}
			}
		if (horasRemanescentes > 0){
			valorNormal += horasRemanescentes * VALOR_HORA_NORMAL;
		}
		return valorNormal + valorDobrado;
		
	}

	/**
	 * Retorna a horario de inicio da baba
	 * @return
	 * 		horadeinicio
	 */
	public int getHorarioInicio() {
		return horaDeInicio;
	}
	
	/**
	 * Retorna o horario de termino da baba
	 * @return
	 * 		horaDeTermino
	 */
	public int getHorarioTermino() {
		return horaDeTermino;
	}
	
	/**
	 * Muda o Horario de termino da baba
	 * @param horarioTermino
	 * 		novo horario de termino
	 */
	public void setHorarioTermino(int horarioTermino) {
		this.horaDeTermino = horarioTermino;
	}

	/**
	 * Muda o Horario de inicio da baba
	 * @param horarioInicio
	 * 		novo horario de inicio
	 */
	public void setHorarioInicio(int horarioInicio) {
		this.horaDeInicio = horarioInicio;
	}

	/**
	 * Retorna a quantidade de horas que a baba vai trabalhar no periodo
	 * @return
	 *		 quantidade de horas que a baba vai trabalhar no periodo
	 */
	public int getHoras() {
		return periodo.getTotalDeHoras();
	}

	/** 
	 * Retorna a baba
	 * @return
	 * 		baba
	 */
	public Baba getBaba(){
		return baba;
	}
	
	/**
	 * Retorna perido de trabalho da baba
	 * @return
	 * 		periodo
	 */
	public Periodo getPeriodo() {
		return periodo;
	}
	
	/**
	 * Representacao em String do servico Babysitter, que contem o nome da Baba, o periodo 
	 * e o valor total cobrado
	 */
	@Override
	public String toString() {
		return "BABYSITTER" + "\nNome da baba: " + getBaba().getNome() + "\n" + periodo.toString() + "\n" + "Valor:" + valor();
		
		// Falta ver como sera a quest�o do periodo para imprimir. Se for
		// usar a classe Periodo mesmo ja tem toString feito
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BabySitter other = (BabySitter) obj;
		if (horaDeInicio != other.horaDeInicio)
			return false;
		if (horas != other.horas)
			return false;
		return true;
	}

}

