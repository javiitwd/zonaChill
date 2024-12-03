package TEMA3.Examenes;

public class Ejercicio2Examen2020Resumen {
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

        mirarSiFlorecera(jardin);

    }

    private static void mirarSiFlorecera(int[][] jardin) {
        for (int i = 0; i < jardin.length; i++) {
            for (int j = 0; j < jardin[i].length; j++) {
                if (jardin[i][j] == 1) { //si hay semilla compreba lo demás

                    boolean hayAgua = comprobarHayAgua(jardin, i, j);
                    boolean hayAbeja = comprobarHayAbeja(jardin, i, j);
                    boolean hayAMalaHierba = comprobarHayMalaHierba(jardin, i, j);
                    boolean hayGusano = comprobarHayGusano(jardin, i, j);

                    if (hayAgua && hayAbeja && !hayAMalaHierba){
                        System.out.println("La posición [" +i+ "] [" +j+ "] florecerá");
                    }
                    else if (hayAgua && hayAbeja && hayAMalaHierba && hayGusano){
                        System.out.println("La posición [" +i+ "] [" +j+ "] florecerá");
                    }
                }
            }
        }
    }

    private static boolean comprobarHayAgua(int[][] jardin, int i, int j) {

        for (int k = i - 1; k <= i + 1; k++) {
            for (int l = j - 1; l <= j + 1; l++) {
                if (k >= 0 && k < jardin.length && l >= 0 && l < jardin.length)
                    if (jardin[k][l] == 2) {
                        return true;
                    }
            }
        }
        return false;
    }

    private static boolean comprobarHayAbeja(int[][] jardin, int i, int j) {

        for (int k = i - 3; k <= i + 3; k++) {
            for (int l = j - 3; l <= j + 3; l++) {
                if (k >= 0 && k < jardin.length && l >= 0 && l < jardin.length)
                    if (jardin[k][l] == 5) {
                        return true;
                    }
            }
        }
        return false;
    }

    private static boolean comprobarHayMalaHierba(int[][] jardin, int i, int j) {

        for (int k = i - 1; k <= i + 1; k++) {
            for (int l = j - 1; l <= j + 1; l++) {
                if (k >= 0 && k < jardin.length && l >= 0 && l < jardin.length)
                    if (jardin[k][l] == 3) {
                        return true;
                    }
            }
        }
        return false;
    }

    private static boolean comprobarHayGusano(int[][] jardin, int i, int j) {

        for (int k = i - 1; k <= i + 1; k++) {
            for (int l = j - 1; l <= j + 1; l++) {
                if (k >= 0 && k < jardin.length && l >= 0 && l < jardin.length)
                    if (jardin[k][l] == 4) {
                        return true;
                    }
            }
        }
        return false;
    }
}
