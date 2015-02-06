package classes.Alimentacao;

import java.util.Calendar;

import classes.HotelOpiniaoServicosPeriodo.Servico;
import excecoes.PeriodoInvalidoException;
import excecoes.ValorInvalidoException;

public class Refeicao implements Servico{
	double valor;
	Calendar data;
	
	public Refeicao(double valor, Calendar data) throws Exception {
		if(valor < 0) {
			throw new ValorInvalidoException("Valor da conta invalido.");
		}
		
		if (data.get(Calendar.HOUR_OF_DAY) < 6 || data.get(Calendar.HOUR_OF_DAY) > 22){
			throw new PeriodoInvalidoException("O restaurante nao estava funcionando nesse horario");
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


	public double valor() {
		return valor;
	}

	@Override
	public String toString() {
		return "Data: " + getDataString() + "\nValor: R$ "  + valor();
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Refeicao))
			return false;
		
		Refeicao rf = (Refeicao) obj;
		
		return getDataString().equals(rf.getDataString()) && valor() == rf.valor();
		
	}
	
	
}
