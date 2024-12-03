/*
3. Crea un metodo que reciba una matriz e imprima,
en una sola línea, los elementos de la misma, leídos por filas:
*/
package TEMA3.Boletín_Matrices;

import java.util.Arrays;
import java.util.Scanner;

public class Ejercicio3MatrizMasLineas {
    static Scanner entrada = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("Tamaño fila");
        int fila = entrada.nextInt();

        System.out.println("Tamaño columna");
        int columna = entrada.nextInt();

        int[][] matriz = new int[fila][columna];

        System.out.println("Rellenalo");
        rellenaMatriz(matriz);

        //Mostrar la matriz rellena
        for (int i = 0; i < matriz.length; i++) {
            System.out.println(Arrays.toString(matriz[i]));
        }
    }

    private static void rellenaMatriz(int[][] matriz) {

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.println("Pon la posición [" + i + " ] [ " + j + " ]");
                matriz[i][j] = entrada.nextInt();
            }
        }
    }
}