package DocumentoCompartido.Tema6.Ejercicio1;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class Ruta {

    private String nombre;
    private String destinoFinal;
    private List<String> paradasIntermedias;

    public Ruta(String nombre, String destinoFinal) {
        this.nombre = nombre;
        this.destinoFinal = destinoFinal;
        this.paradasIntermedias = new LinkedList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDestinoFinal() {
        return destinoFinal;
    }

    public void setDestinoFinal(String destinoFinal) {
        this.destinoFinal = destinoFinal;
    }

    public List<String> getParadasIntermedias() {
        return paradasIntermedias;
    }

    public void setParadasIntermedias(List<String> paradasIntermedias) {
        this.paradasIntermedias = paradasIntermedias;
    }

    public void annadirParada(String parada) throws AgenciaViajesException {

        // .trim() es para no pillar los espacios a la hora de comparar
        // anyMatch = devuelve un boolean si alguno coincide con la condicion de los ()
        if (paradasIntermedias.stream()
                .anyMatch(p -> p.equalsIgnoreCase(parada.trim()))) {
            throw new AgenciaViajesException("Ya está la parada");
        }

        getParadasIntermedias().add(parada);
    }

    public void eliminarParada(String parada) throws AgenciaViajesException {

        //Si no hay ninguna parada (noneMatch()) que se llame como la parada lanzamo Excepcion
        if (paradasIntermedias.stream()
                .noneMatch(p -> p.equalsIgnoreCase(parada.trim()))) {
            throw new AgenciaViajesException("No está la parada");
        }

        getParadasIntermedias().remove(parada);
    }

    public boolean contieneParada(String nombreParada) {

        return paradasIntermedias.contains(nombreParada);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ruta ruta = (Ruta) o;
        return Objects.equals(nombre, ruta.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(nombre);
    }

    @Override
    public String toString() {
        return "Ruta{" +
                "nombre='" + nombre + '\'' +
                ", destinoFinal='" + destinoFinal + '\'' +
                ", paradasIntermedias=" + paradasIntermedias +
                '}';
    }
}