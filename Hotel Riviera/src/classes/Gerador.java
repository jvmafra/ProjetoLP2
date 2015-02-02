package classes;

import java.util.Calendar;
import java.util.GregorianCalendar;

import classes.Quartos.*;
import classes.Carro.*;
import classes.Baba.*;
import classes.Pessoa.*;
import classes.HotelOpiniaoServicosPeriodo.*;


public class Gerador {
	
	public static void main(String[] args) throws Exception {
		Calendar data1 = new GregorianCalendar (2014, 3, 2);
		Calendar data2 = new GregorianCalendar (2014, 3, 12);
		Periodo p = new Periodo(data1, data2);
		
		Carro c = new Carro("PFD1809", false);
		Carro c1 = new Carro("JAO0929", false);
		GerenteDeArquivos.salvaCarro(c, false);
		GerenteDeArquivos.salvaCarro(c1, false);
		
		System.out.println(GerenteDeArquivos.getCarro("PFD1809"));
		
		Baba b = new Baba("Edval Galdino", "9999999999");
		Baba b2 = new Baba("Adiel Andrade", "9122227777");
		
		GerenteDeArquivos.salvaBaba(b, false);
		GerenteDeArquivos.salvaBaba(b2, false);
		
		System.out.println(GerenteDeArquivos.getBaba("Edval Galdino"));
		
		Hospede h = new Hospede("Joao Mafra", "10491339437", "1234987", "joao.mafra@ccc.ufcg.edu.br", 
								"8398235476", "Campina Grande", "4001639299433157");
		
		Hospede h2 = new Hospede("Joao Barroso", "10491339437", "1234987", "joao.mafra@ccc.ufcg.edu.br", 
				"8398235476", "Campina Grande", "4001639299433157");
		GerenteDeArquivos.salvaHospede(h, false);
		GerenteDeArquivos.salvaHospede(h2, false);
		
		System.out.println(GerenteDeArquivos.getHospede("Joao Mafra"));		
		
		for (int i = 0; i < 5; i++) {
			QuartoExecutivoSimples q = new QuartoExecutivoSimples(i + 101);
			GerenteDeArquivos.salvaQuarto(q, false);
		}
		for (int i = 0; i < 5; i++) {
			QuartoExecutivoDuplo q = new QuartoExecutivoDuplo(i + 106);
			GerenteDeArquivos.salvaQuarto(q, false);
		}
		for (int i = 0; i < 10; i++) {
			QuartoExecutivoDuplo q = new QuartoExecutivoDuplo(i + 201);
			GerenteDeArquivos.salvaQuarto(q, false);
		}
		for (int i = 0; i < 10; i++) {
			QuartoExecutivoTriplo q = new QuartoExecutivoTriplo(i + 301);
			GerenteDeArquivos.salvaQuarto(q, false);
		}
		for (int i = 0; i < 10; i++) {
			QuartoExecutivoTriplo q = new QuartoExecutivoTriplo(i + 401);
			GerenteDeArquivos.salvaQuarto(q, false);
		}
		for (int i = 0; i < 5; i++) {
			QuartoLuxoSimples q = new QuartoLuxoSimples(i + 501);
			GerenteDeArquivos.salvaQuarto(q, false);
		}
		for (int i = 0; i < 5; i++) {
			QuartoLuxoDuplo q = new QuartoLuxoDuplo(i + 506);
			GerenteDeArquivos.salvaQuarto(q, false);
		}
		for (int i = 0; i < 10; i++) {
			QuartoLuxoDuplo q = new QuartoLuxoDuplo(i + 601);
			GerenteDeArquivos.salvaQuarto(q, false);
		}
		for (int i = 0; i < 10; i++) {
			QuartoLuxoTriplo q = new QuartoLuxoTriplo(i + 701);
			GerenteDeArquivos.salvaQuarto(q, false);
		}
		for (int i = 0; i < 10; i++) {
			QuartoLuxoTriplo q = new QuartoLuxoTriplo(i + 801);
			GerenteDeArquivos.salvaQuarto(q, false);
		}
		for (int i = 0; i < 5; i++) {
			QuartoPresidencial q = new QuartoPresidencial(i + 900);
			GerenteDeArquivos.salvaQuarto(q, false);
			
		}

	}
		
}