package testes;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import classes.Pessoa.Hospede;
import excecoes.EntradaDeDadosException;
import excecoes.NomeInvalidoException;

public class HospedeTest {
	private Hospede h1;
	private Hospede h2;
	private Hospede h3;
	
	@Before
	public void iniciaHospede() throws Exception{
		h1 = new Hospede("Edval","10530025485", "3224432", "e@hot.com", "8888888888", "ary", "4001635716004159");
	}

	@Test
	public void testandoNome() throws EntradaDeDadosException{
		try{
			
			h3 = new Hospede(null,"87654321098", "0982828718", "adiel.rocha@ccc.ufcg.edu.br", "08396250807" , "Rua: kkdkdk", "3841001111222233334");
			Assert.fail("Deveria lancar excecao");
		} catch(NomeInvalidoException e) {
			Assert.assertEquals("Nome invalido", e.getMessage());
		}
	
		try{
			
			h3 = new Hospede("","87654321098", "0982828718", "adiel.rocha@ccc.ufcg.edu.br", "08396250807" , "Rua: kkdkdk", "3841001111222233334");
			Assert.fail("Deveria lancar excecao");
		} catch(NomeInvalidoException e) {
			Assert.assertEquals("Nome invalido", e.getMessage());
		}
}

		@Test
		public void testConstrutorHospedeCPF(){ 
		
		try{
			h3 = new Hospede("Alane" ,null, "0982828718", "adiel.rocha@ccc.ufcg.edu.br", "08396250807" , "Rua: kkdkdk", "3841001111222233334");
			Assert.fail("Deveria lancar excecao");
		} catch(EntradaDeDadosException e) {
			Assert.assertEquals("CPF invalido", e.getMessage());
		}
			

		try{
			h3 = new Hospede("Alane" ,"", "0982828718", "adiel.rocha@ccc.ufcg.edu.br", "08396250807" , "Rua: kkdkdk", "3841001111222233334");
			Assert.fail("Deveria lancar excecao");
		} catch(EntradaDeDadosException e) {
			Assert.assertEquals("CPF invalido", e.getMessage());
		}
		
		try{
			h3 = new Hospede("Alane" ,"098765432112", "0982828718", "adiel.rocha@ccc.ufcg.edu.br", "08396250807" , "Rua: kkdkdk", "3841001111222233334");
			Assert.fail("Deveria lancar excecao");
		} catch(EntradaDeDadosException e) {
			Assert.assertEquals("CPF invalido", e.getMessage());
		}
		
		try{
			h3 = new Hospede("Alane" , "era pra ter um numero aki", "0982828718", "adiel.rocha@ccc.ufcg.edu.br", "08396250807" , "Rua: kkdkdk", "3841001111222233334");
			Assert.fail("Deveria lancar excecao");
		} catch(EntradaDeDadosException e) {
			Assert.assertEquals("CPF invalido", e.getMessage());
		}}

		@Test
		public void testeRG(){
		try{
			h3 = new Hospede("Alane" ,"10530025485", "" , "adiel.rocha@ccc.ufcg.edu.br", "08396250807" , "Rua: kkdkdk", "3841001111222233334");
			Assert.fail("Deveria lancar excecao");
		} catch(EntradaDeDadosException e) {
			Assert.assertEquals("RG invalido", e.getMessage());
		}
			
// uma maneira de quebrar o codigo seria colocando sete letras, o rg seria invalido, mas passaria pelas exceções.
		try{
			h3 = new Hospede("Alane" ,"10530025485", "era pra ter um numero aki" , "adiel.rocha@ccc.ufcg.edu.br", "08396250807" , "Rua: kkdkdk", "3841001111222233334");
			Assert.fail("Deveria lancar excecao");
		} catch(EntradaDeDadosException e) {
			Assert.assertEquals("RG invalido", e.getMessage());
		}
		}
		
