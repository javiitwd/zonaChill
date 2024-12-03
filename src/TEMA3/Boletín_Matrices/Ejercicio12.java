/*
Crea un metodo que transforme una matriz CUADRADA (tienes que realizar dicha
comprobación) que recibe por parámetro, en otra, que debe ser su reflejo en diagonal
(de arriba a la izquierda a abajo a la derecha):
1 2 3 4 5     1 6 3 9 0
6 7 8 9 0     2 7 2 5 9
3 2 1 4 5 --> 3 8 1 8 8
9 5 8 6 7     4 9 4 6 5
0 9 8 5 4     5 0 5 7 4
*/
package TEMA3.Boletín_Matrices;

import java.util.Arrays;

public class Ejercicio12 {
    public static void main(String[] args) {
        int[][] matriz1 = {{1, 2, 3, 4, 5}, {6, 7, 8, 9, 0}, {3, 2, 1, 4, 5}, {9, 5, 8, 6, 7}, {0, 9, 8, 5, 4}};
        //int[][] matriz2 = {{1, 6, 3, 9, 0}, {2, 7, 2, 5, 9}, {3, 8, 1, 8, 8}, {4, 9, 4, 6, 5}, {5, 0, 5, 7, 4}};

        boolean esCuadrada = comprobarIguadad(matriz1);

        if (esCuadrada) {
            int[][] matrizReflejada = transformarEnReflejo(matriz1);
            for (int i = 0; i < matrizReflejada.length; i++) {
                System.out.println(Arrays.toString(matrizReflejada[i]));
            }
        }
    }

    private static boolean comprobarIguadad(int[][] matriz) {
        boolean cuadrada = false;
        if (matriz.length == matriz[0].length) {
            cuadrada = true;
        }
        return cuadrada;
    }

    private static int[][] transformarEnReflejo(int[][] matriz1) {
        int[][] matrizReflejada = new int[matriz1.length][matriz1[0].length];

        for (int i = 0; i < matriz1.length; i++) {
            for (int j = 0; j < matriz1[0].length; j++) {
                matrizReflejada[j][i] = matriz1[i][j];

            }
        }
        return matrizReflejada;
    }
}