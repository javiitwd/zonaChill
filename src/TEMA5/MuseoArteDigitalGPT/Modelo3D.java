package TEMA5.MuseoArteDigitalGPT;

public class Modelo3D extends Obra{

    private int numPoligonos;
    private int tam_mb;

    public Modelo3D(String titulo, String autor, int anoCreacion, int codigoInventario, double valor, int tam_mb, int numPoligonos) {
        super(titulo, autor, anoCreacion, codigoInventario, valor);

        this.numPoligonos = numPoligonos;
        this.tam_mb = tam_mb;
    }

    public int getNumPoligonos() {
        return numPoligonos;
    }

    public int getTam_mb() {
        return tam_mb;
    }

    @Override
    public String toString() {
        return "Modelo3D{" +
                "numPoligonos=" + numPoligonos +
                ", tam_mb=" + tam_mb +
                '}';
    }
}
