package classes.pessoa;

import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.GregorianCalendar;

import nucleo.classes.formas_cobranca.Estrategia;
import nucleo.classes.hotel.Alugavel;
import nucleo.classes.hotel.Periodo;
import nucleo.classes.hotel.Servico;
import nucleo.classes.pessoa.Contrato;
import nucleo.classes.pessoa.Hospede;
import nucleo.classes.quartos.Quarto;
import nucleo.classes.quartos.QuartoPresidencial;
import nucleo.classes.servicos.AluguelCarro;
import nucleo.classes.servicos.Baba;
import nucleo.classes.servicos.BabySitter;
import nucleo.classes.servicos.Carro;
import nucleo.classes.servicos.Refeicao;
import nucleo.excecoes.NomeInvalidoException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ContratoTest {
	private Estrategia e;
	private Quarto quarto;
	Calendar data1 = new GregorianCalendar(2015, 5, 22);
	Calendar data2 = new GregorianCalendar(2015, 5, 26);
	Periodo periodo;
	Hospede h;
	Contrato contrato;
	
	@Before
	public void iniciaHospede() throws Exception{
		h = new Hospede("Edval","10530025485", "3224432", "18",  "e@hot.com", "8888888888", "ary", "4001635716004159");
		periodo = new Periodo(data1, data2);
		quarto = new QuartoPresidencial(1);
		e = new Estrategia("Sao Joao Especial", 1.5);
		contrato = new Contrato(quarto, h, e, periodo);
	}

	@Test
	public void testaConstrutor() {
		try {
			Contrato c1 = new Contrato(null, h, e, periodo);
			Assert.fail("Deveria lancar excecao");
		} catch (Exception e) {
			Assert.assertEquals("Quarto invalido", e.getMessage());
		}
		
		try {
			Contrato c1 = new Contrato(quarto, null, e, periodo);
			Assert.fail("Deveria lancar excecao");
		} catch (Exception e) {
			Assert.assertEquals("Hospede invalido", e.getMessage());
		}
		
		try {
			Contrato c1 = new Contrato(quarto, h, null, periodo);
			Assert.fail("Deveria lancar excecao");
		} catch (Exception e) {
			Assert.assertEquals("Estrategia invalida", e.getMessage());
		}
		
		try {
			Contrato c1 = new Contrato(quarto, h, e, null);
			Assert.fail("Deveria lancar excecao");
		} catch (Exception e) {
			Assert.assertEquals("Periodo invalido", e.getMessage());
		}
		
			
	}
	
	
	@Test
	public void testaNovoServico() throws Exception{
		Calendar data = new GregorianCalendar(2015, 5, 24, 6, 20);
		Carro c = new Carro("Astra", "MOR8011", true);
		Servico aluguel_carro = new AluguelCarro(c, false, false, periodo);
		Baba b = new Baba("Maria", "33221593");
		BabySitter aluguel_baba = new BabySitter(b, periodo);
		Refeicao rf = new Refeicao(50.0, data);
		Refeicao rf2 = new Refeicao(80.0, data);
		
		contrato.adicionaServico(aluguel_carro);
		contrato.adicionaServico(aluguel_baba);
		contrato.adicionaServico(rf);
		
		Assert.assertTrue(contrato.getServicos().size() == 4);
		
		contrato.removeServico(aluguel_baba);
		
		Assert.assertTrue(contrato.getServicos().size() == 3);
		
		try {
			contrato.removeServico(rf2);
			Assert.fail("Deveria lancar excecao");
		} catch (Exception e) {
			Assert.assertEquals("O servico nao existe", e.getMessage());
		}
		
		
	}
	
	@Test
	public void testaFechamento(){
		Assert.assertEquals("ABERTO", contrato.mostraStatus());
		contrato.fechaContrato();
		Assert.assertEquals("FECHADO", contrato.mostraStatus());
		
	}
	
	@Test
	public void testaValorFaturaComEstrategias() throws Exception{
		Assert.assertEquals(4800.0, contrato.calculaValorServicos(), 0.001);
		Assert.assertEquals(7200.0, contrato.calculaValorTotal(), 0.001);
		
		Estrategia e = new Estrategia("Natal/Reveillon", 1.2);
		contrato.setE(e);
		Assert.assertEquals(5760.0, contrato.calculaValorTotal(), 0.001);
		
		Estrategia e2 = new Estrategia("Alta Temporada", 2);
		contrato.setE(e2);
		Assert.assertEquals(9600.0, contrato.calculaValorTotal(), 0.001);
	}
	
	@Test
	public void testaValorComServicos() throws Exception{
		Calendar data = new GregorianCalendar(2015, 5, 24, 6, 20);
		Carro c = new Carro("Astra", "MOR8011", true);
		Servico aluguel_carro = new AluguelCarro(c, false, false, periodo);
		Refeicao rf = new Refeicao(50.0, data);
		contrato.adicionaServico(aluguel_carro);
		contrato.adicionaServico(rf);
		
		Assert.assertEquals(5250.0, contrato.calculaValorServicos(), 0.001);
		Assert.assertEquals(7875.0, contrato.calculaValorTotal(), 0.001);
	}
	
	@Test
	public void testaToString(){
		Assert.assertEquals("Edval - N: 1 - Presidencial - ABERTO", contrato.toString());
		contrato.fechaContrato();
		Assert.assertEquals("Edval - N: 1 - Presidencial - FECHADO", contrato.toString());
	}
	
	@Test
	public void testaEquals() throws Exception{
		Contrato c2 = new Contrato(quarto, h, e, periodo);
		Assert.assertTrue(c2.equals(contrato));
		
		Carro c = new Carro("Astra", "MOR8011", true);
		Servico aluguel_carro = new AluguelCarro(c, false, false, periodo);
		c2.adicionaServico(aluguel_carro);
		
		Assert.assertFalse(c2.equals(contrato));
		
		c2.removeServico(aluguel_carro);
		
		Assert.assertTrue(c2.equals(contrato));
	}
	
	


}
