package cotuba;

import java.nio.file.Path;

public class Main {

  public static void main(String[] args) {

    CliParser cliParser = new CliParser(args);

    String formato = cliParser.getFormato();
    Path diretorioDosMD = cliParser.getDiretorioDosMD();
    Path arquivoDeSaida = cliParser.getArquivoDeSaida();

    var renderer = new MDtoHTML();
    var capitulos = renderer.renderMDtoHTML(diretorioDosMD);

    Ebook ebook = new Ebook(formato, capitulos, arquivoDeSaida);

    if ("pdf".equals(formato)) {
      var pdf = new PdfConverter();
      pdf.convertPdf(ebook);

    } else if ("epub".equals(formato)) {
        var epub = new EpubConverter();
        epub.convertEpub(ebook);
    } else {
      throw new IllegalArgumentException("Formato do ebook inválido: " + formato);
    }
    System.out.println("Arquivo gerado com sucesso: " + arquivoDeSaida);
  }
}

