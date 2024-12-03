/*
2. Crea un metodo que sume todas las posiciones
de una matriz y devuelva dicho número
*/
package TEMA3.Boletín_Matrices;

public class Ejercicio2 {
    public static void main(String[] args) {
        int[][] tabla = {{1, 2, 3}, {4, 5, 6}};

        int resultadoSuma = sumar(tabla);

        System.out.println("La suma e' " +resultadoSuma);
    }

    private static int sumar(int[][] tabla) {
        int suma = 0;

        for (int i = 0; i < tabla.length; i++) {
            for (int j = 0; j < tabla[i].length; j++) {
                suma += tabla[i][j];
            }
        }
        return suma;
    }
}