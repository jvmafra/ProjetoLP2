package nucleo.classes.hotel;

import java.util.List;

/**
 * Interface alugavel. Todo alugavel do hotel tem uma lista de datas e um metodo para verificar
 * disponibilidade em certo periodo
 * @author Joao Victor Barroso Mafra
 */
public interface Alugavel {
	public List<Periodo> getPeriodos();
	public boolean isDisponivel(Periodo p);
}
