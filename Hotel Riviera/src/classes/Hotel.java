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
	private ListaCarros carros;
	private ListaBabas babas;
	
	/**
	 * Ao ser inicializado o hotel, sao geradas listas de quartos, carros e babas.
	 */
	public Hotel() {
		carros = new ListaCarros();
		babas = new ListaBabas();
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
