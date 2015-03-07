package nucleo.classes.pessoa;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;

import nucleo.classes.formas_cobranca.Estrategia;
import nucleo.classes.hotel.Periodo;
import nucleo.classes.hotel.Servico;
import nucleo.classes.quartos.Quarto;
import nucleo.excecoes.PeriodoInvalidoException;

/**
 * Manipula um contrato de um hotel associado a um hospede.
 * @author Joao Victor Barroso Mafra
 */

public class Contrato implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Hospede hospede;
	private List<Servico> servicos = new ArrayList<Servico>();
	private Estrategia estrategia;
	private Periodo periodo;
	private boolean aberto;
	private Quarto quarto;

	/**
	 * Construtor que recebe as informacoes necessarias para criacao de um contrato
	 * @param quarto
	 * 			O quarto alugado pelo hospede
	 * @param hospede
	 * 			Recebe todas as informacoes a respeito de um hospede
	 * @param e
	 * 			Recebe uma estrategia de cobranca que dependera do periodo do cadastro do hospede
	 * @param periodo
	 * 			Recebe o periodo de hospedagem
	 */
	public Contrato (Quarto quarto, Hospede hospede, Estrategia e, Periodo periodo) throws Exception{
		if (quarto == null)
			throw new Exception("Quarto invalido");
		if (hospede == null)
			throw new Exception("Hospede invalido");
		if (e == null)
			throw new Exception("Estrategia invalida");
		if (periodo == null || periodo.getNumeroDias() == 0){
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


	/**
	 * Retorna a estrategia atual de cobranca
	 */
	public Estrategia getEstrategia() {
		return estrategia;
	}
	
	/**
	 * Modifica a estrategia atual de cobranca
	 * @param e
	 * 			A nova estrategia
	 */
	public void setE(Estrategia e) {
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
	 * Calcula o valor da multa a ser pago pelo cliente em caso de atraso
	 * @return multa
	 * 			Um double que representa a multa a ser paga
	 */
	public double calculaMulta() {
		Calendar hoje = new GregorianCalendar();
		if (hoje.after(periodo.getData_final())){
			Periodo atraso = null;
			try {
				atraso = new Periodo(periodo.getData_final(), hoje);	
			} catch (Exception e) {
			}
			
			return 200 * atraso.getNumeroDias();
			
		}
		else
			return 0;
	}
	
	
	/**
	 * Adiciona um novo servico ao contrato
	 * @param servico
	 * 			Um novo servico a ser adicionado
	 */
	public void adicionaServico(Servico servico) throws Exception{
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
		return (calculaValorServicos() * getEstrategia().getFator()) - calculaMulta();
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
	public String imprimeCadaServicoEspecial(){
		String servicosEspeciais = "SERVICOS ESPECIAIS: \n";
		for (int i = 1; i < servicos.size(); i++) {
			servicosEspeciais += "\n\n" + servicos.get(i).toString();
		}
		
		return servicosEspeciais;
	}
	
	/**
	 * Imprime um resumo atual do contrato
	 */
	public String imprimeResumoAtual(){
		return hospede.mostraInformacoes() + "\n\nQuarto: " + servicos.get(0) + 
				"\n\nPeriodo: " + getPeriodo().toString() + "\n\nSTATUS: " + mostraStatus();
	}
	
	
	/**
	 * Verifica um contrato atualmente. Como sera usado apenas para rapida verificacao nao contem informacoes de pagamento (apenas em relacao ao quarto ,que e fixo)
	 * @return String
	 * 			Contem o nome do hospede, o quarto alugado e o status do contrato
	 */
	@Override
	public String toString(){	
		return getNome() + " - " + servicos.get(0).toString() + " - " + mostraStatus();
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
