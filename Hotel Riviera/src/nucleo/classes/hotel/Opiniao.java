package nucleo.classes.hotel;
import java.io.Serializable;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Opinioes deixadas pelos hospedes sobre o funcionamento do hotel
 * @author Joao Victor Barroso Mafra
 */
public class Opiniao implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String comentario;
	private int nota;
	private Calendar data;
	
	/**
	 * Construtor que recebe as informacoes necessarias para geracao de uma opiniao
	 * @param comentario
	 * 			Comentario feito pelo hospede
	 * @param nota
	 * 			A nota dada pelo hospede		
	 */
	public Opiniao (String comentario, int nota) throws Exception{
		if (comentario == null)
			throw new Exception("Comentario nulo");
		
		if (comentario.length() > 140)
			throw new Exception("Comentario longo demais");
		
		if (nota > 10 || nota < 0)
			throw new Exception("Nota invalida");
		
		data = new GregorianCalendar();
		this.comentario = comentario;
		this.nota = nota;
	}
	
	/**
	 * Retorna a nota dada pelo hospede
	 */
	public int getNota() {
		return nota;
	}
	
	/**
	 * Retorna o comentario feito pelo hospede
	 */
	public String getComentario() {
		return comentario;
	}
	
	/**
	 * Retorna um objeto do tipo Calendar que representa a data daquela opiniao
	 */
	public Calendar getData() {
		return data;
	}
	
	/**
	 * Modifica a data da publicacao
	 */
	public void setData(Calendar data){
		this.data = data;
	}
	
	/**
	 * Retorna a data completa em forma de String no formato XX/YY/ZZZZ
	 */
	public String getDataCompleta() {
		int dia = data.get(Calendar.DATE);
		int mes = data.get(Calendar.MONTH) + 1;
		int ano = data.get(Calendar.YEAR);
		
		String data_completa = dia + "/" + mes + "/" + ano;
		
		return data_completa;
	}
	
	/**
	 * Retorna a hora em forma de String no formato XX:YY
	 */
	public String getHora() {
		@SuppressWarnings("deprecation")
		int hora = data.getTime().getHours();
		@SuppressWarnings("deprecation")
		int minutos = data.getTime().getMinutes();
		
		String hora_completa = hora + ":" + minutos;
		
		return hora_completa;
	}
	
	/**
	 * Retorna a informacao completa a respeito da Opiniao (comentario, data, hora e nota)
	 */
	@Override
	public String toString() {
		return getComentario() + "\n" + getDataCompleta() 
				+  " as " + getHora()
				+ "\nNota: " + getNota();

	}
	
	/**
	 * Verifica se duas opinioes coincidem
	 */
	@Override
	public boolean equals(Object obj){
		if (!(obj instanceof Opiniao))
			return false;
		
		Opiniao o = (Opiniao) obj;
		
		return getComentario().equals(o.getComentario()) && getNota() == o.getNota();
	}
	

}
