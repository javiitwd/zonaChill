package TEMA5.EjercicioInterfaces;

import java.util.Arrays;

public class FicherosBinarios extends Fichero{

    private Byte[] bytes;

    public FicherosBinarios(String nombre, int tamano, Byte[] bytes){
        super(nombre, tamano);
        this.bytes = bytes;
    }

    public Byte[] getBytes() {
        return bytes;
    }

    public void setBytes(Byte[] bytes) {
        this.bytes = bytes;
    }

    @Override
    public String toString() {
        return "FicherosBinarios: " +
                "bytes=" + Arrays.toString(bytes);
    }
}
