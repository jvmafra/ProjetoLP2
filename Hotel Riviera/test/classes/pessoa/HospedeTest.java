// Adiel Andrade e Edval

package classes.pessoa;

import nucleo.classes.pessoa.Hospede;
import nucleo.excecoes.EntradaDeDadosException;
import nucleo.excecoes.NomeInvalidoException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class HospedeTest {
	private Hospede h1;
	private Hospede h2;
	private Hospede h3;
	
	@Before
	public void iniciaHospede() throws Exception{
		h1 = new Hospede("Edval","10530025485", "3224432", "18",  "e@hot.com", "8888888888", "ary", "4001635716004159");
		
	
	}

	@Test
	public void testandoNome() throws EntradaDeDadosException{
		try{
			
			h3 = new Hospede(null,"87654321098", "0982828718",  "18", "adiel.rocha@ccc.ufcg.edu.br", "08396250807" , "Rua: kkdkdk", "3841001111222233334");
			Assert.fail("Deveria lancar excecao");
		} catch(NomeInvalidoException e) {
			Assert.assertEquals("Nome invalido", e.getMessage());
		}
	
		try{
			
			h3 = new Hospede("","87654321098", "0982828718", "18", "adiel.rocha@ccc.ufcg.edu.br", "08396250807" , "Rua: kkdkdk", "3841001111222233334");
			Assert.fail("Deveria lancar excecao");
		} catch(NomeInvalidoException e) {
			Assert.assertEquals("Nome invalido", e.getMessage());
		}
}

		@Test
		public void testConstrutorHospedeCPF(){ 
		
		try{
			h3 = new Hospede("Alane" ,null, "0982828718","18", "adiel.rocha@ccc.ufcg.edu.br", "08396250807" , "Rua: kkdkdk", "3841001111222233334");
			Assert.fail("Deveria lancar excecao");
		} catch(EntradaDeDadosException e) {
			Assert.assertEquals("CPF invalido", e.getMessage());
		}
			

		try{
			h3 = new Hospede("Alane" ,"", "0982828718","18", "adiel.rocha@ccc.ufcg.edu.br", "08396250807" , "Rua: kkdkdk", "3841001111222233334");
			Assert.fail("Deveria lancar excecao");
		} catch(EntradaDeDadosException e) {
			Assert.assertEquals("CPF invalido", e.getMessage());
		}
		
		try{
			h3 = new Hospede("Alane" ,"098765432112","0982828718","18","adiel.rocha@ccc.ufcg.edu.br", "08396250807" , "Rua: kkdkdk", "3841001111222233334");
			Assert.fail("Deveria lancar excecao");
		} catch(EntradaDeDadosException e) {
			Assert.assertEquals("CPF invalido", e.getMessage());
		}
		
		try{
			h3 = new Hospede("Alane" , "era pra ter um numero aki",  "0982828718","18","adiel.rocha@ccc.ufcg.edu.br", "08396250807" , "Rua: kkdkdk", "3841001111222233334");
			Assert.fail("Deveria lancar excecao");
		} catch(EntradaDeDadosException e) {
			Assert.assertEquals("CPF invalido", e.getMessage());
		}}

		@Test
		public void testeRG(){
		try{
			h3 = new Hospede("Alane" ,"10530025485", "" , "18","adiel.rocha@ccc.ufcg.edu.br", "08396250807" , "Rua: kkdkdk", "3841001111222233334");
			Assert.fail("Deveria lancar excecao");
		} catch(EntradaDeDadosException e) {
			Assert.assertEquals("RG invalido", e.getMessage());
		}
			
	try{
			h3 = new Hospede("Alane" ,"10530025485", "era pra ter um numero aki" , "18","adiel.rocha@ccc.ufcg.edu.br", "08396250807" , "Rua: kkdkdk", "3841001111222233334");
			Assert.fail("Deveria lancar excecao");
		} catch(EntradaDeDadosException e) {
			Assert.assertEquals("RG invalido", e.getMessage());
		}
		
		
		try{
			h3 = new Hospede("Alane" ,"10530025485", "111111p" ,"18", "adiel.rocha@ccc.ufcg.edu.br", "08396250807" , "Rua: kkdkdk", "3841001111222233334");
			Assert.fail("Deveria lancar excecao");
		} catch(EntradaDeDadosException e) {
			Assert.assertEquals("RG invalido", e.getMessage());
		}
		}
		
		@Test
		public void testConstrutorHospedeEmail(){ 
		try{
			h3 = new Hospede("Alane" ,"10530025485", "2828718","18", null , "08396250807" , "Rua: kkdkdk", "3841001111222233334");
			Assert.fail("Deveria lancar excecao");
		} catch(EntradaDeDadosException e) {
			Assert.assertEquals("E-mail invalido", e.getMessage());
			
		}
		
		try{
			h3 = new Hospede("Alane" ,"10530025485", "2828718","18","" , "08396250807" , "Rua: kkdkdk", "3841001111222233334");
			Assert.fail("Deveria lancar excecao");
		} catch(EntradaDeDadosException e) {
			Assert.assertEquals("E-mail invalido", e.getMessage());
			
		}
		try{
			h3 = new Hospede("Alane" ,"10530025485", "2828718", "18","edv" , "08396250807" , "Rua: kkdkdk", "3841001111222233334");
			Assert.fail("Deveria lancar excecao");
		} catch(EntradaDeDadosException e) {
			Assert.assertEquals("E-mail invalido", e.getMessage());
			
		}
		try{
			h3 = new Hospede("Alane" ,"10530025485", "2828718","18", "edv@" , "08396250807" , "Rua: kkdkdk", "3841001111222233334");
			Assert.fail("Deveria lancar excecao");
		} catch(EntradaDeDadosException e) {
			Assert.assertEquals("E-mail invalido", e.getMessage());
			
		}
		try{
			h3 = new Hospede("Alane" ,"10530025485", "2828718", "18","edv@.com" , "08396250807" , "Rua: kkdkdk", "3841001111222233334");
			Assert.fail("Deveria lancar excecao");
		} catch(EntradaDeDadosException e) {
			Assert.assertEquals("E-mail invalido", e.getMessage());
			
		}
		try{
			h3 = new Hospede("Alane" ,"10530025485", "2828718","18", "ed@gmail" , "08396250807" , "Rua: kkdkdk", "3841001111222233334");
			Assert.fail("Deveria lancar excecao");
		} catch(EntradaDeDadosException e) {
			Assert.assertEquals("E-mail invalido", e.getMessage());
			
		}
		}
		
		
		@Test
		public void testConstrutorHospedeTelefone() {
		try{
			h3 = new Hospede("Alane" ,"10530025485", "2828718","18", "ed@gmail.com" , null , "Rua: kkdkdk", "3841001111222233334");
			Assert.fail("Deveria lancar excecao");
		} catch(EntradaDeDadosException e) {
			Assert.assertEquals("Telefone invalido", e.getMessage());
			
		}
		
		try{
			h3 = new Hospede("Alane" ,"10530025485", "2828718", "18","ed@gmail.com" , "" , "Rua: kkdkdk", "3841001111222233334");
			Assert.fail("Deveria lancar excecao");
		} catch(EntradaDeDadosException e) {
			Assert.assertEquals("Telefone invalido", e.getMessage());
			
		}
		
		try{
			h3 = new Hospede("Alane" ,"10530025485", "2828718","18", "ed@gmail.com" , "6250807" , "Rua: kkdkdk", "3841001111222233334");
			Assert.fail("Deveria lancar excecao");
		} catch(EntradaDeDadosException e) {
			Assert.assertEquals("Telefone invalido", e.getMessage());
			
		}
		}

		@Test
		public void testConstrutorHospedeEndereco() {
		try{
			h3 = new Hospede("Alane" ,"10530025485", "2828718","18", "ed@gmail.com" , "6250799807" , null, "3841001111222233334");
			Assert.fail("Deveria lancar excecao");
		} catch(EntradaDeDadosException e) {
			Assert.assertEquals("Endereco invalido", e.getMessage());
			
		}
		
		
		try{
			h3 = new Hospede("Alane" ,"10530025485", "2828718", "18","ed@gmail.com" , "6250999807" , "", "3841001111222233334");
			Assert.fail("Deveria lancar excecao");
		} catch(EntradaDeDadosException e) {
			Assert.assertEquals("Endereco invalido", e.getMessage());
			
		}
		}		
	
		@Test
		public void testeCartaoDeCredito(){
			try{
				h3 = new Hospede("Alane" ,"10530025485", "2828718","18", "ed@gmail.com" , "6250999807" , "opa", "41001111222233334");
				Assert.fail("Deveria lancar excecao");
			} catch(EntradaDeDadosException e) {
				Assert.assertEquals("Cartao de credito invalido", e.getMessage());
			}
		
			try{
				h3 = new Hospede("Alane" ,"10530025485", "2828718","18","ed@gmail.com" , "6250999807" , "opa", "");
				Assert.fail("Deveria lancar excecao");
			} catch(EntradaDeDadosException e) {
				Assert.assertEquals("Cartao de credito invalido", e.getMessage());
			}
		
			try{
				h3 = new Hospede("Alane" ,"10530025485", "2828718","18","ed@gmail.com" , "6250999807" , "opa", null);
				Assert.fail("Deveria lancar excecao");
			} catch(EntradaDeDadosException e) {
				Assert.assertEquals("Cartao de credito invalido", e.getMessage());
			}
			
			try{
				h3 = new Hospede("Alane" ,"10530025485", "2828718","18","ed@gmail.com" , "6250999807" , "opa", "9128008511222287638");
				Assert.fail("Deveria lancar excecao");
			} catch(EntradaDeDadosException e) {
				Assert.assertEquals("Cartao de credito invalido", e.getMessage());
			}
			
		}

		@Test
		public void testToString() {
			Assert.assertEquals( "Nome: " + h1.getNome() + "\nCPF: " + h1.getCPF() + "\nRG: " + h1.getRG() + "\nE-mail: " + h1.getEmail()
					+ "\nTelefone: " + h1.getTelefone() + "\nEndereco: " + h1.getEndereco() + "\nIdade: "+ h1.getIdade(), h1.mostraInformacoes() );
			Assert.assertEquals("Edval - 10530025485", h1.toString());
		}
		
		@Test
		public void testEquals() throws Exception{
			h1 = new Hospede("Adiel Andrade Rocha", "10530025485", "2828718","18","adiel.rocha@ccc.ufcg.edu.br", "08396250807" , "Rua: kkdkdk", "376411112222331");
			h2 = new Hospede("Adiel Andrade Rocha", "10530025485", "2828718", "19","adiel.rocha@ccc.ufcg.edu.br", "08396250807" , "Rua: kkdkdk", "376411112222331");
			h3 = new Hospede("Adiel Andrade Rocha", "10530025485", "2828718","18","adiel.rocha@ccc.ufcg.edu.br", "08396250807" , "Rua: kkdkdk", "376411112222331");
			Assert.assertTrue(h1.equals(h3));
			Assert.assertFalse(h2.equals(h3));
		}

}
