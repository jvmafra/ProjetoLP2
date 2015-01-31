package classes;

import java.util.ArrayList;
import java.util.List;

public class ListaCarros {
	private List<Carro> carros = new ArrayList <>();
	
	public void adcionaCarro(Carro carro){
		carros.add(carro);
	}
	
	public void removeCarro(Carro carro){
		carros.remove(carro);
	}
	
	public int numCarros(){
		return carros.size();
	}
	
	public boolean verificaCarroExiste(Carro carro){
		for (int i = 0; i < numCarros(); i++) {
			if(carro.equals(carros.get(i))){
				return true;
			}
			
		}
		return false;
		
	}
	
	
	@Override
	public String toString() {
		return "ListaCarros [carros=" + carros + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ListaCarros other = (ListaCarros) obj;
		if (carros == null) {
			if (other.carros != null)
				return false;
		} else if (!carros.equals(other.carros))
			return false;
		return true;
	}
		
	
}
