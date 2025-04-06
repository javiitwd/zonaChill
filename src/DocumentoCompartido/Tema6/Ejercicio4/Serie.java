package DocumentoCompartido.Tema6.Ejercicio4;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public class Serie {

    private String titulo;
    private String genero;
    private int cantidadTemporadas;
    private List<Usuario> listaUsuariosQueLaSiguen;

    public Serie(String titulo, String genero, int cantidadTemporadas) {
        this.titulo = titulo;
        this.genero = genero;
        this.cantidadTemporadas = cantidadTemporadas;
        this.listaUsuariosQueLaSiguen = new ArrayList<>();
    }

    public String getTitulo() {
        return titulo;
    }

    public String getGenero() {
        return genero;
    }

    public int getCantidadTemporadas() {
        return cantidadTemporadas;
    }

    public List<Usuario> getListaUsuariosQueLaSiguen() {
        return listaUsuariosQueLaSiguen;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Serie serie = (Serie) o;
        return Objects.equals(titulo, serie.titulo);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(titulo);
    }

    public List<Usuario> listaDeUsuariosQueSiguenLaSerie() {

        return listaUsuariosQueLaSiguen.stream()
                .sorted(Comparator.comparing(Usuario::getNombre))
                .toList();
    }

    @Override
    public String toString() {
        return "Serie{" +
                "titulo='" + titulo + '\'' +
                ", genero='" + genero + '\'' +
                ", cantidadTemporadas=" + cantidadTemporadas +
                ", listaUsuariosQueLaSiguen=" + listaUsuariosQueLaSiguen +
                '}';
    }
}
