package DocumentoCompartido.Tema6.Ejercicio2;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Categoria {

    private String nombreCategoria;
    private Set<Frase> frasesDeLaCategoria;

    public Categoria(String nombreCategoria) {
        this.nombreCategoria = nombreCategoria;
        frasesDeLaCategoria = new HashSet<>();
    }

    public String getNombreCategoria() {
        return nombreCategoria;
    }

    public Set<Frase> getFrasesDeLaCategoria() {
        return frasesDeLaCategoria;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Categoria categoria = (Categoria) o;
        return Objects.equals(nombreCategoria, categoria.nombreCategoria);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(nombreCategoria);
    }
}
