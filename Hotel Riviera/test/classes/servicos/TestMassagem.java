package classes.servicos;

import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.GregorianCalendar;

import nucleo.classes.hotel.Periodo;
import nucleo.classes.servicos.Baba;
import nucleo.classes.servicos.Massagem;
import nucleo.classes.servicos.TipoDeMassagens;
import nucleo.excecoes.PeriodoInvalidoException;
import nucleo.excecoes.TipoDeMassagensInvalidaException;
import nucleo.excecoes.TipoDeMassagensInvalidoException;
import nucleo.excecoes.ValorInvalidoException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestMassagem {
	private Massagem m1;
	private Massagem m2;
	private Massagem m3;
	Calendar data_inicial2 = new GregorianCalendar(2015, 1, 24, 8,	0 );
	Calendar data_final2 = new GregorianCalendar(2015, 1, 24, 11, 0);
	private Periodo p2;
	Calendar data_inicial3 = new GregorianCalendar(2015, 1, 24, 8,	0 );
	Calendar data_final3 = new GregorianCalendar(2015, 1, 24, 17, 0);
	private Periodo p3;
	Calendar data_inicial = new GregorianCalendar(2015, 1, 24, 21,	0 );
	Calendar data_final = new GregorianCalendar(2015, 1, 24, 23, 0);
	private Periodo p;
	Calendar data_inicial4 = new GregorianCalendar(2015, 1, 24, 5,	0 );
	Calendar data_final4 = new GregorianCalendar(2015, 1, 24, 7, 0);
	private Periodo p4;
	
	
	@Before
	public void setUp() throws Exception {
		p2 = new Periodo(data_inicial2, data_final2);
		p3 = new Periodo(data_inicial3, data_final3);
		p = new Periodo(data_inicial, data_final);
		p4 = new Periodo(data_inicial4, data_final4);
	}
	
	@Test
	public void testConstrutor() {
		try{
			m1 = new Massagem(null , p2);
			Assert.fail("Deveria lancar excecao");
		} catch(Exception e) {
		Assert.assertEquals("Tipo de massagem invalida", e.getMessage());
		}
		
		try{
			m1 = new Massagem(TipoDeMassagens.CLASSICA , p3);
			Assert.fail("Deveria lancar excecao");
		} catch(Exception e) {
		Assert.assertEquals("periodo invalido", e.getMessage());
		}
		
		try{
			m1 = new Massagem(TipoDeMassagens.CLASSICA , p);
			Assert.fail("Deveria lancar excecao");
		} catch(Exception e) {
		Assert.assertEquals("periodo invalido", e.getMessage());
		}
		
		try{
			m1 = new Massagem(TipoDeMassagens.CLASSICA , p4);
			Assert.fail("Deveria lancar excecao");
		} catch(Exception e) {
		Assert.assertEquals("periodo invalido", e.getMessage());
		}
		
		try{
			m1 = new Massagem(TipoDeMassagens.CLASSICA , null);
			Assert.fail("Deveria lancar excecao");
		} catch(Exception e) {
		Assert.assertEquals("periodo invalido", e.getMessage());
		}
			
	}
	
	@Test
	public void testValor() throws ValorInvalidoException, PeriodoInvalidoException, TipoDeMassagensInvalidoException, TipoDeMassagensInvalidaException{
		m1 = new Massagem(TipoDeMassagens.CLASSICA , p2);
		Assert.assertEquals(m1.valor(), 240.0 ,2);
		m1 = new Massagem(TipoDeMassagens.PEDRAS_QUENTES , p2);
		Assert.assertEquals(m1.valor(), 135.0 ,2);
		m1 = new Massagem(TipoDeMassagens.REIKI , p2);
		Assert.assertEquals(m1.valor(), 255.0 ,2);
		m1 = new Massagem(TipoDeMassagens.SHIATSU , p2);
		Assert.assertEquals(m1.valor(), 300.0 ,2);
	}
	
	
	@Test
	public void testTotalDeHoras() throws ValorInvalidoException, PeriodoInvalidoException, TipoDeMassagensInvalidoException, TipoDeMassagensInvalidaException{
		m1 = new Massagem(TipoDeMassagens.CLASSICA , p2);
		Assert.assertEquals(m1.totalDeHoras(), 3);
	}
	
	@Test
	public void testToString() throws ValorInvalidoException, PeriodoInvalidoException, TipoDeMassagensInvalidoException, TipoDeMassagensInvalidaException{
		m1 = new Massagem(TipoDeMassagens.CLASSICA , p2);
		Assert.assertEquals(m1.toString(), "MASSAGEM: " + m1.getNome() + "\nPeriodo: " + m1.getPeriodo().toString() + "\nValor: R$ " + m1.valor());
	}
	
	
	@Test
	public void testEquals() throws ValorInvalidoException, PeriodoInvalidoException, TipoDeMassagensInvalidoException, TipoDeMassagensInvalidaException{
		m1 = new Massagem(TipoDeMassagens.CLASSICA , p2);
		m2 = new Massagem(TipoDeMassagens.CLASSICA , p2);
		m3 = new Massagem(TipoDeMassagens.PEDRAS_QUENTES , p2);
		
		Assert.assertTrue(m1.equals(m2));
		Assert.assertFalse(m1.equals(m3));
		Assert.assertFalse(m3.equals(m2));
		
	}


	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
