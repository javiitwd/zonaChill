package TEMA6.Boletín1.Ejercicio7.prueba2;

public class Ingrediente {

    private String nombreIngrediente;
    private double cantidad;

    public Ingrediente(String nombreIngrediente, double cantidad) {
        this.nombreIngrediente = nombreIngrediente;
        this.cantidad = cantidad;
    }

    public String getNombreIngrediente() {
        return nombreIngrediente;
    }

    public void setNombreIngrediente(String nombreIngrediente) {
        this.nombreIngrediente = nombreIngrediente;
    }

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        return "Ingrediente: " +
                "nombreIngrediente='" + nombreIngrediente + '\'' +
                ", cantidad=" + cantidad +
                '.';
    }
}
