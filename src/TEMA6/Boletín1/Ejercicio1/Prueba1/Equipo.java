package TEMA6.Boletín1.Ejercicio1.Prueba1;

import TEMA6.Boletín1.Ejercicio1.EquipoException;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Equipo {

    private String nombreEquipo;
    private Set<Alumno> conjuntoAlumnos;

    public Equipo(String nombreEquipo) {
        this.nombreEquipo = nombreEquipo;
        this.conjuntoAlumnos = new HashSet<>();
    }

    public Set<Alumno> getConjuntoAlumnos() {
        return conjuntoAlumnos;
    }

    public void annadirAlumno(Alumno alumnoAAnnadir) throws EquipoException {

        if (conjuntoAlumnos.contains(alumnoAAnnadir)) {
            throw new EquipoException("El alumno ya existe");
        }
        conjuntoAlumnos.add(alumnoAAnnadir);
    }

    public void borrarAlumno(Alumno alumnoABorrar) throws EquipoException {

        if (!conjuntoAlumnos.contains(alumnoABorrar)) {
            throw new EquipoException("El alumno no está en el conjunto");
        }
        //Recorro los alumnos con un iterator, ya que voy a borrar si lo encuentro en pleno bucle
        Iterator<Alumno> iterator = conjuntoAlumnos.iterator();

        //Si lo encuentro, borro la posicion con iterator.remove()
        boolean encontrado = false;
        while (iterator.hasNext()) {
            if (iterator.next().equals(alumnoABorrar)) {
                iterator.remove();
                encontrado = true;
                break;
            }
        }
        if (!encontrado) {
            throw new EquipoException("El alumno no está en el equipo.");
        }
    }

    public Alumno alumnoPerteneceAUnEquipo(Alumno alumnoABuscar) {
        if (conjuntoAlumnos.contains(alumnoABuscar)) {
            return alumnoABuscar;
        }
        return null;
    }

    public String mostrarListaDePersonasDelEquipo() {
        return conjuntoAlumnos.toString();
    }

    public Equipo unirEquipos(Equipo equipoAUnir) {
        //Creo en equipo
        Equipo equipoUnido = new Equipo("EquipoUnido");

        //Creo el conjunto de alumnos de los 2 equipos
        //(al principio tendra los alumnos del equipo que llama al metodo)
        Set<Alumno> alumnosDelEquipoUnido = new HashSet<>(conjuntoAlumnos);

        //Añado a los alumnos del equipo que llama al metodo los alumnos del equipo que recibimos por parametro
        alumnosDelEquipoUnido.addAll(equipoAUnir.getConjuntoAlumnos());

        //Añado al conjunto de alumnos del equipo creado los alumnosDelEquipoUnido (que son los no repetidos)
        equipoUnido.conjuntoAlumnos.addAll(alumnosDelEquipoUnido);
        return equipoUnido;
    }

    public Equipo interseccionDeEquipos(Equipo equipoAInterseccionar) {
        //Creo el equipo
        Equipo equipoInterseccion = new Equipo("EquipoInterseccion");

        //Creo un nuevo conjunto de alumnos con los alumnos del equipo que llama al metodo
        Set<Alumno> conjuntoDeAlumnosDuplicados = new HashSet<>(conjuntoAlumnos);

        //Al nuevo conjunto le llamo al metodo retainAll, pasandole los alumnos del equipo que recibimos por parametro
        //El retain All, deja la coleccion con solo elementos en comun, es deicr, lo que necesitanos
        conjuntoDeAlumnosDuplicados.retainAll(equipoAInterseccionar.conjuntoAlumnos);

        //Añado al conjunto de alumnos del equipo creado los alumnos duplicados de los 2 equipos
        equipoInterseccion.conjuntoAlumnos.addAll(conjuntoDeAlumnosDuplicados);
        return equipoInterseccion;
    }

    @Override
    public String toString() {
        return "Equipo{" +
                "nombreEquipo='" + nombreEquipo + '\'' +
                ", conjuntoAlumnos=" + conjuntoAlumnos +
                '}';
    }
}
