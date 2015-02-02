import java.util.Calendar;
import java.util.GregorianCalendar;

import classes.Baba.Baba;
import classes.Baba.BabySitter;
import classes.HotelOpiniaoServicosPeriodo.Periodo;


public class testaBaba {
	public static void main(String[] args) throws Exception {
		Calendar c = new GregorianCalendar(2015, 1, 1, 7, 0);
		Calendar c2 = new GregorianCalendar(2015, 1, 1, 8, 0);
		
	//	System.out.println(c2);
		//System.out.println(c.HOUR_OF_DAY);
		Periodo p = new Periodo(c, c2);
		Baba b = new Baba("Maria");
		BabySitter bs = new BabySitter(b, p);
		
		System.out.println(bs.valor());
		
		
		//System.out.println(bs.getHorarioInicio());
		//System.out.println(bs.getHorarioTermino());
	}
	

}
