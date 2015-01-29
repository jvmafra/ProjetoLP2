package classes;

import java.util.InputMismatchException;

/**
 * 
 * @authorEdvalGatão
 * Moidecorno, aitacom o javadoc
 */
public class Hospede {
	private String nome, cpf, rg, email,endereco, telefone;
	/**
	 * Construtor da classe hospede. Recebe como parametro esses atributos abaixo.
	 * @param nome
	 * @param CPF
	 * @param RG
	 * @param email
	 * @param telefone
	 * @param endereco
	 * @throws Exception
	 */
	public Hospede(String nome, String CPF, String RG, String email, String telefone, String endereco) throws Exception{
		/**
		 * Osparametrossãoverificados, seforemválidos é criado o hospede, no casodeinvalidolançaumaexceção.
		 */
		if(nome.equals("") || nome.equals(null))
			throw new Exception("Nome inválido");
		
		if(!(isCPF(CPF)))
			throw new Exception("CPF inválido");
		
		if(RG.equals("") || RG.equals(null) || RG.length() != 7)
			throw new Exception("RG inválido");
		
		if(email.equals("") || email.equals(null))
			throw new Exception("E-mail inválido");
		
		if(endereco.equals("") || endereco.equals(null))
			throw new Exception("Endereço inválido");
		
		if(telefone.equals("") || endereco.equals(null))
			throw new Exception("Telefone inválido");
		
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
 * Muda o telefone, primeiramenteverificase o parametro é válido, no casodeconfirma-se a afirmação anterior, muda o telefone.
 * @param telefone
 * @throws Exception
 */
	public void setTelefone(String telefone) throws Exception {
		if(telefone.equals("") || endereco.equals(null))
			throw new Exception("Telefone inválido");
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
 * Retornaendereço.	
 * @returnendereço.
 */
	public String getEndereco() {
		return endereco;
	}

	@Override
	public String toString() {
		return"Hospede [nome=" + nome + ", cpf=" + cpf + ", rg=" + rg
				+ ", email=" + email + ", endereco=" + endereco + ", telefone="
				+ telefone + "]";
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
 * Esse metodo tem como função verificar se o cpf recebido é válido.
 * @param CPF
 * @return
 */
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

	