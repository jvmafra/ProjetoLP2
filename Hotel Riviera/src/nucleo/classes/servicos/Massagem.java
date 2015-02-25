package nucleo.classes.servicos;

import java.io.Serializable;
import java.util.Calendar;
import java.util.GregorianCalendar;

import nucleo.classes.hotel.Periodo;
import nucleo.classes.hotel.Servico;
import nucleo.excecoes.PeriodoInvalidoException;
import nucleo.excecoes.TipoDeMassagensInvalidaException;
import nucleo.excecoes.TipoDeMassagensInvalidoException;
import nucleo.excecoes.ValorInvalidoException;

public class Massagem implements Servico, Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Periodo periodo;
	private double valor;
	private String nome;
	
	public Massagem(TipoDeMassagens tipo, Periodo periodo) throws ValorInvalidoException, PeriodoInvalidoException, TipoDeMassagensInvalidoException, TipoDeMassagensInvalidaException  {
	if (tipo == null){
		throw new TipoDeMassagensInvalidaException("Tipo de massagem invalida");
	}
	
	if (!(isPeriodoValido(periodo))){
		throw new PeriodoInvalidoException("Periodo de massagem invalido");
	}
	this.valor = tipo.getValor();
	this.periodo = periodo;
	this.nome = tipo.getNome();
	}
	
	
	public String getNome(){
		return nome;
	}
	
	@Override
	public double valor() {	
		return valor * periodo.getTotalDeHoras();
	}
	
	public int totalDeHoras(){
		return  periodo.getTotalDeHoras();
	}


	public Periodo getPeriodo() {
		return periodo;
	}


	public void setPeriodo(Periodo periodo) throws PeriodoInvalidoException {
		if (!(isPeriodoValido(periodo))){
			throw new PeriodoInvalidoException("periodo invalido");
		}
		this.periodo = periodo;
	}
	
	@Override
	public String toString() {
		return  "MASSAGEM: " + getNome() + "\nDuracao: " + getPeriodo().getTotalDeHoras() + " hora(s)" + "\nValor: R$ " + valor();
	}


	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Massagem)){
			return false;
		}
		Massagem outro = (Massagem) obj;
		return getNome().equals(outro.getNome()) && valor() == outro.valor();
	}
	
	private boolean isPeriodoValido(Periodo periodo){
		if (periodo == null){
			return false;
		}
		if (periodo.getData_inicial().get(Calendar.HOUR_OF_DAY) < 6 || periodo.getData_final().get(Calendar.HOUR_OF_DAY) > 22){
			return false;
		}
		
		if (periodo.getTotalDeHoras()> 3){
			return false;
		}
		return true;
	}

}
	









