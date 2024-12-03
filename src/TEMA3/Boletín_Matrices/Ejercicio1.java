/*
Crea un método que compruebe si en una matriz hay
algún valor negativo, y devuelva unvalor booleano.
*/

package TEMA3.Boletín_Matrices;

public class Ejercicio1 {
    static boolean hayNegativos = false;

    public static void main(String[] args) {
        int[][] matriz = {{1, 2, 3}, {-4, 5, 6}};

        boolean hayNegativos = comprobarHayNegativos(matriz);

        if (hayNegativos) {
            System.out.println("Hay negativos");
        } else System.out.println("No hay negativos");
    }

    private static boolean comprobarHayNegativos(int[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                if (matriz[i][j] < 0) {
                    hayNegativos = true;
                    break;
                }
            }
        }
        return hayNegativos;
    }
}


