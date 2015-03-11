package nucleo.classes.arquivo;

import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;
import org.apache.commons.mail.MultiPartEmail;

import com.itextpdf.text.Document;

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

		SimpleEmail emailSimples = new SimpleEmail();
		emailSimples.setHostName("smtp.gmail.com");
		emailSimples.addTo(email, "");
		emailSimples.setFrom("rivieracampina@gmail.com", "Hotel Riviera");
		emailSimples.setSubject(assunto);
		emailSimples.setMsg(texto);
		emailSimples
				.setAuthentication("rivieracampina@gmail.com", "edvalcabeca");
		emailSimples.setSmtpPort(465);
		emailSimples.setSSL(true);
		emailSimples.setTLS(true);
		emailSimples.send();

	}
	public void enviaEmailComAnexo(String email, String texto, String assunto, File faturaPDF) throws Exception {
		if (email == null || !verificaEmail(email))
			throw new EmailException();
		if (texto == null || texto.equals(""))
			throw new Exception();
		if (assunto == null || assunto.equals(""))
			throw new Exception();
		if (faturaPDF == null)
			throw new Exception();
		 
		MultiPartEmail emailAnexo = new MultiPartEmail();
		emailAnexo.setHostName("smtp.gmail.com");
		emailAnexo.addTo(email, "");
		emailAnexo.setFrom("rivieracampina@gmail.com", "Hotel Riviera");
		emailAnexo.setSubject(assunto);
		emailAnexo.setMsg(texto);
		emailAnexo
				.setAuthentication("rivieracampina@gmail.com", "edvalcabeca");
		emailAnexo.setSmtpPort(465);
		emailAnexo.setSSL(true);
		emailAnexo.setTLS(true);
		
		EmailAttachment anexo = new EmailAttachment();
	    anexo.setPath("FATURA.pdf");
	    anexo.setDisposition(EmailAttachment.ATTACHMENT);
	    anexo.setName("fatura.pdf");
	    
	    emailAnexo.attach(anexo);
		emailAnexo.send();
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