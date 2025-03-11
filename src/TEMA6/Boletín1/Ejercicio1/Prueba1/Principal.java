package TEMA6.Boletín1.Ejercicio1.Prueba1;

import TEMA6.Boletín1.Ejercicio1.EquipoException;

public class Principal {
    public static void main(String[] args) {

        TEMA6.Boletín1.Ejercicio1.Prueba1.Equipo equipoA = new TEMA6.Boletín1.Ejercicio1.Prueba1.Equipo("a");
        TEMA6.Boletín1.Ejercicio1.Prueba1.Equipo equipoB = new TEMA6.Boletín1.Ejercicio1.Prueba1.Equipo("b");
        TEMA6.Boletín1.Ejercicio1.Prueba1.Equipo equipoC = new TEMA6.Boletín1.Ejercicio1.Prueba1.Equipo("c");

        TEMA6.Boletín1.Ejercicio1.Prueba1.Alumno alumno1 = new TEMA6.Boletín1.Ejercicio1.Prueba1.Alumno("Carmeli", "qwdfw");
        TEMA6.Boletín1.Ejercicio1.Prueba1.Alumno alumno2 = new TEMA6.Boletín1.Ejercicio1.Prueba1.Alumno("Carmeli2", "qefw");
        TEMA6.Boletín1.Ejercicio1.Prueba1.Alumno alumno3 = new TEMA6.Boletín1.Ejercicio1.Prueba1.Alumno("Carmeli3", "32rw");

        try {

            //equipoA.annadirAlumno(alumno1);

            equipoA.borrarAlumno(alumno1);
            equipoA.annadirAlumno(alumno1);
            TEMA6.Boletín1.Ejercicio1.Prueba1.Alumno a = equipoA.alumnoPerteneceAUnEquipo(alumno1);

            System.out.println(equipoA.mostrarListaDePersonasDelEquipo());

            equipoB.annadirAlumno(alumno1);
            equipoB.annadirAlumno(alumno2);
            Equipo equipoUnido = equipoA.unirEquipos(equipoB);
            Equipo equipoInterseccion = equipoA.interseccionDeEquipos(equipoB);

        } catch (EquipoException e) {
            System.out.println(e.getMessage());
        }
    }
}
