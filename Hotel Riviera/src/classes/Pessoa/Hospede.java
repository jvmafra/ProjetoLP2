package classes.Pessoa;

import java.io.Serializable;
import java.util.InputMismatchException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Classe que representa um hospede, que estara associado a um contrato.
 * @author Edval Galdino
 */
public class Hospede implements Serializable{
	private String nome, cpf, rg, email,endereco, telefone, numCartao;
	/**
	 * Construtor da classe hospede.
	 * @param nome
	 * @param CPF
	 * @param RG
	 * @param email
	 * @param telefone
	 * @param endereco
	 * @throws Exception
	 */
	public Hospede(String nome, String CPF, String RG, String email, String telefone, String endereco, String numCartao) throws Exception{
		if(nome.equals("") || nome.equals(null))
			throw new Exception("Nome invalido");
		
		if(!(isCPF(CPF)))
			throw new Exception("CPF invalido");
		
		if(RG.equals("") || RG == null || RG.length() != 7)
			throw new Exception("RG invalido");
		
		if(email.equals("") || email == null || verificaEmail(email) == false)
			throw new Exception("E-mail invalido");
		
		if(endereco.equals("") || endereco == null)
			throw new Exception("Endereco invalido");
		
		if(telefone.equals("") || telefone == null || telefone.length() < 8 || telefone.length() > 12)
			throw new Exception("Telefone invalido");
		
		if (!(validaCartaoDeCredito(numCartao))){
			throw new Exception("Cartao de credito invalido");
		}
		
	this.nome = nome;
	this.cpf = CPF;
	this.email= email;
	this.telefone = telefone;
	this.endereco = endereco;
	this.rg = RG;
	
	}
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
		if(telefone.equals("") || endereco.equals(null))
			throw new Exception("Telefone invalido");
		this.telefone = telefone;
	}
/**
 * Retornanome.
 * @returnnome.
 */
	public String getNome() {
		return nome;
	}

	/**
	 * retornaCpf
	 * @returnCpf
	 */
	public String getCpf() {
		return cpf;
	}

/**
 * Retorna o RG. 
 * @return RG.
 */
	public String getRg() {
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

	@Override
	public String toString() {
		return "Nome: " + getNome() + "\nCPF: " + getCpf() + "\nRG: " + getRg() + "\nE-mail: " + getEmail()
				+ "\nTelefone: " + getTelefone() + "\nEndereco: " + getEndereco();
	}

	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof Hospede))
			return false;
		Hospede h1 = (Hospede) obj;
		
		return nome.equals(h1.getNome()) && cpf.equals(h1.getCpf()) && rg.equals(h1.getRg())
				&& endereco.equals(h1.getEndereco());
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

	