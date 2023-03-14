package cotuba;

import com.itextpdf.html2pdf.HtmlConverter;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.AreaBreak;
import com.itextpdf.layout.element.IBlockElement;
import com.itextpdf.layout.element.IElement;
import com.itextpdf.layout.properties.AreaBreakType;

import java.nio.file.Files;
import java.util.List;

public class PdfConverter {

       public void convertPdf(Ebook ebook) {
            try(var writer = new PdfWriter(Files.newOutputStream(ebook.getArquivoDeSaida()));
                var pdf = new PdfDocument(writer);
                var pdfDocument = new Document(pdf)) {

                for (Capitulo capitulo : ebook.getCapitulos()) {

                    String html = capitulo.getConteudoHTML();
                    List<IElement> convertToElements = HtmlConverter.convertToElements(html);

                    for (IElement element : convertToElements) {
                        pdfDocument.add((IBlockElement) element);
                    }
                    if (!ebook.isUltimoCapitulo(capitulo)){
                        pdfDocument.add(new AreaBreak(AreaBreakType.NEXT_PAGE));
                    }
                }

            } catch (Exception ex) {
                throw new IllegalStateException("Erro ao criar arquivo PDF: " + ebook.getArquivoDeSaida().toAbsolutePath(), ex);
            }
    }
}
