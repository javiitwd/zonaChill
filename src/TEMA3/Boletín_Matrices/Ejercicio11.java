/*
Crea un metodo que reciba dos matrices, y compruebe si son matrices inversas,
es decir, si tienen los mismos valores en los índices inversos:
5 8 9 0     2 3 7 1
4 7 5 2  y  2 5 7 4
1 7 3 2     0 9 8 5
*/
package TEMA3.Boletín_Matrices;

public class Ejercicio11 {
    public static void main(String[] args) {
        int[][] matriz = {{5, 8, 9, 0}, {4, 7, 5, 2}, {1, 7, 3, 2}};
        int[][] matriz2 = {{2, 3, 7, 1}, {2, 5, 7, 4}, {0, 9, 8, 5}};

        boolean esInversa = comprobarEsInversa(matriz, matriz2);
        if (esInversa) {
            System.out.println("Es inversa");
        } else {
            System.out.println("No es inversa");
        }
    }

    //Metodo para comprobar si las matrices son inversas
    private static boolean comprobarEsInversa(int[][] matriz, int[][] matriz2) {
        boolean esInversa = true;
        for (int i = 0; i < matriz.length; i++) {                                        //uso matriz2.length -1 -i y matriz2[0].length -1 -j para empezar por el filas de filas y columnas || el -j para ir restando la posición (de columna) en cada vuelta
            for (int j = 0; j < matriz[0].length; j++) {                                                                                                                                    // el -i para subir una fila una vez he terminado de recorrer las columnas de esa fila
                if (matriz[i][j] != matriz2[matriz2.length - 1 - i][matriz2[i].length - 1 - j]) { //fijo la fila y voy contando de derecha a izquierda las columnas,
                    return !esInversa;                                                  // cuando termino la fila retrocedo 1 fila y repito
                }
            }
        }
        return esInversa;
    }
}