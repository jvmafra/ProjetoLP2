package classes.Quartos;

import static org.junit.Assert.*;
import classes.Quartos.QuartoLuxoSimples;
import org.junit.Assert;
import org.junit.Test;

import classes.Quartos.Quarto;


public class QuartoLuxoSimplesTest {
	private Quarto q1;
	private Quarto q2;
	private Quarto q3;

	
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
}
