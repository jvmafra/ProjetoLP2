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
	public void testaNumDias() throws Exception {
		Assert.assertEquals(8, p1.getNumeroDias());
		
		p2 = new Periodo(data_inicial, new GregorianCalendar(2015,1,28));
		Assert.assertEquals(4, p2.getNumeroDias());
		
		p2 = new Periodo(data_inicial, new GregorianCalendar(2015,2,31));
		Assert.assertEquals(35, p2.getNumeroDias());
		
		p2 = new Periodo(new GregorianCalendar(2015,11,31), new GregorianCalendar(2016,0,1));
		Assert.assertEquals(1, p2.getNumeroDias());
		
		p2 = new Periodo(new GregorianCalendar(2015,11,31), new GregorianCalendar(2016,0,2));
		Assert.assertEquals(2, p2.getNumeroDias());
		
		p2 = new Periodo(new GregorianCalendar(2015,3,30), new GregorianCalendar(2015,4,1));
		Assert.assertEquals(1, p2.getNumeroDias());
		
		p2 = new Periodo(new GregorianCalendar(2015,3,30), new GregorianCalendar(2015,4,1));
		Assert.assertEquals(1, p2.getNumeroDias());
		
		p2 = new Periodo(new GregorianCalendar(2015,3,30), new GregorianCalendar(2015,4,1));
		Assert.assertEquals(1, p2.getNumeroDias());
	}
	
	@Test
	public void testaCoincidenciaDePeriodos() throws Exception {
		p2 = new Periodo(data_inicial, new GregorianCalendar(2015,5,20));
		Assert.assertTrue(p1.periodoCoincide(p2));
		
		p2 = new Periodo(new GregorianCalendar(2015,1,23), data_final);
		Assert.assertTrue(p1.periodoCoincide(p2));
		
		p2 = new Periodo(data_inicial, data_final);
		Assert.assertTrue(p1.periodoCoincide(p2));
		
		p2 = new Periodo(new GregorianCalendar(2015,2,5), new GregorianCalendar(2015,5,31));
		Assert.assertFalse(p1.periodoCoincide(p2));
		
		p2 = new Periodo(new GregorianCalendar(2015,1,1), new GregorianCalendar(2015,1,23));
		Assert.assertFalse(p1.periodoCoincide(p2));
	}
	
	@Test
	public void testaDataContidaEmPeriodo() throws Exception{
		Calendar data1 = new GregorianCalendar(2015, 2, 4);
		Assert.assertTrue(p1.dataIsContida(data1));
		
		Calendar data2 = new GregorianCalendar(2015, 1, 24);
		Assert.assertTrue(p1.dataIsContida(data2));				// 24/1 à 04/02
		
		Calendar data3 = new GregorianCalendar(2015, 1, 25);
		Assert.assertTrue(p1.dataIsContida(data3));
		
		Calendar data4 = new GregorianCalendar(2015, 2, 3);
		Assert.assertTrue(p1.dataIsContida(data4));
		
		Calendar data5 = new GregorianCalendar(2015, 1, 23);
		Assert.assertFalse(p1.dataIsContida(data5));
		
		Calendar data6 = new GregorianCalendar(2015, 2, 5);
		Assert.assertFalse(p1.dataIsContida(data6));
		
		Calendar data7 = new GregorianCalendar(2015, 1, 30);
		Assert.assertTrue(p1.dataIsContida(data7));
		
	}
	
	
	@Test
	public void testaToString() {
		Assert.assertEquals(p1.toString(), "24/2/2015 ate 4/3/2015");
	}
	
	@Test
	public void testaEquals() throws Exception {
		p2 = new Periodo(data_inicial, new GregorianCalendar(2015, 1, 31));
		Assert.assertTrue(p2.equals(p1));
		
		p2 = new Periodo(new GregorianCalendar(2015, 1, 23), data_final);
		Assert.assertTrue(p2.equals(p1));
		
		p2 = new Periodo(data_inicial, data_final);
		Assert.assertTrue(p2.equals(p1));
		
		p2 = new Periodo(new GregorianCalendar(2015, 2, 5), new GregorianCalendar(2015, 2, 6));
		Assert.assertFalse(p2.equals(p1));
	}
	
	
	
	

}
