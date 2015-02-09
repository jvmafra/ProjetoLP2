package testes;

import org.junit.Assert;
import org.junit.Test;

import classes.Quartos.Quarto;
import classes.Quartos.QuartoExecutivoDuplo;
import classes.Quartos.QuartoExecutivoSimples;
import classes.Quartos.QuartoExecutivoTriplo;
import classes.Quartos.QuartoLuxoDuplo;
import classes.Quartos.QuartoLuxoSimples;
import classes.Quartos.QuartoLuxoTriplo;
import classes.Quartos.QuartoPresidencial;




public class QuartosTest {
	private Quarto q1;
	private Quarto q2;
	private Quarto q3;
	
	@Test
	public void testaExecutivoSimples() {
		
		try {
			q1 = new QuartoExecutivoSimples(-10);
			Assert.fail();
		} catch (Exception e) {
			Assert.assertEquals(e.getMessage(), "Numero do Quarto invalido");
		}
	}
	
	
	@Test
	public void testaEqualsExecutivoSimples() throws Exception{
		q1 = new QuartoExecutivoSimples(10);
		q2 = new QuartoExecutivoSimples(510);
		q3 = new QuartoExecutivoSimples(10);
		
		Assert.assertFalse(q1.equals(q2));
		Assert.assertTrue(q1.equals(q3));
		
	}
	
	@Test
	public void testaToStringExecutivoSimples() throws Exception{
		q1 = new QuartoExecutivoSimples(10);
		Assert.assertEquals(q1.toString(), "N: " + q1.getNumeroDoQuarto() +" - Executivo Simples");
	}
	
	@Test
	public void testaExecutivoDuplo() {
		try {
			q1 = new QuartoExecutivoDuplo(-10);
			Assert.fail();
		} catch (Exception e) {
			Assert.assertEquals(e.getMessage(), "Numero do Quarto invalido");
		}
		}

	@Test
	public void testaEqualsQuartoExecutivoDuplo() throws Exception{
		q1 = new QuartoExecutivoDuplo(10);
		q2 = new QuartoExecutivoDuplo(510);
		q3 = new QuartoExecutivoDuplo(10);
		
		Assert.assertFalse(q1.equals(q2));
		Assert.assertTrue(q1.equals(q3));
		
	}
	
	@Test
	public void testaToStringExecutivoDuplo() throws Exception{
		q1 = new QuartoExecutivoDuplo(10);
		Assert.assertEquals(q1.toString(), "N: " + q1.getNumeroDoQuarto() +" - Executivo Duplo");
	}
	
	@Test
	public void testaExecutivoTriplo() {
		try {
			q1 = new QuartoExecutivoTriplo(-10);
			Assert.fail();
		} catch (Exception e) {
			Assert.assertEquals(e.getMessage(), "Numero do Quarto invalido");
		}
		

	}
	
	@Test
	public void testaEqualsQuartoExecutivoTriplo() throws Exception{
		q1 = new QuartoExecutivoTriplo(10);
		q2 = new QuartoExecutivoTriplo(510);
		q3 = new QuartoExecutivoTriplo(10);
		
		Assert.assertFalse(q1.equals(q2));
		Assert.assertTrue(q1.equals(q3));
		
	}
	
	@Test
	public void testaToStringExecutivoTriplo() throws Exception{
		q1 = new QuartoExecutivoTriplo(10);
		Assert.assertEquals(q1.toString(), "N: " + q1.getNumeroDoQuarto() +" - Executivo Triplo");
	}
	
	@Test
	public void testaLuxoSimples() {
		try {
			q1 = new QuartoLuxoSimples(-10);
			Assert.fail();
		} catch (Exception e) {
			Assert.assertEquals(e.getMessage(), "Numero do Quarto invalido");
		}
		
	}
	
	@Test
	public void testaEqualsLuxoSimples() throws Exception{
		q1 = new QuartoLuxoSimples(10);
		q2 = new QuartoLuxoSimples(510);
		q3 = new QuartoLuxoSimples(10);
		
		Assert.assertFalse(q1.equals(q2));
		Assert.assertTrue(q1.equals(q3));
		
	}
	
	@Test
	public void testaToStringLuxoSimples() throws Exception{
		q1 = new QuartoLuxoSimples(10);
		Assert.assertEquals(q1.toString(), "N: " + q1.getNumeroDoQuarto() +" - Luxo Simples");
	}
	
	@Test
	public void testaLuxoDuplo() {
		try {
			q1 = new QuartoLuxoDuplo(-10);
			Assert.fail();
		} catch (Exception e) {
			Assert.assertEquals(e.getMessage(), "Numero do Quarto invalido");
		}
		

	}
	
	@Test
	public void testaEqualsQuartoLuxoDuplos() throws Exception{
		q1 = new QuartoLuxoDuplo(10);
		q2 = new QuartoLuxoDuplo(510);
		q3 = new QuartoLuxoDuplo(10);
		
		Assert.assertFalse(q1.equals(q2));
		Assert.assertTrue(q1.equals(q3));
		
	}
	
	@Test
	public void testaToStringLuxoDuplo() throws Exception{
		q1 = new QuartoLuxoDuplo(10);
		Assert.assertEquals(q1.toString(), "N: " + q1.getNumeroDoQuarto() +" - Luxo Duplo");
	}
	
	@Test
	public void testaLuxoTriplo() {
		try {
			q1 = new QuartoLuxoTriplo(-10);
			Assert.fail();
		} catch (Exception e) {
			Assert.assertEquals(e.getMessage(), "Numero do Quarto invalido");
		}
		
	}
	
	@Test
	public void testaEqualsQuartoLuxoTriplo() throws Exception{
		q1 = new QuartoLuxoTriplo(10);
		q2 = new QuartoLuxoTriplo(510);
		q3 = new QuartoLuxoTriplo(10);
		
		Assert.assertFalse(q1.equals(q2));
		Assert.assertTrue(q1.equals(q3));
		
	}
	
	@Test
	public void testaToStringLuxoTriplos() throws Exception{
		q1 = new QuartoLuxoTriplo(10);
		Assert.assertEquals(q1.toString(), "N: " + q1.getNumeroDoQuarto() +" - Luxo Triplo");
	}
	
	@Test
	public void testaPresidencial() {
		try {
			q1 = new QuartoPresidencial(-10);
			Assert.fail();
		} catch (Exception e) {
			Assert.assertEquals(e.getMessage(), "Numero do Quarto invalido");
		}
		
	}
	
	@Test
	public void testaEqualsQuartoPresidencial() throws Exception{
		q1 = new QuartoPresidencial(10);
		q2 = new QuartoPresidencial(510);
		q3 = new QuartoPresidencial(10);
		
		Assert.assertFalse(q1.equals(q2));
		Assert.assertTrue(q1.equals(q3));
		
	}
	
	@Test
	public void testaToStringPresidencial() throws Exception{
		q1 = new QuartoPresidencial(10);
		Assert.assertEquals(q1.toString(), "N: " + q1.getNumeroDoQuarto() +" - Presidencial");
	}
}
