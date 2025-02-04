package TEMA5.BibliotecaGPT;

public class LibroDescargable extends Libro implements Descargable {

    private int tam_mb;
    private int descargasRealizadas;

    public LibroDescargable(String titulo, String autor, int identificador, int numPaginas, String editorial, int tam_mb) {
        super(titulo, autor, identificador, numPaginas, editorial);
        this.tam_mb = tam_mb;
        descargasRealizadas = 0;
    }

    public int getTam_mb() {
        return tam_mb;
    }

    public void setTam_mb(int tam_mb) {
        this.tam_mb = tam_mb;
    }

    public int getDescargasRealizadas() {
        return descargasRealizadas;
    }

    public void setDescargasRealizadas() {
        this.descargasRealizadas++;
    }

    @Override
    public void descargar() {
        setDescargasRealizadas();
    }

    @Override
    public int consultarMB() {
        return 0;
    }

    @Override
    public int consultarDescargas() {
        return 0;
    }

    @Override
    public String toString() {
        return "LibroDescargable: " +
                "tam_mb=" + tam_mb +
                ", descargasRealizadas=" + descargasRealizadas;
    }
}
