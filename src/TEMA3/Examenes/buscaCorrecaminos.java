package TEMA3.Examenes;

import java.util.Arrays;
import java.util.Scanner;

public class buscaCorrecaminos {
    private static int[][] matrizMinas;
    private static boolean[][] matrizLevantadas;

    private static final int TAM_MATRIZ = 10;
    private static final int MINAS_A_PLANTAR = 10;
    private static final int MINA = -1;
    static Scanner entrada = new Scanner(System.in);

    public static void main(String[] args) {
        //Genero 2 matrices con el mismo tamaño (una para el tablero visible y otra para el oculto con minas)
        generarMatrices(TAM_MATRIZ);

        // Ahora plantamos las minas y los números colindantes a estas
        plantarMinas(MINAS_A_PLANTAR);

        //Muestro el tablero
        visualizaTablero();


        //Le pido la posicion que quiere leventar al usuario y le muestro lo que hay

        for (int i = 0; i < TAM_MATRIZ * TAM_MATRIZ; i++) {

            System.out.println("Que posicion quieres de X");
            int posicionI = entrada.nextInt();

            System.out.println("Que posicion quieres de Y");
            int posicionJ = entrada.nextInt();

            levantarPosicion(matrizLevantadas, posicionI, posicionJ);

            visualizaTablero();

            //Si la posicion que ha elegido tiene mina le digo que ha perdido

            boolean jugadorGana = comprobarCasillasLevantadas(matrizLevantadas);

            if (matrizMinas[posicionI][posicionJ] == MINA) {
                System.out.println("Has perdido nena");
                break;
            } else if (jugadorGana) {
                System.out.println("Ganaste muñeca");
            }
        }
    }

    public static void generarMatrices(int tam) {
        matrizMinas = new int[tam][tam];
        matrizLevantadas = new boolean[tam][tam];
    }
//......................................................................................................................

    //Metodo para llenar de minas
    public static void plantarMinas(int numMinas) {
        for (int i = 0; i < numMinas; i++) {
            int coordX = (int) (Math.random() * TAM_MATRIZ);
            int coordY = (int) (Math.random() * TAM_MATRIZ);

            if (matrizMinas[coordX][coordY] != MINA) {
                matrizMinas[coordX][coordY] = MINA;
            } else {
                i--;
            }
        }

        //Metodo para poner los numeros colindantes a las minas
        for (int i = 0; i < matrizMinas.length; i++) {
            for (int j = 0; j < matrizMinas.length; j++) {

                if (matrizMinas[i][j] == MINA) {
                    llenarDeNumerosLasMinas(matrizMinas, i, j);
                }
            }
        }
        for (int i = 0; i < matrizMinas.length; i++) {
            System.out.println(Arrays.toString(matrizMinas[i]));
        }
    }

    //......................................................................................................................

    //Metodo para poner los numeros colindantes a las minas
    private static void llenarDeNumerosLasMinas(int[][] matrizMinas, int i, int j) {

        for (int k = i - 1; k <= i + 1; k++) {
            for (int l = j - 1; l <= j + 1; l++) {
                if (k >= 0 && k < matrizMinas.length && l >= 0 && l < matrizMinas[i].length && matrizMinas[k][l] != MINA) {

                    if (k != i || l != j) {
                        matrizMinas[k][l] += +1;
                    }
                }
            }
        }
    }
//......................................................................................................................

    //Metodo para visualizar el tablero
    public static void visualizaTablero() {
        for (int i = 0; i < TAM_MATRIZ; i++) {
            for (int j = 0; j < TAM_MATRIZ; j++) {
                if (matrizLevantadas[i][j]) {
                    // Muestro el contenido de la casilla de la matriz de minas
                    System.out.printf("%2d | ", matrizMinas[i][j]);

                    if (matrizMinas[i][j] == 0) {

                        mirar0Colindantes(matrizLevantadas, matrizMinas, i, j);
                    }

                } else {
                    System.out.print("  | ");
                }
            }
            System.out.println();
        }
    }

    //......................................................................................................................

    //Metodo para levantar posiciones del tablero
    private static void levantarPosicion(boolean[][] matrizLevantadas, int posicionI, int posicionJ) {

        matrizLevantadas[posicionI][posicionJ] = true;

    }

    //Metodo para que se rellenen los 0 si la casilla elegida contiene ese numero
    private static void mirar0Colindantes(boolean[][] matrizLevantadas, int[][] matrizMinas, int i, int j) {

        for (int k = i - 1; k <= i + 1; k++) {
            for (int l = j - 1; l <= j + 1; l++) {

                if (k >= 0 && k < matrizMinas.length && l >= 0 && l < matrizMinas[i].length) {
                    if (matrizMinas[k][l] == 0) {

                        matrizLevantadas[k][l] = true;
                    }
                }
            }
        }
    }

    //..................................................................................................................

    //Metodo para comprobar si el jugador ha ganado
    private static boolean comprobarCasillasLevantadas(boolean[][] matrizLevantadas) {

        //Casillas que tiene que levantar el jugador para ganar
        int casillasADescubrir = TAM_MATRIZ * TAM_MATRIZ - MINA;

        //Ver cuantas casillas a levantado el jugador
        int contadorCasillas = 0;
        for (int k = 0; k < matrizLevantadas.length; k++) {
            for (int l = 0; l < matrizLevantadas[k].length; l++) {

                if (matrizLevantadas[k][l]) {
                    contadorCasillas++;
                }
            }
        }

        if (contadorCasillas == casillasADescubrir) {
            return true;

        } else {
            return false;
        }
    }
}