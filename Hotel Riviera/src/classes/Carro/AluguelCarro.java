package classes.Carro;

/**
 * Servico Aluguel de Carro, que deve ter um periodo e claro, um carro.
 * Tambem recebe no construtor as opcoes do hospede (se vira com tanque cheio/seguro)
 * e implementa a interface servicos, tendo portanto um valor a ser adicionado ao montante
 * do hospede
 * 
 * @author Joao Victor Barroso Mafra e Adiel Andrade
 */

import classes.HotelOpiniaoServicosPeriodo.Periodo;
import classes.HotelOpiniaoServicosPeriodo.Servicos;
import excecoes.PeriodoInvalidoException;

public class AluguelCarro implements Servicos {
	private Periodo periodo;
	private boolean tanqueCheio;
	private boolean seguro;
	private double valor;
	private Carro carro;
	
	public AluguelCarro(Carro carro, boolean tanque, boolean seguro, Periodo p) throws Exception {
		if (!(carro.isDisponivel(p)))
			throw new PeriodoInvalidoException("O carro esta ocupado nesse periodo");
		
		getCarro().adicionaPeriodo(p);
		this.seguro = seguro;
		this.tanqueCheio = tanque;
		this.periodo = periodo;
		this.carro = carro;
	}
	
	public Periodo getPeriodo() {
		return periodo;
	}
	
	public Carro getCarro(){
		return carro;
	}
	
	public int getNumDias() {
		return getPeriodo().getNumeroDias();
	}

	public boolean isTanqueCheio() {
		return tanqueCheio;
	}

	public boolean isSeguro() {
		return seguro;
	}

	@Override
	public double valor() {
		valor = (getNumDias() * valorLuxo()) + valorSeguro() + valorTanqueCheio();
		return valor;
	}
	
	@Override
	public String toString() {
		return "ALUGUEL DE CARRO: " + "\nPeriodo: " + getNumDias() + "\nValor: R$ " + valor();
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof AluguelCarro)){
			return false;
		}
		
		AluguelCarro outro = (AluguelCarro) obj;
		
		return getCarro().equals(outro.getCarro()) && getPeriodo().equals(outro.getPeriodo());
	}
	
	private int valorTanqueCheio() {
		if(isTanqueCheio()){
			return 150;
		}
		return 0;
	}
	
	private int valorSeguro() {
		if(isSeguro()){
			return 100;
		}
		return 0;
	}
	
	private int valorLuxo() {
		if(carro.isLuxo()){
			return 100;
		}
		return 60;
	}
	
	
}