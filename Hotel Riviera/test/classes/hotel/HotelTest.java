package classes.hotel;

import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.GregorianCalendar;

import junit.framework.Assert;
import nucleo.classes.formas_cobranca.Estrategia;
import nucleo.classes.hotel.Hotel;
import nucleo.classes.hotel.Periodo;
import nucleo.classes.pessoa.Contrato;
import nucleo.classes.pessoa.Funcionario;
import nucleo.classes.pessoa.Hospede;
import nucleo.classes.quartos.Quarto;
import nucleo.classes.quartos.QuartoPresidencial;
import nucleo.classes.servicos.Baba;
import nucleo.classes.servicos.Carro;
import nucleo.excecoes.EntradaDeDadosException;

import org.junit.Before;
import org.junit.Test;

public class HotelTest {
	Hospede h1;
	Hospede h2;
	Carro c1;
	Carro c2;
	Quarto q;
	Baba baba1;
	Baba baba2;
	Contrato ct1;
	Contrato ct2;
	Calendar data_1 = new GregorianCalendar(2015, 6, 25);
	Calendar data_2 = new GregorianCalendar(2015, 6, 27);
	Hotel hotel;
	Funcionario f;
	
	@Before
	public void setUp() throws Exception {
		Estrategia e = new Estrategia("Simples", 1.0);
		q = new QuartoPresidencial(1);
		hotel = new Hotel();
		h1 = new Hospede("Edval","10530025485", "3224432", "18",  "e@hot.com", "8888888888", "ary", "4001635716004159");
		h2 = new Hospede("Edval","10530025485", "3224434", "18",  "e@hot.com", "8888888888", "ary", "4001635716004159");
		Periodo p = new Periodo(data_1, data_2);
		c1 = new Carro("Palio", "MOR8011", false);
		c2 = new Carro("Civic", "VDP8024", true);
		baba1 = new Baba("Maria", "88258485");
		baba2 = new Baba("Josefa", "98798798");
		ct1 = new Contrato(q, h1, e, p);
		ct2 = new Contrato(q, h2, e, p);
		f = new Funcionario("nome", "admin", "123456", false);

	}
	
	@Test
	public void testaAdicaoNasListas() throws Exception{
		hotel.check_in(ct1);
		Assert.assertEquals(1,hotel.getContratos().size());
		Assert.assertEquals(1,hotel.getContratosAbertos().size());
		
		hotel.check_in(ct2);
		Assert.assertEquals(2,hotel.getContratos().size());
		Assert.assertEquals(2,hotel.getContratosAbertos().size());
		
		hotel.check_out(ct2);
		Assert.assertTrue(2 == hotel.getContratos().size());
		Assert.assertTrue(1 == hotel.getContratosAbertos().size());
		Assert.assertTrue(1 == hotel.getContratosFechados().size());
		
		hotel.adicionaBaba(baba1);
		hotel.adicionaBaba(baba2);
		
		Assert.assertTrue(hotel.getBabas().size() == 2);
		
		hotel.adicionaCarro(c1);
		Assert.assertTrue(hotel.getCarros().size() == 1);
		
		hotel.adicionaHospede(h1);
		Assert.assertTrue(hotel.getHospedes().size() == 1);
		
		hotel.adicionaFuncionario(f);;
		Assert.assertTrue(hotel.getFuncionarios().size() == 2);
		
		Estrategia e = new Estrategia("Copa do Mundo", 3.0);
		hotel.adicionaEstrategia(e);
		Assert.assertTrue(hotel.getEstrategias().size() == 7);
		
		Estrategia e2 = new Estrategia("Olimpiadas", 3.2);
		hotel.adicionaEstrategia(e);
		Assert.assertTrue(hotel.getEstrategias().size() == 8);
		
	}
	
	@Test
	public void testaFuncionalidades() throws Exception{
		hotel.check_in(ct1);
		Assert.assertEquals(hotel.pesquisaContrato("Edval").size(), 1);
		hotel.check_out(ct1);
		
		Assert.assertTrue(hotel.verificaLogin("admin", "123456", false) == true);
		Assert.assertTrue(hotel.verificaLogin("admin", "123456", true) == true);
		Assert.assertTrue(hotel.verificaLogin("admin", "12345", false) == false);
		
	}
	
	

}
