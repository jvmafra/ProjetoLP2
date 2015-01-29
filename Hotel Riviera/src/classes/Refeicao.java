package classes;

import java.util.Calendar;

public class Refeicao {
	double valor;
	Calendar data;
	
	public Refeicao(double valor, Calendar data) throws Exception {
		if(valor < 0) {
			throw new Exception("Valor da conta invalido.");
		}
		
		if (data.getTime().getHours() < 6 || data.getTime().getHours() > 22){
			throw new Exception("O restaurante nao estava funcionando nesse horario");
		}
		this.valor = valor;
		this.data = data;
	}
	
	public Calendar getData() {
		return data;
	}
	
	public String getDataString() {
		int dia = getData().get(Calendar.DATE);
		int mes = getData().get(Calendar.MONTH);
		int ano = getData().get(Calendar.YEAR);
		
		return dia + "/" + mes + "/" + ano;
	}


	public double getPreco() {
		return valor;
	}

	@Override
	public String toString() {
		return "Data: " + getDataString() + "\nValor: R$ "  + getPreco();
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Refeicao))
			return false;
		
		Refeicao rf = (Refeicao) obj;
		
		return getDataString().equals(rf.getDataString()) && getPreco() == rf.getPreco();
		
	}
	
	
}
