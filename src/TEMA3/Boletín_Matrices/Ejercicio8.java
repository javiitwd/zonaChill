/*
8. Crea un metodo que reciba dos matrices, que deben ser de igual tamaño, y sume el
contenido de las posiciones en una tercera matriz, que será la que devuelva:
| 1 2| + | 4 1| = | 5 3|
| 4 6|   | 1 0|   | 5 6|
*/
package TEMA3.Boletín_Matrices;

import java.util.Arrays;

public class Ejercicio8 {
    public static void main(String[] args) {

        int[][] matriz1 = {{1, 2, 3, 4}, {1, 2, 3, 4}, {5, 6, 7, 8}};
        int[][] matriz2 = {{1, 2, 3, 4}, {1, 2, 3, 4}, {5, 6, 7, 8}};

        boolean tamano = comprobarTamano(matriz1, matriz2);

        if (tamano) {
            System.out.println("Son iguales");
            int[][] matrizSumada = sumarMatriz(matriz1, matriz2);
            for (int i = 0; i < matrizSumada.length; i++) {
                System.out.println(Arrays.toString(matrizSumada[i]));
            }
        } else System.out.println("No son iguales");
    }

    //Metodo para comprobar el Tamaño de filas y columnas
    private static boolean comprobarTamano(int[][] matriz1, int[][] matriz2) {

        if (matriz1.length != matriz2.length) {
            if (matriz1[0].length != matriz2[0].length) {
                return false;
            }
        }
        return true;
    }

    //Metodo para sumar matrices
    private static int[][] sumarMatriz(int[][] matriz1, int[][] matriz2) {
        int[][]matrizSumada = new int [matriz1.length][matriz1[0].length];
        int sumaPosiciones = 0;

        for (int i = 0; i < matriz1.length; i++) {
            for (int j = 0; j < matriz1[i].length; j++) {
                matrizSumada[i][j] = matriz1[i][j]+matriz2[i][j];
            }
        }
        return matrizSumada;
    }
}





