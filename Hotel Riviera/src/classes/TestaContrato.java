package classes;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

public class TestaContrato {

	public static void main(String[] args) throws Exception {
		Calendar data1 = new GregorianCalendar();
		Calendar data2 = new GregorianCalendar();
		Quarto q = new QuartoLuxoSimples("2 dias", 1);
		Restaurante r = new Restaurante(52.90, "Macarronada");
		EstrategiaCobranca e = new EstrategiaAltaTemporada();
		List<Servicos> s = new ArrayList<Servicos>();
		Hospede h = new Hospede("Joao", "00000000000", "000000", "jvmafra@hotmail.com", 96446489, "Rua");
		s.add(q);
		s.add(r);
		
		Contrato c = new Contrato(s, h, e, data1, data2, "Cartao");
		
		System.out.println(c.imprimeFaturaFinal());
		
		
		

	}

}
