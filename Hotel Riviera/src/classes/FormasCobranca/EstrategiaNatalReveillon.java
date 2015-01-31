package classes.FormasCobranca;


public class EstrategiaNatalReveillon implements EstrategiaCobranca{
	public static final double FATOR = 1.2; //FATOR FIXO
		
	@Override
	public double getFator(){
		return EstrategiaNatalReveillon.FATOR;
	}

}
