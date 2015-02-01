package classes.Quartos;

import java.util.ArrayList;
import java.util.List;

import classes.HotelOpiniaoServicosPeriodo.Periodo;
/**
 * Classe que representa um objeto do tipo
 * Executivo Simples
 * @author Hugo Gabriel
 *
 */
public class QuartoExecutivoSimples extends Quarto{
	public static final double VALOR_DA_DIARIA = 360.00;
	public static final double VALOR_DA_DIARIA_COM_CAMA_EXTRA = 380.00;
	public static final int CAPACIDADE = 1;
	private boolean camaExtra;
	private List<Periodo> periodos = new ArrayList<>();
	
	/**
	 * Cria o quarto Executivo Simples
	 * @param numeroDoQuarto
	 * 		O numero relativo ao quarto
	 * @param camaExtra
	 * 		Boolean indicando a existencia (ou nao) de cama extra no quarto
	 * @throws Exception
	 * 		O numero do quarto deve ser sempre inteiro positivo
	 */
	public QuartoExecutivoSimples(int numeroDoQuarto, boolean camaExtra) throws Exception{
		super(numeroDoQuarto);
		this.camaExtra = camaExtra;
		
	}
	/**
	 * Verifica se o quarto comporta um dado numero de pessoas
	 * @param numeroDePessoas
	 * 		Quantidade de pessoas que se deseja hospedar no quarto
	 * @return
	 * 		false, se a capacidade maxima do quarto for excedida
	 * 		true, se o quarto suportar o numero de pessoas desejado
	 */
	@Override
	public boolean isCapacidadeValida(int capacidade){
		if (capacidade > CAPACIDADE)
			return false;
		return true;
	}
	
	/**
	 * Verifica se o quarto possui uma cama extra
	 * @return
	 * 		True, se o quarto possuir cama extra
	 * 		False, se nao houver cama extra no quarto
	 */
	public boolean isCamaExtra() { return camaExtra; }
	
	
	/**
	 * Retorna o valor da diaria do quarto
	 */
	@Override
	public double valor() {
		if (camaExtra)
			return VALOR_DA_DIARIA_COM_CAMA_EXTRA;
		return VALOR_DA_DIARIA;
	}
	
	/**
	 * Adiciona um objeto do tipo Periodo na lista de periodos do quarto
	 * @param p Periodo a ser adicionado
	 * @return true se a operacao foi realizada corretamente
	 */
	public boolean adicionaPeriodo(Periodo p) {
		return periodos.add(p);
		
	}
	/**
	 * Remove um objeto do tipo periodo da lista de periodos do quarto 
	 * @param p Periodo a ser removido
	 * @return trua se a operacao foi realizada
	 */
	public boolean removePeriodo(Periodo p){
		return periodos.remove(p);
				
	}
	
	/**
	 * Fornece uma representacao do quarto Executivo Duplo como String
	 */
	@Override
	public String toString() {
		return "Quarto Executivo Simples " + super.toString();
	}

	/**
	 * Verifica se o quarto Executivo Simples e um objeto dado como parametro sao iguais
	 * 
	 * Dois objetos da classe QuartoExecutivoSimples sao iguais se possuem
	 * mesmo numero do quarto e mesmo hospede
	 * @param obj
	 * 		O objeto a ser comparado
	 * @return
	 * 		true, se os objetos forem iguais
	 */
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof QuartoExecutivoSimples))
			return false;
		return super.equals(obj);
	}
	
	@Override
	public List<Periodo> getPeriodos() {
		return periodos;
	}
	
	
}
