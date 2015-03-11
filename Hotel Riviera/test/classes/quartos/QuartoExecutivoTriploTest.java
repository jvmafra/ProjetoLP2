package classes.quartos;

import static org.junit.Assert.*;
import nucleo.classes.quartos.Quarto;
import nucleo.classes.quartos.QuartoExecutivoDuplo;
import nucleo.classes.quartos.QuartoExecutivoTriplo;

import org.junit.Assert;
import org.junit.Test;

public class QuartoExecutivoTriploTest {
	private Quarto q1;
	private Quarto q2;
	private Quarto q3;

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
	public void testPermiteCamaExtra() throws Exception{
		q1 = new QuartoExecutivoTriplo(10);
		Assert.assertFalse(q1.permiteCamaExtra());
	}
	
	
	@Test
	public void testIscapacidadeVAlida() throws Exception{
		q1 = new QuartoExecutivoTriplo(10);
		Assert.assertTrue(q1.isCapacidadeValida(1));
		Assert.assertFalse(q1.isCapacidadeValida(6));
	}

}
