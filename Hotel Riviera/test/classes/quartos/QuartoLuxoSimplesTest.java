package classes.quartos;
//Adiel Andrade e Hugo Gabriel
import static org.junit.Assert.*;
import nucleo.classes.quartos.Quarto;
import nucleo.classes.quartos.QuartoLuxoDuplo;
import nucleo.classes.quartos.QuartoLuxoSimples;

import org.junit.Assert;
import org.junit.Test;


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
	
	@Test
	public void testPermiteCamaExtra() throws Exception{
		q1 = new QuartoLuxoSimples(10);
		Assert.assertTrue(q1.permiteCamaExtra());
	}
	
	
	@Test
	public void testIscapacidadeVAlida() throws Exception{
		q1 = new QuartoLuxoSimples(10);
		Assert.assertTrue(q1.isCapacidadeValida(1));
		Assert.assertFalse(q1.isCapacidadeValida(6));
	}
}
