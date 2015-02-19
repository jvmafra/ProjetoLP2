package classes.quartos;

import static org.junit.Assert.*;
import nucleo.classes.quartos.Quarto;
import nucleo.classes.quartos.QuartoExecutivoSimples;

import org.junit.Assert;
import org.junit.Test;

public class QuartoExecultivoSimplesTest {

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

}
