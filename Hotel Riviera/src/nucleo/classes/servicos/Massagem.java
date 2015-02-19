package nucleo.classes.servicos;

import java.util.Calendar;
import java.util.GregorianCalendar;

import nucleo.classes.hotel.Periodo;
import nucleo.classes.hotel.Servico;
import nucleo.excecoes.PeriodoInvalidoException;
import nucleo.excecoes.TipoDeMassagensInvalidoException;
import nucleo.excecoes.ValorInvalidoException;

public class Massagem implements Servico {
	private Periodo periodo;
	private double valor;
	
	
	public Massagem(double v, Periodo data) throws ValorInvalidoException, PeriodoInvalidoException, TipoDeMassagensInvalidoException  {
		
	if (data == null){
		throw new PeriodoInvalidoException("Data nula");
	}
	if (data.getData_inicial().HOUR_OF_DAY < 6 || data.getData_final().HOUR_OF_DAY > 22){
		throw new PeriodoInvalidoException("A massagens nao funciona nesse horario");
	}
	
	if (data.getTotalDeHoras()> 3){
		throw new PeriodoInvalidoException("Quantidades de horas invalida");
	}
	this.valor = v;
	this.periodo = data;
	}
	
	
	@Override
	public double valor() {	
		return valor * periodo.getTotalDeHoras();
	}
	
	
	public static void main(String[] args) throws Exception {
		
		Calendar data_inicial2 = new GregorianCalendar(2015, 1, 24, 8,0 );
		Calendar data_final2 = new GregorianCalendar(2015, 1, 24, 11, 0);
		
		Periodo p2 = new Periodo(data_inicial2, data_final2);
		Massagem m = new Massagem( TipoDeMassagens.REIKI.getValor(), p2 );
		
		System.out.println(m.valor());
	}

}
	










