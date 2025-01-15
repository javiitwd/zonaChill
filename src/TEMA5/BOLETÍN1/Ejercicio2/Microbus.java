package TEMA5.BOLETÍN1.Ejercicio2;

public class Microbus extends Vehiculo {
    private static final double PRECIO_POR_PLAZA = 5;
    private int numPlazas;

    public Microbus(String matricula, Tgama gama, int numPlazas) {

        super(matricula, gama);
        this.numPlazas = numPlazas;
    }

    @Override
    public double calcularPrecioDeAlquiler(int diasAlquilado) {

        double precioSinExtras = calcularPrecioSinExtras(diasAlquilado);

        double precioExtra = numPlazas * PRECIO_POR_PLAZA;

        return precioSinExtras + precioExtra;
    }
}