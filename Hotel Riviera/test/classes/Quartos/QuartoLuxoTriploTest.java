package classes.Quartos;

import static org.junit.Assert.*;
import classes.Quartos.Quarto;
import classes.Quartos.QuartoLuxoTriplo;

import org.junit.Assert;
import org.junit.Test;

public class QuartoLuxoTriploTest {

	private Quarto q1;
	private Quarto q2;
	private Quarto q3;

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
	

}
