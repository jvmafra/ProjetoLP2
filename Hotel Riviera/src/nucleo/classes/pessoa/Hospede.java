package nucleo.classes.pessoa;

import java.io.Serializable;
import java.util.InputMismatchException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import nucleo.excecoes.CpfInvalidoExcepcion;
import nucleo.excecoes.EmailInvalidoExcepcion;
import nucleo.excecoes.EnderecoInvalidoException;
import nucleo.excecoes.EntradaDeDadosException;
import nucleo.excecoes.IdadeInvalidaException;
import nucleo.excecoes.NomeInvalidoException;
import nucleo.excecoes.NumeroCartaoException;
import nucleo.excecoes.RgInvalidoException;
import nucleo.excecoes.TelefoneInvalidoException;

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
		
		if(verificaIdade(idade))
			throw new IdadeInvalidaException("Idade invalida");
		
		if(email == null || email.equals("") || verificaEmail(email) == false)
			throw new EmailInvalidoExcepcion("E-mail invalido");
		
		if(endereco == null || endereco.equals(""))
			throw new EnderecoInvalidoException("Endereco invalido");
		
		if(verificaTelefone(telefone))
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
	this.numCartao = numCartao;
	
	
	}
	
	/**
	 * @return nome.
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * @return CPF
	 */
	public String getCPF() {
		return cpf;
	}

	/**
	 * @return RG.
	 */
	public String getRG() {
		return rg;
	}

	/**	
	 * @return email.
	 */
	public String getEmail() {
		return email;
	}
	

	/**	
	 * @return 
	 * 		endereco.
	 */
	public String getEndereco() {
		return endereco;
	}
	
	/**	
	 * @return 
	 * 		Numero de cartao do hospede
	 */
	public String getNumCartao() {
		return numCartao;
	}
	
	/**
	 * Retorna a String telefone.
	 * @returntelefone.
	 */
	public String getTelefone() {
		return telefone;
	}
	
	/**
	 * Retorna Idade
	 * @return idade
	 */
	public String getIdade() {		
		
		return idade;

	}
	
	/**
	 * Modifica o CPF do hospede, verificando se o paramatro eh valido antes
	 */
	public void setCpf(String cpf) throws CpfInvalidoExcepcion {
		if(cpf == null || !(isCPF(cpf)))
			throw new CpfInvalidoExcepcion("CPF invalido");
		this.cpf = cpf;
	}
	
	/**
	 * Modifica o RG do hospede, verificando se o paramatro eh valido antes
	 */
	public void setRg(String rg) throws RgInvalidoException {
		if(rg == null || rg.equals("") || rg.length() != 7 || validoRg(rg))
			throw new RgInvalidoException("RG invalido");
		this.rg = rg;
	}
	
	/**
	 * Modifica o Cartao do hospede, verificando se o paramatro eh valido antes
	 */
	public void setNumCartao(String numCartao) throws NumeroCartaoException {
		if (numCartao == null || numCartao.equals("") || !(validaCartaoDeCredito(numCartao))){
			throw new NumeroCartaoException("Cartao de credito invalido");
		}
		this.numCartao = numCartao;
	}
	
	/**
	 * Modifica o nome do hospede, verificando se o paramatro eh valido antes
	 */
	public void setNome(String nome) throws NomeInvalidoException {
		if(nome == null || nome.equals(""))
			throw new NomeInvalidoException("Nome invalido");
		this.nome = nome;
	}
	
	/**
	 * Modifica a idade do hospede, verificando se o paramatro eh valido antes
	 */
	public void setIdade(String idade) throws IdadeInvalidaException {
		if(verificaIdade(idade))
			throw new IdadeInvalidaException("Idade invalida");
		
		this.idade = idade;
	}
	
	/**
	 * Modifica o email do hospede, verificando se o paramatro eh valido antes
	 */
	public void setEmail(String email) throws EmailInvalidoExcepcion {
		if(email == null || email.equals("") || verificaEmail(email) == false)
			throw new EmailInvalidoExcepcion("E-mail invalido");
		this.email = email;
	}
	
	/**
	 * Modifica o endereco do hospede, verificando se o paramatro eh valido antes
	 */
	public void setEndereco(String endereco) throws EnderecoInvalidoException {
		if(endereco == null || endereco.equals(""))
			throw new EnderecoInvalidoException("Endereco invalido");
		this.endereco = endereco;
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
	 * Muda o telefone, primeiramenteverificase o parametro e valido, no caso de confirmar-se a afirmacao anterior, muda o telefone.
	 * @param telefone
	 * @throws Exception
	 */
	public void setTelefone(String telefone) throws Exception {
		if(verificaTelefone(telefone))
			throw new TelefoneInvalidoException("Telefone invalido");
		this.telefone = telefone;
	}
	
	
	/**
	 * Mostra um resumo do hospede
	 */
	public String mostraInformacoes(){
		return "Nome: " + getNome() + "\nCPF: " + getCPF() + "\nRG: " + getRG() + "\nE-mail: " + getEmail()
				+ "\nTelefone: " + getTelefone() + "\nEndereco: " + getEndereco() + "\nIdade: "+ getIdade();
	}
	
	/**
	 * Mostra nome e cpf do hospede
	 */
	@Override
	public String toString() {
		return getNome() + " - " + getCPF();
	}

	
	/**
	 * Verifica se dois hospedes sao iguais, pelo nome e cpf
	 */
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Hospede))
			return false;
		Hospede h = (Hospede) obj;
		
		return getNome().equals(h.getNome()) && getCPF().equals(h.getCPF());
	}
	
	
	private boolean verificaEmail(String email){
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
	
	/**
	 * Esse metodo tem como funcao verificar se o cpf recebido eh valido.
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
	
	private boolean verificaTelefone(String telefone){
		if(telefone == null || telefone.equals("") ||  telefone.length() < 8 || telefone.length() > 16)
				return true;
		for (int i = 0; i < telefone.length(); i++) {
			if(Character.isLetter(telefone.charAt(i))){
				return true;					
			}
		}
		return false;
	}
		
	
	private boolean verificaIdade(String idade) {
		if(idade == null || idade.equals(""))
			return true;
		int idades = Integer.parseInt(idade);
		if(idades<18 || idades> 120)
			return true;
		return false;
	}			


}


	