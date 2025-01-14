package TEMA5.BOLETÍN1.Ejercicio2;

public class Coche extends Vehiculo {
    private Tcombustible combustible;

    public Coche(String matricula, Tgama gama, Tcombustible combustible) {
        super(matricula, gama);
        this.combustible = combustible;
    }

    @Override
    public double calcularPrecioDeAlquiler(int diasAlquilado) {

        double precioSinExtras = calcularPrecioSinExtras(diasAlquilado);

        double precioExtra = combustible.precioCombustible;

        return precioExtra + precioExtra;
    }
}
