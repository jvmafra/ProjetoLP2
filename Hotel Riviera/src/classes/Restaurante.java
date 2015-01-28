package classes;

public class Restaurante implements Servicos {
	double valor;
	String Pedido;
	public Restaurante(double valor, String item)throws Exception {
		if(valor < 0){
			throw new Exception("valor passado invalido");
		}
		this.valor = valor;
		Pedido = item;
	}

	public String getPedido() {
		return Pedido;
	}

	public void setPedido(String pedido) {
		Pedido = pedido;
	}

	@Override
	public double valor() {
		return valor;
	}

	@Override
	public String toString() {
		return "Restaurante valor=" + valor  ;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Restaurante other = (Restaurante) obj;
		if (Double.doubleToLongBits(valor) != Double.doubleToLongBits(other.valor))
			return false;
		return true;
	}



	
}
