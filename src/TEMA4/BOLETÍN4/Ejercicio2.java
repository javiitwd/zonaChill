package TEMA4.BOLETÍN4;

import java.util.Scanner;

public class Ejercicio2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Introduce una cadena");
        String cadena = sc.next();

        int contadorMayusculas = 0;
        int contadorMinusculas = 0;
        int contadorNumeros = 0;

        for (int i = 0; i < cadena.length(); i++) {
            char c = (cadena.charAt(i));
            if (Character.isLetter(c)) {
                if (Character.isLowerCase(c)) {
                    contadorMinusculas++;
                } else {
                    contadorMayusculas++;
                }
            }
            if (Character.isDigit(c)) {
                contadorNumeros++;
            }
        }

        System.out.printf("Mayusculas: %s ", contadorMayusculas);
        System.out.printf("\nMinusculas: %s ", contadorMinusculas);
        System.out.printf("\nNumeros: %s ", contadorNumeros);
    }
}

