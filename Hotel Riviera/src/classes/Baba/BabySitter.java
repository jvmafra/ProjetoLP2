package classes.Baba;

import java.util.Calendar;

import classes.HotelOpiniaoServicosPeriodo.Hotel;
import classes.HotelOpiniaoServicosPeriodo.Periodo;
import classes.HotelOpiniaoServicosPeriodo.Servicos;

/**
 * Servico BabySitter, que deve ter um periodo e claro, uma baba.
 * Implementa a interface servicos, tendo portanto um valor a ser adicionado ao montante
 * do hospede
 * 
 * @author Joao Victor Barroso Mafra e Adiel Andrade
 */

public class BabySitter implements Servicos {
	private static final int VALOR_HORA_NORMAL = 25;
	private static final int VALOR_HORA_DOBRADA = 50;
	private int horaDeInicio;
	private int horaDeTermino;
	private int horas;
	private Baba baba;
	private double valor;
	private Periodo periodo;
	
	
	public BabySitter(Baba baba, Periodo periodo)throws Exception{
		this.periodo = periodo;
		this.baba = baba;
		this.horaDeInicio = periodo.getData_inicial().get(Calendar.HOUR_OF_DAY);
		this.horaDeTermino = periodo.getData_final().get(Calendar.HOUR_OF_DAY);
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
				horasRemanescentes -= (7 - horaDeTermino);
				valorDobrado += (7- horaDeTermino) * VALOR_HORA_DOBRADA;
				}
			}
		if (horasRemanescentes > 11){
			valorDobrado += (horasRemanescentes - 11) * VALOR_HORA_DOBRADA;
			horasRemanescentes -= 11;	
		}
		if (horasRemanescentes > 0){
			valorNormal += horasRemanescentes * VALOR_HORA_NORMAL;
		}
		return valorNormal + valorDobrado;
		
	}

	public int getHorarioInicio() {
		return horaDeInicio;
	}
	public int getHorarioTermino() {
		return horaDeTermino;
	}
	public void setHorarioTermino(int horarioTermino) {
		this.horaDeTermino = horarioTermino;
	}

	public void setHorarioInicio(int horarioInicio) {
		this.horaDeInicio = horarioInicio;
	}

	public int getHoras() {
		return periodo.getTotalDeHoras();
	}

	public void setHoras(int horas) {
		this.horas = horas;
	}
	
	public Baba getBaba(){
		return baba;
	}
	
	public Periodo getPeriodo() {
		return periodo;
	}

	@Override
	public String toString() {
		return getBaba().toString();
		
		// Falta ver como sera a questão do periodo para imprimir. Se for
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

