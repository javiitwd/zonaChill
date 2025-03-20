package DocumentoCompartido.Tema6.Ejercicio1;

import java.util.ArrayList;
import java.util.List;

public class Ruta {

    private String nombre;
    private String destinoFinal;
    private List<String> paradasIntermedias;

    public Ruta(String nombre, String destinoFinal) {
        this.nombre = nombre;
        this.destinoFinal = destinoFinal;
        this.paradasIntermedias = new ArrayList<>();
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

    @Override
    public String toString() {
        return "Ruta{" +
                "nombre='" + nombre + '\'' +
                ", destinoFinal='" + destinoFinal + '\'' +
                ", paradasIntermedias=" + paradasIntermedias +
                '}';
    }
}
