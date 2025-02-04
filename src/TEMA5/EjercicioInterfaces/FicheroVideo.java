package TEMA5.EjercicioInterfaces;

public class FicheroVideo extends FicherosBinarios implements Reproducible{

    private double duracion;

    public FicheroVideo(String nombre, int tamano, Byte[] bytes, double duracion) {
        super(nombre, tamano, bytes);

        this.duracion = duracion;
    }

    public double getDuracion() {
        return duracion;
    }

    public void setDuracion(double duracion) {
        this.duracion = duracion;
    }

    @Override
    public String toString() {
        return "FicheroVideo: " +
                "duracion=" + duracion;
    }

    @Override
    public void reproducir() {
        System.out.println("Reproduciendo FicheroVideo");
    }
}
