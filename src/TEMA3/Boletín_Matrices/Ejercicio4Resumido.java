package TEMA3.Boletín_Matrices;

public class Ejercicio4Resumido {
    public static void main(String[] args) {
        int[][] matriz = {{1, 2, 3}, {4, 5, 6}};

        for (int i = matriz.length - 1; i >= 0; i--) {
            for (int j = matriz[i].length - 1; j >= 0; j--) {
                System.out.print(matriz[i][j] + " ");
            }
        }
    }
}