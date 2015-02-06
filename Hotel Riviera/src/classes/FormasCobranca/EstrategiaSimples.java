package classes.FormasCobranca;


public class EstrategiaSimples implements EstrategiaCobranca {
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
