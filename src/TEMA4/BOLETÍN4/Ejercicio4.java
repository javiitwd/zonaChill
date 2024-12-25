package TEMA4.BOLETÍN4;

import java.util.Scanner;

public class Ejercicio4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce la frase");
        String frase = sc.next();
        System.out.println("¿Cuál es la palabra a buscar?");
        String palabraABuscar = sc.next();
        String nuevaPalabra = "0";

        for (int i = 0; i < palabraABuscar.length(); i++) {
            for (int j = 0; j < frase.length(); j++) {
                if (palabraABuscar.charAt(i) == frase.charAt(j)){
                    nuevaPalabra += palabraABuscar.charAt(i);
                }
            }
        }



        if (nuevaPalabra.equals(frase)){

        }
    }
}
