package nucleo.classes.hotel;

import java.util.List;

public interface Alugavel {
	public List<Periodo> getPeriodos();
	public boolean isDisponivel(Periodo p);
}
