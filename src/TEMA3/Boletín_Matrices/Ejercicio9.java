/*
9. Crea un metodo que compruebe si una matriz pasada por parámetro
es simétrica en función del eje X. Es decir, la matriz
1 3 5 6
4 2 0 8
4 2 0 8
1 3 5 6
*/
package TEMA3.Boletín_Matrices;

public class Ejercicio9 {
    public static void main(String[] args) {
        int[][] matriz = {{1, 2, 3, 4}, {4, 5, 6, 7}, {4, 5, 6, 7}, {1, 2, 3, 4}};

        boolean matrizEsSimetrica = comprobarMatrizSimetrica(matriz);

        if (matrizEsSimetrica) {
            System.out.println("La matriz es simétrica en el eje x");
        } else {
            System.out.println("La matriz no es simétrica en el eje x");
        }
    }

    //Metodo para comprobar si la matriz es simetrica
    private static boolean comprobarMatrizSimetrica(int[][] matriz) {
        for (int j = 0; j < matriz[0].length; j++) {
            for (int i = 0; i < matriz.length; i++) {
                if (matriz[i][j] != matriz[matriz[0].length-1-i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
}