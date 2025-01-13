package TEMA4.BOLETÍN4;

import java.util.Scanner;

public class Ejercicio3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Introduce una cadena");
        String cadena = sc.next();

        boolean isPalindromo = esIgual(cadena);
        if (isPalindromo) {
            System.out.println("Si, es palindromo");
        } else {
            System.out.println("No es palindromo");
        }

        boolean esPalindromo = esReverso(cadena);
        if (esPalindromo) {
            System.out.println("Si, es palindromo");
        } else {
            System.out.println("No es palindromo");
        }
    }

    public static boolean esIgual(String cadena) {
        for (int i = 0; i < cadena.length(); i++) {
            if (cadena.charAt(i) != cadena.charAt(cadena.length() - i - 1)) {
                return false;
            }
        }
        return true;
    }

    public static boolean esReverso(String cadena) {
        //Convertimos cadena a String builder para poder usar el metodo reverse,
        // y el toString() es para convertir elStringBuilder en String
        String palabraAlReves = new StringBuilder(cadena).reverse().toString();

        //Compara si plabaraAlReves es igual a cadena
        return palabraAlReves.equals(cadena);
    }
}