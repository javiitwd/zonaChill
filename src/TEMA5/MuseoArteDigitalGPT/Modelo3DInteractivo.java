package TEMA5.MuseoArteDigitalGPT;

public class Modelo3DInteractivo extends Modelo3D {

    private int numInteracciones;
    private String tipoInteraccionPermitida;

    public Modelo3DInteractivo(String titulo, String autor, int anoCreacion, int codigoInventario, double valor, int tam_mb, int numPoligonos, int numInteracciones, String tipoInteraccionPermitida) {
        super(titulo, autor, anoCreacion, codigoInventario, valor, tam_mb, numPoligonos);

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

    @Override
    public String toString() {
        return "Modelo3DInteractivo{" +
                "numInteracciones=" + numInteracciones +
                ", tipoInteraccionPermitida='" + tipoInteraccionPermitida + '\'' +
                '}';
    }
}
