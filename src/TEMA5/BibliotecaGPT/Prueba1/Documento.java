package TEMA5.BibliotecaGPT.Prueba1;

public class Documento {

    private String titulo;
    private String autor;
    private int idUnico;

    public Documento(int idUnico, String autor, String titulo) {
        this.idUnico = idUnico;
        this.autor = autor;
        this.titulo = titulo;
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

    public int getIdUnico() {
        return idUnico;
    }

    public void setIdUnico(int idUnico) {
        this.idUnico = idUnico;
    }
}
