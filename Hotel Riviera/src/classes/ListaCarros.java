package classes;

/**
 * Manipula uma lista de carros que estarao presentes no Hotel. Eh possivel
 * adicionar ou remover um carro, bem como verificar a existencia de um.
 * 
 * @author Joao Victor Barroso Mafra e Adiel Andrade
 */


import java.util.ArrayList;
import java.util.List;

public class ListaCarros {
	private List<Carro> carros = new ArrayList <>();
	
	public void adicionaCarro(Carro carro){
		carros.add(carro);
	}
	
	public void removeCarro(Carro carro){
		carros.remove(carro);
	}
	
	public int numCarros(){
		return carros.size();
	}
	
	public boolean verificaCarro(String placa){
		for (Carro carro: carros) {
			if(carro.getPlaca().equals(placa)){
				return true;
			}
			
		}
		return false;
		
	}
	
	@Override
	public String toString() {
		String todasPlacas = "CARROS: \n";
		for (Carro carro: carros){
			todasPlacas += "\n" + carro.getPlaca();
		}
		
		return todasPlacas;
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
