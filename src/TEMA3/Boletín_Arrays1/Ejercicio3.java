package TEMA3.Boletín_Arrays1;
/*
3. Crea un programa que pregunte cuántos elementos tendremos en un array de
enteros. Posteriormente se preguntarán tantos números como haya indicado el
usuario. Posteriormente, mostraremos por pantalla el mayor, el menor y la media. Si
el número mayor o menor están repetidos, deberá indicarse cuántas veces se repite.
Por ejemplo:
Introduzca las posiciones que tendrá el array: 5
Introduzca el número 1: 4
Introduzca el número 2: -1
Introduzca el número 3: 9
Introduzca el número 4: 5
Introduzca el número 5: 9
 */

import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.Scanner;

public class Ejercicio3 {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        // Pido el tamaño del array
        System.out.println("¿Cuántos elementos quieres en el array de enteros?");
        int elementos = entrada.nextInt();

        /* Creo un Array (tipo int) llamado "número" con el tamaño
         del número de "elementos" que quiere el usuario */
        int[] numero = new int[elementos];

        // Le pido los números del array
        System.out.println("Pon los números del Array");

        // Pido números hasta la cantidad solicitada
        for (int i = 0; i < elementos; i++) {
            System.out.print("Pon el número: " + (i + 1) + " : "); /* el (i) es para que se le muestre al usuario por el
                                                                    número que va y el +1 es para que no empiece en 0 */

            numero[i] = entrada.nextInt(); // Esto es para guardar cada número en el Array que llamamos "numero"
        }                                  //En la posición i (0,1,2,3...) el número valdrá lo que ponga el usuario

        // Muestro los números solicitados
        System.out.print("Los números son: ");
        System.out.println(Arrays.toString(numero));

        // Ahora muestro el mayor y el menor
        int mayor = numero[0]; // Inicializo mayor con el primer elemento del Array (que es la posición 0)
        int menor = numero[0]; // igual que antes
        //Muestro la media
        float media = 0; // Creo una variable para la media y la inicializo en 0
        int numRepeMayor = 1;
        int numRepeMenor = 1;

        for (int i = 1; i < numero.length; i++) {
            if (numero[i] > mayor) {
                mayor = numero[i]; // Actualizo mayor
                numRepeMayor = 1;
            }
            if (numero[i] < menor) {
                menor = numero[i]; // Actualizo menor
                numRepeMenor = 1;
            }
            if (numero[i] == mayor) {
                numRepeMayor++;
            }
            if (numero[i] == menor) {
                numRepeMenor++;
            }
            media += numero[i];
        }
        media = media / elementos;

        System.out.printf("El número mayor es %d, el menor %d, y la media %s", mayor, menor, media);
    }
}
