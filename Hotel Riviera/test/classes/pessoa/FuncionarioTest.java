package classes.pessoa;

import nucleo.classes.pessoa.Funcionario;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class FuncionarioTest {

	private Funcionario f1,f2,f3;
	
	@Before
	public void InicializaFuncionarios() throws Exception{
	
		f1 = new Funcionario("Edval", "ed", "1111111", true);
		f2 = new Funcionario("joao", "cris", "2222222", false);
		
	}

	@Test
	public void testandoExcecoes() throws Exception{
		try {
			f3 = new Funcionario(null, "huguin", "3333333", true);
			Assert.fail("Deveria lancar excecao");
			
		} catch(Exception e) {
			Assert.assertEquals("nome invalido", e.getMessage());
		}
	
		try {
			f3 = new Funcionario("", "huguin", "3333333", true);
			Assert.fail("Deveria lancar excecao");
			
		} catch(Exception e) {
			Assert.assertEquals("nome invalido", e.getMessage());
		}
		
		try {
			f3 = new Funcionario("Hugo", "", "3333333", true);
			Assert.fail("Deveria lancar excecao");
			
		} catch(Exception e) {
			Assert.assertEquals("login invalido", e.getMessage());
		}
		
		try {
			f3 = new Funcionario("Hugo", null, "3333333", true);
			Assert.fail("Deveria lancar excecao");
			
		} catch(Exception e) {
			Assert.assertEquals("login invalido", e.getMessage());
		}
		
		try {
			f3 = new Funcionario("Hugo", "huguin", null, true);
			Assert.fail("Deveria lancar excecao");
			
		} catch(Exception e) {
			Assert.assertEquals("senha invalida", e.getMessage());
		}
		
		try {
			f3 = new Funcionario("Hugo", "huguin", "", true);
			Assert.fail("Deveria lancar excecao");
			
		} catch(Exception e) {
			Assert.assertEquals("senha invalida", e.getMessage());
		}
		
		try {
			f3 = new Funcionario("Hugo", "huguin", "11111", true);
			Assert.fail("Deveria lancar excecao");
			
		} catch(Exception e) {
			Assert.assertEquals("senha muito curta", e.getMessage());
		}
		
		try {
			f3 = new Funcionario("Hugo", "huguin", "11111", true);
			Assert.fail("Deveria lancar excecao");
			
		} catch(Exception e) {
			Assert.assertEquals("senha muito curta", e.getMessage());
		}
	}

	@Test
	public void testGets(){
		f1.getNome().equals("Edval");
		f1.getLogin().equals("ed");
		f1.getSenha().equals("1111111");
		f2.getNome().equals("joao");
		f2.getLogin().equals("cris");
		f2.getSenha().equals("2222222");
		Assert.assertTrue(f1.isPermissaoGerente() == true);
		Assert.assertTrue(f2.isPermissaoGerente() == false);
	}

	@Test
	public void testSets(){
		try {
			f1.setNome(null);
			Assert.fail("Deveria lancar excecao");
			
		} catch(Exception e) {
			Assert.assertEquals("nome invalido", e.getMessage());
		}

		try {
			f1.setNome("");
			Assert.fail("Deveria lancar excecao");
			
		} catch(Exception e) {
			Assert.assertEquals("nome invalido", e.getMessage());
		}
	
		try {
			f1.setLogin(null);
			Assert.fail("Deveria lancar excecao");
			
		} catch(Exception e) {
			Assert.assertEquals("login invalido", e.getMessage());
		}
		
		try {
			f1.setLogin("");
			Assert.fail("Deveria lancar excecao");
			
		} catch(Exception e) {
			Assert.assertEquals("login invalido", e.getMessage());
		}
		
		try {
			f1.setSenha(null);
			Assert.fail("Deveria lancar excecao");
			
		} catch(Exception e) {
			Assert.assertEquals("senha invalida", e.getMessage());
		}
		
		try {
			f1.setSenha("");
			Assert.fail("Deveria lancar excecao");
			
		} catch(Exception e) {
			Assert.assertEquals("senha invalida", e.getMessage());
		}
		
		try {
			f1.setSenha("11111");
			Assert.fail("Deveria lancar excecao");
			
		} catch(Exception e) {
			Assert.assertEquals("senha muito curta", e.getMessage());
		}
	
		try {
			f1.setSenha("111");
			Assert.fail("Deveria lancar excecao");
			
		} catch(Exception e) {
			Assert.assertEquals("senha muito curta", e.getMessage());
		}
		
		try {
			f1.setSenha("5");
			Assert.fail("Deveria lancar excecao");
			
		} catch(Exception e) {
			Assert.assertEquals("senha muito curta", e.getMessage());
		}
		
	
	
	try {
		f1.setSenha("1111");
		Assert.fail("Deveria lancar excecao");
		
	} catch(Exception e) {
		Assert.assertEquals("senha muito curta", e.getMessage());
	}
	
	}

	@Test
	public void testEquals() throws Exception{
		f1 = new Funcionario("Edval", "ed", "111111", true);
		f2 = new Funcionario("Joao", "ed", "111111", true);
		f3 = new Funcionario("Edval", "ed", "111111", true);
		Assert.assertTrue(f1.equals(f3));
		Assert.assertFalse(f2.equals(f3));
	}
	
	@Test
	public void testatoString() {
		Assert.assertEquals(f1.toString(), "Edval - GERENTE");
	}
}
