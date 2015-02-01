package classes.Baba;

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
	private int horarioInicio;
	private int horas;
	private Baba baba;
	private double valor;
	private Periodo periodo;
	
	public BabySitter(Baba baba, int horarioInicial, int horas)throws Exception{
		if( horarioInicial< 0 || horarioInicial > 24){
			throw new Exception("horario passado invalido");
		}
		if( horas < 1 || horas > 24){
			throw new Exception("horario passado invalido");
		}
		this.horas = horas;
		this.horarioInicio =horarioInicial;
	}

	@Override
	public double valor() {
		for (int i = 0; i < horas; i++) {
			if(horarioInicio == 24)
			horarioInicio = 1;
			if(horarioInicio > 18 || horarioInicio < 7){
				valor +=25;
			}else{
				valor +=50;
			}
		}
		return valor;
	}

	public int getHorarioInicio() {
		return horarioInicio;
	}

	public void setHorarioInicio(int horarioInicio) {
		this.horarioInicio = horarioInicio;
	}

	public int getHoras() {
		return horas;
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
		if (horarioInicio != other.horarioInicio)
			return false;
		if (horas != other.horas)
			return false;
		return true;
	}
	
	
}
