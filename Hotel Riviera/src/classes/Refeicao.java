package classes;

import java.util.Calendar;

public class Refeicao implements Servicos {
	double valor;
	String descricao;
	Calendar data;
	
	public Refeicao(double valor, String item, Calendar data) throws Exception {
		if(valor < 0) {
			throw new Exception("Valor da conta inválido.");
		}
		
		if (data.getTime().getHours() < 6 || data.getTime().getHours() > 22){
			throw new Exception("O restaurante não estava funcionando nesse horário");
		}
		this.valor = valor;
		this.descricao = item;
		this.data = data;
	}

	public String getDescricao() {
		return descricao;
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

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@Override
	public double valor() {
		return valor;
	}

	@Override
	public String toString() {
		return "Descrição: " + getDescricao()
				+ "\nValor: R$ " + valor() + "\nData: " + getDataString();
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Refeicao))
			return false;
		
		Refeicao rf = (Refeicao) obj;
		
		return getDescricao() == rf.getDescricao() && valor() == rf.valor();
		
	}
	
	
}
