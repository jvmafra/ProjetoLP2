package nucleo.classes.arquivo;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

public class Email {
	
	public Email() {

	}

	public void enviaEmail(String email, String texto, String assunto)
			throws Exception {
		if (email == null || !verificaEmail(email))
			throw new EmailException();
		if (texto == null || texto.equals(""))
			throw new Exception();
		if (assunto == null || assunto.equals(""))
			throw new Exception();

		SimpleEmail emailFatura = new SimpleEmail();
		emailFatura.setHostName("smtp.gmail.com");
		emailFatura.addTo(email, "Joao");
		emailFatura.setFrom("rivieracampina@gmail.com", "Hotel Riviera");
		emailFatura.setSubject(assunto);
		emailFatura.setMsg(texto);
		emailFatura
				.setAuthentication("rivieracampina@gmail.com", "edvalcabeca");
		emailFatura.setSmtpPort(465);
		emailFatura.setSSL(true);
		emailFatura.setTLS(true);
		emailFatura.send();

	}

	private boolean verificaEmail(String email) {
		
		Pattern p = Pattern
				.compile("^[\\w-]+(\\.[\\w-]+)*@([\\w-]+\\.)+[a-zA-Z]{2,7}$");

		Matcher m = p.matcher(email);
		if (m.find())
			return true;

		return false;

	}
}