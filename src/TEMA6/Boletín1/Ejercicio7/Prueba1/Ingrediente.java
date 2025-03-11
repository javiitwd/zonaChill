package TEMA6.Boletín1.Ejercicio7.Prueba1;

import java.util.Objects;

public class Ingrediente {

    private String nombreIngrediente;
    private int cantidad;

    public Ingrediente(String nombre, int cantidad) {
        this.nombreIngrediente = nombre;
        this.cantidad = cantidad;
    }

    public String getNombreIngrediente() {
        return nombreIngrediente;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    //Para comparar los ingredientes, necesitamos reescribir el equals y hashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ingrediente that = (Ingrediente) o;
        return Objects.equals(nombreIngrediente, that.nombreIngrediente);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(nombreIngrediente);
    }

    @Override
    public String toString() {
        return "Ingrediente: " +
                "nombre='" + nombreIngrediente + '\'' +
                ", cantidad=" + cantidad +
                '.';
    }
}
