/*
10. Crea un metodo que compruebe si una matriz pasada por parámetro
es simétrica en función del eje Y. Es decir, la matriz
{1, 2, 2, 1}
{4, 5, 5, 4}
{1, 2, 2, 1}
{4, 5, 5, 4}
*/


package TEMA3.Boletín_Matrices;

public class Ejercicio10 {
    public static void main(String[] args) {
        int[][] matriz = {{1, 2, 2, 1}, {4, 5, 5, 4}, {1, 2, 2, 1}, {4, 5, 5, 4}};

        boolean matrizEsSimetrica = comprobarMatrizSimetrica(matriz);

        if (matrizEsSimetrica) {
            System.out.println("La matriz es simétrica en el eje y");
        } else {
            System.out.println("La matriz no es simétrica en el eje y");
        }
    }

    //Metodo para comprobar si la matriz es simetrica
    private static boolean comprobarMatrizSimetrica(int[][] matriz) {
        boolean esSimetrica = true;
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                if (matriz[i][j] != matriz[i][matriz[i].length-1-j]) {
                    return !esSimetrica;
                }
            }
        }
        return esSimetrica;
    }
}