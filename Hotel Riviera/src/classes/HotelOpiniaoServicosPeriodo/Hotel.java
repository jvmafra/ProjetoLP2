package classes.HotelOpiniaoServicosPeriodo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import classes.Baba.Baba;
import classes.Baba.ListaBabas;
import classes.Carro.Carro;
import classes.Carro.ListaCarros;
import classes.Pessoa.Contrato;
import classes.Quartos.Quarto;
import classes.Quartos.QuartoExecutivoDuplo;
import classes.Quartos.QuartoExecutivoSimples;
import classes.Quartos.QuartoExecutivoTriplo;
import classes.Quartos.QuartoLuxoDuplo;
import classes.Quartos.QuartoLuxoSimples;
import classes.Quartos.QuartoLuxoTriplo;
import classes.Quartos.QuartoPresidencial;

/**
 * Manipula operacoes relacionadas ao Hotel como um todo
 * @author Joao Victor Barroso Mafra
 */
public class Hotel {
	private List<Contrato> contratos_abertos = new ArrayList<>();
	private List<Contrato> contratos_fechados = new ArrayList<>();
	private List<Opiniao> opinioes = new ArrayList<>();
	private List<Quarto> quartos = new ArrayList<>();
	private List<Baba> babas = new ArrayList<>();
	private List<Carro> carros = new ArrayList<>();
	
	/**
	 * Ao ser inicializado o hotel, sao geradas listas de quartos, carros e babas.
	 */
	public Hotel() {
		instanciaPresidenciais();
		instanciaExecutivosSimples();
		instanciaExecutivosDuplo();
		instanciaExecutivosTriplos();
		instanciaLuxosSimples();
		instanciaLuxosDuplo();
		instanciaLuxosTriplos();
	}
	
	/**
	 * Adiciona um novo contrato
	 */
	public void check_in(Contrato c){
		getContratos_abertos().add(c);
	}
	
	/**
	 * Remove um contrato e o coloca como fechado
	 */
	public void check_out(Contrato c){
		getContratos_abertos().remove(c);
		getContratos_fechados().add(c);
		c.fechaContrato();
	}
	
	/**
	 * Retorna uma list com os contratos em aberto
	 */
	public List<Contrato> getContratos_abertos() {
		return contratos_abertos;
	}
	
	/**
	 * Retorna uma list com os contratos ja finalizados
	 */
	public List<Contrato> getContratos_fechados() {
		return contratos_fechados;
	}
	
	/**
	 * Retorna uma list com as opinioes dos hospedes
	 */
	public List<Opiniao> getOpinioes() {
		return opinioes;
	}
	
	/**
	 * Retorna uma list com os quartos disponiveis em determinado periodo
	 */
	public List<Quarto> verificaQuartosDisponiveis(Periodo p){
		List<Quarto> disponiveis = new ArrayList<>();
		for (Quarto quarto: quartos){
			boolean disponivel = true;
			for (Periodo p1: quarto.getPeriodos()){
				if (p1.periodoCoincide(p))
					disponivel = false;
			if (disponivel == true)
				disponiveis.add(quarto);	
			}
		}
		
		return disponiveis;
	}
	
	/**
	 * Retorna uma list com as babas disponiveis em determinado periodo
	 */
	public List<Baba> verificaBabasDisponiveis(Periodo p){
		List<Baba> disponiveis = new ArrayList<>();
		for (Baba baba: babas){
			boolean disponivel = true;
			for (Periodo p1: baba.getPeriodos()){
				if (p1.periodoCoincide(p))
					disponivel = false;
			if (disponivel == true)
				disponiveis.add(baba);	
			}
		}
			
		return disponiveis;
		
	}
	
	/**
	 * Retorna uma list com os carros disponiveis em determinado periodo
	 */
	public List<Carro> verificaCarrosDisponiveis(Periodo p){
		List<Carro> disponiveis = new ArrayList<>();
		for (Carro carro: carros){
			boolean disponivel = true;
			for (Periodo p1: carro.getPeriodos()){
				if (p1.periodoCoincide(p))
					disponivel = false;
			if (disponivel == true)
				disponiveis.add(carro);	
			}
		}
			
		return disponiveis;
	}
	
	/**
	 * Adiciona uma nova baba ao hotel
	 */
	public void AdicionaBaba(Baba baba){
		babas.add(baba);
	}
	
	/**
	 * Adiciona um novo carro ao hotel
	 */
	public void AdicionaCarro(Carro carro){
		carros.add(carro);
	}
	
	/**
	 * Adiciona um novo quarto ao hotel
	 */
	public void AdicionaQuarto(Quarto q){
		quartos.add(q);
	}
	
	/**
	 * Imprime todas as opinioes a respeito do hotel (comentario, nota e data)
	 */
	public String imprimeOpinioes(){
		String todas_opinioes = "OPINIOES DOS HOSPEDES: ";
		for (int i = opinioes.size(); i <= 0; i--){
			todas_opinioes += "\n\n" + opinioes.get(i).toString();
		}	
		return todas_opinioes;
	}
	
	private void instanciaPresidenciais(){
		int i = 0;
		while (i < 5){
			try {
				Quarto quarto = new QuartoPresidencial(i + 1);
				quartos.add(quarto);
				i++;
			} catch (Exception e) {
			}
			
		}
	}
	
	private void instanciaExecutivosSimples(){
		int i = 0, j = 6;
		while (i < 5){
			try {
				Quarto quarto = new QuartoExecutivoSimples(j);
				quartos.add(quarto);
				i++;
				j++;
			} catch (Exception e) {
			}
			
		}
	}
	
	private void instanciaExecutivosDuplo(){
		int i = 0, j = 11;
		while (i < 15){
			try {
				Quarto quarto = new QuartoExecutivoDuplo(j);
				quartos.add(quarto);
				i++;
				j++;
			} catch (Exception e) {
			}
			
		}
	}
	
	private void instanciaExecutivosTriplos(){
		int i = 0, j = 26;
		while (i < 20){
			try {
				Quarto quarto = new QuartoExecutivoTriplo(j);
				quartos.add(quarto);
				i++;
				j++;
			} catch (Exception e) {
			}
			
		}
	}
	
	private void instanciaLuxosSimples(){
		int i = 0, j = 46;
		while (i < 5){
			try {
				Quarto quarto = new QuartoLuxoSimples(j);
				quartos.add(quarto);
				i++;
				j++;
			} catch (Exception e) {
			}
			
		}
	}
	
	private void instanciaLuxosDuplo(){
		int i = 0, j = 51;
		while (i < 15){
			try {
				Quarto quarto = new QuartoLuxoDuplo(j);
				quartos.add(quarto);
				i++;
				j++;
			} catch (Exception e) {
			}
			
		}
	}
	
	private void instanciaLuxosTriplos(){
		int i = 0, j = 66;
		while (i < 20){
			try {
				Quarto quarto = new QuartoLuxoTriplo(j);
				quartos.add(quarto);
				i++;
				j++;
			} catch (Exception e) {
			}
			
		}
	}
	

}
