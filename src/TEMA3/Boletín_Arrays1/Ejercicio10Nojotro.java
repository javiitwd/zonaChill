/*
10. Crea un array que devuelva un nuevo array donde
se hayan eliminado los elementos duplicados del primero.
*/
package TEMA3.Boletín_Arrays1;

import java.util.Arrays;

public class Ejercicio10Nojotro {
    public static void main(String[] args) {
        int[] array = {1, 2, 2, 3, 4, 4, 5};

        int[] arrayNoRepetido = calcularArrayNoRepetido(array);

        System.out.println(Arrays.toString(arrayNoRepetido));
    }

    private static int[] calcularArrayNoRepetido(int[] array) {
        int[] arrayNoRepetido = new int[array.length];
        int tamanoArrayNoRepetido = 0;

        for (int i = 0; i < array.length; i++) {
            if (numeroIgual(arrayNoRepetido, array[i]) == -1){
                arrayNoRepetido[tamanoArrayNoRepetido] = array[i];
                tamanoArrayNoRepetido++;
            }
        }

        int [] arrayFinalSinCeros = new int[tamanoArrayNoRepetido];
        for (int i = 0; i < arrayFinalSinCeros.length; i++) {
            arrayFinalSinCeros [i] = arrayNoRepetido[i];

        }
        return arrayFinalSinCeros;
    }

    private static int numeroIgual (int [] arrayNoRepetido, int numeroArray){
        for (int i = 0; i < arrayNoRepetido.length; i++) {
            if (numeroArray == arrayNoRepetido[i]){
                return i; //fallamos en no poner el return aqui
            }
        }

        return -1;
    }
}