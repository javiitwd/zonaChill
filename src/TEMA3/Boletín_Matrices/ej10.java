/*
10. Crea un metodo que compruebe si una matriz pasada por parámetro
es simétrica en función del eje Y. Es decir, la matriz
1 3 0 3 1
4 2 7 2 4
6 1 9 1 6
0 8 8 8 0
*/

package TEMA3.Boletín_Matrices;

public class ej10 {
    public static void main(String[] args) {
        int[][] matriz = {{1, 3, 0, 3, 1}, {4, 2, 7, 2, 4}, {6, 1, 9, 1, 6}, {0, 8, 8, 8, 0}};

        boolean simetricaY = comprobarEsSimetricaY(matriz);

        if (simetricaY) {
            System.out.println("Es simetrica en el eje y");
        } else {
            System.out.println("No es simetrica en el eje Y");
        }
    }

    private static boolean comprobarEsSimetricaY(int[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                if (matriz[i][j] != matriz[i][matriz[i].length -1 -j]) {
                    return false;
                }
            }
        }
        return true;
    }
}