package TEMA5.BibliotecaGPT;

public class LibroLeible extends Libro implements Leible {

    private String url;
    private int numVisualizaciones;

    public LibroLeible(String titulo, String autor, int identificador, int numPaginas, String editorial, String url) {

        super(titulo, autor, identificador, numPaginas, editorial);
        this.url = url;
        numVisualizaciones = 0;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getNumVisualizaciones() {
        return numVisualizaciones;
    }

    @Override
    public String toString() {
        return "LibroLeible: " +
                "url='" + url + '\'' +
                ", numVisualizaciones=" + numVisualizaciones;
    }

    @Override
    public void leer() {
        numVisualizaciones++;
    }

    @Override
    public String consultarURL() {
        return url;
    }

    @Override
    public int consultarVisualizaciones() {
        return numVisualizaciones;
    }
}
