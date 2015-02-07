package classes.Baba;

import java.util.Calendar;

import classes.HotelOpiniaoServicosPeriodo.Periodo;
import classes.HotelOpiniaoServicosPeriodo.Servico;
import excecoes.BabaInvalidaException;
import excecoes.PeriodoInvalidoException;

/**
 * Servico BabySitter, que deve ter um periodo e claro, uma baba.
 * Implementa a interface servicos, tendo portanto um valor a ser adicionado ao montante
 * do hospede
 * 
 * @author Joao Victor Barroso Mafra e Adiel Andrade e Hugo Gabriel
 */

public class BabySitter implements Servico {
	private static final int VALOR_HORA_NORMAL = 25;
	private static final int VALOR_HORA_DOBRADA = 50;
	private int horaDeInicio;
	private int horaDeTermino;
	private int horas;
	private Baba baba;
	private Periodo periodo;
	
	
	public BabySitter(Baba baba, Periodo periodo)throws Exception{
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
//	public static void main(String[] args) throws Exception {
//		Calendar data_inicial = new GregorianCalendar(2015, 1, 24, 20, 0 );
//		Calendar data_final = new GregorianCalendar(2015, 1, 25, 6 ,0);
//		
//		Calendar data_inicial2 = new GregorianCalendar(2015, 1, 24, 8,0 );
//		Calendar data_final2 = new GregorianCalendar(2015, 1, 24, 17, 0);
//		
//		Calendar data_inicial3 = new GregorianCalendar(2015, 1, 24, 0,0 );
//		Calendar data_final3 = new GregorianCalendar(2015, 1, 25, 0, 0);
//		 Periodo p;
//		 Periodo p2;
//		 Periodo p3;
//		BabySitter baby;
//		BabySitter baby2;
//		BabySitter baby3;
//		Baba bb = new Baba("Adiel Andrade", "96250807" );
//		Baba bb3 = new Baba("Adiel Andrade", "96250807" );
//		Baba bb2 = new Baba("Adiel Andrade", "96250807" );
//		p = new Periodo(data_inicial, data_final);
//		p2 = new Periodo(data_inicial2, data_final2);
//		p3 = new Periodo(data_inicial3, data_final3);
//		baby = new BabySitter(bb, p);
//		baby2 =new BabySitter(bb2, p2);
//		baby3 =new BabySitter(bb3, p3);	
//		System.out.println(baby.valor());
//		System.out.println(baby2.valor());
//		System.out.println(baby3.valor());
//	}
	
	
}

