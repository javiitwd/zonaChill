/*
8. Crea un metodo que reciba dos matrices, que deben ser de igual tamaño, y sume el
contenido de las posiciones en una tercera matriz, que será la que devuelva:
| 1 2| + | 4 1| = | 5 3|
| 4 6|   | 1 0|   | 5 6|
*/

package ALEJANDRO_Tema1y2;

import java.util.Arrays;

public class alnglesitoo {

    public static void main(String[] args) {

        int[][] matriz1 = {{1, 2}, {4, 6}};
        int[][] matriz2 = {{4, 1}, {1, 0}};

        boolean igualTamano = comprobarTamano(matriz1, matriz2);

        if (igualTamano) {

            System.out.println("Igual en tamaño");

            int[][] matrizSumada = sumarMatrices(matriz1, matriz2);

            for (int i = 0; i < matrizSumada.length; i++) {
                System.out.println(Arrays.toString(matrizSumada[i]));

            }
        } else {
            System.out.println("No es igual en tamaño");
        }
    }


    private static boolean comprobarTamano(int[][] matriz1, int[][] matriz2) {

        int filasMatriz1 = matriz1.length;
        int filasMatriz2 = matriz2.length;

        if (matriz1.length == matriz2.length) {

            for (int i = 0; i < matriz1.length; i++) {

                if (matriz1[i].length != matriz2[i].length) {

                    return false;
                }
                else {
                    return true;
                }
            }

        }
        return false;
    }

    private static int[][] sumarMatrices(int[][] matriz1, int[][] matriz2) {
        int [][] matrizSumada = new int[matriz1.length][matriz1[0].length];

        for (int i = 0; i < matriz1.length; i++) {
            for (int j = 0; j < matriz1[i].length; j++) {

                matrizSumada[i][j] = matriz1[i][j] + matriz2[i][j];
            }
        }
        return matrizSumada;
    }
}