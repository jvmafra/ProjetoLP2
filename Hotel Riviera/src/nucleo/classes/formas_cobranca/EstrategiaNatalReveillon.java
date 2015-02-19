package nucleo.classes.formas_cobranca;

import java.io.Serializable;


public class EstrategiaNatalReveillon implements EstrategiaCobranca, Serializable{
	public static final double FATOR = 1.2; //FATOR FIXO
		
	@Override
	public double getFator(){
		return EstrategiaNatalReveillon.FATOR;
	}
	
	@Override
	public String toString(){
		return "NATAL/REVEILLON";
	}

}
