package TEMA5.BibliotecaGPT;

public class ArticuloCientificoLeible extends ArticuloCientifico implements Leible {

    private String url;
    private int numVisualizaciones;

    public ArticuloCientificoLeible(String titulo, String autor, int identificador, int numCitas, String revista, String url) {

        super(titulo, autor, identificador, numCitas, revista);
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

    public void setNumVisualizaciones() {
        this.numVisualizaciones++;
    }

    @Override
    public void leer() {
        setNumVisualizaciones();
    }

    @Override
    public String consultarURL() {
        return url;
    }

    @Override
    public int consultarVisualizaciones() {
        return numVisualizaciones;
    }

    @Override
    public String toString() {
        return "ArticuloCientificoLeible: " +
                "url='" + url + '\'' +
                ", numVisualizaciones=" + numVisualizaciones;
    }
}
