/*
7. Crea un metodo que reciba dos matrices,
y compruebe si son cuadradas e iguales en numeros
*/
package TEMA3.Boletín_Matrices;

public class Ejercicio7Angelsito {

    public static void main(String[] args) {

        int[][] matriz1 = {{1, 2, 3, 4}, {5, 6, 7, 8}, {1, 2, 3, 4}, {5, 6, 7, 8}};
        int[][] matriz2 = {{1, 2, 3, 4}, {5, 6, 7, 8}, {1, 2, 3, 4}, {5, 6, 7, 8}};

        boolean MatricesCuadradas = ComprobarSiMatricesCuadradas(matriz1, matriz2);

        if (MatricesCuadradas) {

            boolean sonIguales = comprobarSonIguales (matriz1, matriz2);

            if (sonIguales){
                System.out.println("Son iguales en numeros y tamaño");
            } else {
                System.out.println("Son iguales en tamaño, no en numero");
            }
        } else {
            System.out.println("No son iguales");
        }
    }

    private static boolean ComprobarSiMatricesCuadradas(int[][] matriz1, int[][] matriz2) {

        int filas1 = matriz1.length;
        int filas2 = matriz2.length;

        if (matriz1.length == matriz2.length) {

            for (int i = 0; i < matriz1.length; i++) {

                if (matriz1[i].length != filas1 || matriz2[i].length != filas2) {
                    return false;

                } else {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean comprobarSonIguales (int[][]matriz1, int[][]matriz2){

        for (int i = 0; i < matriz1.length; i++) {
            for (int j = 0; j < matriz1[i].length; j++) {

                if (matriz1[i][j] != matriz2[i][j]){
                    return false;
                }
            }
        }
        return true;
    }
}
