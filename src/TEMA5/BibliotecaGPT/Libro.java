package TEMA5.BibliotecaGPT;

public class Libro extends Documento{

    private int numPaginas;
    private String editorial;

    public Libro(String titulo, String autor, int identificador, int numPaginas, String editorial) {
        super(titulo, autor, identificador);
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

    @Override
    public String toString() {
        return "Libro: " +
                "numPaginas=" + numPaginas +
                ", editorial='" + editorial + '\'';
    }
}
