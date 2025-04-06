package DocumentoCompartido.Tema6.Ejercicio4;

import java.util.*;
import java.util.stream.Collectors;

public class PlataformaStreaming {

    private Set<Usuario> conjuntoUsuarios;
    private Set<Serie> conjuntoSeries;

    public PlataformaStreaming() {
        this.conjuntoUsuarios = new HashSet<>();
        this.conjuntoSeries = new HashSet<>();
    }

    /**
     * Metodo para agregar nueva serie
     *
     * @param serieAResgistrar serie a registrar
     * @return devuvelve true/false para indicar
     * si se ha añadido o no la serie
     */
    public boolean registrarNuevaSerie(Serie serieAResgistrar) {

        return conjuntoSeries.add(serieAResgistrar);
    }

    /**
     * Metodo para añadir un nuevo usuario
     *
     * @param usuarioAAnnadir
     * @return devuelve true/false para indicar
     * si se ha añadido o no el usuario
     */
    public boolean registrarNuevoUsuario(Usuario usuarioAAnnadir) {

        return conjuntoUsuarios.add(usuarioAAnnadir);
    }

    public List<Serie> obtenerSeriesMasSeguidas() throws PlataformaStreamingException {

        int maxEspectantes = conjuntoSeries.stream()
                .mapToInt(s -> s.getListaUsuariosQueLaSiguen().size())
                .max()
                .orElseThrow(() -> new PlataformaStreamingException("No hay series"));

        return conjuntoSeries.stream()
                .filter(s -> s.getListaUsuariosQueLaSiguen().size() == maxEspectantes)
                .toList();
    }

    public void eliminarSerieDelSistema(Serie serieAEliminar) throws PlataformaStreamingException {

        conjuntoSeries.remove(serieAEliminar);

        for (Usuario usuario : conjuntoUsuarios){

            if (usuario.seriesQueEstaViendo().contains(serieAEliminar)){
                usuario.eliminarSerieDeLaLista(serieAEliminar);

            }
        }
    }

    public String obtenerGeneroMasPopular() {

        return conjuntoUsuarios.stream()
                .flatMap(usuario -> usuario.getSeriesQueEstaViendo().stream()) // todas las series de todos los usuarios
                .map(Serie::getGenero) // extraemos solo el género
                .collect(Collectors.groupingBy( // agrupamos por género
                        genero -> genero,
                        Collectors.counting() // contamos cuántas veces aparece cada uno
                ))
                //creamos un flujo de conjunto clave-valor
                .entrySet()
                .stream()
                //coge el maximo conjunto clave/valor comparado por los valores (numSeguidores)
                .max(Map.Entry.comparingByValue())
                //convertimos el conjunto clave-valor a la clave(genero) que es lo que nos interesa
                .map(Map.Entry::getKey)
                .orElse(null); // por si no hay nada
    }

    public String obtenerGeneroMasPopular2() throws PlataformaStreamingException {

        return conjuntoUsuarios.stream()
                .flatMap(usuario -> usuario.getSeriesQueEstaViendo().stream())
                .map(Serie::getGenero)
                .collect(Collectors.groupingBy(genero -> genero, Collectors.counting()))
                .entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElseThrow(() -> new PlataformaStreamingException("Error"));
    }
}
