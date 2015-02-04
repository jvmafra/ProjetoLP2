package testes;

import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.GregorianCalendar;

import org.junit.Assert;
import org.junit.Test;

import classes.Alimentacao.Refeicao;
import classes.Carro.AluguelCarro;

public class ReceicaoTest {
	Calendar data = new GregorianCalendar(2015, 5, 22, 3, 0);
	Calendar data2 = new GregorianCalendar(2015, 5, 22, 23, 0);
	Calendar data3 = new GregorianCalendar(2015, 5, 22, 12, 0);
	Calendar data4 = new GregorianCalendar();
	private Refeicao refeicao;
	private Refeicao refeicao2;
	private Refeicao refeicao3;
	
	
	@Test
	public void testConstrutor() {
		
			try{	
				refeicao = new Refeicao(60.0, data);
				Assert.fail("Deveria lancar excecao");
			} catch(Exception e) {
				Assert.assertEquals("O restaurante nao estava funcionando nesse horario", e.getMessage());
			}
		
			try{	
				refeicao = new Refeicao(60.0, data2);
				Assert.fail("Deveria lancar excecao");
			} catch(Exception e) {
				Assert.assertEquals("O restaurante nao estava funcionando nesse horario", e.getMessage());
			}
			
			try{	
				refeicao = new Refeicao(-60.0, data3);
				Assert.fail("Deveria lancar excecao");
			} catch(Exception e) {
				Assert.assertEquals("Valor da conta invalido.", e.getMessage());
			}
	
	}
		
	@Test
	public void testGetDataString() throws Exception{
		refeicao = new Refeicao(60.0, data3);
		refeicao2 = new Refeicao(60.0, data4);
		Assert.assertEquals(refeicao.getDataString(), "22/5/2015");
		Assert.assertEquals(refeicao2.getDataString(), "4/1/2015");
			
	}
	
	@Test
	public void testToString() throws Exception{
		refeicao = new Refeicao(60.0, data3);
		refeicao2 = new Refeicao(60.0, data4);
		Assert.assertEquals(refeicao.toString(), "Data: 22/5/2015\nValor: R$ 60.0" );
		Assert.assertEquals(refeicao2.toString(), "Data: 4/1/2015\nValor: R$ 60.0" );
		
	}
	
	@Test
	public void testEquals() throws Exception{
		refeicao = new Refeicao(60.0, data3);
		refeicao2 = new Refeicao(60.0, data4);
		refeicao3 = new Refeicao(60.0, data3);
		Assert.assertFalse(refeicao.equals(refeicao2));
		Assert.assertTrue(refeicao.equals(refeicao3));
	}
	
	@Test
	public void testValor() throws Exception{
		refeicao = new Refeicao(60.0, data3);
		Assert.assertEquals(refeicao.valor(), 60.0, 2);
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
		
	}


