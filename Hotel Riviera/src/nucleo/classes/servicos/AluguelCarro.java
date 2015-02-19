package nucleo.classes.servicos;

/**
 * Servico Aluguel de Carro, que deve ter um periodo e claro, um carro.
 * Tambem recebe no construtor as opcoes do hospede (se vira com tanque cheio/seguro)
 * e implementa a interface servicos, tendo portanto um valor a ser adicionado ao montante
 * do hospede
 * 
 * @author Joao Victor Barroso Mafra e Adiel Andrade
 */

import nucleo.classes.hotel.Periodo;
import nucleo.classes.hotel.Servico;
import nucleo.excecoes.CarroInvalidoException;
import nucleo.excecoes.PeriodoInvalidoException;

public class AluguelCarro implements Servico {
	private static final long serialVersionUID = 1L;
	private Periodo periodo;
	private boolean tanqueCheio;
	private boolean seguro;
	private double valor;
	private Carro carro;
	
	/**
	 * Construtor da classe Aluguel de carro que rebebe um carrro, um boolean tanque, um boolean seguro e um periodo
	 * @param carro
	 * 		Um objeto carro 
	 * @param tanque
	 * 		boolean tanque
	 * @param seguro
	 * 		booelan seguro
	 * @param p
	 * 		um periodo o qual o carro esteja alugado
	 * @throws PeriodoInvalidoException
	 * 		Caso o casso nao esteja disponvel no periodo ou o periodo seja invalido
	 * @throws CarroInvalidoException
	 * 		caso seja recebido um carro null
	 */
	public AluguelCarro(Carro carro, boolean tanque, boolean seguro, Periodo p) throws PeriodoInvalidoException, CarroInvalidoException {
		if (carro == null){
			throw new CarroInvalidoException("O carro nao esta sendo encontrado");
		}
		
		if ( p == null ){
			throw new PeriodoInvalidoException("Datas nulas");
			
		}
		
		if (!(carro.isDisponivel(p)))
			throw new PeriodoInvalidoException("O carro esta ocupado nesse periodo");
		
		
		this.seguro = seguro;
		this.tanqueCheio = tanque;
		this.periodo = p;
		this.carro = carro;
		getCarro().adicionaPeriodo(p);
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
	 * Retorna um carro
	 * @return
	 * 		carro
	 */
	public Carro getCarro(){
		return carro;
	}
	
	
	/**
	 * Retorna o numero de dias que o carro esteja alugado
	 * @return
	 * 		 numero de dias que o carro esteja alugado
	 */
	public int getNumDias() {
		return getPeriodo().getNumeroDias();
	}

	
	/**
	 * Retona um boolean Tanque
	 * @return
	 * 		True: Caso o tanque seja cheio
	 * 		False: caso o tanque nao seja cheio
	 */
	public boolean isTanqueCheio() {
		return tanqueCheio;
	}

	/**
	 * Retona um boolean Seguro
	 * @return
	 * 		True: Caso a carro seja segurado
	 * 		False: caso o carro nao seja segurado
	 */
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
		return "ALUGUEL DE CARRO: " + "\nPeriodo: " + periodo.toString() + "\nValor: R$ " + valor();
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof AluguelCarro)){
			return false;
		}
		
		AluguelCarro outro = (AluguelCarro) obj;
		
		return getCarro().equals(outro.getCarro()) && valor() == outro.valor();
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