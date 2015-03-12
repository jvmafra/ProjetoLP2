package nucleo.classes.servicos;

import java.io.Serializable;
import java.util.Calendar;

import nucleo.classes.hotel.Servico;
import nucleo.excecoes.PeriodoInvalidoException;
import nucleo.excecoes.TipoDeMassagensInvalidaException;
import nucleo.excecoes.TipoDeMassagensInvalidoException;
import nucleo.excecoes.ValorInvalidoException;


/**
 * Serviço de Massagem , que tem que receber um tipo de massagem uma data e uma duração
 * Implementa a interface servicos, tendo portanto um valor a ser adicionado ao montante
 * do hospede
 * 
 * 
 * @author Adiel Andrade
 *
 */
public class Massagem implements Servico, Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private double valor;
	private String nome;
	private Calendar data;
	private int duracao;
	
	
	/**
	 * COnstrutor de Massagem que tem que receber um tipo de massagem uma data e uma duração
	 * @param tipo
	 * 		um tipo de massagem que e uma constante criada no enum
	 * @param data
	 * 		Uma data valida no periodo 
	 * @param duracao
	 * 		A duração da massagem que pode ser de 1 hora ate 3 horas
	 * @throws ValorInvalidoException
	 * 		
	 * @throws PeriodoInvalidoException
	 * 		Caso o periodo seja nulo eu em um horario invalido pra a massagem
	 * @throws TipoDeMassagensInvalidaException
	 * 		caso o tipo passado seja nulo 
	 */
	public Massagem(TipoDeMassagens tipo, Calendar data, int duracao) throws  PeriodoInvalidoException, TipoDeMassagensInvalidaException {
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
	
	/**
	 * Retorna o nome da massagem
	 * @return
	 * 		nome
	 */
	public String getNome(){
		return nome;
	}
	
	@Override
	public double valor() {	
		return valor * totalDeHoras();
	}
	
	/**
	 * retorna a duração da massagem
	 * @return
	 * 		duracao
	 */
	public int totalDeHoras(){
		return duracao;
	}

	/**
	 * retorna a data passada para a massagem
	 * @return
	 * 		data
	 */
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
	









