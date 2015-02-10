package classes.Carro;

/**
 * Um carro possui uma placa de identificacao, a identificacao se eh considerado
 * de luxo ou nao, uma descricao e uma lista de periodos, que sera modificada a medida que o carro
 * eh alugado por alguem ou devolvido.
 * 
 * @author Joao Victor Barroso Mafra e Adiel Andrade
 */

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import classes.HotelOpiniaoServicosPeriodo.Alugavel;
import classes.HotelOpiniaoServicosPeriodo.Periodo;
import excecoes.DescricaoInvalidaException;
import excecoes.PlacaInvalidaException;

public class Carro implements Serializable, Alugavel{
	
	private static final long serialVersionUID = 1L;
	private String descricao;
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	private String placa;
	private boolean luxo;
	private List<Periodo> periodos;
	
	
	/**
	 * Costrutor de um novo carro que recebe uma descricao, uma placa, e um boolean para saber se o carro e de luxo ou nao
	 * @param descricao
	 * 		descricao do carro
	 * @param placa
	 * 		placa do carro
	 * @param luxo
	 * 		boolean para saber se o carro e de luxo ou não
	 * @throws PlacaInvalidaException 
	 * 		Caso a descricao enviada seja null ou uma String vazia
	 * @throws DescricaoInvalidaException
	 *		Caso a placa seja invalida
	 */
	
	public Carro(String descricao,String placa, boolean luxo) throws DescricaoInvalidaException, PlacaInvalidaException{
		if (descricao == null || descricao.equals("")){
			throw new DescricaoInvalidaException("Descricao invalida");
		}
		
		if(!(verificaPlacaValida(placa))){
			throw new PlacaInvalidaException("Placa invalida");
		}
		
		this.luxo = luxo;
		this.placa = placa;
		this.descricao = descricao;
		
		periodos = new ArrayList<>();
	}
	
	
	/**
	 * Retorna a Descriçao do carro
	 * @return -String descricao
	 */
	public String getDescricao() {
		return descricao;
	}

	/**
	 * Retorna a placa do carro
	 * @return String placa
	 */
	public String getPlaca() {
		return placa;
	}
	

	/**
	 * Muda a placa do carro recebendo uma nova placa
	 * @param placa
	 * 		nova placa do carro
	 */
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	
	/**
	 * Retorna um boolean se o carro luxo
	 * @return True: se o carro for de luxo, False: se o carro nao for de luxo
	 * 
	 */
	public boolean isLuxo() {
		return luxo;
	}
	
	/**
	 * Muda se o carro e de luxo ou nao
	 * @param luxo
	 * 		boolean luxo
	 */
	public void setLuxo(boolean luxo) {
		this.luxo = luxo;
	}
	
	/**
	 * Pega o periodo da lista de periodos
	 */
	public List<Periodo> getPeriodos() {
		return periodos;
	}
	
	/**
	 * Adiciona um periodo na lista de periodos
	 * @param periodo
	 * 		Objecto Periodo que contem um intervalo de datas
	 */
	public void adicionaPeriodo(Periodo periodo) {
		getPeriodos().add(periodo);
	}
	
	/**
	 * Remove um periodo da lista de periodo
	 * @param periodo
	 */
	public void removePeriodo(Periodo periodo) {
		getPeriodos().remove(periodo);				
	}
	
	/**
	 * verifica se o carro estara disponivel em algum determinado periodo
	 * @param p
	 * 		Objecto Periodo que contem um intervalo de datas
	 * @return True: se o carro estiver disponivel, False: se o carro nao estiver disponivel
	 */
	public boolean isDisponivel(Periodo p){
		for (Periodo periodo: periodos){
			if (p.periodoCoincide(periodo))
				return false;
		}
		
		return true;
	}
	
	
	private boolean verificaPlacaValida(String placa){
		if((!(placa.length() == 7 ))){
			return false;
		}
		for (int i = 0; i < placa.length(); i++) {
			if (i < 3){
				if(!(Character.isLetter(placa.charAt(i)))){
					return false;					
				}
			}
			if (i > 2 ){
				if(!(Character.isDigit(placa.charAt(i)))){
					return false;
			}
		}
	}
	return true;
	
	}
	
	
	@Override
	public boolean equals(Object obj){
		if (!(obj instanceof Carro))
			return false;
		
		Carro c = (Carro) obj;
		
		return getPlaca().equals(c.getPlaca()) && isLuxo() == c.isLuxo();
	}
	
	@Override
	public String toString() {
		return getDescricao() + " - " + getPlaca();
	}
}
