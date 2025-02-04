package TEMA6.Boletín1.Ejercicio1;

import java.util.List;

public class Principal {
    public static void main(String[] args) {

        Equipo equipoA = new Equipo("A");
        Equipo equipoB = new Equipo("B");
        Equipo equipoC = new Equipo("C");

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
            Equipo equipo = equipoA.interseccionDeEquipos(equipoB);

        } catch (EquipoException e) {
            System.out.println(e.getMessage());
        }
    }
}
