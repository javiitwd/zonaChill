/*
NO ENTENDIDO PERO CASI CASI
11. Crea un metodo que acepte 2 arrays, y devuelva un
nuevo array con los elementos que ambos arrays tienen en común.
*/
package TEMA3.Boletín_Arrays1;

import java.util.Arrays;

public class Ejercicio11 {
    public static void main(String[] args) {

        int[] array1 = {1, 2, 3, 4, 5, 9};
        int[] array2 = {2, 5, 3, 8, 9, 9};

        //Creo un metodo para buscar elementos comunes y meterlos en un nuevo Array
        int[] arrayComun = calcularElementosComunes(array1, array2);

        //Muestro el array con elementos comunes
        System.out.println(Arrays.toString(arrayComun));
    }

    private static int[] calcularElementosComunes(int[] array1, int[] array2) {
        int[] tempArray = new int[array1.length]; // Tamaño máximo posible para los elementos comunes
        int tamanoArrayComun = 0; // Contador para el tamaño del array de elementos comunes
        boolean yaEsta = false;

        // Recorrer todos los elementos de array1
        for (int i = 0; i < array1.length; i++) {
            // Comparar con todos los elementos de array2
            for (int j = 0; j < array2.length; j++) {
                // Si encontramos un elemento común
                if (array1[i] == array2[j] && yaEsta == false) {

                    // Verificar si ya está en tempArray
                    for (int k = 0; k < tamanoArrayComun; k++) {
                        if (tempArray[k] == array1[i]) {
                            yaEsta = true; // Ya existe, no lo añadimos
                            break;
                        }
                    }
                    // Si no está, lo añadimos y aumentamos el tamaño del array común
                    if (!yaEsta) {
                        tempArray[tamanoArrayComun++] = array1[i];
                    }
                }
            }
        }
        // Crear un nuevo array del tamaño correcto y copiar los elementos comunes
        int[] arrayComun = new int[tamanoArrayComun];
        for (int i = 0; i < tamanoArrayComun; i++) {
            arrayComun[i] = tempArray[i];
        }

        return arrayComun; // Devolver el array de elementos comunes
    }
}