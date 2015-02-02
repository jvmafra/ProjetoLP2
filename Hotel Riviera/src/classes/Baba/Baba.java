package classes.Baba;

/**
 * Cada baba possui um nome e uma lista de periodos, que servira para administrar
 * quando ele estara disponivel ou nao. Essa lista eh modificada a medida que a
 * baba eh alugada ou devolvida. O Hotel possuira uma lista delas.
 * 
 * @author Joao Victor Barroso Mafra e Adiel Andrade
 */

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import classes.HotelOpiniaoServicosPeriodo.Periodo;
import excecoes.NomeInvalidoException;
import excecoes.TelefoneInvalidoException;

public class Baba implements Serializable{
	private String nome, telefone;
	private List<Periodo> periodos;
	
	public Baba(String nome, String telefone) throws NomeInvalidoException, TelefoneInvalidoException{
		if (nome == null || nome.equals(""))
			throw new NomeInvalidoException("Nome invalido");
		
		if(telefone.equals("") || telefone == null || telefone.length() < 8 || telefone.length() > 12)
			throw new TelefoneInvalidoException("Telefone invalido");
		
		
		this.telefone = telefone;
		this.nome = nome;
		periodos = new ArrayList<Periodo>();
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) throws TelefoneInvalidoException {
	if(telefone.equals("") || telefone == null || telefone.length() < 8 || telefone.length() > 12)
		throw new TelefoneInvalidoException("Telefone invalido");
		
		this.telefone = telefone;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Periodo> getPeriodos() {
		return periodos;
	}
	
	public void removePeriodo(Periodo p){
		getPeriodos().remove(p);
	}
	
	public void adicionaPeriodo(Periodo p){
		getPeriodos().add(p);
	}
	
	public boolean isDisponivel(Periodo p){
		for (Periodo periodo: periodos){
			if (p.periodoCoincide(periodo))
				return false;
		}
		return true;
	}
	
	@Override
	public boolean equals(Object obj){
		if (!(obj instanceof Baba))
			return false;
		
		Baba b = (Baba) obj;
		
		return getNome().equals(b.getNome());
	}
	
	@Override
	public String toString(){
		return "Nome: " + getNome();
	}

}
