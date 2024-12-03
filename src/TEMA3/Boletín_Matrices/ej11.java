/*
11. Crea un metodo que reciba dos matrices, y compruebe si son matrices inversas,
es decir, si tienen los mismos valores en los índices inversos:
5 8 9 0   2 3 7 1
4 7 5 2 y 2 5 7 4
1 7 3 2   0 9 8 5
*/

package TEMA3.Boletín_Matrices;

public class ej11 {
    public static void main(String[] args) {

        int[][] matriz = {{5,8,9,0}, {4,7,5,2}, {1,7,3,2}};
        int[][] matriz2 = {{2,3,7,1}, {2,5,7,4}, {0,9,8,5}};

        boolean matrizInversa = comprobarMatrizInversa (matriz, matriz2);

        if (matrizInversa){
            System.out.println("La matriz es inversa");
        } else {
            System.out.println("La matriz no es inversa");
        }
    }

    private static boolean comprobarMatrizInversa (int[][]matriz, int[][]matriz2){
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
               if (matriz[i][j] != matriz2[matriz2.length-1-i][matriz2[i].length-1-j]){
                   return false;
               }
            }
        }
        return true;
    }
}
