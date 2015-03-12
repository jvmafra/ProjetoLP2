package nucleo.classes.arquivo;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import nucleo.classes.pessoa.Contrato;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

public class GeradorPDF {
	private Document document;
	static Contrato contrato;

	public GeradorPDF(Contrato contrato) {
		this.contrato = contrato;
		// criação do documento
		Document document = new Document();
		try {
			PdfWriter.getInstance(document, new FileOutputStream("Fatura.pdf"));
			document.open();
			Image logo = Image.getInstance(GeradorPDF.class
					.getResource("/nucleo/icones/hotel4 feito.png"));
			logo.setAlignment(Element.ALIGN_CENTER);
			document.add(logo);

			Paragraph sobreHospede = new Paragraph(getContrato().getHospede()
					.mostraInformacoes(), new Font(FontFamily.UNDEFINED, 14));
			sobreHospede.setSpacingAfter(20);
			sobreHospede.setSpacingBefore(20);
			
			document.add(sobreHospede);
			document.add(new Paragraph(getContrato()
					.imprimeCadaServicoEspecial()));
			document.add(new Paragraph("Periodo "
					+ getContrato().getPeriodo().toString()));

			Font f = new Font(FontFamily.UNDEFINED, 16, Font.BOLD);
			Paragraph total = new Paragraph("Valor total: R$ "
					+ getContrato().calculaValorTotal(), f);
			total.setAlignment(Element.ALIGN_CENTER);
			document.add(total);

			if (document.isOpen())
				document.close();
		} catch (DocumentException de) {
			System.err.println(de.getMessage());
		} catch (IOException ioe) {
			System.err.println(ioe.getMessage());
		}

	}

	public File getDocumento() {
		File fatura = new File("Fatura.pdf");
		return fatura;
	}

	public void apagaDocumento() {
		File fatura = new File("Fatura.pdf");
		fatura.delete();

	}

	public static Contrato getContrato() {
		return contrato;
	}
}