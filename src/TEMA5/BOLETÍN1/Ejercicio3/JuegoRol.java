package TEMA5.BOLETÍN1.Ejercicio3;

import java.util.ArrayList;
import java.util.List;

public class JuegoRol {

    private List<Personaje> listadoDePersonajes;

    public JuegoRol(List<Personaje> listadoDePersonajes) {
        this.listadoDePersonajes = new ArrayList<>();
    }

    public String mostrarListadoDePersonajes() {

        StringBuilder lista = new StringBuilder();

        for (Personaje personaje : listadoDePersonajes) {

            lista.append(personaje).append(System.lineSeparator());
        }

        return lista.toString();
    }

    public String mostrarListadoOrdenadoPorPuntosVidaActuales() {

        List<Personaje> personajesOrdenados = new ArrayList<>(listadoDePersonajes);

        personajesOrdenados.sort(null);

        StringBuilder lista = new StringBuilder();

        for (Personaje personaje : personajesOrdenados) {

            lista.append(personaje).append(System.lineSeparator());
        }

        return lista.toString();
    }
}
