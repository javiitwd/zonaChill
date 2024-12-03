package TEMA3.Examenes;

public class jardinDeMiPrima {

    public static void main(String[] args) {

        int[][] jardin = {
                {1, 0, 0, 0, 1, 0, 0, 0, 2, 1, 1, 0, 0, 5, 0},
                {0, 2, 0, 5, 0, 0, 3, 0, 1, 0, 0, 0, 1, 0, 0},
                {3, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 2, 4},
                {0, 0, 2, 0, 0, 0, 0, 0, 2, 1, 3, 0, 0, 0, 1},
                {0, 0, 1, 0, 0, 0, 3, 0, 1, 0, 0, 0, 0, 0, 3},
                {4, 3, 0, 0, 0, 2, 1, 0, 0, 0, 0, 5, 0, 0, 0},
                {1, 2, 0, 5, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 2},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1},
                {3, 0, 0, 0, 0, 0, 2, 1, 4, 0, 0, 0, 1, 0, 0},
                {2, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 3, 0},
                {0, 0, 5, 1, 0, 0, 0, 5, 0, 3, 0, 0, 1, 0, 0},
                {1, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 5, 2, 4, 0},
                {0, 0, 1, 3, 0, 0, 1, 0, 0, 1, 0, 0, 1, 3, 0},
                {0, 1, 2, 1, 0, 0, 0, 0, 0, 2, 3, 1, 0, 0, 1},
                {1, 3, 4, 0, 0, 5, 0, 0, 1, 0, 0, 0, 0, 4, 2}
        };

        mirarPosicionesFlorecen(jardin);

    }

    private static void mirarPosicionesFlorecen(int[][] jardin) {

        for (int i = 0; i < jardin.length; i++) {
            for (int j = 0; j < jardin[i].length; j++) {

                if (jardin[i][j] == 1) {

                    boolean hayAgua = mirarSiHayAgua(jardin, i, j);
                    boolean hayAbeja = mirarSiHayAbeja(jardin, i, j);
                    boolean hayMalaHierba = mirarSiHayMalaHierba(jardin, i, j);
                    boolean hayGusano = mirarSiHayGusano(jardin, i, j);

                    if (hayAgua && hayAbeja && (!hayMalaHierba || hayGusano)){
                        System.out.println("La posición [" +i+ " , " +j+ "] florecerá" );
                    }
                }
            }
        }
    }

    private static boolean mirarSiHayAgua(int[][] jadrin, int i, int j) {

        for (int k = i - 1; k <= i + 1; k++) {
            for (int l = j - 1; l <= j + 1; l++) {

                if (k >= 0 && k < jadrin.length && l >= 0 && l < jadrin[i].length && (k != i || l != j)) {
                    if (jadrin[k][l] == 2) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private static boolean mirarSiHayAbeja(int[][] jadrin, int i, int j) {

        for (int k = i - 3; k <= i + 3; k++) {
            for (int l = j - 3; l <= j + 3; l++) {

                if (k >= 0 && k < jadrin.length && l >= 0 && l < jadrin[i].length && (k != i || l != j)) {
                    if (jadrin[k][l] == 5) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private static boolean mirarSiHayMalaHierba(int[][] jadrin, int i, int j) {

        for (int k = i - 1; k <= i + 1; k++) {
            for (int l = j - 1; l <= j + 1; l++) {

                if (k >= 0 && k < jadrin.length && l >= 0 && l < jadrin[i].length && (k != i || l != j)) {
                    if (jadrin[k][l] == 3) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private static boolean mirarSiHayGusano(int[][] jadrin, int i, int j) {

        for (int k = i - 1; k <= i + 1; k++) {
            for (int l = j - 1; l <= j + 1; l++) {

                if (k >= 0 && k < jadrin.length && l >= 0 && l < jadrin[i].length && (k != i || l != j)) {
                    if (jadrin[k][l] == 4) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
