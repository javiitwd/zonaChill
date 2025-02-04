package TEMA5.EjercicioInterfaces;

import java.util.Arrays;

public class FicheroTexto extends Fichero implements Leible{

    private String[] parrafos;

    public FicheroTexto(String nombre, long tamano) {
        super(nombre, tamano);
        parrafos = new String[200];
    }

    public String[] getParrafos() {
        return parrafos;
    }

    public void setParrafos(String[] parrafos) {
        this.parrafos = parrafos;
    }

    @Override
    public String toString() {
        return "FicheroTexto: " +
                "parrafos=" + Arrays.toString(parrafos);
    }

    @Override
    public void leer(String texto) {
        System.out.printf("Leyendo %s ", texto);
    }
}