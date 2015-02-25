package classes.servicos;

import java.util.Calendar;
import java.util.GregorianCalendar;

import nucleo.classes.hotel.Periodo;
import nucleo.classes.servicos.Baba;
import nucleo.classes.servicos.Carro;
import nucleo.excecoes.DescricaoInvalidaException;
import nucleo.excecoes.NomeInvalidoException;
import nucleo.excecoes.PlacaInvalidaException;
import nucleo.excecoes.TelefoneInvalidoException;

import org.junit.Assert;
import org.junit.Test;

public class CarroTest {
	private Carro c1;
	private Carro c2;
	private Carro c3;
	
	

	@Test
	public void testConstrutor() {
		try{
			c1 = new Carro("Carro", "12345678",true);
			Assert.fail("Deveria lancar excecao");
		} catch(Exception e) {
		Assert.assertEquals("Placa invalida", e.getMessage());
		}
	
		try{
			c1 = new Carro("Carro","as234aa",true);
			Assert.fail("Deveria lancar excecao");
		} catch(Exception e) {
			Assert.assertEquals("Placa invalida", e.getMessage());
		}
		
		try{
			c1 = new Carro("Carro",null ,true);
			Assert.fail("Deveria lancar excecao");
		} catch(Exception e) {
			Assert.assertEquals("Placa invalida", e.getMessage());
		}
		
		try{
			c1 = new Carro("Carro","aaaaaaa",true);
			Assert.fail("Deveria lancar excecao");
		} catch(Exception e) {
			Assert.assertEquals("Placa invalida", e.getMessage());
		}
		try{
			c1 = new Carro("","aaaaaaa",true);
			Assert.fail("Deveria lancar excecao");
		} catch(Exception e) {
			Assert.assertEquals("Descricao invalida", e.getMessage());
		}
		try{
			c1 = new Carro(null,"aaaaaaa",true);
			Assert.fail("Deveria lancar excecao");
		} catch(Exception e) {
			Assert.assertEquals("Descricao invalida", e.getMessage());
		}
		
}
	@Test
	public void testEquals() throws Exception{
		c1= new Carro("Carro", "asd1234" , true);
		c2= new Carro("Carro","asd1234" , true);
		c3= new Carro("Carro", "asd9234" , true);
		
		Assert.assertFalse(c1.equals(c3));
		Assert.assertTrue(c1.equals(c2));
		
	}
	
	@Test
	public void testToString() throws Exception{
		c1= new Carro("Carro","asd1234" , true);
		Assert.assertEquals ("Carro - asd1234", c1.toString());
	}
	
	@Test
	public void testIsDisponivel() throws Exception{
		Calendar data3 = new GregorianCalendar(2015, 5, 22);
		Calendar data4 = new GregorianCalendar(2015, 5, 24);
		Periodo p2 = new Periodo(data3, data4);
		c1= new Carro("Carro","asd1234" , true);
		
		Assert.assertTrue(c1.isDisponivel(p2));
		c1.adicionaPeriodo(p2);
		Assert.assertFalse(c1.isDisponivel(p2));
	}
	
	@Test
	public void testAdicionaPeriodo() throws Exception {
		Calendar data3 = new GregorianCalendar(2015, 5, 22);
		Calendar data4 = new GregorianCalendar(2015, 5, 24);
		Periodo p = new Periodo(data3, data4);
		c1= new Carro("Carro","asd1234" , true);
		Assert.assertEquals(c1.getPeriodos().size(), 0);
		c1.adicionaPeriodo(p);
		Assert.assertEquals(c1.getPeriodos().size(), 1);
	}
	
	@Test
	public void testRemovePeriodo() throws Exception{
		Calendar data3 = new GregorianCalendar(2015, 5, 22);
		Calendar data4 = new GregorianCalendar(2015, 5, 24);
		Periodo p = new Periodo(data3, data4);
		c1= new Carro("Carro","asd1234" , true);
		c1.adicionaPeriodo(p);
		Assert.assertEquals(c1.getPeriodos().size(), 1);
		c1.removePeriodo(p);
		Assert.assertEquals(c1.getPeriodos().size(), 0);
	}
	
	@Test
	public void testSetPlaca(){
		try{
			c1= new Carro("Carro","asd1234" , true);
			c1.setPlaca("12345678");
			Assert.fail("Deveria lancar excecao");
		} catch(Exception e) {
		Assert.assertEquals("Placa invalida", e.getMessage());
		}
	
		try{
			c1= new Carro("Carro","asd1234" , true);
			c1.setPlaca("as123as");
			Assert.fail("Deveria lancar excecao");
		} catch(Exception e) {
			Assert.assertEquals("Placa invalida", e.getMessage());
		}
		
		try{
			c1= new Carro("Carro","asd1234" , true);
			c1.setPlaca("aaaaaaa");
			Assert.fail("Deveria lancar excecao");
		} catch(Exception e) {
			Assert.assertEquals("Placa invalida", e.getMessage());
		}
		
		try{
			c1= new Carro("Carro","asd1234" , true);
			c1.setPlaca(null);
			Assert.fail("Deveria lancar excecao");
		} catch(Exception e) {
			Assert.assertEquals("Placa invalida", e.getMessage());
		}
	}
	
}