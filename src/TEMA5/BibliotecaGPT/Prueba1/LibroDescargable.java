package TEMA5.BibliotecaGPT.Prueba1;

public class LibroDescargable extends Libros implements Descargable {

    private int tamMb;
    private int visitas;

    public LibroDescargable(int idUnico, String autor, String titulo, int numPaginas, String editorial, int tamMb, int visitas) {
        super(idUnico, autor, titulo, numPaginas, editorial);
        this.tamMb = tamMb;
        this.visitas = visitas;
    }

    @Override
    public void descargar() {
        System.out.println("Descargando...");
        visitas++;
    }

    @Override
    public int obtenerNumDescargas() {
        return getVisitas();
    }

    public int getTamMb() {
        return tamMb;
    }

    public void setTamMb(int tamMb) {
        this.tamMb = tamMb;
    }

    public int getVisitas() {
        return visitas;
    }

    public void setVisitas(int visitas) {
        this.visitas = visitas;
    }
}