		@Test
		public void testConstrutorHospedeEmail(){ 
		try{
			h3 = new Hospede("Alane" ,"10530025485", "2828718", null , "08396250807" , "Rua: kkdkdk", "3841001111222233334");
			Assert.fail("Deveria lancar excecao");
		} catch(EntradaDeDadosException e) {
			Assert.assertEquals("E-mail invalido", e.getMessage());
			
		}
		
		try{
			h3 = new Hospede("Alane" ,"10530025485", "2828718", "" , "08396250807" , "Rua: kkdkdk", "3841001111222233334");
			Assert.fail("Deveria lancar excecao");
		} catch(EntradaDeDadosException e) {
			Assert.assertEquals("E-mail invalido", e.getMessage());
			
		}
		try{
			h3 = new Hospede("Alane" ,"10530025485", "2828718", "edv" , "08396250807" , "Rua: kkdkdk", "3841001111222233334");
			Assert.fail("Deveria lancar excecao");
		} catch(EntradaDeDadosException e) {
			Assert.assertEquals("E-mail invalido", e.getMessage());
			
		}
		try{
			h3 = new Hospede("Alane" ,"10530025485", "2828718", "edv@" , "08396250807" , "Rua: kkdkdk", "3841001111222233334");
			Assert.fail("Deveria lancar excecao");
		} catch(EntradaDeDadosException e) {
			Assert.assertEquals("E-mail invalido", e.getMessage());
			
		}
		try{
			h3 = new Hospede("Alane" ,"10530025485", "2828718", "edv@.com" , "08396250807" , "Rua: kkdkdk", "3841001111222233334");
			Assert.fail("Deveria lancar excecao");
		} catch(EntradaDeDadosException e) {
			Assert.assertEquals("E-mail invalido", e.getMessage());
			
		}
		try{
			h3 = new Hospede("Alane" ,"10530025485", "2828718", "ed@gmail" , "08396250807" , "Rua: kkdkdk", "3841001111222233334");
			Assert.fail("Deveria lancar excecao");
		} catch(EntradaDeDadosException e) {
			Assert.assertEquals("E-mail invalido", e.getMessage());
			
		}
		}
		
		
		@Test
		public void testConstrutorHospedeTelefone() {
		try{
			h3 = new Hospede("Alane" ,"10530025485", "2828718", "ed@gmail.com" , null , "Rua: kkdkdk", "3841001111222233334");
			Assert.fail("Deveria lancar excecao");
		} catch(EntradaDeDadosException e) {
			Assert.assertEquals("Telefone invalido", e.getMessage());
			
		}
		
		try{
			h3 = new Hospede("Alane" ,"10530025485", "2828718", "ed@gmail.com" , "" , "Rua: kkdkdk", "3841001111222233334");
			Assert.fail("Deveria lancar excecao");
		} catch(EntradaDeDadosException e) {
			Assert.assertEquals("Telefone invalido", e.getMessage());
			
		}
		
		try{
			h3 = new Hospede("Alane" ,"10530025485", "2828718", "ed@gmail.com" , "6250807" , "Rua: kkdkdk", "3841001111222233334");
			Assert.fail("Deveria lancar excecao");
		} catch(EntradaDeDadosException e) {
			Assert.assertEquals("Telefone invalido", e.getMessage());
			
		}
		}

		@Test
		public void testConstrutorHospedeEndereco() {
		try{
			h3 = new Hospede("Alane" ,"10530025485", "2828718", "ed@gmail.com" , "6250799807" , null, "3841001111222233334");
			Assert.fail("Deveria lancar excecao");
		} catch(EntradaDeDadosException e) {
			Assert.assertEquals("Endereco invalido", e.getMessage());
			
		}
		
		
		try{
			h3 = new Hospede("Alane" ,"10530025485", "2828718", "ed@gmail.com" , "6250999807" , "", "3841001111222233334");
			Assert.fail("Deveria lancar excecao");
		} catch(EntradaDeDadosException e) {
			Assert.assertEquals("Endereco invalido", e.getMessage());
			
		}
		}		
	
		@Test
		public void testeCartaoDeCredito(){
			try{
				h3 = new Hospede("Alane" ,"10530025485", "2828718", "ed@gmail.com" , "6250999807" , "opa", "41001111222233334");
				Assert.fail("Deveria lancar excecao");
			} catch(EntradaDeDadosException e) {
				Assert.assertEquals("Cartao de credito invalido", e.getMessage());
			}
		
			try{
				h3 = new Hospede("Alane" ,"10530025485", "2828718", "ed@gmail.com" , "6250999807" , "opa", "");
				Assert.fail("Deveria lancar excecao");
			} catch(EntradaDeDadosException e) {
				Assert.assertEquals("Cartao de credito invalido", e.getMessage());
			}
		
			try{
				h3 = new Hospede("Alane" ,"10530025485", "2828718", "ed@gmail.com" , "6250999807" , "opa", null);
				Assert.fail("Deveria lancar excecao");
			} catch(EntradaDeDadosException e) {
				Assert.assertEquals("Cartao de credito invalido", e.getMessage());
			}
			
			try{
				h3 = new Hospede("Alane" ,"10530025485", "2828718", "ed@gmail.com" , "6250999807" , "opa", "9128008511222287638");
				Assert.fail("Deveria lancar excecao");
			} catch(EntradaDeDadosException e) {
				Assert.assertEquals("Cartao de credito invalido", e.getMessage());
			}
			
		}
}
//		@Test
//		public void testToString() {
//			Assert.assertEquals("Nome: " + h1.getNome() + "\nCPF: " + h1.getCpf()
//				+ "\nRG: " + h1.getRg() + "\nEmail: " + h1.getEmail() + "\nEndereco: " + h1.getEndereco()
//				+ "\nTelefone: " + h1.getTelefone(), h1.toString() );
//		}
//		
//		@Test
//		public void testEquals() throws Exception{
//			h3 = new Hospede("Adiel Andrade Rocha", "87654321098", "0982828718", "adiel.rocha@ccc.ufcg.edu.br", "08396250807" , "Rua: kkdkdk", "3841001111222233334");
//			Assert.assertTrue(h1.equals(h3));
//			Assert.assertFalse(h2.equals(h3));
//		}
//
//}
