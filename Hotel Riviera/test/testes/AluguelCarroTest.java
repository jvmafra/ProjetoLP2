package testes;

import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.GregorianCalendar;
import excecoes.PeriodoInvalidoException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import classes.Carro.AluguelCarro;
import classes.Carro.Carro;
import classes.HotelOpiniaoServicosPeriodo.Periodo;

public class AluguelCarroTest {
	Calendar data3 = new GregorianCalendar(2015, 5, 22);
	Calendar data4 = new GregorianCalendar(2015, 5, 24);
	Calendar data5 = new GregorianCalendar(2015, 5, 23);
	Calendar data6 = new GregorianCalendar(2015, 5, 25);
	Calendar data7 = new GregorianCalendar(2015, 5, 27);
	private AluguelCarro ac;
	private AluguelCarro ac2;
	private AluguelCarro ac3;
	private Periodo p;
	private Periodo p2;
	private Periodo p3;
	private Carro c1;
	private Carro c2;
	
	@Before
	public void iniciador() throws Exception{	
	p3 = new Periodo(data6, data7);
	p2 = new Periodo(data3, data4);
	p = new Periodo(data5, data4);
	c1= new Carro("Carro","asd1234" , true);
	c2= new Carro("Carro","asd1204" , true);
	
	
	}
		
	
	@Test
	public void testConstrutor() throws Exception {
		
		try{	
			ac = new AluguelCarro (c1, true, true , p2);
			ac2 = new AluguelCarro (c1, true, true , p2);
			Assert.fail("Deveria lancar excecao");
		} catch(Exception e) {
			Assert.assertEquals("O carro esta ocupado nesse periodo", e.getMessage());
		}
	}

	@Test
	public void testValor() throws Exception{
		ac = new AluguelCarro (c1, true, true , p2);
		Assert.assertEquals(ac.valor(), 450.0, 2);
		ac2 = new AluguelCarro (c2, true, true , p);
		Assert.assertEquals(ac2.valor(), 350.0, 2);
		
	}
	
	@Test
	public void testToString() throws Exception{
		ac = new AluguelCarro (c1, true, true , p2);
		Assert.assertEquals(ac.toString(), "ALUGUEL DE CARRO: " + "\nPeriodo: " + ac.getNumDias() + "\nValor: R$ " +ac.valor());
		
	}
	
	@Test
	public void testEquals() throws Exception{
		ac = new AluguelCarro (c1, true, true , p2);
		ac2 = new AluguelCarro (c1, true, true , p3);
		ac3 = new AluguelCarro (c2, true, true , p);
		
		Assert.assertFalse(ac.equals(ac3));
		Assert.assertTrue(ac.equals(ac2));
		
	}
	
	
}