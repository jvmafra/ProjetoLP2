package classes.Alimentacao;

import java.util.ArrayList;
import java.util.List;

import classes.HotelOpiniaoServicosPeriodo.Periodo;
import classes.HotelOpiniaoServicosPeriodo.Servico;

public class Restaurante implements Servico{
	private Refeicao refeicao;
	
	public Restaurante (Refeicao refeicao){
		this.refeicao = refeicao;
	}

	public Refeicao getRefeicao() {
		return refeicao;
	}
	
	@Override
	public double valor(){
		return getRefeicao().getPreco();
	}
	
	
	public String getData(){
		return getRefeicao().getDataString();
	}
	
	@Override
	public String toString(){
		return getRefeicao().toString();
	}
	
	@Override
	public boolean equals(Object obj){
		if (!(obj instanceof Restaurante))
			return false;
		Restaurante outro = (Restaurante) obj;
		
		return getRefeicao().equals(outro.getRefeicao());
	}
	
	
	
	
}
