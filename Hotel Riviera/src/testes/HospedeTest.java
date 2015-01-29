package testes;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import classes.Hospede;

public class HospedeTest {
	private Hospede h1;
	private Hospede h2;
	private Hospede h3;
	
	@Before
	public void setUp() throws Exception {
		h1 = new Hospede("Adiel Andrade Rocha", "87654321098", "0982828718", "adiel.rocha@ccc.ufcg.edu.br", "08396250807" , "Rua: kkdkdk");
		h2 = new Hospede("Artur Andrade Rocha" , "09876543211","0982828718",  "Skillet@qualquer.com", "09876544320", "Rua:oof");
	}
		
	
	@Test
	public void testConstrutorHospedeNome() {
		
		
		try{
			h3 = new Hospede("","87654321098", "0982828718", "adiel.rocha@ccc.ufcg.edu.br", "08396250807" , "Rua: kkdkdk");
			Assert.fail("Deveria lancar excecao");
		} catch(Exception e) {
			Assert.assertEquals("Nome invalido", e.getMessage());
		}
		try{
			
			h3 = new Hospede(null,"87654321098", "0982828718", "adiel.rocha@ccc.ufcg.edu.br", "08396250807" , "Rua: kkdkdk");
			Assert.fail("Deveria lancar excecao");
		} catch(Exception e) {
			Assert.assertEquals("Nome invalido", e.getMessage());
		}
	}
		@Test
		public void testConstrutorHospedeCPF(){ 
		
		try{
			h3 = new Hospede("Alane" ,null, "0982828718", "adiel.rocha@ccc.ufcg.edu.br", "08396250807" , "Rua: kkdkdk");
			Assert.fail("Deveria lancar excecao");
		} catch(Exception e) {
			Assert.assertEquals("CPF invalido", e.getMessage());
		}
		
		try{
			h3 = new Hospede("Alane" ,"", "0982828718", "adiel.rocha@ccc.ufcg.edu.br", "08396250807" , "Rua: kkdkdk");
			Assert.fail("Deveria lancar excecao");
		} catch(Exception e) {
			Assert.assertEquals("CPF invalido", e.getMessage());
		}
		
		try{
			h3 = new Hospede("Alane" ,"098765432112", "0982828718", "adiel.rocha@ccc.ufcg.edu.br", "08396250807" , "Rua: kkdkdk");
			Assert.fail("Deveria lancar excecao");
		} catch(Exception e) {
			Assert.assertEquals("CPF invalido", e.getMessage());
		}
		
		try{
			h3 = new Hospede("Alane" , "era pra ter um numero aki", "0982828718", "adiel.rocha@ccc.ufcg.edu.br", "08396250807" , "Rua: kkdkdk");
			Assert.fail("Deveria lancar excecao");
		} catch(Exception e) {
			Assert.assertEquals("CPF invalido", e.getMessage());
		}
		
		}
		@Test
		public void testConstrutorHospedeRG() {
		
		try{
			h3 = new Hospede("Alane" ,"87654321098", null , "adiel.rocha@ccc.ufcg.edu.br", "08396250807" , "Rua: kkdkdk");
			Assert.fail("Deveria lancar excecao");
		} catch(Exception e) {
			Assert.assertEquals("RG invalido", e.getMessage());
		}
		
		try{
			h3 = new Hospede("Alane" ,"87654321098", "" , "adiel.rocha@ccc.ufcg.edu.br", "08396250807" , "Rua: kkdkdk");
			Assert.fail("Deveria lancar excecao");
		} catch(Exception e) {
			Assert.assertEquals("RG invalido", e.getMessage());
		}
		

		try{
			h3 = new Hospede("Alane" ,"87654321098", "era pra ter um numero aki" , "adiel.rocha@ccc.ufcg.edu.br", "08396250807" , "Rua: kkdkdk");
			Assert.fail("Deveria lancar excecao");
		} catch(Exception e) {
			Assert.assertEquals("RG invalido", e.getMessage());
		}
		
		}
		
		@Test
		public void testConstrutorHospedeEmail(){ 
		try{
			h3 = new Hospede("Alane" ,"87654321098", "0982828718", null , "08396250807" , "Rua: kkdkdk");
			Assert.fail("Deveria lancar excecao");
		} catch(Exception e) {
			Assert.assertEquals("E-mail invalido", e.getMessage());
			
		}
		
		try{
			h3 = new Hospede("Alane" ,"87654321098", "0982828718", "" , "08396250807" , "Rua: kkdkdk");
			Assert.fail("Deveria lancar excecao");
		} catch(Exception e) {
			Assert.assertEquals("E-mail invalido", e.getMessage());
			
		}
		}
		
		@Test
		public void testConstrutorHospedeTelefone() {
		try{
			h3 = new Hospede("Alane" ,"87654321098", "0982828718", "adiel.rocha@ccc.ufcg.edu.br" , null , "Rua: kkdkdk");
			Assert.fail("Deveria lancar excecao");
		} catch(Exception e) {
			Assert.assertEquals("Telefone invalido", e.getMessage());
			
		}
		
		try{
			h3 = new Hospede("Alane" ,"87654321098", "0982828718", "adiel.rocha@ccc.ufcg.edu.br" , "" , "Rua: kkdkdk");
			Assert.fail("Deveria lancar excecao");
		} catch(Exception e) {
			Assert.assertEquals("Telefone invalido", e.getMessage());
			
		}
		
		try{
			h3 = new Hospede("Alane" ,"87654321098", "0982828718", "adiel.rocha@ccc.ufcg.edu.br" , "era para ter um numero aqui" , "Rua: kkdkdk");
			Assert.fail("Deveria lancar excecao");
		} catch(Exception e) {
			Assert.assertEquals("Telefone invalido", e.getMessage());
			
		}
		}

		@Test
		public void testConstrutorHospedeEndereco() {
		try{
			h3 = new Hospede("Alane" ,"87654321098", "0982828718", "adiel.rocha@ccc.ufcg.edu.br" ,"097654677777" ,  null);
			Assert.fail("Deveria lancar excecao");
		} catch(Exception e) {
			Assert.assertEquals("Endereco invalido", e.getMessage());
			
		}
		
		
		try{
			h3 = new Hospede("Alane" ,"87654321098", "0982828718", "adiel.rocha@ccc.ufcg.edu.br" ,"097654677777" ,  "");
			Assert.fail("Deveria lancar excecao");
		} catch(Exception e) {
			Assert.assertEquals("Endereco invalido", e.getMessage());
			
		}
		
	}
		@Test
		public void testToString() {
			Assert.assertEquals("Nome: " + h1.getNome() + "\nCPF: " + h1.getCpf()
				+ "\nRG: " + h1.getRg() + "\nEmail: " + h1.getEmail() + "\nEndereco: " + h1.getEndereco()
				+ "\nTelefone: " + h1.getTelefone(), h1.toString() );
		}
		
		@Test
		public void testEquals() throws Exception{
			h3 = new Hospede("Adiel Andrade Rocha", "87654321098", "0982828718", "adiel.rocha@ccc.ufcg.edu.br", "08396250807" , "Rua: kkdkdk");
			Assert.assertTrue(h1.equals(h3));
			Assert.assertFalse(h2.equals(h3));
		}

}
