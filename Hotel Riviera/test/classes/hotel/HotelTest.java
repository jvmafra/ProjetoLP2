package classes.hotel;

import java.util.Calendar;
import java.util.GregorianCalendar;
import junit.framework.Assert;
import nucleo.classes.formas_cobranca.Estrategia;
import nucleo.classes.hotel.Hotel;
import nucleo.classes.hotel.Opiniao;
import nucleo.classes.hotel.Periodo;
import nucleo.classes.pessoa.Contrato;
import nucleo.classes.pessoa.Funcionario;
import nucleo.classes.pessoa.Hospede;
import nucleo.classes.quartos.Quarto;
import nucleo.classes.quartos.QuartoPresidencial;
import nucleo.classes.servicos.Baba;
import nucleo.classes.servicos.Carro;

import org.junit.Before;
import org.junit.Test;

@SuppressWarnings("deprecation")
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
	Periodo p;

	@Before
	public void setUp() throws Exception {
		Estrategia e = new Estrategia("Simples", 1.0);
		q = new QuartoPresidencial(1);
		hotel = new Hotel();
		h1 = new Hospede("Edval","10530025485", "3224432", "18",  "e@hot.com", "8888888888", "ary", "4001635716004159");
		h2 = new Hospede("Edval","10530025485", "3224434", "18",  "e@hot.com", "8888888888", "ary", "4001635716004159");
		p = new Periodo(data_1, data_2);
		c1 = new Carro("Palio", "MOR8011", false);
		c2 = new Carro("Civic", "VDP8024", true);
		baba1 = new Baba("Maria", "88258485");
		baba2 = new Baba("Josefa", "98798798");
		ct1 = new Contrato(q, h1, e, p);
		ct2 = new Contrato(q, h2, e, p);
		f = new Funcionario("nome", "admin", "123456", false);

	}
	
	@Test
	public void testaAdicaoERemocaoNasListas() throws Exception{
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
		hotel.adicionaEstrategia(e2);
		Assert.assertTrue(hotel.getEstrategias().size() == 8);
		
		hotel.removeEstrategia(e2);
		Assert.assertTrue(hotel.getEstrategias().size() == 7);
		
		hotel.incrementaAlugueisCarro();
		hotel.incrementaBabySitter();
		hotel.incrementaMassagens();
		Assert.assertTrue(hotel.getAlugueisCarro() == 1);
		Assert.assertTrue(hotel.getBabySitter() == 1);
		Assert.assertTrue(hotel.getMassagens() == 1);
		Assert.assertTrue(hotel.getRefeicoes() == 0);
		
		Assert.assertEquals(hotel.verificaAlugaveisDisponiveis(p, hotel.getQuartos()).size(), 85);
		ct1 = new Contrato((Quarto) hotel.getQuartos().get(0), h1, e, p);
		Assert.assertEquals(hotel.verificaAlugaveisDisponiveis(p, hotel.getQuartos()).size(), 84);
		
		
	}

	
	@Test
	public void testaFuncionalidades() throws Exception{
		hotel.check_in(ct1);
		Assert.assertEquals(hotel.pesquisaContrato("Edval").size(), 1);
		hotel.check_out(ct1);
		
		Assert.assertTrue(hotel.verificaLogin("admin", "123456", false) == true);
		Assert.assertTrue(hotel.verificaLogin("admin", "123456", true) == true);
		Assert.assertTrue(hotel.verificaLogin("admin", "12345", false) == false);
		
		hotel.adicionaOpiniao(new Opiniao("Comentario", 10));
		hotel.adicionaOpiniao(new Opiniao("Comentario", 5));
		Assert.assertTrue(hotel.getOpinioes().size() == 2);
		
		Assert.assertEquals(hotel.MediaDoHotel(), "7,50");
		
		
		
	}
	
	@Test
	public void testaValores(){
		hotel.check_in(ct1);
		hotel.check_in(ct2);
		Assert.assertEquals(hotel.faturamentoTotal(), 0.0);
		
		int mes = p.getData_final().get(Calendar.MONTH);
		
		hotel.check_out(ct1);
		Assert.assertEquals(hotel.getFaturamentoMensal(mes), ct1.calculaValorTotal());
		hotel.check_out(ct2);
		Assert.assertEquals(hotel.getFaturamentoMensal(mes), ct1.calculaValorTotal() + ct2.calculaValorTotal());
		
		Assert.assertTrue(hotel.getFaturamentoMensal(mes) == hotel.faturamentoTotal());
	}
	
	

	

	

}