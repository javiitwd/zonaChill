package TEMA2.TEMA2_BOLETÍN_REFUERZO;/*
EJERCICO 10 BOLETÍN DE REFUERZO:
Crea un programa que dibuje un árbol
de navidad de altura X con asteriscos.
 */

import java.util.Scanner;

public class Ejercicio10 {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        System.out.println("Pon la altura");
        int altura = entrada.nextInt();

        for (int i = 1; i <= altura; i++) {
            for (int j = 1; j <= altura - i; j++) { //la altura (ej: 3)-la fila (ej: 1)= 2 (espacios en blanco)
                System.out.print(" ");
                for (int k = 1; k <= 2 * i - 1; k++) { //k=1 *2-1= * | k=2 *2-1= ***
                    System.out.print("*");
                }
                System.out.println();
            }
        }
    }
}