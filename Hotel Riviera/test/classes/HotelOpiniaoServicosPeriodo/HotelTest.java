package classes.HotelOpiniaoServicosPeriodo;

import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.GregorianCalendar;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import classes.Baba.Baba;
import classes.Carro.Carro;
import classes.FormasCobranca.EstrategiaCobranca;
import classes.FormasCobranca.EstrategiaSimples;
import classes.Pessoa.Contrato;
import classes.Pessoa.Hospede;
import classes.Quartos.Quarto;
import classes.Quartos.QuartoPresidencial;
import excecoes.EntradaDeDadosException;

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
	EstrategiaCobranca e = new EstrategiaSimples();
	Hotel hotel;
	
	@Before
	public void setUp() throws Exception {
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
		
		hotel.cadastraFuncionario("login", "senha");
		Assert.assertTrue(hotel.getFuncionarios().size() == 1);
		
	}
	
	@Test
	public void testaFuncionalidades() throws Exception{
		hotel.check_in(ct1);
		Assert.assertEquals(hotel.pesquisaContrato("Edval").size(), 1);
		hotel.check_out(ct1);
		
		hotel.cadastraFuncionario("login", "senha");
		Assert.assertTrue(hotel.verificaLogin("login", "senha") == true);
		Assert.assertTrue(hotel.verificaLogin("login", "senh") == false);
		
	}
	
	

}
