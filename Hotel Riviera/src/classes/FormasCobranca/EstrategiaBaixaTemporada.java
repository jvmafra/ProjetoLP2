package classes.FormasCobranca;


public class EstrategiaBaixaTemporada implements EstrategiaCobranca{
	public static final double FATOR = 0.8;
	
	@Override
	public double getFator(){
		return EstrategiaBaixaTemporada.FATOR;
	}
	
	@Override
	public String toString(){
		return "BAIXA TEMPORADA";
	}
}
