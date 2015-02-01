package classes.Quartos;

import java.util.ArrayList;
import java.util.List;

import classes.HotelOpiniaoServicosPeriodo.Periodo;

/**
 * Classe que representa um quarto do tipo
 * Luxo Simples do Hotel
 * @author Hugo Gabriel
 *
 */

public class QuartoLuxoSimples extends Quarto{
	public static final double VALOR_DA_DIARIA = 520.00;
	public static final double VALOR_DA_DIARIA_COM_CAMA_EXTRA = 540.00;
	public static final int CAPACIDADE = 1;
	private boolean camaExtra;
	private List<Periodo> periodo = new ArrayList<>();
	
	/**
	 * Cria o quarto Luxo Simples
	 * @param numeroDoQuarto
	 * 		O numero relativo ao quarto
	 * @param camaExtra
	 * 		Boolean indicando a existencia (ou nao) de cama extra no quarto
	 * @throws Exception
	 * 		O numero do quarto deve ser sempre inteiro positivo
	 */
	public QuartoLuxoSimples(int numeroDoQuarto, boolean camaExtra) throws Exception{
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
		return periodo.add(p);
		
	}
	/**
	 * Remove um objeto do tipo periodo da lista de periodos do quarto 
	 * @param p Periodo a ser removido
	 * @return trua se a operacao foi realizada
	 */
	public boolean removePeriodo(Periodo p){
		return periodo.remove(p);
				
	}
	
	/**
	 * Fornece uma representacao do quarto Luxo Simples como String
	 */
	@Override
	public String toString() {
		return "Quarto Luxo Simples " + super.toString();
	}
	
	/**
	 * Verifica se o quarto Luxo Simples e um objeto dado como parametro sao iguais
	 * 
	 * Dois objetos da classe QuartoLuxoSimples sao iguais se possuem
	 * mesmo numero do quarto e mesmo hospede
	 * @param obj
	 * 		O objeto a ser comparado
	 * @return
	 * 		true, se os objetos forem iguais
	 */
	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof QuartoLuxoSimples))
			return false;
		return super.equals(obj);
	}

}