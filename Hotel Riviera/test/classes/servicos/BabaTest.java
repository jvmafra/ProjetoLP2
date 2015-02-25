package classes.servicos;

import java.util.Calendar;
import java.util.GregorianCalendar;

import nucleo.classes.hotel.Periodo;
import nucleo.classes.servicos.Baba;
import nucleo.excecoes.NomeInvalidoException;
import nucleo.excecoes.PlacaInvalidaException;
import nucleo.excecoes.TelefoneInvalidoException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;



public class BabaTest {
	private Baba b1;
	private Baba b2;
	private Baba b3;
	private Periodo p;
	Calendar data_inicial = new GregorianCalendar(2015, 1, 24, 20,0 );
	Calendar data_final = new GregorianCalendar(2015, 1, 25, 5 ,0);
	
	@Before
	public void setUp() throws Exception {
		p = new Periodo(data_inicial, data_final);
	}
	
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
		Assert.assertEquals(b1.toString(), "Nome: Adiel - 96854858");
	}
	
	@Test
	public void testSeteNome() throws NomeInvalidoException, TelefoneInvalidoException{
		b1= new Baba("Adiel" , "96854858");
		try{
			b1.setNome(null);
			Assert.fail("Deveria lancar excecao");
		} catch(Exception e) {
		Assert.assertEquals("Nome invalido", e.getMessage());
		}
		
		try{
			b1.setNome("");
			Assert.fail("Deveria lancar excecao");
		} catch(Exception e) {
		Assert.assertEquals("Nome invalido", e.getMessage());
		}
	}
	
	@Test
	public void testSetTelefone() throws NomeInvalidoException, TelefoneInvalidoException{
		b1= new Baba("Adiel" , "96854858");
		try{
			b1.setTelefone("");
			Assert.fail("Deveria lancar excecao");
		} catch(Exception e) {
		Assert.assertEquals("Telefone invalido", e.getMessage());
		}
		
		try{
			b1.setTelefone(null);
			Assert.fail("Deveria lancar excecao");
		} catch(Exception e) {
		Assert.assertEquals("Telefone invalido", e.getMessage());
		}
	
		try{
			b1.setTelefone("telefone");
			Assert.fail("Deveria lancar excecao");
		} catch(Exception e) {
		Assert.assertEquals("Telefone invalido", e.getMessage());
		}
		
		try{
			b1.setTelefone("1234567");
			Assert.fail("Deveria lancar excecao");
		} catch(Exception e) {
		Assert.assertEquals("Telefone invalido", e.getMessage());
		}
		
		try{
			b1.setTelefone("1234596789121314");
			Assert.fail("Deveria lancar excecao");
		} catch(Exception e) {
		Assert.assertEquals("Telefone invalido", e.getMessage());
		}
		
	}
	
	@Test
	public void testAdicionaPeriodo() throws TelefoneInvalidoException, NomeInvalidoException{
		b1= new Baba("Adiel" , "96854858");
		Assert.assertEquals(b1.getPeriodos().size(), 0);
		b1.adicionaPeriodo(p);
		Assert.assertEquals(b1.getPeriodos().size(), 1);
	}
	
	@Test
	public void testRemovePeriodo() throws TelefoneInvalidoException, NomeInvalidoException{
		b1= new Baba("Adiel" , "96854858");
		b1.adicionaPeriodo(p);
		Assert.assertEquals(b1.getPeriodos().size(), 1);
		b1.removePeriodo(p);
		Assert.assertEquals(b1.getPeriodos().size(), 0);
	}

}