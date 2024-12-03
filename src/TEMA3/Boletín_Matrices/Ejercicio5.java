package TEMA3.Boletín_Matrices;

import java.util.Scanner;

public class Ejercicio5 {
    static Scanner entrada = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("Tamaño fila");
        int fila = entrada.nextInt();

        System.out.println("Tamaño columna");
        int columna = entrada.nextInt();

        int[][] matriz = new int[fila][columna];

        System.out.println("Rellenalo");
        rellenaMatriz(matriz);

        int numero; //Variable para guardar los números que ocupan las posiciones [i] [j]

        //Recorro las posiciones de la matriz
        for (int i = 0; i < matriz[0].length; i++) {
            for (int j = 0; j < matriz.length; j++) {
                numero = matriz[j][i]; //1ºa vez = columa 0, fila 0 || 2ºa vez = columna 0, fila 1 (la columa no avanza hasta que no termine las filas)
                System.out.print(numero + " ");
            }
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

/*
EXPLICACIÓN DE CUANDO RECORRE EL FOR Y PORQUÉ ES ASÍ
matriz[0] es {1, 2, 3}, es decir, la primera fila.
matriz[0].length es 3, ya que esa fila tiene 3 columnas.
Entonces, matriz[0].length te da el número total de columnas de la matriz, que puedes usar en tu bucle para evitar el error.
*/