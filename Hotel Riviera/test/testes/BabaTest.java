package testes;

import java.util.Calendar;
import java.util.GregorianCalendar;

import org.junit.Assert;
import org.junit.Test;

import classes.Baba.Baba;
import classes.HotelOpiniaoServicosPeriodo.Periodo;
import excecoes.NomeInvalidoException;
import excecoes.PlacaInvalidaException;
import excecoes.TelefoneInvalidoException;



public class BabaTest {
	private Baba b1;
	private Baba b2;
	private Baba b3;

	
	@Test
	public void testConstrutor() {
		try{
			b1 = new Baba(null , "96585858");
			Assert.fail("Deveria lancar excecao");
		} catch(Exception e) {
		Assert.assertEquals("Nome invalido", e.getMessage());
		}
		
		try{
			b1 = new Baba("" , "96585858");
			Assert.fail("Deveria lancar excecao");
		} catch(Exception e) {
		Assert.assertEquals("Nome invalido", e.getMessage());
		}
		
		try{
			b1 = new Baba("Adiel" , "");
			Assert.fail("Deveria lancar excecao");
		} catch(Exception e) {
		Assert.assertEquals("Telefone invalido", e.getMessage());
		}
		
		try{
			b1 = new Baba("Adiel" , null);
			Assert.fail("Deveria lancar excecao");
		} catch(Exception e) {
		Assert.assertEquals("Telefone invalido", e.getMessage());
		}
	
		try{
			b1 = new Baba("Adiel" , "numerojj");
			Assert.fail("Deveria lancar excecao");
		} catch(Exception e) {
		Assert.assertEquals("Telefone invalido", e.getMessage());
		}
		
		try{
			b1 = new Baba("Adiel" , "123567");
			Assert.fail("Deveria lancar excecao");
		} catch(Exception e) {
		Assert.assertEquals("Telefone invalido", e.getMessage());
		}
		
		try{
			b1 = new Baba("Adiel" , "12356789101213");
			Assert.fail("Deveria lancar excecao");
		} catch(Exception e) {
		Assert.assertEquals("Telefone invalido", e.getMessage());
		}
	
	}

	@Test
	public void testEquals() throws Exception{
		b1= new Baba("Adiel" , "96854858");
		b2= new Baba("Adiel" , "96854858");
		b3= new Baba("Edval" , "96854857");
		
		Assert.assertFalse(b1.equals(b3));
		Assert.assertTrue(b1.equals(b2));
				
	}
	@Test
	public void testIsDisponivel() throws Exception{
		Calendar data3 = new GregorianCalendar(2015, 5, 22);
		Calendar data4 = new GregorianCalendar(2015, 5, 24);
		Periodo p2 = new Periodo(data3, data4);
		b1= new Baba("Adiel" , "96854858");
		
		Assert.assertTrue(b1.isDisponivel(p2));
	}
		@Test
		public void testToString() throws PlacaInvalidaException, NomeInvalidoException, TelefoneInvalidoException{
			b1= new Baba("Adiel" , "96854858");
			Assert.assertEquals(b1.toString(), "Nome: " + b1.getNome() + "/n" +"Numero: " + b1.getNumero());
		}
	


}
