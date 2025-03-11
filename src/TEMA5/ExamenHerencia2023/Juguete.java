package TEMA5.ExamenHerencia2023;

public class Juguete {

    private double precio;
    private String nombre;
    private String marca;

    public Juguete(double precio, String nombre, String marca) {
        this.precio = precio;
        this.nombre = nombre;
        this.marca = marca;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    @Override
    public String toString() {
        return "Juguete{" +
                "precio=" + precio +
                ", nombre='" + nombre + '\'' +
                ", marca='" + marca + '\'' +
                '}';
    }
}
