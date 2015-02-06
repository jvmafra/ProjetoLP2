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

import classes.HotelOpiniaoServicosPeriodo.Alugavel;
import classes.HotelOpiniaoServicosPeriodo.Periodo;
import excecoes.NomeInvalidoException;
import excecoes.TelefoneInvalidoException;

public class Baba implements Serializable, Alugavel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nome, telefone;
	private List<Periodo> periodos;
	
	public Baba(String nome, String telefone) throws NomeInvalidoException, TelefoneInvalidoException{
		if (nome == null || nome.equals(""))
			throw new NomeInvalidoException("Nome invalido");
		
		if(telefone == null || verificaTelefone(telefone))
			throw new TelefoneInvalidoException("Telefone invalido");
		
		
		this.telefone = telefone;
		this.nome = nome;
		periodos = new ArrayList<Periodo>();
	}
	
	private boolean verificaTelefone(String telefone){
		if(telefone.equals("")){
			return true;
		}
		if(telefone.length() < 8 ){
			return true;
		}
		if(telefone.length() > 12){
			return true;
		}
		for (int i = 0; i < telefone.length(); i++) {
			if(Character.isLetter(telefone.charAt(i))){
				return true;					
			}
		}
		return false;
	}
	
	

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) throws TelefoneInvalidoException {
	if(verificaTelefone(telefone))
		throw new TelefoneInvalidoException("Telefone invalido");
		
		this.telefone = telefone;
	}
	
	public String getNumero(){
		return telefone;
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
		return "Nome: " + getNome() + "/n" +"Numero: " + getNumero();
	}
	
	
}
