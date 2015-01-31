package classes;

public class ValidaCartaoDeCredito {
	 
		public static boolean validadorDeCartao(String numero) {
			int s1 = 0, s2 = 0;
			String invertida = new StringBuffer(numero).reverse().toString();
			for (int i = 0 ;i < invertida.length();i++) {
				int digito = Character.digit(invertida.charAt(i), 10);
				if(i % 2 == 0) { s1 += digito; }
				else {
					s2 += 2 * digito;
					if (digito >= 5) { s2 -= 9; }
				}
			}
			return (s1 + s2) % 10 == 0;
		}
}
