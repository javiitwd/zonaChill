package TEMA5.BibliotecaGPT.Prueba1;

public class ArticuloCientificoLeible extends ArticuloCientifico implements Leible {

    private String url;
    private int descargas;

    public ArticuloCientificoLeible(int idUnico, String autor, String titulo, int numCitas, String revistaEnLaQueFuePublicado, String url, int descargas) {
        super(idUnico, autor, titulo, numCitas, revistaEnLaQueFuePublicado);
        this.url = url;
        this.descargas = descargas;
    }

    @Override
    public void leer() {
        System.out.println("Leyendo...");
        descargas++;
    }

    @Override
    public int obtenerNumVisitas() {
        return getDescargas();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getDescargas() {
        return descargas;
    }

    public void setDescargas(int descargas) {
        this.descargas = descargas;
    }
}
