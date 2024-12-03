/*
10. Crea un array que devuelva un nuevo array donde
se hayan eliminado los elementos duplicados del primero.
*/

package TEMA3.Boletín_Arrays1;

import java.util.Arrays;

public class Ejercicio10 {

    public static void main(String[] args) {
        int[] array = {1, 2, 2, 3, 4, 5, 5, 6, 7};

        int[] nuevoArray = eliminarDuplicados(array);

        System.out.println(Arrays.toString(nuevoArray));
    }

    private static int[] eliminarDuplicados(int[] array) {
        int[] nuevoArray = new int[array.length];
        int tamanoNuevoArray = 0;
        for (int i = 0; i < array.length; i++) {
            if (buscarNumero(nuevoArray, array[i]) == -1) {
                nuevoArray[tamanoNuevoArray] = array[i]; //meto el numero en la posicion 0 del array
                tamanoNuevoArray++; //añado otra posicion del array
            }
        }
        return nuevoArray;
    }

    //Submetodo del metodo de arriba
    private static int buscarNumero(int[] nuevoArray, int numeroArray) {
        for (int i = 0; i < nuevoArray.length; i++) {
            //si el numero está en el array devuelvo ese numero
            if (nuevoArray[i] == numeroArray) {
                return i; //devuleve la posicion, no el numero
            }
        }
        //Si el numero no está en el array devuelvo -1 al metodo de arriba
        return -1;
    }
}