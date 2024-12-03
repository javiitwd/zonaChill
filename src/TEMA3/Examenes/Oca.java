package TEMA3.Examenes;

import java.util.Arrays;

public class Oca {

    static int[][] tablero = new int[8][8];
    static String[] jugadores = {"Amarillo", "Verde", "Rojo", "Naranja"};


    public static void main(String[] args) {

        ordenarJugadores(jugadores);


    }

    private static int tirarDado() {

        int numero = (int) (Math.random() * 6) + 1; //*6 te llevara de 0 a 5, por eso le sumo 1, para que sea de 1 a 6

        return numero;
    }

    //..................................................................................................................

    private static void ordenarJugadores(String[] jugadores) {
        //Me creo otro array con el tamaño de los jugadores para guardar sus puntuaciones
        int[] puntuaciones = new int[jugadores.length];

        //Cada jugador tira el dado y guardo el resultado en el nuevo array
        for (int i = 0; i < jugadores.length; i++) {

            puntuaciones[i] = tirarDado();

        }

        //Metodo para desempatar
        for (int i = 0; i < puntuaciones.length; i++) {
            for (int j = 0; j < puntuaciones.length; j++) {

                if (puntuaciones[j] == puntuaciones[i]) {

                    desempate(jugadores, puntuaciones, i, j);
                }
            }
        }

        //Ordeno el array de Jugadores segun lo que hayan sacado, el que saque mas va primero y despues en orden de colores
        int mayor = puntuaciones[0];

        for (int i = 1; i < puntuaciones.length; i++) {
            if (puntuaciones[i] > mayor){
                mayor = puntuaciones[i];
                String mayorJugador = jugadores[i];
            }
        }

        for (int i = 0; i < puntuaciones.length; i++) {


        }

        System.out.println("El orden es...");
        System.out.println(Arrays.toString(jugadores));

    }

    //..................................................................................................................

    private static void desempate(String[] jugadores, int[] puntuaciones, int i, int j) {

        do{
            puntuaciones[i] = tirarDado();

            puntuaciones[j] = tirarDado();

        } while (puntuaciones[i] == puntuaciones[j]);


        if (puntuaciones[i] < puntuaciones[j]){ //Si la posicion de despues es mayor, la pongo como actual y la menor pasa a ser la posterior

            String temporalString = jugadores[i];
            jugadores[i] = jugadores[j];
            jugadores[j] = temporalString;

        }
    }

    //..................................................................................................................

}
