package DocumentoCompartido.Tema6.Ejercicio4;

import java.util.*;

public class Usuario {

    private String nombre;
    private String correoElectronico;
    private List<Serie> seriesQueEstaViendo;

    public Usuario(String nombre, String correoElectronico) {
        this.nombre = nombre;
        this.correoElectronico = correoElectronico;
        this.seriesQueEstaViendo = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public List<Serie> getSeriesQueEstaViendo() {
        return seriesQueEstaViendo;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public void addSerieALaLista(Serie serie) throws PlataformaStreamingException {

        if (seriesQueEstaViendo.contains(serie)) {
            throw new PlataformaStreamingException("El usuario ya tiene la serie añadida en su lista");
        }
        seriesQueEstaViendo.add(serie);
    }

    public void eliminarSerieDeLaLista(Serie serie) throws PlataformaStreamingException {

        if (!seriesQueEstaViendo.contains(serie)) {
            throw new PlataformaStreamingException("El usuario no tiene la serie añadida en su lista");
        }
        seriesQueEstaViendo.remove(serie);
    }

    public List<Serie> seriesQueEstaViendo() {

        return seriesQueEstaViendo.stream()
                .sorted(Comparator.comparingInt(Serie::getCantidadTemporadas).reversed())
                .toList();
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "nombre='" + nombre + '\'' +
                ", correoElectronico='" + correoElectronico + '\'' +
                ", seriesQueEstaViendo=" + seriesQueEstaViendo +
                '}';
    }
}
