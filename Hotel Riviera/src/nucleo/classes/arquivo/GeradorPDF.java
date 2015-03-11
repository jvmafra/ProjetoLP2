package nucleo.classes.arquivo;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import nucleo.classes.pessoa.Contrato;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
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
			
			document.add(new Paragraph(getContrato().getHospede()
					.mostraInformacoes()));
			document.add(new Paragraph(getContrato()
					.imprimeCadaServicoEspecial()));
			document.add(new Paragraph("Periodo "
					+ getContrato().getPeriodo().toString()));
			document.add(new Paragraph("Valor total: R$ "
					+ getContrato().calculaValorTotal()));


		} catch (DocumentException de) {
			System.err.println(de.getMessage());
		} catch (IOException ioe) {
			System.err.println(ioe.getMessage());
		}

		document.close();
		
	}

	public File getDocumento() {
		File fatura = new File("Fatura.pdf");
		return fatura;
	}
	public void apagaDocumento() {
				
	}

	public static Contrato getContrato() {
		return contrato;
	}
}