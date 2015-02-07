package classes;

import java.util.Calendar;
import java.util.GregorianCalendar;

import classes.Alimentacao.Refeicao;
import classes.Baba.Baba;
import classes.Baba.BabySitter;
import classes.Carro.AluguelCarro;
import classes.Carro.Carro;
import classes.FormasCobranca.EstrategiaCobranca;
import classes.FormasCobranca.EstrategiaSaoJoao;
import classes.HotelOpiniaoServicosPeriodo.Periodo;
import classes.HotelOpiniaoServicosPeriodo.Servico;
import classes.Pessoa.Contrato;
import classes.Pessoa.Hospede;
import classes.Quartos.Quarto;
import classes.Quartos.QuartoPresidencial;

public class teste {
	private static EstrategiaCobranca e;
	private static Quarto quarto;
	static Calendar data1 = new GregorianCalendar(2015, 5, 22);
	static Calendar data2 = new GregorianCalendar(2015, 5, 26);
	static Periodo periodo;
	static Hospede h;
	static Contrato contrato;
	
	public static void main(String[] args) throws Exception {
		h = new Hospede("Edval","10530025485", "3224432", "18",  "e@hot.com", "8888888888", "ary", "4001635716004159");
		periodo = new Periodo(data1, data2);
		quarto = new QuartoPresidencial(1);
		e = new EstrategiaSaoJoao(true);
		contrato = new Contrato(quarto, h, e, periodo);
		
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
		
		System.out.println(contrato.imprimeFaturaFinal());

	}

}
