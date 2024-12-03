/*
TEMA 2. BOLETÍN 2.1, EJERCICIO 5.
Realizar un programa que solicite un número e informe
de si es o no primo. Un número es primo si entre sus
divisores sólo está él mismo y el número 1.
 */
package TEMA2.TEMA2_BOLETÍN_2_1;

import java.util.Scanner;

public class Ejercicio5 {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int n1;

        // Comprobar que el número es mayor que 1
        do {
            System.out.println("Pon un número");
            n1 = entrada.nextInt();
        } while (n1 <= 0);

        boolean esPrimo = true;

        // Solo necesitamos comprobar hasta la mitad del número
        for (int i = 2; i <= n1 / 2; i++) {
            if (n1 % i == 0) {
                esPrimo = false;
                break; // Si encontramos un divisor, no es primo
            }
        }
        if (esPrimo == true) {
            System.out.println("El numero es primo");
        } else {
            System.out.println("El numero no es primo");
        }
    }
}


