package TEMA2.TEMA2_BOLETÍN_REFUERZO;

import java.util.Scanner;
/*
EJERCICIO 2 BOLETÍN REFUERZO:
Crea un programa que convierta un
número binario a decimal
 */
public class Eercicio2 {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        String binario;

        System.out.println("Pon el binario:");
        binario = entrada.next();

        // Invertir el número binario
        StringBuilder sb = new StringBuilder(binario);
        String oiranib = sb.reverse().toString();

        // Convertir el binario a decimal
        int decimal = 0;

        // Leer los caracteres de la cadena invertida
        for (int i = 0; i < oiranib.length(); i++) {
            // Obtener el carácter en la posición i
            char bit = oiranib.charAt(i);

            // Convertir el carácter a entero (0 o 1)
            int valorBit = Character.getNumericValue(bit);

            // Calcular el valor decimal
            decimal += valorBit * Math.pow(2, i);
        }

        System.out.println("El número decimal es: " + decimal);
        entrada.close();
    }
}
