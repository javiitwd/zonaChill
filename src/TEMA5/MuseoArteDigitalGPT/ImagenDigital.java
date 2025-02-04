package TEMA5.MuseoArteDigitalGPT;

public class ImagenDigital extends Obra{

    private int resolucion;
    private String formato;

    public ImagenDigital(String titulo, String autor, int anoCreacion, int codigoInventario, double valor, int resolucion, String formato) {
        super(titulo, autor, anoCreacion, codigoInventario, valor);
        this.resolucion = resolucion;
        this.formato = formato;
    }

    public int getResolucion() {
        return resolucion;
    }

    public String getFormato() {
        return formato;
    }
}
