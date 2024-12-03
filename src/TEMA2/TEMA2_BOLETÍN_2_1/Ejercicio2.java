/*
TEMA 2. BOLETÍN 2.1, EJERCICIO 2.
Realizar un programa que solicite dos números, base y exponente, enteros
positivos (incluido el 0), y que calcule la potencia (base elevado a
exponente) a través de productos. Si los datos son incorrectos deberán
volverse a solicitar
 */
package TEMA2.TEMA2_BOLETÍN_2_1;

import java.util.Scanner;

public class Ejercicio2 {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int base, exponente;

        // Solicitar la base
        do {
            System.out.println("Introduce la base (entero positivo o 0):");
            base = entrada.nextInt();
        } while (base < 0);

        // Solicitar el exponente
        do {
            System.out.println("Introduce el exponente (entero positivo o 0):");
            exponente = entrada.nextInt();
        } while (exponente < 0);

        // Calcular la potencia usando productos
        int resultado = 1;

        for (int i = 0; i < exponente; i++) {
            resultado *= base; // Multiplicar base exponente veces
        }

        System.out.println("El resultado de " + base + " elevado a " + exponente + " es: " + resultado);
    }
}
