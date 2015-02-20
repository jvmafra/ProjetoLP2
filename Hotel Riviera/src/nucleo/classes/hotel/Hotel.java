package nucleo.classes.hotel;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import nucleo.classes.formas_cobranca.Estrategia;
import nucleo.classes.pessoa.Contrato;
import nucleo.classes.pessoa.Funcionario;
import nucleo.classes.pessoa.Hospede;
import nucleo.classes.quartos.Quarto;
import nucleo.classes.quartos.QuartoExecutivoDuplo;
import nucleo.classes.quartos.QuartoExecutivoSimples;
import nucleo.classes.quartos.QuartoExecutivoTriplo;
import nucleo.classes.quartos.QuartoLuxoDuplo;
import nucleo.classes.quartos.QuartoLuxoSimples;
import nucleo.classes.quartos.QuartoLuxoTriplo;
import nucleo.classes.quartos.QuartoPresidencial;
import nucleo.classes.servicos.Baba;
import nucleo.classes.servicos.Carro;

/**
 * Manipula operacoes relacionadas ao Hotel como um todo
 * @author Joao Victor Barroso Mafra
 */
public class Hotel implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private List<Contrato> contratos = new ArrayList<>();
	private List<Hospede> hospedes = new ArrayList<>();
	private List<Opiniao> opinioes = new ArrayList<>();
	private List<Alugavel> quartos = new ArrayList<>();
	private List<Alugavel> babas = new ArrayList<>();
	private List<Alugavel> carros = new ArrayList<>();
	private List<Estrategia> estrategias = new ArrayList<>();
	private List<Funcionario> funcionarios = new ArrayList<>();

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
		instanciaEstrategias();
		criaGerente();
		
	}
	
	public List<Hospede> getHospedes() {
		return hospedes;
	}
	
	public List<Funcionario> getFuncionarios() {
		return funcionarios;
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
	
	public String MediaDoHotel() {
		double soma = 0;
		if (opinioes.size() == 0)
			return "0";
		for (int i = 0; i < opinioes.size(); i++) {
			soma += opinioes.get(i).getNota();
		}
		DecimalFormat df = new DecimalFormat("0.00");  
		return df.format(soma / opinioes.size()); 
		
	}
	
	/**
	 * Retorna uma list com algum tipo de servico alugavel em determinado periodo
	 */
	public List<Alugavel> verificaAlugaveisDisponiveis(Periodo p, List<Alugavel> lista){
		List<Alugavel> disponiveis = new ArrayList<>();
		for (Alugavel alugavel: lista){
			boolean disponivel = true;
			for (int i = 0; i < alugavel.getPeriodos().size(); i++) {
				if (p.periodoCoincide(alugavel.getPeriodos().get(i)))
					disponivel = false;
			}
			if (disponivel == true)
				disponiveis.add(alugavel);	
		}
		
		return disponiveis;
	}
	
	public Hospede pesquisaHospede(String nome_cpf){
		for (Hospede hospede: hospedes){
			if (hospede.getCPF().equals(nome_cpf) || hospede.getNome().equals(nome_cpf))
				return hospede;
		}
		
		return null;
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
	 * Verifica login e senha no momento que um funcionario tenta logar no sistema do hotel
	 * @return True ou False
	 * 			Dependendo se aquele funcionario ja esta cadastrado ou nao
	 */
	public boolean verificaLogin(String login, String senha, boolean verificaGerente){
		for (Funcionario f: funcionarios){
			if (f.getLogin().equals(login) && f.getSenha().equals(senha)){
				if (!(verificaGerente))
					return true;
				else
					if (f.isPermissaoGerente())
						return true;
			}
		}
			
		return false;
	}
	
	/**
	 * Cadastra um novo funcionario ao hotel
	 */
	public void adicionaFuncionario(Funcionario f){
		funcionarios.add(f);
	}
	
	/**
	 * Cadastra uma nova estrategia de cobranca ao hotel
	 */
	public void adicionaEstrategia(Estrategia e){
		estrategias.add(e);
	}
	
	/**
	 * Cadastra uma nova baba no hotel
	 */
	public void adicionaBaba(Baba baba){
		babas.add(baba);
	}
	
	/**
	 * Cadastra um novo carro no hotel
	 */
	public void adicionaCarro(Carro carro){
		carros.add(carro);
	}
	
	/**
	 * Cadastra um novo quarto no hotel
	 */
	public void adicionaQuarto(Quarto q){
		quartos.add(q);
	}
	
	/**
	 * Adiciona um hospede ao hotel
	 */
	public void adicionaHospede(Hospede h){
		hospedes.add(h);
	}
	
	/**
	 * Adiciona uma opiniao ao hotel
	 */
	public void adicionaOpiniao(Opiniao o){
		opinioes.add(o);;
	}
	
	/**
	 * Remove uma nova baba no hotel
	 */
	public void removeBaba(Baba baba){
		babas.remove(baba);
	}
	
	/**
	 * Remove um carro no hotel
	 */
	public void removeCarro(Carro carro){
		carros.remove(carro);
	}
	
	/**
	 * Remove um hospede do hotel
	 */
	public void removeHospede(Hospede hospede){
		hospedes.remove(hospede);
	}
	

	
	/**
	 * Remove um novo quarto no hotel
	 */
	public void removeQuarto(Quarto q){
		quartos.remove(q);
	}
	
	/**
	 * Imprime todas as opinioes a respeito do hotel (comentario, nota e data)
	 */
	public String imprimeOpinioes(){
		String todas_opinioes = "OPINIOES DOS HOSPEDES:";
		for (int i = opinioes.size(); i <= 0 ; i--){
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
	
	private void instanciaEstrategias(){
		try {
			Estrategia alta_temporada = new Estrategia("Alta Temporada", 2.0);
			adicionaEstrategia(alta_temporada);
			
			Estrategia baixa_temporada = new Estrategia("Baixa Temporada", 0.8);
			adicionaEstrategia(baixa_temporada);
			
			Estrategia natal_reveillon = new Estrategia("Natal/Reveillon", 1.2);
			adicionaEstrategia(natal_reveillon);
			
			Estrategia sao_joao = new Estrategia("Sao Joao", 1.1);
			adicionaEstrategia(sao_joao);
			
			Estrategia sao_joao_especial = new Estrategia("Sao Joao Especial", 1.5);
			adicionaEstrategia(sao_joao_especial);
			
			Estrategia simples = new Estrategia("Simples", 1.0);
			adicionaEstrategia(simples);
			
		} catch (Exception e) {
		}
	}
	
	private void criaGerente(){
		Funcionario gerente;
		try {
			gerente = new Funcionario("Gerente", "admin", "123456", true);
			adicionaFuncionario(gerente);
		} catch (Exception e) {
		}

	}
	
	

	public List<Estrategia> getEstrategias() {
		return estrategias;
	}

	public List<Alugavel> getQuartos() {
		return quartos;
	}

	public List<Alugavel> getBabas() {
		return babas;
	}

	public List<Alugavel> getCarros() {
		return carros;
	}
	

}