package classes.Baba;

/**
 * Manipula uma lista de babas que estarao presentes no Hotel. Eh possivel
 * adicionar ou remover uma baba, bem como verificar a existencia de uma.
 * 
 * @author Joao Victor Barroso Mafra e Adiel Andrade
 */

import java.util.ArrayList;
import java.util.List;

public class ListaBabas {
	private List<Baba> babas = new ArrayList <>();
	
	public List<Baba> getBabas() {
		return babas;
	}
	
	public void adicionaBaba (Baba baba){
		getBabas().add(baba);
	}
	
	public void removeBaba (Baba baba){
		getBabas().remove(baba);
	}
	
	public int numBabas() {
		return getBabas().size();
	}
	
	public boolean verificaBaba(String nome){
		for (Baba baba: babas){
			if (baba.getNome().equals(nome))
				return true;
		}
		
		return false;
	}
	
	@Override
	public boolean equals(Object obj){
		if (!(obj instanceof ListaBabas))
			return false;
		
		ListaBabas outraLista = (ListaBabas) obj;
		
		if (numBabas() != outraLista.numBabas()) {
			return false;
		}
		for (int i = 0; i < babas.size(); i++) {
			if (!(babas.get(i).equals(outraLista.getBabas().get(i))))
				return false;
		}
		
		return true;
	}
	
	@Override
	public String toString(){
		String todasBabas = "BABAS: \n";
		for (Baba baba: babas){
			todasBabas += "\n" + baba.toString();
		}
		
		return todasBabas;
	}
	
	
}
