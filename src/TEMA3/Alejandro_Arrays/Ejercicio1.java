/*
EJERCICIO 1:
Leer 5 números, guardarlos en un arreglo
y mostrarlos en el mismo orden introducido.
 */

package TEMA3.Alejandro_Arrays;

import java.util.Arrays;
import java.util.Scanner;

public class Ejercicio1 {
    public static void main(String[] args) {
        Scanner entrada = new Scanner (System.in);

        int [] numero = new int[5];

        for(int i = 0; i<5; i++){
            System.out.println("Pon un número hasta llegar a 5, nUmero" +(i+1)+ " : ");
            numero[i] = entrada.nextInt();
        }
        System.out.println(Arrays.toString(numero));
    }
}
