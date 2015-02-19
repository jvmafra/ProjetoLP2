package nucleo.classes.formas_cobranca;

import java.io.Serializable;


public class EstrategiaSaoJoao implements EstrategiaCobranca, Serializable{
	
	public static final double FATOR = 1.1;
	public static final double FATOR_ESPECIAL = 1.5;   // depende dos dias
	private boolean diaEspecial;
	
	public EstrategiaSaoJoao (boolean diaEspecial){
		this.diaEspecial = diaEspecial;
	}
	
	private boolean isDiaEspecial(){
		return diaEspecial;
	}
	
	@Override
	public double getFator(){
		if (isDiaEspecial())
			return FATOR_ESPECIAL;
		else
			return FATOR;
	}
	
	@Override
	public String toString(){
		return "SAO JOAO";
	}
	
}
