package classes.FormasCobranca;


public class EstrategiaAltaTemporada implements EstrategiaCobranca {
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
