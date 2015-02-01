package classes.Pessoa;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;

import classes.Alimentacao.Refeicao;
import classes.Alimentacao.Restaurante;
import classes.Baba.BabySitter;
import classes.Carro.AluguelCarro;
import classes.FormasCobranca.EstrategiaCobranca;
import classes.HotelOpiniaoServicosPeriodo.Periodo;
import classes.HotelOpiniaoServicosPeriodo.Servicos;
import classes.Quartos.Quarto;
import excecoes.ContratoFechadoException;
import excecoes.PeriodoInvalidoException;

/**
 * Manipula um contrato de um hotel associado a um hospede.
 * @author Joao Victor Barroso Mafra
 */

public class Contrato {
	private Hospede hospede;
	private List<Servicos> servicos = new ArrayList<Servicos>();
	private EstrategiaCobranca e;
	private Periodo periodo;
	private boolean aberto;
	private Restaurante restaurante;
	
	/**
	 * Construtor que recebe as informacoes necessarias para criacao de um contrato
	 * @param servicos
	 * 			Recebe uma lista de servicos (obrigatoriamente um quarto no minimo) ou outros servicos contratados no momento do cadastro
	 * @param hospede
	 * 			Recebe todas as informacoes a respeito de um hospede
	 * @param e
	 * 			Recebe uma estrategia de cobranca que dependera do periodo do cadastro do hospede
	 * @param periodo
	 * 			Recebe o periodo de hospedagem
	 * @param formaDePagamento
	 * 			Recebe a forma de pagamento do hospede
	 */
	public Contrato (Quarto quarto, Hospede hospede, EstrategiaCobranca e, Periodo periodo) throws Exception{	
		this.hospede = hospede;
		this.e = e;
		this.periodo = periodo;
		restaurante = new Restaurante();
		quarto.adicionaPeriodo(periodo);
		servicos.add(quarto);
		servicos.add(restaurante);
		aberto = true;
	}
	
	public Restaurante getRestaurante() {
		return restaurante;
	}

	/**
	 * Retorna a estrategia atual de cobranca
	 */
	public EstrategiaCobranca getEstrategia() {
		return e;
	}
	
	/**
	 * Modifica a estrategia atual de cobranca
	 * @param e
	 * 			A nova estrategia
	 */
	public void setE(EstrategiaCobranca e) {
		this.e = e;
	}
	
	/**
	 * Retorna a lista atual de servicos presentes no contrato
	 */
	public List<Servicos> getServicos() {
		return servicos;
	}
	
	/**
	 * Retorna o periodo da estadia
	 * @return periodo
	 * 			Periodo da estadia do hospede
	 */
	public Periodo getPeriodo() {
		return periodo;
	}
	
	/**
	 * Retorna o numero de dias em que o hospede ficara hospedado
	 * @return Numero de dias
	 */
	public int numDias() {
		return periodo.getNumeroDias();
	}
	
	
	/**
	 * Adiciona um novo aluguel de carro a lista de servicos
	 * @param aluguel
	 * 			Um novo aluguel de carro
	 */
	public void adicionaAluguelCarro(AluguelCarro aluguel) throws Exception{
		verificaContratoFechado();
		verificaCoincidenciaNumDias(aluguel.getPeriodo());
		servicos.add(aluguel);
	}
	
	/**
	 * Adiciona um novo servico de BabySitter ao contrato
	 * @param baby
	 * 			Um servico de BabySitter
	 */
	public void adicionaBabySitter(BabySitter baby) throws ContratoFechadoException, PeriodoInvalidoException {
		verificaContratoFechado();
		verificaCoincidenciaNumDias(baby.getPeriodo());
		servicos.add(baby);
	}
	
	/**
	 * Adiciona uma nova refeicao ao objeto restaurante, que e mais um servico do contrato
	 * @param r
	 * 			Uma nova refeicao a ser adicionada.
	 */
	public void adicionaRefeicao(Refeicao r) throws ContratoFechadoException, PeriodoInvalidoException{
		verificaContratoFechado();
		if (!(getPeriodo().dataIsContida(r.getData()))){
			throw new PeriodoInvalidoException("Data nao esta contida na hospedagem");
		}
		getRestaurante().adicionaRefeicao(r);
	}
	
	/**
	 * Verifica se o contrato esta aberto ou fechado
	 * @return aberto
	 * 			True se o contrato estiver aberto ou False caso contrario
	 */
	public boolean isAberto(){
		return aberto;
	}
	
