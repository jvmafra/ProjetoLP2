package nucleo.classes.servicos;


/**
 * UM enum , que possui os tipo de massagem com informações sobre o nome e o valor de cada.
 * 
 * @author Adiel Andrade
 *
 */
public enum TipoDeMassagens {
	
	SHIATSU("Shiatsu" , 100),CLASSICA("Classica" , 80),REIKI("Reiki",85),PEDRAS_QUENTES("Pedras Quentes" ,45);
	
	private double valor;
	private String nome;
	
	private TipoDeMassagens(String nome ,  double valor){
		this.valor = valor;
		this.nome =nome;
	}
	
	/**
	 * Retorna o valor da massagem
	 * @return
	 * 		valor
	 */
	public double getValor(){
		return valor;
	}
	
	/**
	 * retorna o Nome da massagem
	 * @return
	 * 		nome
	 */
	public String getNome(){
		return nome;
	}

}
