package TEMA6.Boletín1.Ejercicio2;

import TEMA6.Boletín1.Ejercicio1.Alumno;
import TEMA6.Boletín1.Ejercicio1.Equipo;
import TEMA6.Boletín1.Ejercicio1.EquipoException;

import java.util.List;

public class PrincipalGenerica {
    public static void main(String[] args) {

        EquipoGenerico<Alumno> equipoA = new EquipoGenerico<>("C");
        EquipoGenerico<Alumno> equipoB = new EquipoGenerico<>("C");
        EquipoGenerico<Alumno> equipoC = new EquipoGenerico<>("C");

        Alumno alumno1 = new Alumno("Antoñito", "qefw");
        Alumno alumno2 = new Alumno("Antoñito", "qefw");
        Alumno alumno3 = new Alumno("Antoñito", "qefw");

        try {

            equipoA.anadirAlumno(alumno1);

            equipoA.borrarAlumno(alumno1);
            equipoA.anadirAlumno(alumno1);
            Alumno si = equipoA.buscarAlumno(alumno1);

            List<Alumno> lista = equipoA.mostrarListaDePersonasDelEquipo();
            System.out.println(lista.toString());

            equipoB.anadirAlumno(alumno1);
            equipoB.anadirAlumno(alumno2);
            EquipoGenerico<Alumno> equipo = equipoA.interseccionDeEquipos(equipoB);

        } catch (EquipoException e) {
            System.out.println(e.getMessage());
        }
    }
}
