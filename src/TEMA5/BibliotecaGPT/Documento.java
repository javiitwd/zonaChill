package TEMA5.BibliotecaGPT;

public class Documento {

    private String titulo;
    private String autor;
    private int identificador;

    public Documento(String titulo, String autor, int identificador) {
        this.titulo = titulo;
        this.autor = autor;
        this.identificador = identificador;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getIdentificador() {
        return identificador;
    }

    public void setIdentificador(int identificador) {
        this.identificador = identificador;
    }


    @Override
    public String toString() {
        return "Documento: " +
                "titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", identificador=" + identificador;
    }
}
