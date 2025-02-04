package TEMA5.MuseoArteDigitalGPT;

public class ImagenDigitalInteractiva extends ImagenDigital{

    private int numInteracciones;
    private String tipoInteraccionPermitida;

    public ImagenDigitalInteractiva(String titulo, String autor, int anoCreacion, int codigoInventario, double valor, int resolucion, String formato, String tipoInteraccionPermitida) {
        super(titulo, autor, anoCreacion, codigoInventario, valor, resolucion, formato);

        this.numInteracciones = 0;
        this.tipoInteraccionPermitida = tipoInteraccionPermitida;
    }

    public int getNumInteracciones() {
        return numInteracciones;
    }

    public void setNumInteracciones(int numInteracciones) {
        this.numInteracciones = numInteracciones;
    }

    public String getTipoInteraccionPermitida() {
        return tipoInteraccionPermitida;
    }

}
