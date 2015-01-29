package classes;

import java.util.InputMismatchException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Classe que representa um hospede, que estara associado a um contrato.
 * @author Edval Galdino
 */
public class Hospede {
	private String nome, cpf, rg, email,endereco, telefone;
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
	public Hospede(String nome, String CPF, String RG, String email, String telefone, String endereco) throws Exception{
		if(nome.equals("") || nome.equals(null))
			throw new Exception("Nome invalido");
		
		if(!(isCPF(CPF)))
			throw new Exception("CPF invalido");
		
		if(RG.equals("") || RG.equals(null) || RG.length() != 7)
			throw new Exception("RG invalido");
		
		if(email.equals("") || email.equals(null) || verificaEmail(email) == false)
			throw new Exception("E-mail invalido");
		
		if(endereco.equals("") || endereco.equals(null))
			throw new Exception("Endereco invalido");
		
		if(telefone.equals("") || endereco.equals(null))
			throw new Exception("Telefone invalido");
		
	this.nome = nome;
	this.cpf = CPF;
	this.email= email;
	this.telefone = telefone;
	this.endereco = endereco;
	this.rg = RG;
	
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

	