package TEMA3.Examenes;

import java.util.Arrays;
import java.util.Scanner;

public class BuscaMinitasGoticasCulonas {

    public static final int TAMANO = 10;
    public static final int MINAS_A_PONER = 10;
    public static final int MINA = -1;
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        boolean[][] tablero = new boolean[TAMANO][TAMANO];

        int[][] tableroMinas = llenarTableroConMinas(tablero);

        //(IGNORAR) ver tablero con minas
        for (int i = 0; i < tableroMinas.length; i++) {
            System.out.println(Arrays.toString(tableroMinas[i]));
        }

        verTablero(tablero, tableroMinas);

        boolean hasGanado = false;

        while (!hasGanado) {

            System.out.println("Qué casilla quieres retirar, trapito?!");
            int posicionFila = sc.nextInt();
            int posicionColumna = sc.nextInt();

            if (!tablero[posicionFila][posicionColumna]) {
                tablero[posicionFila][posicionColumna] = true;
                if (tableroMinas[posicionFila][posicionColumna] == 0) {
                    levantar0Colindantes(tablero, tableroMinas, posicionFila, posicionColumna);
                }
                if (tableroMinas[posicionFila][posicionColumna] == -1) {
                    System.out.println("Cagaste");
                    break;
                }
                verTablero(tablero, tableroMinas);
            }
        }
    }

    //Planto minas en un nuevo tablero
    private static int[][] llenarTableroConMinas(boolean[][] tablero) {
        int[][] tableroMinas = new int[tablero.length][tablero[0].length];

        for (int i = 0; i <= MINAS_A_PONER; i++) {

            int posicionMinaI = (int) (Math.random() * MINAS_A_PONER);
            int posicionMinaJ = (int) (Math.random() * MINAS_A_PONER);
            tableroMinas[posicionMinaI][posicionMinaJ] = -1;
        }

        for (int i = 0; i < tableroMinas.length; i++) {
            for (int j = 0; j < tableroMinas[i].length; j++) {
                if (tableroMinas[i][j] == MINA) {
                    llenarDeNumeros(tableroMinas, i, j);
                }
            }
        }
        return tableroMinas;
    }

    private static void llenarDeNumeros(int[][] tableroMinas, int i, int j) {

        for (int k = i - 1; k <= i + 1; k++) {
            for (int l = j - 1; l <= j + 1; l++) {
                if (k >= 0 && k < tableroMinas.length && l >= 0 && l < tableroMinas[i].length && tableroMinas[k][l] != MINA && (k != i || l != j)) {
                    tableroMinas[k][l] += 1;
                }
            }
        }
    }

    //Metodo para ver tablero
    private static void verTablero(boolean[][] tablero, int[][] tableroMInas) {

        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[i].length; j++) {

                if (tablero[i][j]) {
                    System.out.print(tableroMInas[i][j] + " | ");
                } else {
                    System.out.print(" | ");
                }
            }
            System.out.println();
        }
    }

    private static void levantar0Colindantes(boolean[][] tablero, int[][] tableroMinas, int i, int j) {

        for (int k = i - 1; k <= i + 1; k++) {
            for (int l = j - 1; l <= j + 1; l++) {

                if (k >= 0 && k < tableroMinas.length && l >= 0 && l < tableroMinas[i].length && (k != i || l != j)) {
                    if (tableroMinas[k][l] == 0) {
                        tablero[k][l] = true;
                    }
                }
            }
        }
    }
}
