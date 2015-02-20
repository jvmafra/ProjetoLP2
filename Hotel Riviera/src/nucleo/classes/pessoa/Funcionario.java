package nucleo.classes.pessoa;

import java.io.Serializable;

import nucleo.excecoes.NomeInvalidoException;


/**
 * Classe que representa um funcionario do hotel
 * @author Joao Victor Barroso Mafra
 */

public class Funcionario implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nome, login, senha;
	private boolean permissaoGerente;
	
	/**
	 * Construtor que recebe as informacoes necessarias para geracao de um funcionario
	 * @param nome
	 * 			Nome do funcionario
	 * @param login
	 * 			Login para entrar no sistema
	 * @param senha
	 * 			senha para entrar no sistema		
	 */
	public Funcionario(String nome, String login, String senha, boolean permissaoGerente) throws Exception{
		if (nome == null || nome.equals(""))
			throw new NomeInvalidoException("Nome invalido");
		
		if (login == null || login.equals(""))
			throw new NomeInvalidoException("login invalido");
		
		if (senha == null || senha.equals(""))
			throw new NomeInvalidoException("Senha invalida");
		
		if (senha.length() < 6)
			throw new Exception("Senha muito curta");
		
		this.login = login;
		this.nome = nome;
		this.senha = senha;
		this.permissaoGerente = permissaoGerente;
	}
	
	/**
	 * Retorna o nome do funcionario do hotel
	 */
	public String getNome() {
		return nome;
	}
	
	/**
	 * Modifica o nome do funcionario do hotel
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	/**
	 * Retorna o login do funcionario
	 */
	public String getLogin() {
		return login;
	}
	
	/**
	 * Modifica o login do funcionario
	 */
	public void setLogin(String login) {
		this.login = login;
	}
	
	/**
	 * Retorna a senha do funcionario
	 */
	public String getSenha() {
		return senha;
	}
	
	/**
	 * Modifica a senha do funcionario
	 */
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	/**
	 * Retorna se o funcionario possui permissao especial para acessar o sistema
	 */
	public boolean isPermissaoGerente() {
		return permissaoGerente;
	}
	
	private String funcao(){
		if (isPermissaoGerente())
			return "GERENTE";
		else
			return "FUNCIONARIO";
	}
	
	/**
	 * Retorna a string representando o funcionario
	 */
	public String toString(){
		return getNome() + " - " + funcao();
	}
	
	/**
	 * Verifica se dois funcionarios sao iguais
	 */
	public boolean equals(Object obj){
		if (!(obj instanceof Funcionario))
			return false;
		
		Funcionario f = (Funcionario) obj;
		
		return getNome().equals(f.getNome()) && isPermissaoGerente() == f.isPermissaoGerente();
	}

}
