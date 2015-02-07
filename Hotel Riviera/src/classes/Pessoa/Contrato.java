package classes.Pessoa;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import classes.FormasCobranca.EstrategiaCobranca;
import classes.HotelOpiniaoServicosPeriodo.Periodo;
import classes.HotelOpiniaoServicosPeriodo.Servico;
import classes.Quartos.Quarto;
import excecoes.ContratoFechadoException;
import excecoes.PeriodoInvalidoException;

/**
 * Manipula um contrato de um hotel associado a um hospede.
 * @author Joao Victor Barroso Mafra
 */

public class Contrato {
	private Hospede hospede;
	private List<Servico> servicos = new ArrayList<Servico>();
	private EstrategiaCobranca estrategia;
	private Periodo periodo;
	private boolean aberto;
	private Quarto quarto;
	
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
		if (quarto == null)
			throw new Exception("Quarto invalido");
		if (hospede == null)
			throw new Exception("Hospede invalido");
		if (e == null)
			throw new Exception("Estrategia invalida");
		if (periodo == null){
			throw new PeriodoInvalidoException("Periodo invalido");
		}
		
		this.hospede = hospede;	
		this.estrategia = e;
		this.periodo = periodo;
		this.quarto = quarto;
		
		quarto.adicionaPeriodo(periodo);
		servicos.add(quarto);
		aberto = true;
	}

	public void setPeriodo(Periodo periodo) {
		this.periodo = periodo;
	}

	/**
	 * Retorna a estrategia atual de cobranca
	 */
	public EstrategiaCobranca getEstrategia() {
		return estrategia;
	}
	
	/**
	 * Modifica a estrategia atual de cobranca
	 * @param e
	 * 			A nova estrategia
	 */
	public void setE(EstrategiaCobranca e) {
		this.estrategia = e;
	}
	
	/**
	 * Retorna a lista atual de servicos presentes no contrato
	 */
	public List<Servico> getServicos() {
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
	 * Adiciona um novo servico ao contrato
	 * @param servico
	 * 			Um novo servico a ser adicionado
	 */
	public void adicionaServico(Servico servico) throws Exception{
		verificaContratoFechado();
		servicos.add(servico);
	}
	
	/**
	 * Remove um servico do contrato
	 * @param servico
	 * 			Um servico a ser removido
	 */
	public void removeServico(Servico servico) throws Exception{
		if (!(servicos.contains(servico)))
			throw new Exception("O servico nao existe");
		
		verificaContratoFechado();
		servicos.remove(servico);
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
		if (!(isAberto()))
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
		getQuarto().setPeriodoAtual(getPeriodo());
		double soma = 0;
		Iterator<Servico> it = servicos.iterator();
		while(it.hasNext()) {
			Servico umServico = it.next();
			soma += umServico.valor();		
		}
		
		return soma;
	}
	
	public Quarto getQuarto() {
		return quarto;
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
		return hospede.getCPF();
	}
	
	/**
	 * Retorna o RG do hospede
	 */
	public String getRG() {
		return hospede.getRG();
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
	public String mostraStatus(){
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
				+ "\n\nStatus do contrato: " + mostraStatus();
	}
	
	private void verificaContratoFechado() throws ContratoFechadoException {
		if (!(isAberto()))
			throw new ContratoFechadoException("O contrato ja foi fechado");
	}
	
	
	/**
	 * Verifica um contrato atualmente. Como sera usado apenas para rapida verificacao nao contem informacoes de pagamento (apenas em relacao ao quarto ,que e fixo)
	 * @return String
	 * 			Contem o nome do hospede, o quarto alugado e o status do contrato
	 */
	@Override
	public String toString(){	
		return hospede.getNome() + " - " + servicos.get(0).toString() + " - " + mostraStatus();
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
