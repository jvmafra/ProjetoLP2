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
	
	

	@Test
	public void testConstrutor() {
		try{
			c1 = new Carro("12345678",true);
			Assert.fail("Deveria lancar excecao");
		} catch(Exception e) {
		Assert.assertEquals("Placa invalida", e.getMessage());
		}
	
		try{
			c1 = new Carro("as234aa",true);
			Assert.fail("Deveria lancar excecao");
		} catch(Exception e) {
			Assert.assertEquals("Placa invalida", e.getMessage());
		}
		
		try{
			c1 = new Carro("aaaaaaa",true);
			Assert.fail("Deveria lancar excecao");
		} catch(Exception e) {
			Assert.assertEquals("Placa invalida", e.getMessage());
		}
}
	@Test
	public void testEquals() throws Exception{
		c1= new Carro("asd1234" , true);
		c2= new Carro("asd1234" , true);
		c3= new Carro("asd9234" , true);
		
		Assert.assertFalse(c1.equals(c3));
		Assert.assertTrue(c1.equals(c2));
		
	}
	
	@Test
	public void testToString() throws PlacaInvalidaException{
		c1= new Carro("asd1234" , true);
		Assert.assertEquals ("Placa: " + c1.getPlaca(), c1.toString());
	}
	
	@Test
	public void testIsDisponivel() throws Exception{
		Calendar data3 = new GregorianCalendar(2015, 5, 22);
		Calendar data4 = new GregorianCalendar(2015, 5, 24);
		Periodo p2 = new Periodo(data3, data4);
		c1= new Carro("asd1234" , true);
		
		Assert.assertTrue(c1.isDisponivel(p2));
		c1.adicionaPeriodo(p2);
		Assert.assertFalse(c1.isDisponivel(p2));
	}
	
	
	
}
