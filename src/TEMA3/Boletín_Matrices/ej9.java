package TEMA3.Boletín_Matrices;

public class ej9 {
    public static void main(String[] args) {

        int[][] matriz = {{1, 3, 5, 6}, {4, 2, 0, 8}, {4, 2, 0, 8}, {1, 3, 5, 6}};

        boolean simetriaX = comprobarSimetriaX(matriz);

        if (simetriaX) {
            System.out.println("La matriz es simetrica");
        } else {
            System.out.println("La matriz no es simetrica");
        }
    }

    private static boolean comprobarSimetriaX(int[][] matriz) {

        for (int j = 0; j < matriz[0].length; j++) {
            for (int i = 0; i < matriz.length; i++) {

                if (matriz[i][j] != matriz[matriz.length - 1 - i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
}
