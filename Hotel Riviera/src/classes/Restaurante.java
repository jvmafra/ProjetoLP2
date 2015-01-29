package classes;

import java.util.ArrayList;
import java.util.List;

public class Restaurante {
	private List<Refeicao> refeicoes = new ArrayList <>();
	
	public Restaurante(){
		
	}
	public void adcionaRefeicao(Refeicao pedido){
		refeicoes.add(pedido);
	}
	
	public void removeRefeicao(Refeicao pedido){
		refeicoes.remove(pedido);
	}
	
	public int numIdasAoRestaurante(){
		return refeicoes.size();
	}

	@Override
	public String toString() {
		if (numIdasAoRestaurante() == 0){
			return "O hospede nao frequentou o restaurante";
		}
		String idas = "Idas ao restaurante: \n";
		for (int i = 0; i < refeicoes.size(); i++) {
			Refeicao refeicao = refeicoes.get(i);
			idas += refeicao.toString() + "\n";
		}
		return idas;
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
		if (refeicoes == null) {
			if (other.refeicoes != null)
				return false;
		} else if (!refeicoes.equals(other.refeicoes))
			return false;
		return true;
	}
	
	
	
}
