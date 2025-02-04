package TEMA6.Boletín1.Ejercicio2;

import TEMA6.Boletín1.Ejercicio1.Alumno;
import TEMA6.Boletín1.Ejercicio1.EquipoException;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class EquipoGenerico<T> {

    private String nombreEquipo;
    private Set<Alumno> conjuntoAlumnos;

    public EquipoGenerico(String nombreEquipo) {
        this.nombreEquipo = nombreEquipo;
        conjuntoAlumnos = new HashSet<>();
    }

    public String getNombreEquipo() {
        return nombreEquipo;
    }

    public Set<Alumno> getConjuntoAlumnos() {
        return conjuntoAlumnos;
    }

    public void anadirAlumno(Alumno alumno) throws EquipoException {

        if (conjuntoAlumnos.contains(alumno)) {
            throw new EquipoException("El alumno ya existe");
        }
        conjuntoAlumnos.add(alumno);
    }

    public void borrarAlumno(Alumno alumno) throws EquipoException {

        if (!conjuntoAlumnos.contains(alumno)) {
            throw new EquipoException("El alumno no está");
        }
        conjuntoAlumnos.remove(alumno);
    }

    public Alumno buscarAlumno(Alumno alumno) {

        if (conjuntoAlumnos.contains(alumno)) {
            return alumno;
        }
        return null;
    }

    public List<Alumno> mostrarListaDePersonasDelEquipo() {

        //Convertimos la coleccion en una lista
        return new ArrayList<>(conjuntoAlumnos);
    }

    public EquipoGenerico<T> unionDeEquipos(EquipoGenerico<T> equipo) {

        EquipoGenerico<T> equipoNuevo = new EquipoGenerico<>("EquipoUnion");

        //addAll es para añadir toda la coleccion
        equipoNuevo.conjuntoAlumnos.addAll(equipo.getConjuntoAlumnos());
        equipoNuevo.conjuntoAlumnos.addAll(this.getConjuntoAlumnos());
        return equipoNuevo;
    }

    public EquipoGenerico<T> interseccionDeEquipos(EquipoGenerico<T> equipo) {

        EquipoGenerico<T> equipoNuevo = new EquipoGenerico<>("EquipoUnion");

        equipoNuevo.conjuntoAlumnos.addAll(this.conjuntoAlumnos);

        //Añado solo los jugadores que se repiten, los diferentes se eliminan
        equipoNuevo.conjuntoAlumnos.retainAll(equipo.getConjuntoAlumnos());
        return equipoNuevo;
    }

    @Override
    public String toString() {
        return "Equipo{" +
                "nombreEquipo='" + nombreEquipo + '\'' +
                ", conjuntoAlumnos=" + conjuntoAlumnos +
                '}';
    }
}
