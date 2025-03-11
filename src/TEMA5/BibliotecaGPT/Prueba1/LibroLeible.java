package TEMA5.BibliotecaGPT.Prueba1;

public class LibroLeible extends Libros implements Leible{

    private String url;
    private int descargas;

    public LibroLeible(int idUnico, String autor, String titulo, int numPaginas, String editorial, String url, int descargas) {
        super(idUnico, autor, titulo, numPaginas, editorial);
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
