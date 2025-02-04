package TEMA5.EjercicioInterfaces;

import java.text.Format;

public class FicheroImagen extends FicherosBinarios{

    private String formato;
    public FicheroImagen(String nombre, int tamano, Byte[] bytes, String formato) {
        super(nombre, tamano, bytes);

        this.formato = formato;
    }

    public String getFormato() {
        return formato;
    }

    public void setFormato(String formato) {
        this.formato = formato;
    }

    @Override
    public String toString() {
        return "FicheroImagen: " +
                "formato='" + formato + '\'';
    }
}
