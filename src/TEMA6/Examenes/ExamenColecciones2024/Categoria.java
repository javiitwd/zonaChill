package TEMA6.Examenes.ExamenColecciones2024;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Categoria {
    private String nombre;
    private Set<Producto> productos;

    public Categoria(String nombre) {
        this.nombre = nombre;
        productos = new HashSet<>();
    }

    public Set<Producto> getProductos() {
        return productos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Categoria categoria = (Categoria) o;
        return Objects.equals(nombre, categoria.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(nombre);
    }
}
