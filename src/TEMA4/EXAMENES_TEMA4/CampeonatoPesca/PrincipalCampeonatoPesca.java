package TEMA4.EXAMENES_TEMA4.CampeonatoPesca;

import java.util.Scanner;

public class PrincipalCampeonatoPesca {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //Declaramos los objetos para que su valor no viva solo dentro del switch
        Pescador capitan = null;
        Pescador pescador = null;
        Equipo equipo = null;
        Campeonato campeonato = new Campeonato("Prueba");

        boolean salir = false;
        do {
            System.out.println("Seleccione una opción");
            System.out.println("1.- Registrar un nuevo equipo");
            System.out.println("2.- Añadir un pescador a un equipo existente");
            System.out.println("3.- Registrar una nueva captura para un pescador ");
            System.out.println("4.- Consultar el peso total de las capturas realizadas por un equipo");
            System.out.println("5.- Consultar el pescador con la mayor captura individual");
            System.out.println("6.- Consultar el equipo con el mayor peso acumulado en capturas");
            System.out.println("7.- Finalizar la aplicación");
            int opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    try {
                        System.out.println("Introduzca los siguientes datos: ");
                        System.out.println("Nombre: ");
                        String nombreEquipo = sc.next();
                        System.out.println("Región: ");
                        String regionEquipo = sc.next();
                        System.out.println("Datos del capitán: ");
                        System.out.println("Nombre: ");
                        String nombreCapitan = sc.next();
                        System.out.println("Edad: ");
                        int edadCapitan = sc.nextInt();
                        System.out.println("Años de experiencia: ");
                        int experienciaCapitan = sc.nextInt();

                        capitan = new Pescador(nombreCapitan, edadCapitan, experienciaCapitan);
                        equipo = new Equipo(nombreEquipo, regionEquipo, capitan);

                        System.out.println("Equipo creado con éxito");

                        campeonato.anadirEquipo(equipo);
                    } catch (CampeonatoPescaException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 2:
                    try {
                        System.out.println("Datos del pescador: ");
                        System.out.println("Nombre: ");
                        String nombrePescador = sc.next();
                        System.out.println("Edad: ");
                        int edadPescador = sc.nextInt();
                        System.out.println("Años de experiencia: ");
                        int experienciaPescador = sc.nextInt();

                        pescador = new Pescador(nombrePescador, edadPescador, experienciaPescador);

                        System.out.println("Ponga el nombre del equipo: ");
                        String nombreEquipo = sc.next();

                        //Busco y guardo el equipo que tiene el nombre solicitado
                        Equipo equipoDelPescador = campeonato.buscarEquipoPorNombre(nombreEquipo);

                        //Añado el pescador a ese equipo
                        equipoDelPescador.anadirPescador(pescador);

                        System.out.println("Pescador añadido con éxito");


                    } catch (CampeonatoPescaException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 3:
                    try {
                        System.out.println("Indique el nombre del equipo al que pertenece el jugador: ");
                        String nombreEquipo = sc.next();
                        System.out.println("Indique el nombre del pescador");
                        String nombrePescador = sc.next();
                        System.out.println("Indique el peso de su nueva captura");
                        double pesoCaptura = sc.nextDouble();

                        //Busco y guardo el equipo que tiene el nombre solicitado
                        Equipo equipoDelPescador = campeonato.buscarEquipoPorNombre(nombreEquipo);

                        //Busco y guardo el pescador que tiene el nombre solicitado en el equipo guardado recientemente
                        Pescador pescadorARegistrarCaptura = equipo.buscarPescadorPorNombre(nombrePescador);

                        //Finalmente, al pesacdor identificado le añado la captura
                        pescadorARegistrarCaptura.anadirCaptura(pesoCaptura);

                        System.out.println("Captura añadida con éxito");

                    } catch (CampeonatoPescaException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 4:
                    try {
                        System.out.println("Digame el noombre del equipo del que quiere saber el peso total de capturas");
                        String nombreEquipo = sc.next();

                        Equipo equipoASacarTotalDePesoCapturas = campeonato.buscarEquipoPorNombre(nombreEquipo);
                        double totalDePesoCapturas = equipoASacarTotalDePesoCapturas.pesoTotalDeCapturasRealizadas();

                        System.out.printf("El total de peso de las captuars de ese equipo es: %.2f", totalDePesoCapturas);
                        break;

                    } catch (CampeonatoPescaException e) {
                        System.out.println(e.getMessage());
                    }

                case 5:
                    //Guardo el pesacdor con la mayor captura individual
                    Pescador pescadorConMayorCapturaIndividual = campeonato.buscarPescadorConMayorCapturaIndividual();

                    //Muestro sus datos y los de su captura máxima
                    System.out.printf("El ganador ha sido: " + pescadorConMayorCapturaIndividual + " con %.2f peso de captura! \n", pescadorConMayorCapturaIndividual.capturaMaximaDelPescador());
                    break;

                case 6:

                    Equipo equipoConMayorPesoDeCapturas = campeonato.equipoConMayorCapuras();
                    System.out.printf("El ganador es el equipo %s \n", equipoConMayorPesoDeCapturas.getNombre());
                    break;

                case 7: salir = true;
                break;
            }

        } while (!salir);
    }
}
