/*
13. Crea un metodo que transforme una matriz CUADRADA (tienes que realizar dicha
comprobación) que recibe por parámetro, en otra, que debe ser su reflejo en diagonal (de
abajo a la derecha a arriba a la izquierda):
1 2 3 4 5     4 7 5 0 5
6 7 8 9 0     5 6 4 9 4
3 2 1 4 5 --> 8 8 1 8 3
9 5 8 6 7     9 5 2 7 2
0 9 8 5 4     0 9 3 6 1
*/
package TEMA3.Boletín_Matrices;

import java.util.Arrays;

public class Ejercicio13 {
    public static void main(String[] args) {

        int[][] matriz = {{1, 2, 3, 4, 5}, {6, 7, 8, 9, 0}, {3, 2, 1, 4, 5}, {9, 5, 8, 6, 7}, {0, 9, 8, 5, 4}};

        boolean esCuadrada = comprobarMatrizCuadrada(matriz);

        if (esCuadrada) {
            int[][] matrizReflejadaDiagonal = reflejarMatriz(matriz);
            for (int i = 0; i < matrizReflejadaDiagonal.length; i++) {
                System.out.println(Arrays.toString(matrizReflejadaDiagonal[i]));
            }
        } else {
            System.out.println("No es cuadrada");
        }
    }

    private static boolean comprobarMatrizCuadrada(int[][] matriz) {
        int filas = matriz.length;

        for (int i = 0; i < matriz.length; i++) {
            if (filas != matriz[i].length) { //Si filas (5) es diferente al número de columnas (matriz[i].length) que hay en esa fila ([i]) returno false
                return false;
            }
        }
        return true;
    }

    //Metodo para reflejar matriz en diagonal
    private static int[][] reflejarMatriz(int[][] matriz) {
        int[][] matrizCuadrada = new int[matriz.length][matriz[0].length];

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                matrizCuadrada[i][j] = matriz[matriz.length - 1 - j][matriz.length - 1 - i]; //explicado abajo
            }
        }
        return matrizCuadrada;
    }
}
/*
-El corchete de la izquierda es para la fila, pero al poner -j
lo primero que avanza es la fila (en este caso va subiendo las filas)

-El corchete de la derecha es para las columnas, pero al poner -i,
que es el for de fuera avanza después, por eso es como bloquear la columna y avanzar pot filas
*/