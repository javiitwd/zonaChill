package TEMA3.Examenes;

import java.util.Arrays;
import java.util.Scanner;

public class BuscaMinas {
    static Scanner entrada = new Scanner(System.in);

    public static void main(String[] args) {

        int[][] tamanoTableroMinas = new int[5][5];
        boolean[][] tablero = new boolean[5][5];

        System.out.println("Lleno el tablero con minas y numeros (el oculto)");
        int[][] tableroConMinas = llenarMinas(tamanoTableroMinas);

        //Muestro el resultado del tablero oculto
        for (int k = 0; k < tableroConMinas.length; k++) {
            System.out.println(Arrays.toString(tableroConMinas[k]));

        }

        System.out.println("Muestro al usuario el tablero que verá siempre (no oculto)");
        levantarCasillas(tablero, tableroConMinas);


        for (int i = 0; i < tablero.length; i++) {
            System.out.println(Arrays.toString(tablero[i]));

        }

        System.out.println("\n Qué posición de X quieres retirar");
        int posicionFila = entrada.nextInt();

        System.out.println("Qué posición de Y quieres retirar");
        int posicionColumna = entrada.nextInt();

        levantarCasillas(tablero, tableroConMinas);


    }
    //..................................................................................................................
    //..................................................................................................................

    //A y B) Llenar un tablero con minas
    private static int[][] llenarMinas(int[][] tablero) {
        int[][] minasOcultas = new int[tablero.length][tablero[0].length];

        for (int i = 0; i < 5; i++) {

            int posicionX = (int) (Math.random() * tablero.length); //Si lo multiplico por 5 por ej como en este caso
            int posicionY = (int) (Math.random() * tablero[0].length); //Nunca llegará a 5, como mucho al 4 y la matriz va de la posicion 0 a la 4

            if (minasOcultas[posicionX][posicionY] == -1) {
                i--;
            } else {
                minasOcultas[posicionX][posicionY] = -1;
            }
        }

        //Lleno alrededor de cada minas con 1
        for (int i = 0; i < minasOcultas.length; i++) {
            for (int j = 0; j < minasOcultas[i].length; j++) {

                if (minasOcultas[i][j] == -1) {
                    llenarDeMinasYNumeros(minasOcultas, i, j);
                }
            }
        }
        return minasOcultas;
    }

    //..................................................................................................................

    //Submetodo para llenar las casillas con minas con 1
    private static int[][] llenarDeMinasYNumeros(int[][] minasOcultas, int i, int j) {

        for (int k = i - 1; k <= i + 1; k++) {
            for (int l = j - 1; l <= j + 1; l++) {
                if (k >= 0 && k < minasOcultas.length && l >= 0 && l < minasOcultas[0].length && (minasOcultas[k][l] != -1)) { //Pongo que tiene que ser diferente a -1 (mina)
                    if (k != i || l != j) {                                                                                     //ya que sjno sumaria +1 a la mina y seria 0

                        minasOcultas[k][l] += +1; //meto en cada casilla colindante a la mina un +1
                    }
                }
            }
        }
        return minasOcultas;
    }

    private static void levantarCasillas(boolean[][] tablero, int[][] tableroConMinas) {

        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[i].length; j++) {

                if (tablero[i][j]) {
                    System.out.printf("%2d | ", tableroConMinas[i][j]);

                } else {
                    System.out.print(" | ");
                }
                System.out.println();
            }
        }
    }
}

//......................................................................................................................