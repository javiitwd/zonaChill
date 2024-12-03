/*
6. Crea un metodo que reciba una matriz e imprima, en una sola línea,
los elementos de la misma, pero leídos por columna, empezando por los últimos índices:
1 3 5 --> La salida es: 7 5 2 3 0 1
0 2 7
*/

package TEMA3.Boletín_Matrices;

public class Ejercicio6 {
    public static void main(String[] args) {
        int[][] matriz = {{1, 2, 3}, {4, 5, 6}};

        for (int j = matriz[0].length - 1; j >= 0; j--) { //Fijo la columna del final
            for (int i = matriz.length - 1; i >= 0; i--) {  //Y lo que muevo es las filas, cuando termina las filas,
                                                            // retrocede la columna y vuelve el bucle fijando las columnas
                System.out.print(matriz[i][j] + " ");
            }
        }
    }
}
