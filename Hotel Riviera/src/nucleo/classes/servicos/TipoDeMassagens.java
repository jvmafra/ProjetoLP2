package nucleo.classes.servicos;

public enum TipoDeMassagens {
	
	SHIATSU("Shiatsu" , 100),CLASSICA("Classica" , 80),REIKI("Reiki",85),PEDRAS_QUENTES("Pedras Quentes" ,45);
	
	private double valor;
	private String nome;
	
	private TipoDeMassagens(String nome , double valor){
		this.valor = valor;
		this.nome =nome;
	}
	
	public double getValor(){
		return valor;
	}
	
	public String getNome(){
		return nome;
	}

}
