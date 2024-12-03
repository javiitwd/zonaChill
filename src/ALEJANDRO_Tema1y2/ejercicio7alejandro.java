package ALEJANDRO_Tema1y2;

import java.util.Scanner;
/*
Ejercicio 7(Alejandro): Pedir números hasta que se
introduzca uno negativo, y calcular la media.
*/
public class ejercicio7alejandro {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int n1, cantidad, suma;
        float media;
        suma = 0;
        cantidad = 0;

        System.out.println("Pon un número");
        n1 = entrada.nextInt();
        while (n1 > 0) {
            cantidad++;
            suma = n1 + suma;
            System.out.println("Pon otro número");
            n1 = entrada.nextInt();
        }
        if (cantidad > 0) {
            media = (float) suma / cantidad;
            System.out.println("La media es " + media);
        }
    }
}
