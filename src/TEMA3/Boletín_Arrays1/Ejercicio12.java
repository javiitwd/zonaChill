/*
2. Crea un metodo que acepte un array de enteros y devuelva el mismo array ordenado
de menor a mayor. Utiliza para ello el metodo de ordenación de la burbuja
*/
package TEMA3.Boletín_Arrays1;

import org.w3c.dom.ls.LSOutput;

import java.util.Arrays;
import java.util.Scanner;

public class Ejercicio12 {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        System.out.println("Pon la longitud");
        int tamano = entrada.nextInt();

        int[] array = new int[tamano];

        System.out.println("Puto rellenalo");
        int[] arrayDesordenado = llenoArray(array);

        System.out.println(Arrays.toString(arrayDesordenado));

        int[] arrayOrdenado = ordenarArray(arrayDesordenado);

        System.out.println("Y ordenado mediante el método de la burbuja es:");
        System.out.println(Arrays.toString(arrayOrdenado));


    }

    private static int[] llenoArray(int[] array) {
        Scanner entrada = new Scanner(System.in);
        for (int i = 0; i < array.length; i++) {
            System.out.println("Rellena la posición " + i + " del array");
            array[i] = entrada.nextInt();
        }
        return array;
    }

    private static int[] ordenarArray(int[] arrayDesordenado) {

        //Creo un nuevo array para ordenarlo sin modificar el desordenado, dandole los valores del desordenado
        int[] arrayOrdenado = new int[arrayDesordenado.length];

        for (int i = 0; i < arrayDesordenado.length; i++) {
            arrayOrdenado[i] = arrayDesordenado[i];
        }

        int temporal;
        for (int i = 0; i < arrayOrdenado.length; i++) { //1ºfor = Controla cuántas veces se necesita pasar por el array, es necesario ya que sino solo se ordenaría cada numero 1 posición
            for (int j = 0; j < arrayOrdenado.length - 1; j++) { //2ºfor = Realiza las comparaciones y ordena el array
                if (arrayOrdenado[j] > arrayOrdenado[j + 1]) {
                    temporal = arrayOrdenado[j]; //guardo del mayor (actual) en un temporal
                    arrayOrdenado[j] = arrayOrdenado[j + 1]; //al actual le doy el valor del siguiente (que es menor)
                    arrayOrdenado[j + 1] = temporal; //al siguiente le doy el valor del actual (que es mayor)
                }
            }
        }
        return arrayOrdenado;
    }
}
