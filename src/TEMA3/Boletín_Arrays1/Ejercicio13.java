/*
13. Crea un programa que implemente una estructura de pila de números enteros. Una
estructura de pila es aquella que permite almacenar elementos de la manera “último
en entrar, primero en salir (LIFO - Last in first out)”. Crea un metodo main, donde
hagas llamadas a un metodo apilar para añadir elementos y otro metodo desapilar
para eliminarlos. Muestra el array tras cada una de las operaciones. La pila tendrá
como máximo 5 números enteros.
*/
package TEMA3.Boletín_Arrays1;
import java.util.Arrays;
import java.util.Scanner;

public class Ejercicio13 {
    //Scanner y Variable (Indice) estarán en todos los metodos
    static Scanner entrada = new Scanner(System.in);
    static int indice = 0;

    //Metodo principal en el cual se le dá la opción al usuario de apilar o desapilar
    public static void main(String[] args) {

        //Creo mi array "pila", este tiene como máximo 5 posiciones
        int[] pila = new int[5];
        int op;

        do {
            System.out.println("Si quieres apilar pulsa 1, si quieres desapilar pulsa 2 y si quieres salir pulsa 3");
            op = entrada.nextInt();

            if (op == 1) {
                apilar(pila); //Nos pasamos la pila
            } else if (op == 2) {
                desapilar(pila);
            }

        } while (op != 3);

        System.out.println(Arrays.toString(pila));
    }
//......................................................................................................................

    //Metodo de apilar
    private static void apilar(int[] pila) {
        int num;
        if (indice < pila.length) {
            System.out.println("¿Qué número quieres introducir");
            num = entrada.nextInt();
            pila[indice] = num;
            System.out.println("Has apilado el " + num);
            indice++;
        } else {
            System.out.println("La pila está llena");
        }
    }

    //Metodo de desapilar
    private static void desapilar(int[] pila) {

        if (indice > 0) {

            indice--;
            int desapila = pila[indice];
            System.out.println("Has desapilado el " + desapila);

        } else {

            System.out.println("La pila está vacía");
        }
    }
}

