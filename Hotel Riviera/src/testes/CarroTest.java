package testes;

import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.GregorianCalendar;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import classes.Carro.Carro;
import classes.HotelOpiniaoServicosPeriodo.Periodo;
import excecoes.PlacaInvalidaException;

public class CarroTest {
	private Carro c1;
	private Carro c2;
	private Carro c3;
	Calendar data1 = new GregorianCalendar(2015, 5, 20);
	Calendar data2 = new GregorianCalendar(2015, 5, 28);
	private Periodo p;
	
	@Before
	public void setUp() throws Exception {
		p = new Periodo(data1, data2);
	}
	

	@Test
	public void testConstrutor() {
		try{
			c1 = new Carro("12345678",true, p);
			Assert.fail("Deveria lancar excecao");
		} catch(Exception e) {
		Assert.assertEquals("Placa invalida", e.getMessage());
		}
	
		try{
			c1 = new Carro("as234aa",true, p);
			Assert.fail("Deveria lancar excecao");
		} catch(Exception e) {
			Assert.assertEquals("Placa invalida", e.getMessage());
		}
		
		try{
			c1 = new Carro("aaaaaaa",true, p);
			Assert.fail("Deveria lancar excecao");
		} catch(Exception e) {
			Assert.assertEquals("Placa invalida", e.getMessage());
		}
}
	@Test
	public void testEquals() throws Exception{
		c1= new Carro("asd1234" , true, p);
		c2= new Carro("asd1234" , true, p);
		c3= new Carro("asd9234" , true, p);
		
		Assert.assertFalse(c1.equals(c3));
		Assert.assertTrue(c1.equals(c2));
		
	}
	
	@Test
	public void testToString() throws PlacaInvalidaException{
		c1= new Carro("asd1234" , true, p);
		Assert.assertEquals ("Placa: " + c1.getPlaca(), c1.toString());
	}
	
	@Test
	public void testIsDisponivel() throws Exception{
		Calendar data3 = new GregorianCalendar(2015, 5, 22);
		Calendar data4 = new GregorianCalendar(2015, 5, 24);
		Periodo p2 = new Periodo(data3, data4);
		c1= new Carro("asd1234" , true, p);
		
		Assert.assertTrue(c1.isDisponivel(p2));
		
	}
	
}