package classes;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Restaurante implements Servicos {
	double valor;
	List<String> itensConsumidos = new ArrayList<String>();
	Calendar c = Calendar.getInstance();
	
	public Restaurante(double valor, String item)throws Exception {
		if(valor < 0){
			throw new Exception("valor passado invalido");
		}
		this.valor = valor;
		itensConsumidos.add(item);
	}
	
	public void Refeicao(double valor, String item) throws Exception{
		if(valor < 0){
			throw new Exception("valor passado invalido");
		}
		this.valor += valor;
		itensConsumidos.add(item);
	}

	@Override
	public double valor() {
		return valor;
	}

	@Override
	public String toString() {
		return "Restaurante [valor=" + valor + ", itensConsumidos="
				+ itensConsumidos + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Restaurante other = (Restaurante) obj;
		if (itensConsumidos == null) {
			if (other.itensConsumidos != null)
				return false;
		} else if (!itensConsumidos.equals(other.itensConsumidos))
			return false;
		if (Double.doubleToLongBits(valor) != Double
				.doubleToLongBits(other.valor))
			return false;
		return true;
	}

	
}
