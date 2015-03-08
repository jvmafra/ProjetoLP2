package classes.servicos;
// Adiel Andrade

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
	Calendar data_1 = new GregorianCalendar(2015, 1, 24, 8,	0 );
	int duracao_1 = 3;
	
	Calendar data_2 = new GregorianCalendar(2015, 1, 24, 8,	0 );
	int duracao_2 = 9;
	
	Calendar data_inicial = new GregorianCalendar(2015, 1, 24, 21,	0 );
	int duracao_inicial = 2;
	
	
	Calendar data_inicial4 = new GregorianCalendar(2015, 1, 24, 5,	0 );
	int duracao = 2;
	
	
	@Before
	public void setUp() throws Exception {
	}
	
	@Test
	public void testConstrutor() {
		try{
			m1 = new Massagem(null , data_1, duracao_1);
			Assert.fail("Deveria lancar excecao");
		} catch(Exception e) {
		Assert.assertEquals("Tipo de massagem invalida", e.getMessage());
		}
		
		try{
			m1 = new Massagem(TipoDeMassagens.CLASSICA , data_2, duracao_2);
			Assert.fail("Deveria lancar excecao");
		} catch(Exception e) {
		Assert.assertEquals("A massagem deve durar entre 1 e 3 horas", e.getMessage());
		}
		
		try{
			m1 = new Massagem(TipoDeMassagens.CLASSICA , data_inicial, duracao_inicial);
			Assert.fail("Deveria lancar excecao");
		} catch(Exception e) {
		Assert.assertEquals("A massagem não funciona nesse horário.", e.getMessage());
		}
		
		try{
			m1 = new Massagem(TipoDeMassagens.CLASSICA , data_inicial4, duracao);
			Assert.fail("Deveria lancar excecao");
		} catch(Exception e) {
		Assert.assertEquals("A massagem não funciona nesse horário.", e.getMessage());
		}
		
		try{
			m1 = new Massagem(TipoDeMassagens.CLASSICA , null, 3);
			Assert.fail("Deveria lancar excecao");
		} catch(Exception e) {
		Assert.assertEquals("Selecione uma data.", e.getMessage());
		}
			
	}
	
	@Test
	public void testValor() throws ValorInvalidoException, PeriodoInvalidoException, TipoDeMassagensInvalidoException, TipoDeMassagensInvalidaException{
		m1 = new Massagem(TipoDeMassagens.CLASSICA , data_1, duracao_1);
		Assert.assertEquals(m1.valor(), 240.0 ,2);
		m1 = new Massagem(TipoDeMassagens.PEDRAS_QUENTES , data_1, duracao_1);
		Assert.assertEquals(m1.valor(), 135.0 ,2);
		m1 = new Massagem(TipoDeMassagens.REIKI , data_1, duracao_1);
		Assert.assertEquals(m1.valor(), 255.0 ,2);
		m1 = new Massagem(TipoDeMassagens.SHIATSU , data_1, duracao_1);
		Assert.assertEquals(m1.valor(), 300.0 ,2);
	}
	
	
	@Test
	public void testToString() throws ValorInvalidoException, PeriodoInvalidoException, TipoDeMassagensInvalidoException, TipoDeMassagensInvalidaException{
		m1 = new Massagem(TipoDeMassagens.CLASSICA , data_1, duracao_1);
		Assert.assertEquals(m1.toString(), "MASSAGEM: Classica\nDia: 24/2/2015\nDuracao: 3 hora(s)\nValor: R$ 240.0");
	}
	
	
	@Test
	public void testEquals() throws ValorInvalidoException, PeriodoInvalidoException, TipoDeMassagensInvalidoException, TipoDeMassagensInvalidaException{
		m1 = new Massagem(TipoDeMassagens.CLASSICA , data_1, duracao_1);
		m2 = new Massagem(TipoDeMassagens.CLASSICA , data_1, duracao_1);
		m3 = new Massagem(TipoDeMassagens.PEDRAS_QUENTES , data_1, duracao_1);
		
		Assert.assertTrue(m1.equals(m2));
		Assert.assertFalse(m1.equals(m3));
		Assert.assertFalse(m3.equals(m2));
		
	}


	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}