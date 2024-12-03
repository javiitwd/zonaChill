package TEMA3.Alejandro_Arrays;

import java.util.Scanner;

public class Ejercicio5 {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int[] a = new int[10];
        int[] b = new int[10];
        int[] c = new int[20];

        for (int i = 0; i <= 10; i++) {
            System.out.println("Pon 10 números");
            a[i] = entrada.nextInt();
        }
        for (int i = 0; i <= 10; i++) {
            System.out.println("Pon 10 números");
            b[i] = entrada.nextInt();
        }

    }
}
