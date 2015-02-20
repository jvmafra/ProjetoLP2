package nucleo.classes.formas_cobranca;

import java.io.Serializable;

import nucleo.classes.hotel.Periodo;
import nucleo.excecoes.NomeInvalidoException;
import nucleo.excecoes.PeriodoInvalidoException;
import nucleo.excecoes.ValorInvalidoException;

public class Estrategia implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nome;
	private double fator;
	
	public Estrategia(String nome, double fator) throws Exception{
		if (nome == null || nome.equals(""))
			throw new NomeInvalidoException("Digite um nome");
		if (fator <= 0)
			throw new ValorInvalidoException("Digite um fator valido");

		this.nome = nome;
		this.fator = fator;
		
		
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getFator() {
		return fator;
	}

	public void setFator(double fator) {
		this.fator = fator;
	}
	
	public String toString(){
		return getNome();
	}
	
	public boolean equals(Object obj){
		if (!(obj instanceof Estrategia))
			return false;
		
		Estrategia e = (Estrategia) obj;
		
		return getFator() == e.getFator();
	}
	

}