	/**
	 * Modifica o status do contrato. De fechado para aberto ou vice-versa
	 */
	public boolean fechaContrato(){
		if (isAberto())
			return false;
		else {
			aberto = false;
			return true;
		}
	}
	
	/**
	 * Calcula o valor de todos os servicos usados pelo hospede (Quarto e servicos especiais)
	 * @return soma
	 * 			O somatorio do valor de todos os servicos
	 */
	public double calculaValorServicos(){
		double soma = 0;
		Iterator<Servicos> it = servicos.iterator();
		while(it.hasNext()) {
			Servicos umServico = it.next();
			soma += umServico.valor();		
		}
		
		return soma;
	}
	
	/**
	 * Calcula o valor de todos os servicos usando a estrategia de cobranca, que depende do periodo
	 */
	public double calculaValorTotal(){
		return calculaValorServicos() * getEstrategia().getFator();
	}
	
	/**
	 * Retorna o objeto hospede
	 */
	public Hospede getHospede(){
		return hospede;
	}
	
	/**
	 * Retorna o telefone do hospede
	 */
	public String getTelefone() {
		return hospede.getTelefone();
	}
	
	/**
	 * Retorna o nome do hospede
	 */
	public String getNome() {
		return hospede.getNome();
	}
	
	/**
	 * Retorna o CPF do hospede
	 */
	public String getCPF() {
		return hospede.getCpf();
	}
	
	/**
	 * Retorna o RG do hospede
	 */
	public String getRG() {
		return hospede.getRg();
	}
	
	/**
	 * Retorna o email do hospede
	 */
	public String getEmail() {
		return hospede.getEmail();
	}
	
	/**
	 * Retorna o endereco do hospede
	 */
	public String getEndereco() {
		return hospede.getEndereco();
	}
	
	/**
	 * Imprime o status do quarto
	 * @return Status
	 * 			Retorna a string ABERTO ou FECHADO
	 */
	private String mostraStatus(){
		if (isAberto())
			return "ABERTO";
		else
			return "FECHADO";
	}
	
	/**
	 * Imprime todos os servicos especiais consumidos que constara na fatura final
	 */
	private String imprimeCadaServicoEspecial(){
		String servicosEspeciais = "\n-";
		for (int i = 1; i < servicos.size(); i++) {
			servicosEspeciais += "\n\n" + servicos.get(i).toString();
		}
		
		return servicosEspeciais;
	}
	
	/**
	 * Imprime a fatura final com todas as caracteristicas da hospedagem
	 * @return String
	 * 			Contem as informacoes do hospede, o quarto, todos servicos usados e seu valor total, alem do valor final da estadia, a forma de pagamento e o status atual do contrato
	 */
	public String imprimeFaturaFinal(){
		return hospede.toString() + "\nPeriodo: " + getPeriodo().toString() + "(" + numDias() + " dias)"
				+ "\nDados do quarto: " + servicos.get(0).toString()
				+ "\n\nServicos especiais (pela ordem): " + imprimeCadaServicoEspecial()
				+ "\n\n\nValor total dos servicos: " + calculaValorServicos() 
				+ "\nValor total da estadia: " + calculaValorTotal()
				+ "\nForma de pagamento: " + hospede.getNumeroCartao()
				+ "\n\nStatus do contrato: " + mostraStatus();
	}
	
	private void verificaContratoFechado() throws ContratoFechadoException {
		if (!(isAberto()))
			throw new ContratoFechadoException("O contrato ja foi fechado");
	}
	
	private void verificaCoincidenciaNumDias(Periodo p)
			throws PeriodoInvalidoException {
		if (p.getNumeroDias() > getPeriodo().getNumeroDias())
			throw new PeriodoInvalidoException("Numero de dias invalido");
	}
	
	/**
	 * Verifica um contrato atualmente. Como sera usado apenas para rapida verificacao nao contem informacoes de pagamento (apenas em relacao ao quarto ,que e fixo)
	 * @return String
	 * 			Contem as informacoes do hospede, o periodo, o quarto e o statis
	 */
	@Override
	public String toString(){	
		return hospede.toString()
				+ "\nPeriodo da hospedagem: " + getPeriodo().toString()
				+ "\n" + servicos.get(0).toString()
				+ "\nStatus do contrato: " + mostraStatus();
	}

	/**
	 * Verifica se dois contratos sao iguais
	 */
	@Override
	public boolean equals(Object obj){
		if (!(obj instanceof Contrato))
			return false;
		
		Contrato c1 = (Contrato) obj;
		
		return getHospede().equals(c1.getHospede()) && isAberto() == c1.isAberto() && calculaValorTotal() == c1.calculaValorTotal();
	}
	
	
}
