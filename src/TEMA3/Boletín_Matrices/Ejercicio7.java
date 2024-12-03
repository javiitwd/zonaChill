/*
7. Crea un metodo que reciba dos matrices,
y compruebe si son exactamente iguales
*/
package TEMA3.Boletín_Matrices;

public class Ejercicio7 {
    public static void main(String[] args) {
        int[][] matriz1 = {{1, 2, 3, 4}, {1, 2, 3, 4}, {5, 6, 7, 8}};
        int[][] matriz2 = {{1, 2, 3, 4}, {1, 2, 3, 4}, {5, 6, 7, 8}};

        boolean tamano = comprobarTamano(matriz1, matriz2);
        boolean numeros = comprobarNumeros(matriz1, matriz2);

        if (tamano && numeros) {
            System.out.println("Son iguales");
        } else {
            System.out.println("No son iguales");
        }
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

    //Metodo para comprobar si los números son iguales
    private static boolean comprobarNumeros(int[][] matriz1, int[][] matriz2) {
        for (int i = 0; i < matriz1.length; i++) {
            for (int j = 0; j < matriz1[0].length; j++) {
                if (matriz1[i][j] != matriz2[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
}

