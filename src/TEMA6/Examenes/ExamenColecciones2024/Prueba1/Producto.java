package TEMA6.Examenes.ExamenColecciones2024.Prueba1;

import java.time.LocalDate;
import java.util.Objects;

public class Producto implements Comparable<Producto>{

    private String marca;
    private String modelo;
    private double precio;
    private String descripcion;
    private LocalDate fechaIncorporacion;
    private int stock;

    public Producto(String marca, String modelo, double precio, String descripcion, int stock) {
        this.marca = marca;
        this.modelo = modelo;
        this.precio = precio;
        this.descripcion = descripcion;
        this.stock = stock;
        this.fechaIncorporacion = LocalDate.now();
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public double getPrecio() {
        return precio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public LocalDate getFechaIncorporacion() {
        return fechaIncorporacion;
    }

    public int getStock() {
        return stock;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Producto producto = (Producto) o;
        return Objects.equals(marca, producto.marca) && Objects.equals(modelo, producto.modelo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(marca, modelo);
    }

    @Override
    public String toString() {
        return "Producto{" +
                "marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", precio=" + precio +
                ", descripcion='" + descripcion + '\'' +
                ", fechaIncorporacion=" + fechaIncorporacion +
                ", stock=" + stock +
                '}';
    }

    @Override
    public int compareTo(Producto o) {
        return this.getStock() - o.getStock();
    }
}
