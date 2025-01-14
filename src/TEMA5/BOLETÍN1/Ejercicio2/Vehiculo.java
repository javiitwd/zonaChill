package TEMA5.BOLETÍN1.Ejercicio2;

public abstract class Vehiculo {
    private String matricula;
    private Tgama gama;

    public Vehiculo(String matricula, Tgama gama) {
        this.matricula = matricula;
        this.gama = gama;
    }

    public String getMatricula() {
        return matricula;
    }

    public double calcularPrecioSinExtras(int diasAlquilado) {

        // Obtener el precio base según la gama
        double precioBase = this.gama.precioBase;

        // Esto solo calcula el precio base, ahora necesitas considerar los extras
        return precioBase * diasAlquilado;
    }

    /*
      calcularPrecioDeAlquiler es abstract, lo que obliga
      a todas las subclases (como Coche, Furgoneta, etc.)
      a proporcionar su propia implementación de este metodo.
     */
    public abstract double calcularPrecioDeAlquiler(int diasAlquilado);
}
