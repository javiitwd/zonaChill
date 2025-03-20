package TEMA6.Examenes.examen_colecciones2023stream;

import java.util.*;

public class Liga {
    private List<Equipo> equipos;
    private String nombre;

    public Liga(String nombre) {
        this.equipos = new ArrayList<>();
        this.nombre = nombre;
    }

    public void addEquipo(Equipo e) throws LigaException {

        if (equipos.contains(e)) {
            throw new LigaException("Ya existe el equipo");
        }

        if (e.getJugadores().isEmpty()) {
            throw new LigaException("El equipo a añadir no puede estar vacío");
        }

        equipos.add(e);
    }

    public void eliminarEquipo(Equipo e) throws LigaException {

        if (!equipos.contains(e)) {
            throw new LigaException("El equipo no está en la liga");
        }

        equipos.remove(e);
    }

    public void unirEquipos(Equipo e1, Equipo e2) throws LigaException {

        //Si algunos de los 2 equipos no estan en la liga lanzamos Excepcion
        if (!equipos.contains(e1) || !equipos.contains(e2)) {
            throw new LigaException("Los 2 equipos deben estar en la liga");
        }

        //Si el equipo 2 esta vacio lanzamos Excepcion
        if (e2.getJugadores().isEmpty()) {
            throw new LigaException("El equipo 2 debe tener jugadores");
        }

        //A los jugadores del equipo1 le meto los jugadores del equipo2
        //automaticamente no se nos metera sin repetidos ya que es un Set
        e1.getJugadores().addAll(e2.getJugadores());
    }

    public List<Jugador> jugadoresEnComun(Equipo e1, Equipo e2) throws LigaException {

        List<Jugador> jugadoresComun = new ArrayList<>();

        return e1.getJugadores().stream()
                .filter(e -> e.equals(e2.getJugadores()))
                .toList();
    }

    public double calcularMediaEdad() {
        return equipos.stream() // Recorremos los equipos
                //Convertimos el stream de equipos en un Stream de jugadores
                .flatMap(equipo -> equipo.getJugadores().stream())
                //Convertimos el Stream de Jugadores a un Stream de Int (edad de los jugadores)
                .mapToInt(Jugador::calcularEdad) //  el metodo calcularEdad() para obtener la edad de cada jugador
                .average() // Calculamos la media
                .orElse(0); // Si no hay jugadores, devolvemos 0
    }

    public List<Jugador> jugadoresOrdenadosEdad() {

        //Convierto el Set de todos los jugadores de la liga en una Lista
        List<Jugador> todosLosJugadores = new ArrayList<>(todosLosJugadores());

        //Lo ordenamos por la edad (de menor a mayor)
        todosLosJugadores.sort(Comparator.comparing(Jugador::calcularEdad).reversed());

        return todosLosJugadores;
    }

    public List<Jugador> jugadoresOrdenadosNombre() {

        //Convierto el Set de todos los jugadores de la liga en una Lista
        List<Jugador> todosLosJugadores = new ArrayList<>(todosLosJugadores());

        //Lo ordenamos por la nombre (Alfabeticamente)
        todosLosJugadores.sort(Comparator.comparing(Jugador::getNombre));

        return todosLosJugadores;
    }

    private Set<Jugador> todosLosJugadores() {

        //Creo el Set en el que voy a meter todos los jugadores de la liga
        Set<Jugador> todosLosJugadoresDeLaLiga = new HashSet<>();

        //Recorro los equipos y añado sus jugadores al nuevo Set que hemos creado
        for (Equipo equipo : equipos) {
            todosLosJugadoresDeLaLiga.addAll(equipo.getJugadores());
        }

        return todosLosJugadoresDeLaLiga;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Bienvenidos a " + nombre).append(System.lineSeparator());
        sb.append("Equipos: ").append(System.lineSeparator());
        for (Equipo e : equipos) {
            sb.append(e).append(System.lineSeparator());
        }

        return sb.toString();

    }
}
