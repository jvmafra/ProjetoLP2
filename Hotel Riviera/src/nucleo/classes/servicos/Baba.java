package nucleo.classes.servicos;

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

import nucleo.classes.hotel.Alugavel;
import nucleo.classes.hotel.Periodo;
import nucleo.excecoes.NomeInvalidoException;
import nucleo.excecoes.TelefoneInvalidoException;

public class Baba implements Serializable, Alugavel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nome, telefone;
	private List<Periodo> periodos;
	
	/**
	 * Construtor da classe Baba Que recebe um nome e um telefone
	 * @param nome
	 * 		nome da baba
	 * @param telefone
	 * 		telefone da baba
	 * @throws NomeInvalidoException
	 * 		Caso o nome enviado seja null ou uma String vazia
	 * @throws TelefoneInvalidoException
	 * 		Caso o telefone enviado seja null ou uma String vazia ou invalido
	 */
	public Baba(String nome, String telefone) throws NomeInvalidoException, TelefoneInvalidoException{
		if (nome == null || nome.equals(""))
			throw new NomeInvalidoException("Nome invalido");
		
		if(telefone == null || verificaTelefone(telefone))
			throw new TelefoneInvalidoException("Telefone invalido");
		
		
		this.telefone = telefone;
		this.nome = nome;
		periodos = new ArrayList<Periodo>();
	}
	

/**
 * Retorna a String Telefone
 * @return String Telefone
 */
	public String getTelefone() {
		return telefone;
	}
	
/**
 * Muda o telefone
 * @param telefone
 * 		uma nova String telefone
 * @throws TelefoneInvalidoException
 * 		Caso o telefone esteja errado
 */
	public void setTelefone(String telefone) throws TelefoneInvalidoException {
		if(telefone == null || verificaTelefone(telefone))
			throw new TelefoneInvalidoException("Telefone invalido");
		
		this.telefone = telefone;
	}
	
/**
 * Retorna o nome da baba
 * @return	String nome
 */
	public String getNome() {
		return nome;
	}

	/**
	 * Muda o nome da Baba
	 * @param nome
	 * 		Novo nome da baba
	 * @throws NomeInvalidoException
	 * 		verifica se nome e valido 
	 */
	public void setNome(String nome) throws NomeInvalidoException {
		if (nome == null || nome.equals(""))
			throw new NomeInvalidoException("Nome invalido");
		this.nome = nome;
	}

	/**
	 * retorna a lista de periodos periodo
	 */
	public List<Periodo> getPeriodos() {
		return periodos;
	}
	
	/**
	 * Remove o periodo da lista do periodo
	 * @param p
	 * 		Periodo A ser removido
	 */
	public void removePeriodo(Periodo p){
		getPeriodos().remove(p);
	}
	
	/**
	 * Adiciona um novo periodo na lista de periodos
	 * @param p
	 * 	Periodo a ser adicionado
	 */
	public void adicionaPeriodo(Periodo p){
		getPeriodos().add(p);
	}
	
	/**
	 * Verifica se a baba esta disponivel em algum determinado periodo
	 * @param p
	 * 		perido a ser verificado
	 * @return
	 * 		True: se a baba esta disponivel
	 * 		False: Se a baba nao esta disponivel
	 */
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
		return "Nome: " + getNome() + " - " + getTelefone();
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
	
	
}