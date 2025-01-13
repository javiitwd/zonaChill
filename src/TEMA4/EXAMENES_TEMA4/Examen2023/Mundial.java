package TEMA4.EXAMENES_TEMA4.Examen2023;

import java.util.Scanner;

public class Mundial {
    static Scanner sc = new Scanner(System.in);
    private int nombre;
    private static Equipo[] equiposParticipantes;

    public Mundial() {
        equiposParticipantes = new Equipo[4];
    }

    public static void main(String[] args) {

        boolean salir = false;
        while (!salir) {
            System.out.println("A) Crear nuevo equipo");
            System.out.println("B) Añadir un jugador a un equipo existente");
            System.out.println("C) Ver el número total de goles marcados por un equipo existente");
            System.out.println("D) Ver el número total de goles marcados por un jugador existente");
            System.out.println("E) Ver el equipo con más goles marcados en el mundial");
            System.out.println("F) Ver el jugador con más goles marcados en el mundial");

            char op = sc.next().charAt(0);
            switch (op) {
                case 'A':
                    System.out.println("Digame el país del equipo");
                    String pais = sc.next();
                    System.out.println("Digame el nombre del entrenador del equipo");
                    String nombreEntrenador = sc.next();
                    System.out.println("¿Cuantos jugadores hay en el equipo?");
                    int tamEquipo = sc.nextInt();
                    Jugador[] listaJugadores = crearListaJugadores(tamEquipo);
                    //Creo el equipo con los datos recogidos
                    Equipo equipo = new Equipo(pais, nombreEntrenador, listaJugadores);
                    //Añado el equipo creado en la ultima posicion
                    equiposParticipantes[equiposParticipantes.length - 1] = equipo;
                    break;
                case 'B':
                    //Obtenemos los datos del equipo
                    System.out.println("Digame el país del equipo");
                    String paisB = sc.next();
                    System.out.println("Digame el nombre del entrenador del equipo");
                    String nombreEntrenadorB = sc.next();
                    System.out.println("¿Cuantos jugadores hay en el equipo?");
                    int tamEquipoB = sc.nextInt();
                    Jugador[] listaJugadoresB = crearListaJugadores(tamEquipoB);

                    //Obtenemos los datos del jugador
                    System.out.println("Dime el nombre del jugador");
                    String nombre = sc.next();
                    System.out.println("Dime la edad del jugador");
                    int edad = sc.nextInt();
                    System.out.println("Dime los goles que ha marcado el jugador");
                    int numGolesMarcados = sc.nextInt();
                    Jugador jugadorAAnadir = new Jugador(nombre, edad, numGolesMarcados);

                    //Busco la posición del equipo en la lista de participantes
                    int posicionDelEquipo = buscarEquipo(paisB, nombreEntrenadorB, listaJugadoresB);
                    //Añado al equipo el jugado con sus datos correspondientes
                    equiposParticipantes[posicionDelEquipo].anadirJugadores(nombre, edad, numGolesMarcados);
                    break;
                case 'C':
                    System.out.println("Escriba la posicion que ocupa el equipo del que se quiere conocer su total de goles");
                    int posicionEquipo = sc.nextInt();

                    int totaGoles = contadorGolesEquipo(posicionEquipo);
                    System.out.printf("El equipo ha marcado %d goles \n", totaGoles);
                    break;
                case 'D':
                    System.out.println("Escriba la posicion que ocupa el equipo del jugador que se quiere conocer su total de goles");
                    int posicionEquipoJugador = sc.nextInt();
                    System.out.println("Escriba la posicion que ocupa el jugador en el equipo");
                    int posicionJugador = sc.nextInt();
                    //Consultamos el total de goles que ha marcado el jugador descrito
                    int totalGolesJugador = equiposParticipantes[posicionJugador].getListaJugadores()[posicionEquipoJugador].getNumGolesMarcados();
                    System.out.printf("El jugador ha marcado %d goles\n", totalGolesJugador);
                    break;
                case 'E':
                    int equipoConMasGoles = equipoConMasGoles();
                    System.out.printf("El equipo con más goles es el que ocupa la posicion %d\n", equipoConMasGoles);
                case 'F':
                    int equipoDelJugadorConMasGoles = equipoDelJugadorConMasGoles();
                    int jugadorConMasGoles = jugadorConMasGoles();
                    System.out.printf("El jgador con el maximo numero de goles es el que ocupa la posicion %d, del equipo %d", jugadorConMasGoles, equipoDelJugadorConMasGoles);
            }
        }
    }

