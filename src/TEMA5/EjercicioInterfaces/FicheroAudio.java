package TEMA5.EjercicioInterfaces;

public class FicheroAudio extends FicherosBinarios implements Reproducible{

    private double duracion;

    public FicheroAudio(String nombre, int tamano, Byte[] bytes, double duracion) {
        super(nombre, tamano, bytes);
        this.duracion = duracion;
    }

    @Override
    public void reproducir() {
        System.out.println("Reproduciendo FicheroAudio");
    }
}
