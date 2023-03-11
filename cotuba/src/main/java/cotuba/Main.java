package cotuba;

import java.nio.file.Path;

public class Main {

  public static void main(String[] args) {

    CliParser cliParser = new CliParser(args);

    String formato = cliParser.getFormato();
    Path diretorioDosMD = cliParser.getDiretorioDosMD();
    Path arquivoDeSaida = cliParser.getArquivoDeSaida();

    if ("pdf".equals(formato)) {
      var pdf = new PdfConverter();
      pdf.convertPdf(diretorioDosMD, arquivoDeSaida);

    } else if ("epub".equals(formato)) {
        var epub = new EpubConverter();
        epub.convertEpub(diretorioDosMD, arquivoDeSaida);
    } else {
      throw new IllegalArgumentException("Formato do ebook inválido: " + formato);
    }
    System.out.println("Arquivo gerado com sucesso: " + arquivoDeSaida);
  }
}

