package TEMA5.BibliotecaGPT.Prueba1;

public class ArticuloCientificoDescargable extends ArticuloCientifico implements Descargable {

    private int tamMb;
    private int visitas;

    public ArticuloCientificoDescargable(int idUnico, String autor, String titulo, int numCitas, String revistaEnLaQueFuePublicado, int tamMb, int visitas) {
        super(idUnico, autor, titulo, numCitas, revistaEnLaQueFuePublicado);
        this.tamMb = tamMb;
        this.visitas = visitas;
    }

    @Override
    public void descargar() {
        System.out.println("Descargando...");
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
