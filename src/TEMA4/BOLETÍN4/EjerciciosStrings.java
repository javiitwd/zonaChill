package TEMA4.BOLETÍN4;

import java.util.Arrays;

public class EjerciciosStrings {
    public static void main(String[] args) {
        String cadena = "      hjkis jska hl kjahsd kjl   sadhjkh asdhj     ";
        System.out.println(cadena);
        cadena = cadena.trim();
        System.out.println(cadena);

        StringBuilder sb = new StringBuilder(cadena);
        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) == ' ' && sb.charAt(i + 1) == ' ') {
                sb.delete(i + 1, i + 2);
                i--;
            }
        }
        System.out.println(sb);

        String[] palabras = sb.toString().split(" ");

        System.out.println("Las palabras son : " + Arrays.toString(palabras) + " y son " + palabras.length);

    }
}
