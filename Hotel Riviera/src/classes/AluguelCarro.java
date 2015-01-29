package classes;

public class AluguelCarro implements Servicos {
	private Periodo periodo;
	private boolean tanqueCheio;
	private boolean luxo;
	private boolean seguro;
	private double valor;
	
	public AluguelCarro(boolean tanque, boolean luxo, boolean seguro, Periodo p) throws Exception {
		this.luxo = luxo;
		this.seguro = seguro;
		this.tanqueCheio = tanque;
	}
	
	public Periodo getPeriodo() {
		return periodo;
	}
	public int getNumDias() {
		return getPeriodo().getNumeroDias();
	}

	public boolean isTanqueCheio() {
		return tanqueCheio;
	}

	public boolean isLuxo() {
		return luxo;
	}

	public boolean isSeguro() {
		return seguro;
	}

	@Override
	public double valor() {
		valor = (getNumDias() * valorLuxo()) + valorSeguro() + valorTanqueCheio();
		return valor;
	}
	
	@Override
	public String toString() {
		return "ALUGUEL DE CARRO: " + "\nPeriodo: " + getNumDias() + "\nValor: R$ " + valor();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AluguelCarro other = (AluguelCarro) obj;
		if (luxo != other.luxo)
			return false;
		if (getNumDias() != other.getNumDias())
			return false;
		if (seguro != other.seguro)
			return false;
		if (tanqueCheio != other.tanqueCheio)
			return false;
		if (Double.doubleToLongBits(valor) != Double
				.doubleToLongBits(other.valor))
			return false;
		return true;
	}
	
	private int valorTanqueCheio() {
		if(isTanqueCheio()){
			return 150;
		}
		return 0;
	}
	
	private int valorSeguro() {
		if(isSeguro()){
			return 100;
		}
		return 0;
	}
	
	private int valorLuxo() {
		if(isLuxo()){
			return 100;
		}
		return 60;
	}
	
	
}
