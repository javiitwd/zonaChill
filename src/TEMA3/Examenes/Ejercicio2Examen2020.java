/*
El jardín floreciente:

Tenemos un tablero de 15x15 que representa un jardín. En él, se siembran flores, representadas por un 1.
Pero estas flores necesitan ciertas condiciones para florecer.
⦁   Una flor necesita obligatoriamente estar colindante a una casilla con agua (incluso en diagonal) para poder florecer. El agua se representa con un 2.
⦁	Además, una flor necesita que exista una abeja polinizadora (representada por un 5) en un radio de 3 casillas.
⦁	Una flor no puede crecer si tiene una mala hierba (representada por un 3) colindante, excepto si además la flor (no la mala hierba) es colindante a un gusano come-hierbas (representado por un 4), en cuyo caso sí podrá florecer.
⦁	El resto de casillas, que serán de tierra, se representarán con un 0.

Se pide que, dado el siguiente array, indiques qué flores florecerán, indicando sus posiciones en el array.

Aclaraciones sobre la abeja: en la siguiente imagen se muestra el área de influencia de una abeja (en amarillo):

Para que sirva de referencia, al pasar el array adjunto, la salida debe ser esta:

La flor de la posición 0,0 florecerá
La flor de la posición 1,12 florecerá
*/

package TEMA3.Examenes;

public class Ejercicio2Examen2020 {
    public static void main(String[] args) {

        int[][] jardin = {
                {1, 0, 0, 0, 1, 0, 0, 0, 2, 1, 1, 0, 0, 5, 0},
                {0, 2, 0, 5, 0, 0, 3, 0, 1, 0, 0, 0, 1, 0, 0},
                {3, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 2, 4},
                {0, 0, 2, 0, 0, 0, 0, 0, 2, 1, 3, 0, 0, 0, 1},
                {0, 0, 1, 0, 0, 0, 3, 0, 1, 0, 0, 0, 0, 0, 3},
                {4, 3, 0, 0, 0, 2, 1, 0, 0, 0, 0, 5, 0, 0, 0},
                {1, 2, 0, 5, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 2},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1},
                {3, 0, 0, 0, 0, 0, 2, 1, 4, 0, 0, 0, 1, 0, 0},
                {2, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 3, 0},
                {0, 0, 5, 1, 0, 0, 0, 5, 0, 3, 0, 0, 1, 0, 0},
                {1, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 5, 2, 4, 0},
                {0, 0, 1, 3, 0, 0, 1, 0, 0, 1, 0, 0, 1, 3, 0},
                {0, 1, 2, 1, 0, 0, 0, 0, 0, 2, 3, 1, 0, 0, 1},
                {1, 3, 4, 0, 0, 5, 0, 0, 1, 0, 0, 0, 0, 4, 2}
        };

        mirarSiFlorecera(jardin);
    }

    private static void mirarSiFlorecera(int[][] jardin) {

        for (int i = 0; i < jardin.length; i++) {
            for (int j = 0; j < jardin[i].length; j++) {
                if (jardin[i][j] == 1) {

                    boolean hayAgua = mirarSiHayAgua(jardin, i, j);
                    boolean hayAbeja = mirarSiHayAbeja(jardin, i, j);
                    boolean hayMalaHierba = mirarSiHayMalaHierba(jardin, i, j);
                    boolean hayGusano = mirarSiHayGusano(jardin, i, j);

                    if (hayAgua && hayAbeja && !hayMalaHierba) {
                        System.out.println("La posición [" + i + ", " + j + "] florecerá");

                    } else if (hayAgua && hayAbeja && hayMalaHierba && hayGusano) {
                        System.out.println("La posición [" + i + ", " + j + "] florecerá");

                    }
                }
            }
        }
    }

    private static boolean mirarSiHayAgua(int[][] jardin, int i, int j) {

        for (int k = i - 1; k <= i + 1; k++) {
            for (int l = j - 1; l <= j + 1; l++) {
                if (k >= 0 && k < jardin.length && l >= 0 && l < jardin.length)
                    if (jardin[k][l] == 2) {
                        return true;
                    }
            }
        }
        return false;
    }

    private static boolean mirarSiHayAbeja(int[][] jardin, int i, int j) {
        for (int k = i - 3; k <= i + 3; k++) {
            for (int l = j - 3; l <= j + 3; l++) {
                if (k >= 0 && k < jardin.length && l >= 0 && l < jardin.length)
                    if (jardin[k][l] == 5) {
                        return true;
                    }
            }
        }
        return false;
    }

    private static boolean mirarSiHayMalaHierba(int[][] jardin, int i, int j) {
        for (int k = i - 1; k <= i + 1; k++) {
            for (int l = j - 1; l <= j + 1; l++) {
                if (k >= 0 && k < jardin.length && l >= 0 && l < jardin.length)
                    if (jardin[k][l] == 3) {
                        return true;
                    }
            }
        }
        return false;
    }

    private static boolean mirarSiHayGusano(int[][] jardin, int i, int j) {
        for (int k = i - 1; k <= i + 1; k++) {
            for (int l = j - 1; l <= j + 1; l++) {
                if (k >= 0 && k < jardin.length && l >= 0 && l < jardin.length)
                    if (jardin[k][l] == 4) {
                        return true;
                    }
            }
        }
        return false;
    }
}