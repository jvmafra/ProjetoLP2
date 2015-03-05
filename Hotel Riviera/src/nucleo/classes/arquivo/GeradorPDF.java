package nucleo.classes.arquivo;

import java.io.FileOutputStream;
import java.io.IOException;

import nucleo.classes.pessoa.Contrato;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

public class GeradorPDF {
	
	static Contrato contrato;
	
	public GeradorPDF(Contrato contrato){
		this.contrato = contrato;
	}

    public static void main(String[] args) {
           // criação do documento
          Document document = new Document();
          try {
             
              PdfWriter.getInstance(document, new FileOutputStream("PDF_DevMedia.pdf"));
             
              document.add(new Paragraph(getContrato().getHospede().mostraInformacoes()));
              document.add(new Paragraph(getContrato().imprimeCadaServicoEspecial()));
              document.add(new Paragraph("Periodo " + getContrato().getPeriodo().toString()));
              document.add(new Paragraph("Valor total: R$ " + getContrato().calculaValorTotal()));
              
}
          catch(DocumentException de) {
              System.err.println(de.getMessage());
          }
          catch(IOException ioe) {
              System.err.println(ioe.getMessage());
          }
          document.close();
      }
    
    public static Contrato getContrato(){
    	return contrato;
    }
  }