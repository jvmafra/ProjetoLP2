package testes;

import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.GregorianCalendar;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import classes.Opiniao;
import classes.Periodo;

public class PeriodoTest {
	
	private Periodo p1;
	private Periodo p2;
	Calendar data_inicial = new GregorianCalendar(2015, 1, 24);
	Calendar data_final = new GregorianCalendar(2015, 2, 4);

	@Before
	public void setUp() throws Exception {
		p1 = new Periodo(data_inicial, data_final);
	}
	
	@Test
	public void testaExcessoes() throws Exception {
		try {
			p2 = new Periodo(null, null);
			Assert.fail();
		} catch (Exception e) {
			Assert.assertEquals(e.getMessage(), "Datas nulas");
		}
		
		try {
			p2 = new Periodo(null, data_inicial);
			Assert.fail();
		} catch (Exception e) {
			Assert.assertEquals(e.getMessage(), "Datas nulas");
		}
		
		try {
			p2 = new Periodo(null, data_final);
			Assert.fail();
		} catch (Exception e) {
			Assert.assertEquals(e.getMessage(), "Datas nulas");
		}
			
	}
	
	@Test
	public void testaToString() {
		Assert.assertEquals(p1.toString(), "24/2/2015 ate 4/3/2015");
	}
	
	@Test
	public void testaEquals() throws Exception {
		p2 = new Periodo(data_inicial, new GregorianCalendar(2015, 1, 31));
		Assert.assertFalse(p2.equals(p1));
		
		p2 = new Periodo(new GregorianCalendar(2015, 1, 23), data_final);
		Assert.assertFalse(p2.equals(p1));
		
		p2 = new Periodo(data_inicial, data_final);
		Assert.assertTrue(p2.equals(p1));
		
	}
	
	
	
	

}