package TEMA4.BOLETÍN4;

import java.util.Scanner;

public class Ejercicio1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Introduce una cadena");
        String cadena = sc.next();
        System.out.println("Introduce un caracter");
        char caracter = sc.next().charAt(0);
        cadena = cadena.toLowerCase();
        caracter = Character.toLowerCase(caracter);
        int contador = 0;
        for (int i = 0; i <cadena.length(); i++) {
            if (cadena.charAt(i) == caracter){
                contador++;
            }
        }

        System.out.println("La el caracter " +caracter+ " se repite " +contador+ " veces");
    }
}
