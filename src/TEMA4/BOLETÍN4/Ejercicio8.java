package TEMA4.BOLETÍN4;

import java.util.Scanner;

public class Ejercicio8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Dime la frase");
        String frase = sc.nextLine();

        int totalDePalabras = mirarPalabrasEnLaFrases(frase);
        System.out.printf("Hay %d palabras", totalDePalabras);
    }

    public static int mirarPalabrasEnLaFrases(String frase) {
        int contadorPalabras = 1;
        for (int i = 0; i < frase.length() - 1; i++) {
            char c = frase.charAt(i);
            if (Character.isLetter(c) && frase.charAt(i + 1) == ' ') {
                contadorPalabras++;
            }
        }
        return contadorPalabras;
    }

    //hola soy antoñito
   /* public static int mirarPalabrasEnLaFrases(String frase) {
        int contadorPalabras = 0;

        for (int i = 0; i < frase.length(); i++) {
            if (frase.charAt(i) == ' ') {
                i += contadorDeEspacios(frase, i);
            } else {
                if (i > 0 && Character.isLetter(frase.charAt(i - 1))) {
                    break;
                }
                contadorPalabras++;
            }
        }
        return contadorPalabras;
    }

    public static int contadorDeEspacios(String frase, int i) {
        int contadorEspacios = 0;

        for (int j = i; j < frase.length(); j++) {
            if (frase.charAt(i) == ' ') {
                contadorEspacios++;
            } else {
                break;
            }
        }
        return contadorEspacios;
    }*/
}