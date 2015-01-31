package classes;

import excecoes.PlacaInvalidaException;

public class Carro {
	private String placa;
	private boolean luxo;
	private Periodo periodo;
	
	public Carro(String placa, boolean luxo, Periodo p) throws PlacaInvalidaException{
		if(verificaPlacaValida(placa)){
			throw new PlacaInvalidaException();
		}
		this.periodo= p;
		this.luxo = luxo;
		this.placa = placa;
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
	

	public Periodo getPeriodo() {
		return periodo;
	}
	

	public void setPeriodo(Periodo periodo) {
		this.periodo = periodo;
	}
	

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Carro other = (Carro) obj;
		if (luxo != other.luxo)
			return false;
		if (periodo == null) {
			if (other.periodo != null)
				return false;
		} else if (!periodo.equals(other.periodo))
			return false;
		if (placa == null) {
			if (other.placa != null)
				return false;
		} else if (!placa.equals(other.placa))
			return false;
		return true;
	}

	private boolean verificaPlacaValida(String placa){
		if((!(placa.length() == 7 ))){
			return false;
		}
		for (int i = 0; i < placa.length(); i++) {
			if (i <= 4){
				if(!(Character.isLetter(placa.charAt(i)))){
					return false;					
				}
			}
			if (i > 4 ){
				if(!(Character.isDigit(placa.charAt(i)))){
					return false;
			}
		}
	}
	return true;
	
}














}
