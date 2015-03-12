package nucleo.classes.formas_cobranca;

import java.io.Serializable;

import nucleo.excecoes.NomeInvalidoException;
import nucleo.excecoes.ValorInvalidoException;

/**
 * Classe que configura a criacao de um Estrategia de Cobranca para o hotel
 * @author Joao Victor Barroso Mafra
 */

public class Estrategia implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nome;
	private double fator;
	
	/**
	 * Toda Estrategia possui um nome de identificacao e um fator
	 * @param nome
	 * 			O nome da estrategia
	 * @param fator
	 * 			O fator multiplicador
	 */
	public Estrategia(String nome, double fator) throws Exception{
		if (nome == null || nome.equals(""))
			throw new NomeInvalidoException("Digite um nome");
		if (fator <= 0)
			throw new ValorInvalidoException("Digite um fator valido");

		this.nome = nome;
		this.fator = fator;
		
		
	}
	
	/**
	 * @return O nome da estrategia 
	 */
	public String getNome() {
		return nome;
	}
	
	/**
	 * Modifica o nome da estrategia
	 * @param nome
	 * 			O novo nome 
	 */
	public void setNome(String nome) throws NomeInvalidoException {
		if (nome == null || nome.equals(""))
			throw new NomeInvalidoException("Digite um nome");
		
		this.nome = nome;
	}
	
	/**
	 * @return O fator da estrategia
	 */
	public double getFator() {
		return fator;
	}
	
	/**
	 * Modifica o fator da estrategia
	 * @param fator
	 * 			O novo fator
	 */
	public void setFator(double fator) throws ValorInvalidoException {
		if (fator <= 0)
			throw new ValorInvalidoException("Digite um fator valido");
		this.fator = fator;
	}
	
	/**
	 * @return O nome da estrategia
	 */
	public String toString(){
		return getNome();
	}
	
	/**
	 * Verifica se duas estrategias sao iguais
	 */
	public boolean equals(Object obj){
		if (!(obj instanceof Estrategia))
			return false;
		
		Estrategia e = (Estrategia) obj;
		
		return getFator() == e.getFator();
	}
	

}
