package TEMA4.BOLETÍN4;

import java.util.Scanner;

public class Ejercicio4 {

    public static boolean buscarPalabra(String frase, String palabra) {
        // Inicializamos un índice para recorrer la palabra
        int indicePalabra = 0;

        // Recorremos la frase
        for (int i = 0; i < frase.length(); i++) {
            // Si encontramos la letra que corresponde con la palabra, avanzamos
            if (frase.charAt(i) == palabra.charAt(indicePalabra)) {
                indicePalabra++;
            }

            // Si hemos encontrado toda la palabra, la palabra está oculta
            if (indicePalabra == palabra.length()) {
                return true;
            }
        }

        // Si no hemos encontrado toda la palabra, no está oculta
        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Solicitar entrada del usuario
        System.out.print("Introduce frase: ");
        String frase = scanner.nextLine();

        System.out.print("Palabra escondida: ");
        String palabra = scanner.nextLine();

        // Comprobar si la palabra se encuentra
        if (buscarPalabra(frase, palabra)) {
            System.out.println("Encontrada");
        } else {
            System.out.println("No se encuentra");
        }
        scanner.close();
    }
}