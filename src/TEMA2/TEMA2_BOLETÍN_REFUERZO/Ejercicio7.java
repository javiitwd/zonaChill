package TEMA2.TEMA2_BOLETÍN_REFUERZO;/*
EJERCICIO 7 BOLETÍN REFUERZO.
Crea un programa que dibuje un
cuadrado de tamaño NxN con asteriscos.
 */
import java.util.Scanner;
public class Ejercicio7 {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Pon el número de asteriscos:");
        int n = entrada.nextInt();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print("*"); // Usa print en lugar de println
            }
            System.out.println(); // Esto va después del bucle interno
        }
    }
}
