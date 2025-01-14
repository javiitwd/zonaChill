package TEMA5.BOLETÍN1.Ejercicio2;

public class Furgoneta extends Vehiculo {
    private static final double EXTRA_POR_PMA = 0.5;
    double pma;

    public Furgoneta(String matricula, Tgama gama, double pma) {
        super(matricula, gama);
        this.pma = pma;
    }

    @Override
    public double calcularPrecioDeAlquiler(int diasAlquilado) {

        double precioSinExtras = calcularPrecioSinExtras(diasAlquilado);

        double precioExtra = pma * EXTRA_POR_PMA;

        return precioSinExtras + precioExtra;
    }
}
