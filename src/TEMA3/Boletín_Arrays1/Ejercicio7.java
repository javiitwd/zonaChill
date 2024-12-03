/*
USO BOOLEANOS!!!
Crea un metodo contieneElemento, que acepte un array de enteros y un entero a
buscar, que realice la misma operación que el ejercicio anterior, y devuelva
un valor booleano que indique si el array contiene el elemento o no.
*/

package TEMA3.Boletín_Arrays1;

import java.security.spec.RSAOtherPrimeInfo;
import java.util.Arrays;
import java.util.Scanner;

public class Ejercicio7 {
    public static void main(String[] args) {
        Scanner entrada = new Scanner (System.in);

        //pido cantidad de elementos
        System.out.println("Pon la cantidad del array");
        int tamanoArray = entrada.nextInt();

        //creo un array con la cantidad de elemntos pedida
        int [] array = new int [tamanoArray];

        //creo un metodo aparte en el que voy a rellenar el array
        rellenar(array);

        //muestro el contenido del array
        System.out.println(Arrays.toString(array));

        //miro si el número está en el array
        boolean buscarNumero = calcularBuscarNumero (array, 5);

        if (buscarNumero == true){
            System.out.println("El número está");
        } else {
            System.out.println("El número no está");
        }

    }
//......................................................................................................................

    private static void rellenar (int [] array){ //uso void para no tener que poner un puto return
        Scanner entrada = new Scanner (System.in);
        for (int i = 0; i<array.length; i++){
            System.out.println("Pon el numero " +(i+1)+ " : ");
            array[i] = entrada.nextInt();
        }
    }

    private static boolean calcularBuscarNumero (int [] array, int numero){
        boolean esta = false;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == numero){
                esta = true;
            }
        }
        return esta;
    }
}
