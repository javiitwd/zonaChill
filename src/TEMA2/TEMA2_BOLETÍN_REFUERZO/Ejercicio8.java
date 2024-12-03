package TEMA2.TEMA2_BOLETÍN_REFUERZO;/*
EJERCICIO 8 BOLETÍN REFUERZO:
Crea un programa que dibuje un rectángulo
de tamaño NxM con asteriscos.
 */

import java.util.Scanner;
public class Ejercicio8 {
    public static void main(String[] args) {
        Scanner entrada = new Scanner (System.in);
        System.out.println("Pon la altura");
        int n = entrada.nextInt();
        System.out.println("Pon la anchura");
        int m = entrada.nextInt();

        for (int i = 0; i<n; i++){
            for (int j = 0; j<m; j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
