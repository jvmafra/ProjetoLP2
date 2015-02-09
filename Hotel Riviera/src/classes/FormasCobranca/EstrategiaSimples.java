package classes.FormasCobranca;

import java.io.Serializable;


public class EstrategiaSimples implements EstrategiaCobranca, Serializable{
	public static final double FATOR = 1;
	
	@Override
	public double getFator(){
		return EstrategiaSimples.FATOR;
	}
	
	@Override
	public String toString(){
		return "SIMPLES";
	}
}
