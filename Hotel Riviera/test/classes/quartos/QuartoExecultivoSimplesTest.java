package classes.quartos;
//Adiel Andrade e Hugo Gabriel
import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.GregorianCalendar;

import nucleo.classes.hotel.Periodo;
import nucleo.classes.quartos.Quarto;
import nucleo.classes.quartos.QuartoExecutivoSimples;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class QuartoExecultivoSimplesTest {
		Calendar data_inicial = new GregorianCalendar(2015, 1, 24);
		Calendar data_final = new GregorianCalendar(2015, 1, 25);
		private Periodo p;
		private Quarto q1;
		private Quarto q2;
		private Quarto q3;
		
		
		@Before
		public void setUp() throws Exception {
			p = new Periodo(data_inicial, data_final);
		}
		
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
		public void testPermiteCamaExtra() throws Exception{
			q1 = new QuartoExecutivoSimples(10);
			Assert.assertTrue(q1.permiteCamaExtra());
		}
		
		
		@Test
		public void testIscapacidadeVAlida() throws Exception{
			q1 = new QuartoExecutivoSimples(10);
			Assert.assertTrue(q1.isCapacidadeValida(1));
			Assert.assertFalse(q1.isCapacidadeValida(3));
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
}
