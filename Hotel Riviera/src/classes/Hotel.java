package classes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Manipula operacoes relacionadas ao Hotel como um todo
 * @author Joao Victor Barroso Mafra
 */
public class Hotel {
	private List<Contrato> contratos_abertos = new ArrayList();
	private List<Contrato> contratos_fechados = new ArrayList();
	private List<Opiniao> opinioes = new ArrayList();
	private Map<String, Integer> quartos = new HashMap<String, Integer>(7);
	
	/**
	 * Ao ser inicializado o hotel, é gerado seu mapa de quartos
	 */
	public Hotel() {
		geraMapaDeQuartos();	
	}
	
	private void geraMapaDeQuartos(){
		quartos.put("Presidencial", 5);
		quartos.put("Luxo Simples", 5);
		quartos.put("Luxo Duplo", 15);
		quartos.put("Luxo Triplo", 20);
		quartos.put("Executivo Simples", 5);
		quartos.put("Executivo Duplo", 15);
		quartos.put("Executivo Triplo", 20);
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
		c.setStatus();
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
	 * Retorna um Map, que e o mapa de quartos do hotel
	 */
	public Map<String, Integer> getQuartos() {
		return quartos;
	}
	
	/**
	 * Verifica se um certo quarto esta disponivel
	 */
	public boolean isDisponivel(String quarto) throws Exception{
		if (!(getQuartos().containsKey(quarto)))
			throw new Exception("Tipo de quarto inexistente");
		
		if (getQuartos().get(quarto) == 0)
			return false;
		
		return true;
			
	}
	
	/**
	 * Reserva um quarto, decrementando seu valor no mapa
	 */
	public void reservaQuarto(String quarto) throws Exception{
		if (!(getQuartos().containsKey(quarto)))
			throw new Exception("Tipo de quarto inexistente");
		
		if (isDisponivel(quarto)){
			int nova_quantidade = getQuartos().get(quarto) - 1;
			getQuartos().remove(quarto);
			getQuartos().put(quarto, nova_quantidade);
		}
		
		// Precisa ser verificado se existe uma forma melhor de decrementar no mapa sem excluir uma chave
			
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
	

}