    //OPCION A
    //Con este metodo voy a crear los jugadores para el equipo con la cantidad solicitada
    public static Jugador[] crearListaJugadores(int tamEquipo) {

        Jugador[] listaJugadores = new Jugador[tamEquipo];
        for (int i = 0; i < tamEquipo; i++) {

            System.out.println("Dime el nombre del jugador que será asignador a la posicion " + i + 1);
            String nombre = sc.next();
            System.out.println("Dime la edad del jugador que será asignador a la posicion " + i + 1);
            int edad = sc.nextInt();
            System.out.println("Dime los goles que ha marcado el jugador que será asignador a la posicion " + i + 1);
            int numGolesMarcados = sc.nextInt();

            listaJugadores[i] = new Jugador(nombre, edad, numGolesMarcados);
        }
        return listaJugadores;
    }

    //OPCION B
    //Este metodo busca la posicion que ocupa el equipo al que se quiere añadir el jugador
    public static int buscarEquipo(String pais, String nombreEntrenador, Jugador[] listaJugadores) {
        Equipo equipo = new Equipo(pais, nombreEntrenador, listaJugadores);
        int posicionDelEquipo = 0;
        for (int i = 0; i < equiposParticipantes.length; i++) {
            if (equiposParticipantes[i].equals(equipo)) {
                posicionDelEquipo = i;
            }
        }
        return posicionDelEquipo;
    }

    //OPCION C
    public static int contadorGolesEquipo(int equipo) {
        //Para que sea mas comodo defino al equipo del que se quieren consultar los goles
        Equipo equipoABuscar = equiposParticipantes[equipo];
        int totalGoles = 0;
        //Hacemos un bucle para pasar por todos los jugadores del equipo
        for (int i = 0; i < equiposParticipantes[equipo].getListaJugadores().length; i++) {
            //Si el equipo no tiene jugadores returnamos 0 directamente
            if (equipoABuscar.getListaJugadores() == null) return 0;
            //Añado los goles del jugador que ocupa la posicion i a la lista de goles totales
            totalGoles += equipoABuscar.getListaJugadores()[i].getNumGolesMarcados();
        }
        return totalGoles;
    }

    //OPCION E
    public static int equipoConMasGoles() {
        int equipoConElMaximoDeGoles = 0;
        int golesTotalesEquipos = 0;
        for (int i = 0; i < equiposParticipantes.length; i++) {

            //Si el numero de goles del equipo actual es mayor que el del campeon, este lo sustituye;
            if (contadorGolesEquipo(i) > golesTotalesEquipos) {
                golesTotalesEquipos = contadorGolesEquipo(i);
                equipoConElMaximoDeGoles = i;
            }
        }
        return equipoConElMaximoDeGoles;
    }

    //OPCION F
    public static int equipoDelJugadorConMasGoles() {
        int equipoDeljugadorConElMaximoDeGoles = 0;
        int maximoDeGolesTotales = 0;
        //De cada equipo miro los jugadores
        for (int i = 0; i < equiposParticipantes.length; i++) {
            for (int j = 0; j < equiposParticipantes[i].getListaJugadores().length; j++) {

                //Recojo los goles que ha marcado el jugador en una variable
                int totalGolesJugadorActual = equiposParticipantes[i].getListaJugadores()[i].getNumGolesMarcados();
                //Si el numero de goles del jugador actual es mayor que el del campeon, este lo sustituye;
                if (totalGolesJugadorActual > maximoDeGolesTotales) {
                    maximoDeGolesTotales = totalGolesJugadorActual;
                    equipoDeljugadorConElMaximoDeGoles = i;
                }
            }
        }
        return equipoDeljugadorConElMaximoDeGoles;
    }

    public static int jugadorConMasGoles() {
        int jugadorConElMaximoDeGoles = 0;
        int maximoDeGolesTotales = 0;
        //De cada equipo miro los jugadores
        for (int i = 0; i < equiposParticipantes.length; i++) {
            for (int j = 0; j < equiposParticipantes[i].getListaJugadores().length; j++) {

                //Recojo los goles que ha marcado el jugador en una variable
                int totalGolesJugadorActual = equiposParticipantes[i].getListaJugadores()[j].getNumGolesMarcados();
                //Si el numero de goles del jugador actual es mayor que el del campeon, este lo sustituye;
                if (totalGolesJugadorActual > maximoDeGolesTotales) {
                    maximoDeGolesTotales = totalGolesJugadorActual;
                    jugadorConElMaximoDeGoles = j;
                }
            }
        }
        return jugadorConElMaximoDeGoles;
    }
}