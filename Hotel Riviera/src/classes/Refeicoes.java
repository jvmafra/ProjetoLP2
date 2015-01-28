package classes;

import java.util.ArrayList;
import java.util.List;

public class Refeicoes {
	private List<Restaurante> refeicoes = new ArrayList <>();
	
	public Refeicoes(){
		
	}
	
	public void adcionaRefeicao(Restaurante pedido){
		refeicoes.add(pedido);
	}
	
	public void removeRefeicao(Restaurante pedido){
		refeicoes.remove(pedido);
	}
	
	public int numPedidos(){
		return refeicoes.size();
	}

	@Override
	public String toString() {
		String qualquer = "Refeições feitas no restaurante: \n";
		qualquer = qualquer.concat("Data: " +"           -  "+ "Pedido: \n");
		for (int i = 0; i < refeicoes.size(); i++) {
			Restaurante restaurante = refeicoes.get(i);
			qualquer = qualquer.concat("Data: " +"           -  "+ restaurante.getPedido());
		}
		return qualquer;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Refeicoes other = (Refeicoes) obj;
		if (refeicoes == null) {
			if (other.refeicoes != null)
				return false;
		} else if (!refeicoes.equals(other.refeicoes))
			return false;
		return true;
	}
	
	
	
}
