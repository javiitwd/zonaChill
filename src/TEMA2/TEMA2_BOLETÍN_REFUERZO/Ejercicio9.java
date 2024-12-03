package TEMA2.TEMA2_BOLETÍN_REFUERZO;/*
EJERCICIO 9 BOLETÍN REFUERZO:
Crea un programa que dibuje un triángulo
de altura X con asteriscos:
 */

import java.util.Scanner;

public class Ejercicio9 {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        System.out.println("Pon la altura");
        int altura = entrada.nextInt();

        for(int i = 1; i<=altura; i++){
            for(int j = 1; j<=i; j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
}