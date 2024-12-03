/*
8. Crea un metodo que devuelva la posición que ocupa un valor
dentro de un array, o -1 si el array no contiene ese valor.
*/

package TEMA3.Boletín_Arrays1;

import java.util.Scanner;

public class Ejercicio8 {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        //pongo el array y el numero a buscar
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9};

        //metodo para buscar si esta en el array
        int resultado = buscarNumero(array, 3); //pa´ pone´ esto tienes que poner numero abajo y despues basta con que pongas un número aqui

        //muestro si está el número
        System.out.println(resultado); //podría usar un if resultado==-1; "El numero no está"... Pero como no me lo pide y sé hacerlo pa´ qué
    }

    private static int buscarNumero(int[] array, int numero) { //aqui xd
        for (int i = 0; i < array.length; i++) {
            //si el numero está en el array devuelvo ese numero
            if (array[i] == numero) {
                return i; //devuleve la posicion, no el numero
            }
        }
        return -1; //si no es igual no entra al if, es decir, devuelve directamente -1
    }
}

