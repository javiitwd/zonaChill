package TEMA4.BOLETÍN4;

import java.util.Scanner;

public class Ejercicio7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Pon una frase");
        String frase = sc.nextLine();


        StringBuilder fraseNueva = new StringBuilder();

        //Le equitamos los espacios a la frase
        String fraseSinEspacios = frase.replace(" ", "");

        crearNuevaFrase(fraseSinEspacios, fraseNueva);

        System.out.println("Frase original: " + frase);
        System.out.println("Frase nueva: " + fraseNueva);

    }

    public static void crearNuevaFrase(String frase, StringBuilder fraseNueva) {
        StringBuilder vocales = new StringBuilder();
        //Convertimos la frase a minuscula
        String fraseMinuscula = frase.toLowerCase();

        for (int i = 0; i < frase.length(); i++) {

            if (fraseMinuscula.charAt(i) != 'a' && fraseMinuscula.charAt(i) != 'e' && fraseMinuscula.charAt(i) != 'i' && fraseMinuscula.charAt(i) != 'o' && fraseMinuscula.charAt(i) != 'u') {
                fraseNueva.append(frase.charAt(i));
            } else {
                vocales.append(frase.charAt(i));
            }
        }
        fraseNueva.append(vocales);
    }
}
