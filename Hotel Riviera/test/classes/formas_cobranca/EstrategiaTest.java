package classes.formas_cobranca;

import nucleo.classes.formas_cobranca.Estrategia;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class EstrategiaTest {
	
	Estrategia estrategia;

	@Before
	public void setUp() throws Exception {
		estrategia = new Estrategia("Copa do Mundo", 2.0);
	}
	
	@Test
	public void testaConstrutor(){
		try {
			estrategia = new Estrategia(null, 2);
			Assert.fail("Deveria lancar excecao");
		} catch (Exception e) {
			Assert.assertEquals("Digite um nome", e.getMessage());
		}
		
		try {
			estrategia = new Estrategia("", 2);
			Assert.fail("Deveria lancar excecao");
		} catch (Exception e) {
			Assert.assertEquals("Digite um nome", e.getMessage());
		}
		
		try {
			estrategia = new Estrategia("Sao Joao", -1);
			Assert.fail("Deveria lancar excecao");
		} catch (Exception e) {
			Assert.assertEquals("Digite um fator valido", e.getMessage());
		}
	}
	
	@Test
	public void testaSets(){
		try {
			estrategia.setNome("");
			Assert.fail("Deveria lancar excecao");
		} catch (Exception e) {
			Assert.assertEquals("Digite um nome", e.getMessage());
		}
		
		try {
			estrategia.setNome(null);
			Assert.fail("Deveria lancar excecao");
		} catch (Exception e) {
			Assert.assertEquals("Digite um nome", e.getMessage());
		}
		
		try {
			estrategia.setFator(0);
			Assert.fail("Deveria lancar excecao");
		} catch (Exception e) {
			Assert.assertEquals("Digite um fator valido", e.getMessage());
		}
	}
	
	
	@Test
	public void testaEquals() throws Exception{
		Estrategia e2 = new Estrategia("Sao Joao", 2);
		Estrategia e3 = new Estrategia("Sao Joao", 3);
		
		Assert.assertTrue(e2.equals(estrategia));
		Assert.assertFalse(e2.equals(e3));
		Assert.assertFalse(e3.equals(estrategia));
	}
	
	@Test
	public void testaToString(){
		Assert.assertEquals("Copa do Mundo", estrategia.toString());
	}
	
	

}
