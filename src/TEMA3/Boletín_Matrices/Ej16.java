package TEMA3.Boletín_Matrices;/*
16. Crea un metodo que compruebe, sobre una matriz de enteros, cuántas casillas
adyacentes tienen valores pares. Se considera adyacente todas las posiciones
colindantes, incluidas las diagonales. En el siguiente ejemplo, el 7 (en rojo) tiene 4
casillas colindantes con números pares. El resultado se deberá guardar en otra matriz,
que contendrá dichos números. Para este ejercicio, consideraremos que el 0 es par.
1 2 3 4 5     1 2 3 2 2
6 7 8 9 0     2 4 4 4 2
3 2 1 4 5  →  2 3 5 4 3
9 5 8 6 7     2 4 4 4 3
0 9 8 5 4     0 3 2 4 1
*/

import java.util.Arrays;

public class Ej16 {
    public static void main(String[] args) {
        int[][] matriz = {{1, 2, 3, 4, 5}, {6, 7, 8, 9, 0}, {3, 2, 1, 4, 5}, {9, 5, 8, 6, 7}, {0, 9, 8, 5, 4}};

        int[][] matrizColindantes = crearMatrizColindantes(matriz);

        for (int i = 0; i < matrizColindantes.length; i++) {
            System.out.println(Arrays.toString(matrizColindantes[i]));
        }
    }

    private static int[][] crearMatrizColindantes(int[][] matriz) {

        int[][] matrizColindantes = new int[matriz.length][matriz[0].length];

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {

                int numeroColindantes = sumaPosicionesColindantes(matriz, i, j);
                matrizColindantes[i][j] = numeroColindantes;
            }
        }

        return matrizColindantes;
    }

    private static int sumaPosicionesColindantes(int[][] matriz, int i, int j) {

        int paresColindantes = 0;

        for (int k = i - 1; k <= i + 1; k++) {
            for (int l = j - 1; l <= j + 1; l++) {

                if (k >= 0 && k < matriz.length && l < matriz.length && l >= 0) {
                    if (k != i || l != j) {
                        if (matriz[k][l] % 2 == 0) {
                            paresColindantes++;
                        }
                    }
                }
            }
        }
        return paresColindantes;
    }
}
