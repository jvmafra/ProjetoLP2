package classes.HotelOpiniaoServicosPeriodo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import classes.Baba.Baba;
import classes.Carro.Carro;
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
	private List<Contrato> contratos = new ArrayList<>();
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
		getContratos().add(c);
	}
	
	/**
	 * Coloca certo contrato como fechado
	 */
	public void check_out(Contrato c){
		c.fechaContrato();
	}
		/**
	 * Retorna uma list com os contratos do hotel
	 */
	public List<Contrato> getContratos() {
		return contratos;
	}
	
	
	/**
	 * Retorna uma list com as opinioes dos hospedes
	 */
	public List<Opiniao> getOpinioes() {
		return opinioes;
	}
	
	/**
	 * Retorna uma list com algum tipo de servico alugavel em determinado periodo
	 */
	public List<Alugavel> verificaAlugaveisDisponiveis(Periodo p, List<Alugavel> lista){
		List<Alugavel> disponiveis = new ArrayList<>();
		for (Alugavel alugavel: lista){
			boolean disponivel = true;
			for (Periodo p1: alugavel.getPeriodos()){
				if (p1.periodoCoincide(p))
					disponivel = false;
			if (disponivel == true)
				disponiveis.add(alugavel);	
			}
		}
		
		return disponiveis;
	}
	
	/**
	 * Retorna uma list com os contratos associados a certo hospede
	 */
	public List<Contrato> pesquisaContrato(String nome_cpf){
		List<Contrato> contratos_hospede = new ArrayList<>();
		for (Contrato contrato: contratos){
			if (contrato.getCPF().equals(nome_cpf) || contrato.getNome().equals(nome_cpf))
				contratos_hospede.add(contrato);
		}
		
		return contratos_hospede;
	}
	
	/**
	 * Retorna uma list apenas com os contratos em aberto
	 */
	public List<Contrato> getContratosAbertos(){
		List<Contrato> contratos_abertos = new ArrayList<>();
		for (Contrato contrato: contratos){
			if (contrato.isAberto())
				contratos_abertos.add(contrato);
		}
		
		return contratos_abertos;
	}
	
	/**
	 * Retorna uma list apenas com os contratos em aberto
	 */
	public List<Contrato> getContratosFechados(){
		List<Contrato> contratos_fechados = new ArrayList<>();
		for (Contrato contrato: contratos){
			if (contrato.isAberto() == false)
				contratos_fechados.add(contrato);
		}
		
		return contratos_fechados;
	}
	
	/**
	 * Cadastra uma nova baba no hotel
	 */
	public void AdicionaBaba(Baba baba){
		babas.add(baba);
	}
	
	/**
	 * Cadastra um novo carro no hotel
	 */
	public void AdicionaCarro(Carro carro){
		carros.add(carro);
	}
	
	/**
	 * Cadastra um novo quarto no hotel
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
