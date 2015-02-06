package classes.Carro;

/**
 * Um carro possui uma placa de identificacao, a identificacao se eh considerado
 * de luxo ou nao e uma lista de periodos, que sera modificada a medida que o carro
 * eh alugado por alguem ou devolvido.
 * 
 * @author Joao Victor Barroso Mafra e Adiel Andrade
 */

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import classes.HotelOpiniaoServicosPeriodo.Alugavel;
import classes.HotelOpiniaoServicosPeriodo.Periodo;
import excecoes.PlacaInvalidaException;

public class Carro implements Serializable, Alugavel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String descricao;
	private String placa;
	private boolean luxo;
	private List<Periodo> periodos;
	
	public Carro(String descricao,String placa, boolean luxo) throws Exception{
		if (descricao == null || descricao.equals("")){
			throw new Exception("Descricao invalida");
		}
		
		if(!(verificaPlacaValida(placa))){
			throw new PlacaInvalidaException("Placa invalida");
		}
		
		this.luxo = luxo;
		this.placa = placa;
		this.descricao = descricao;
		
		periodos = new ArrayList<>();
	}
	
	public String getDescricao() {
		return descricao;
	}

	public String getPlaca() {
		return placa;
	}
	

	public void setPlaca(String placa) {
		this.placa = placa;
	}
	

	public boolean isLuxo() {
		return luxo;
	}
	

	public void setLuxo(boolean luxo) {
		this.luxo = luxo;
	}
	

	public List<Periodo> getPeriodos() {
		return periodos;
	}
	

	public void adicionaPeriodo(Periodo periodo) {
		getPeriodos().add(periodo);
	}
	
	public void removePeriodo(Periodo periodo) {
		getPeriodos().remove(periodo);				
	}
	
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
