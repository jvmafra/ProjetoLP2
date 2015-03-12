package classes.quartos;
//Adiel Andrade e Hugo Gabriel
import nucleo.classes.quartos.Quarto;
import nucleo.classes.quartos.QuartoLuxoTriplo;
import nucleo.classes.quartos.QuartoPresidencial;

import org.junit.Assert;
import org.junit.Test;




public class QuartoPresidencialTest {
	private Quarto q1;
	private Quarto q2;
	private Quarto q3;

	
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
	
	@Test
	public void testPermiteCamaExtra() throws Exception{
		q1 = new QuartoPresidencial(10);
		Assert.assertFalse(q1.permiteCamaExtra());
	}
	
	
	@Test
	public void testIscapacidadeVAlida() throws Exception{
		q1 = new QuartoPresidencial(10);
		Assert.assertTrue(q1.isCapacidadeValida(1));
		Assert.assertFalse(q1.isCapacidadeValida(6));
	}
}
