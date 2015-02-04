package testes;

import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.GregorianCalendar;

import classes.Baba.Baba;
import classes.Baba.BabySitter;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import classes.HotelOpiniaoServicosPeriodo.Periodo;
import excecoes.NomeInvalidoException;
import excecoes.TelefoneInvalidoException;


public class BabySitterTest {
	private Baba bb;
	private Baba bb2;
	private Baba bb3;
	Calendar data_inicial = new GregorianCalendar(2015, 1, 24, 20,0 );
	Calendar data_final = new GregorianCalendar(2015, 1, 25, 7 ,0);
	
	Calendar data_inicial2 = new GregorianCalendar(2015, 1, 24, 8,0 );
	Calendar data_final2 = new GregorianCalendar(2015, 1, 24, 17, 0);
	
	Calendar data_inicial3 = new GregorianCalendar(2015, 1, 24, 0,0 );
	Calendar data_final3 = new GregorianCalendar(2015, 1, 25, 0, 0);
	private Periodo p;
	private Periodo p2;
	private Periodo p3;
	private BabySitter baby;
	private BabySitter baby2;
	private BabySitter baby3;

	@Before
	public void setUp() throws Exception {
		bb = new Baba("Adiel Andrade", "96250807" );
		bb3 = new Baba("Adiel Andrade", "96250807" );
		bb2 = new Baba("Adiel Andrade", "96250807" );
		p = new Periodo(data_inicial, data_final);
		p2 = new Periodo(data_inicial2, data_final2);
		p3 = new Periodo(data_inicial3, data_final3);
		
	}
	

	@Test
	public void testConstrutor() {
		
		try{
			baby = new BabySitter(bb , p);
			baby2 = new BabySitter(bb , p);
			Assert.fail("Deveria lancar excecao");
		} catch(Exception e) {
		Assert.assertEquals("Baba esta indisponivel nesse periodo", e.getMessage());
		}
		
		try{
			baby = new BabySitter(null , p);
			Assert.fail("Deveria lancar excecao");
		} catch(Exception e) {
		Assert.assertEquals("Baba passada invalida", e.getMessage());
		}
		
		try{
			baby = new BabySitter(bb , null);
			Assert.fail("Deveria lancar excecao");
		} catch(Exception e) {
		Assert.assertEquals("Datas nulas", e.getMessage());
		}
				
	}
	
	@Test
	public void testValor() throws Exception{
		baby = new BabySitter(bb, p);
		baby2 =new BabySitter(bb2, p2);
		baby3 =new BabySitter(bb3, p3);		
		Assert.assertEquals(baby.valor() , 350.0 ,2);
		Assert.assertEquals(baby2.valor(), 225.0 ,2);
		Assert.assertEquals(baby3.valor(), 925.0 ,2);
	
	}
	
	@Test
	public void testEquals() throws Exception{
		baby = new BabySitter(bb, p);
		baby2 =new BabySitter(bb2, p2);
		baby3 =new BabySitter(bb3, p);	
		Assert.assertFalse(baby.equals(baby2));
		Assert.assertTrue(baby.equals(baby3));
		
	}

	
	@Test
	public void testToString() throws Exception{
		baby = new BabySitter(bb, p);
		Assert.assertEquals(baby.toString(),bb.toString() + "/n"+ "valor" + baby.valor());
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
