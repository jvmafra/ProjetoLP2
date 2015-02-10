package classes.Pessoa;

import java.io.Serializable;
import java.util.InputMismatchException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import excecoes.CpfInvalidoExcepcion;
import excecoes.EmailInvalidoExcepcion;
import excecoes.EnderecoInvalidoException;
import excecoes.EntradaDeDadosException;
import excecoes.IdadeInvalidaException;
import excecoes.NomeInvalidoException;
import excecoes.NumeroCartaoException;
import excecoes.RgInvalidoException;
import excecoes.TelefoneInvalidoException;

/**
 * Classe que representa um hospede, que estara associado a um contrato.
 * @author Edval Galdino e Adiel Andrade 
 */
public class Hospede implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nome, cpf, rg, idade , email,endereco, telefone, numCartao ;
	/**
	 * Construtor da classe hospede.
	 * @param nome
	 * @param CPF
	 * @param RG
	 * @param email
	 * @param telefone
	 * @param endereco
	 * @param idade
	 * @throws Exception
	 */
	public Hospede(String nome, String CPF, String RG,String idade , String email, String telefone, String endereco, String numCartao) throws EntradaDeDadosException{	
		if(nome == null || nome.equals(""))
			throw new NomeInvalidoException("Nome invalido");
		
		if(CPF == null || !(isCPF(CPF)))
			throw new CpfInvalidoExcepcion("CPF invalido");
		
		if(RG == null || RG.equals("") || RG.length() != 7 || validoRg(RG))
			throw new RgInvalidoException("RG invalido");
		
		if(idade == null || idade.equals(""))
			throw new IdadeInvalidaException("Idade invalida");
		
		if(email == null || email.equals("") || verificaEmail(email) == false)
			throw new EmailInvalidoExcepcion("E-mail invalido");
		
		if(endereco == null || endereco.equals(""))
			throw new EnderecoInvalidoException("Endereco invalido");
		
		if(telefone == null || telefone.equals("") ||  telefone.length() < 8 || telefone.length() > 12)
			throw new TelefoneInvalidoException("Telefone invalido");
		
		if (numCartao == null || numCartao.equals("") || !(validaCartaoDeCredito(numCartao))){
			throw new NumeroCartaoException("Cartao de credito invalido");
		}
		
	this.nome = nome;
	this.cpf = CPF;
	this.email= email;
	this.telefone = telefone;
	this.endereco = endereco;
	this.rg = RG;
	this.idade = idade;
	
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getRg() {
		return rg;
	}
	public void setRg(String rg) {
		this.rg = rg;
	}
	public String getNumCartao() {
		return numCartao;
	}
	public void setNumCartao(String numCartao) {
		this.numCartao = numCartao;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public void setIdade(String idade) {
		this.idade = idade;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	private boolean verificaIdade(String idade) {
		int idades = Integer.parseInt(idade);
		if(idades<18 || idades> 120)
			return false;
		return true;
	}
	/**
	 * Testa numero de cart�o de cr�dito
	 * @param numero
	 * @return
	 */
	private boolean validaCartaoDeCredito(String numero) {
		int s1 = 0, s2 = 0;
		String invertida = new StringBuffer(numero).reverse().toString();
		for (int i = 0 ;i < invertida.length();i++) {
			int digito = Character.digit(invertida.charAt(i), 10);
			if(i % 2 == 0) { s1 += digito; }
			else {
				s2 += 2 * digito;
				if (digito >= 5) { s2 -= 9; }
			}
		}
		return (s1 + s2) % 10 == 0;
	}
/**
 * Retorna a String telefone.
 * @returntelefone.
 */
	public String getTelefone() {
		return telefone;
	}
/**
 * Muda o telefone, primeiramenteverificase o parametro e valido, no caso de confirmar-se a afirmacao anterior, muda o telefone.
 * @param telefone
 * @throws Exception
 */
	public void setTelefone(String telefone) throws Exception {
		if(telefone == null || telefone.equals("")
			||  telefone.length() < 8 || telefone.length() > 12)
			throw new TelefoneInvalidoException("Telefone invalido");
		this.telefone = telefone;
	}
	
	
	/**
	 * Retorna Idade
	 * @return idade
	 */
	public String getIdade() {		
		
		return idade;

	}
	
	
	
/**
 * Retornanome.
 * @returnnome.
 */
	public String getNome() {
		return nome;
	}

	/**
	 * retorna Cpf
	 * @return Cpf
	 */
	public String getCPF() {
		return cpf;
	}

/**
 * Retorna o RG. 
 * @return RG.
 */
	public String getRG() {
		return rg;
	}

/**
 * Retorna email.	
 * @return email.
 */
	public String getEmail() {
		return email;
	}
	
	public String getNumeroCartao(){
		return numCartao;
	}
	public void setNumeroCartao(String num){
		numCartao = num;
	}

/**
 * Retorna endereco.	
 * @return 
 * 		endereco.
 */
	public String getEndereco() {
		return endereco;
	}
	
	public String mostraInformacoes(){
		return "Nome: " + getNome() + "\nCPF: " + getCPF() + "\nRG: " + getRG() + "\nE-mail: " + getEmail()
				+ "\nTelefone: " + getTelefone() + "\nEndereco: " + getEndereco() + "\nIdade: "+ getIdade();
	}

	@Override
	public String toString() {
		return getNome() + " - " + getCPF();
	}

	

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Hospede))
			return false;
		Hospede other = (Hospede) obj;
		if (cpf == null) {
			if (other.cpf != null)
				return false;
		} else if (!cpf.equals(other.cpf))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (endereco == null) {
			if (other.endereco != null)
				return false;
		} else if (!endereco.equals(other.endereco))
			return false;
		if (idade == null) {
			if (other.idade != null)
				return false;
		} else if (!idade.equals(other.idade))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (numCartao == null) {
			if (other.numCartao != null)
				return false;
		} else if (!numCartao.equals(other.numCartao))
			return false;
		if (rg == null) {
			if (other.rg != null)
				return false;
		} else if (!rg.equals(other.rg))
			return false;
		if (telefone == null) {
			if (other.telefone != null)
				return false;
		} else if (!telefone.equals(other.telefone))
			return false;
		return true;
	}
	/**
	 * Esse metodo tem como funcao verificar se o cpf recebido e valido.
	 * @param CPF
	 * @return
	 */
	
	public boolean verificaEmail(String email){
		Pattern p = Pattern
				.compile("^[\\w-]+(\\.[\\w-]+)*@([\\w-]+\\.)+[a-zA-Z]{2,7}$");

		Matcher m = p.matcher(email);
		if (m.find()) 
			return true;
	
		return false;
		
	}
	
	private boolean validoRg(String Rg){
		for (int i = 0; i < Rg.length(); i++) {
			if(Character.isLetter(Rg.charAt(i))){
				return true;					
				}	
		}
		return false;
		
	}
	private static boolean isCPF(String CPF) { // considera-se erro CPF's formados por uma sequencia de numeros iguais 
		if (CPF.equals("00000000000") || CPF.equals("11111111111") || CPF.equals("22222222222") || 
			CPF.equals("33333333333") || CPF.equals("44444444444") || CPF.equals("55555555555") || 
			CPF.equals("66666666666") || CPF.equals("77777777777") || CPF.equals("88888888888") || 
			CPF.equals("99999999999") || (CPF.length() != 11))
			return(false); 
		
		char dig10, dig11; int sm, i, r, num, peso;
		// "try" - protege o codigo para eventuais erros de conversao de tipo (int) 
		try { 
			// Calculo do 1o.
			sm = 0; peso = 10; for (i=0; i<9; i++) { 
				 num = (int)(CPF.charAt(i) - 48); sm = sm + (num * peso); peso = peso - 1; } 
			r = 11 - (sm % 11); 
			if ((r == 10) || (r == 11))
				dig10 = '0';
			
			else
				dig10 = (char)(r + 48); 
			
			//Calculo do 2o. Digito Verificador 
			sm = 0; peso = 11; for(i=0; i<10; i++) { 
				num = (int)(CPF.charAt(i) - 48); 
				
			sm = sm + (num * peso);
				peso = peso - 1; 
				} 
			r = 11 - (sm % 11); if ((r == 10) || (r == 11)) dig11 = '0'; 
			
			else 
				dig11 = (char)(r + 48); 				
			
			if ((dig10 == CPF.charAt(9)) && (dig11 == CPF.charAt(10)))
				return(true); 
			
			else
				return(false); 
			}
		catch (InputMismatchException erro) { return(false); } }
				

}


	