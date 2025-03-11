package TEMA5.BibliotecaGPT.Prueba1;

public class Libros extends Documento {

    private int numPaginas;
    private String editorial;

    public Libros(int idUnico, String autor, String titulo, int numPaginas, String editorial) {
        super(idUnico, autor, titulo);
        this.numPaginas = numPaginas;
        this.editorial = editorial;
    }

    public int getNumPaginas() {
        return numPaginas;
    }

    public void setNumPaginas(int numPaginas) {
        this.numPaginas = numPaginas;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }
}
