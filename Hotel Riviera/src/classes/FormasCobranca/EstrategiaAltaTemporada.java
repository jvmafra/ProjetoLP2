package classes.FormasCobranca;

import java.io.Serializable;


public class EstrategiaAltaTemporada implements EstrategiaCobranca, Serializable{
	public static final double FATOR = 2;
	
	@Override
	public double getFator(){
		return EstrategiaAltaTemporada.FATOR;
	}
	
	@Override
	public String toString(){
		return "ALTA TEMPORADA";
	}
}
