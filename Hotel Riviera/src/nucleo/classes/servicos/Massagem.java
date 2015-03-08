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
	private double valor;
	private String nome;
	private Calendar data;
	private int duracao;
	
	public Massagem(TipoDeMassagens tipo, Calendar data, int duracao) throws ValorInvalidoException, PeriodoInvalidoException, TipoDeMassagensInvalidoException, TipoDeMassagensInvalidaException  {
	if (tipo == null){
		throw new TipoDeMassagensInvalidaException("Tipo de massagem invalida");
	}
	
	if (data == null)
		throw new PeriodoInvalidoException("Selecione uma data.");
	
	if (data.get(Calendar.HOUR_OF_DAY) + duracao > 22 || data.get(Calendar.HOUR_OF_DAY) < 8)
		throw new PeriodoInvalidoException("A massagem não funciona nesse horário.");
	
	if (duracao <= 0 || duracao > 3)
		throw new PeriodoInvalidoException("A massagem deve durar entre 1 e 3 horas");
	
	this.valor = tipo.getValor();
	this.nome = tipo.getNome();
	this.duracao = duracao;
	this.data = data;
	
	}
	
	
	public String getNome(){
		return nome;
	}
	
	@Override
	public double valor() {	
		return valor * totalDeHoras();
	}
	
	public int totalDeHoras(){
		return duracao;
	}


	public Calendar getData() {
		return data;
	}
	
	private String diaDaMassagem(){
		int dia = data.get(Calendar.DATE);
		int mes = data.get(Calendar.MONTH) + 1;
		int ano = data.get(Calendar.YEAR);
		
		return dia + "/" + mes + "/" + ano;
	}
	
	@Override
	public String toString() {
		return  "MASSAGEM: " + getNome() + "\nDia: " + diaDaMassagem() + "\nDuracao: " + totalDeHoras() + " hora(s)" + "\nValor: R$ " + valor();
	}


	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Massagem)){
			return false;
		}
		Massagem outro = (Massagem) obj;
		return getNome().equals(outro.getNome()) && valor() == outro.valor();
	}
	

}
	









