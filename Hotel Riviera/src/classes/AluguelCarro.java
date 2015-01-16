package classes;

public class AluguelCarro implements Servicos {
	boolean tanqueCheio;
	boolean luxo;
	boolean seguro;
	int numDias;
	double valor;
	
	public AluguelCarro(boolean tanque, boolean luxo, boolean seguro, int numDias) throws Exception {
		if(numDias <= 0 ){
			throw new Exception("Numero de dias invalidos");		
		}
		this.luxo = luxo;
		this.numDias = numDias;
		this.seguro = seguro;
		this.tanqueCheio = tanque;
	}
	
	public int getNumDias() {
		return numDias;
	}

	public void setNumDias(int numDias) {
		this.numDias = numDias;
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
	valor = (numDias * luxo()) + seguro() + tanquecheio();
		return 0;
	}
	
	@Override
	public String toString() {
		return "AluguelCarro [numero de dias=" + numDias + ", valor =" + valor + "]";
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
		if (numDias != other.numDias)
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
	
	private int tanquecheio() {
		if(tanqueCheio){
			return 150;
		}
		return 0;
	}
	
	private int seguro() {
		if(seguro){
			return 100;
		}
		return 0;
	}
	
	private int luxo() {
		if(luxo){
			return 100;
		}
		return 60;
	}
	
	
}
