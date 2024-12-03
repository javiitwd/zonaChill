/*
El bosque encantado:
Tenemos un bosque representado como un tablero de tamaño dinámico M x N
M×N (que el usuario elige al inicio). Cada casilla del tablero puede tener diferentes elementos:
Árboles (representados por un 1)
Piedras mágicas (representadas por un 2)
Animales mágicos (representados por un 3)
Árboles malditos (representados por un 4)
Vacío/Tierra (representado por un 0)
Se pide determinar qué árboles están protegidos mágicamente. Para que un árbol esté protegido mágicamente, debe cumplir todas las siguientes condiciones:
Debe haber al menos una piedra mágica en un radio de 2 casillas (contando laterales, diagonales y verticales).
No debe haber árboles malditos colindantes (directamente a los lados, arriba o abajo, pero no en diagonal).
Si hay un animal mágico en la misma fila o columna del árbol (independientemente de la distancia), se considera automáticamente protegido, aunque no se cumplan las condiciones anteriores.
Se debe implementar lo siguiente: Solicitar al usuario el tamaño del tablero M x N
M×N y llenarlo con valores generados aleatoriamente entre 0 y 4. (Opcionalmente, permitir al usuario ingresar valores).
Mostrar el tablero inicial en la consola. Identificar las posiciones de los árboles protegidos mágicamente.
Imprimir en la consola las posiciones de los árboles protegidos y el tablero actualizado con los árboles protegidos destacados (por ejemplo, representándolos con un 5).
*/
package TEMA3.Examenes;

import java.util.Arrays;
import java.util.Scanner;

public class JardinEncantado {
    static Scanner sc = new Scanner(System.in);
    public static int ARBOL = 1;
    public static int PIEDRA_MAGICA = 2;
    public static int ANIMAL_MAGICO = 3;
    public static int ARBOL_MALDITO = 4;
    public static int TIERRA = 0;

    public static void main(String[] args) {

        System.out.println("Pon el tamaño M");
        int M = sc.nextInt();
        System.out.println("Pon el tamaño N");
        int N = sc.nextInt();

        int porcentajeArboles = (int) ((M * N) * 0.20);
        int porcentajePiedrasMagicas = (int) ((M * N) * 0.10);
        int porcentajeAnimalesMagicos = (int) ((M * N) * 0.10);
        int porcentajeArbolesMalditos = (int) ((M * N) * 0.10);
        System.out.println(+porcentajeArboles + ", " + porcentajePiedrasMagicas + " , " + porcentajeAnimalesMagicos + " , " + porcentajeArbolesMalditos);

        int[][] bosque = new int[M][N];

        crearTablero(bosque, porcentajeArboles, porcentajePiedrasMagicas, porcentajeAnimalesMagicos, porcentajeArbolesMalditos, M, N);

        //Muestro el tablero
        for (int i = 0; i < bosque.length; i++) {
            System.out.println(Arrays.toString(bosque[i]));
        }

        mirarArbolesProtegidos(bosque);
    }

    //CREO EL TABLERO CON LOS ELEMENTOS REQUERIDOS
    private static void crearTablero(int[][] bosque, int porcentajeArboles, int porcentajePiedrasMagicas, int porcentajeAnimalesMagicos, int porcentajeArbolesMalditos, int N, int M) {

        for (int i = 0; i < porcentajeArboles; i++) {
            int arbolPosicionI = (int) (Math.random() * (M));
            int arbolPosicionJ = (int) (Math.random() * (N));
            bosque[arbolPosicionI][arbolPosicionJ] = ARBOL;
        }
        for (int i = 0; i < porcentajeAnimalesMagicos; i++) {
            int animalMagicoPosicionI = (int) (Math.random() * (M));
            int animalMagicoPosicionJ = (int) (Math.random() * (N));
            if (bosque[animalMagicoPosicionI][animalMagicoPosicionJ] == TIERRA) {

                bosque[animalMagicoPosicionI][animalMagicoPosicionJ] = ANIMAL_MAGICO;
            } else {
                i--;
            }
        }

        for (int i = 0; i < porcentajeArbolesMalditos; i++) {
            int arbolesMalditosPosicionI = (int) (Math.random() * (M));
            int arbolesMalditosPosicionJ = (int) (Math.random() * (N));
            if (bosque[arbolesMalditosPosicionI][arbolesMalditosPosicionJ] == TIERRA) {

                bosque[arbolesMalditosPosicionI][arbolesMalditosPosicionJ] = ARBOL_MALDITO;
            } else {
                i--;
            }
        }
        for (int i = 0; i < porcentajePiedrasMagicas; i++) {
            int piedrasMagicasPosicionI = (int) (Math.random() * (M));
            int piedrasMagicasPosicionJ = (int) (Math.random() * (N));
            if (bosque[piedrasMagicasPosicionI][piedrasMagicasPosicionJ] == TIERRA) {

                bosque[piedrasMagicasPosicionI][piedrasMagicasPosicionJ] = PIEDRA_MAGICA;
            } else {
                i--;
            }
        }
    }

    //...........................................................................................................................

    private static void mirarArbolesProtegidos(int[][] bosque) {

        for (int i = 0; i < bosque.length; i++) {
            for (int j = 0; j < bosque[i].length; j++) {
                if (bosque[i][j] == ARBOL) {
                    boolean hayPiedra = mirarHayPiedra(bosque, i, j);
                    boolean hayArbolMaldito = mirarHayArbolMaldito(bosque, i, j);
                    boolean hayAnimalMagico = mirarHayAnimalMagico(bosque, i, j);

                    if (hayPiedra && !hayArbolMaldito || (hayAnimalMagico)) {
                        System.out.println("El arbol en posicion " + i + " , " + j + " está protegido");
                    }
                }
            }
        }
    }

    private static boolean mirarHayPiedra(int[][] bosque, int i, int j) {

        for (int k = i - 2; k <= i + 2; k++) {
            for (int l = j - 2; l <= j + 2; l++) {
                if (k >= 0 && k < bosque.length && l >= 0 && l < bosque.length) {
                    if (bosque[k][l] == PIEDRA_MAGICA) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private static boolean mirarHayArbolMaldito(int[][] bosque, int i, int j) {

        for (int k = i; k <= i; k++) {
            for (int l = j - 1; l <= j + 1; l++) {
                if (k >= 0 && k < bosque.length && l >= 0 && l < bosque.length) {
                    if (bosque[k][l] == ARBOL_MALDITO) {
                        return true;
                    }
                }
            }
        }

        for (int l = j; l <= j; l++) {
            for (int k = i - 1; k <= i + 1; k++) {
                if (k >= 0 && k < bosque.length && l >= 0 && l < bosque.length) {
                    if (bosque[k][l] == ARBOL_MALDITO) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private static boolean mirarHayAnimalMagico(int[][] bosque, int i, int j) {

        for (int k = i; k <= i; k++) {
            for (int l = 0; l <= bosque[i].length; l++) {
                if (k >= 0 && k < bosque.length && l >= 0 && l < bosque.length) {
                    if (bosque[k][l] == ANIMAL_MAGICO) {
                        return true;
                    }
                }
            }
        }

        for (int l = j; l <= j; l++) {
            for (int k = 0; k <= bosque[j].length; k++) {
                if (k >= 0 && k < bosque.length && l >= 0 && l < bosque.length) {
                    if (bosque[k][l] == ANIMAL_MAGICO) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}