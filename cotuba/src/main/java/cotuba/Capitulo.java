package cotuba;

public class Capitulo {

    private String titulo;
    private String conteudoHTML;

    public Capitulo() {
    }

    public Capitulo(String titulo, String conteudoHTML) {
        this.titulo = titulo;
        this.conteudoHTML = conteudoHTML;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getConteudoHTML() {
        return conteudoHTML;
    }

    public void setConteudoHTML(String conteudoHTML) {
        this.conteudoHTML = conteudoHTML;
    }
}
