package TEMA4.BOLETÍN4;

import java.util.Scanner;

public class Ejercicio11 {
    public static final int NUM_FALLOS = 7;
    private static String palabraOculta = "Aprobar";
    private static StringBuilder palabraAMostrar = new StringBuilder("_".repeat(palabraOculta.length()));
    private static int contadorDeFallos = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        boolean terminado = false;
        while (!terminado) {
            System.out.println(palabraAMostrar);
            System.out.println("Ponga su letra");
            char letra = sc.next().charAt(0);
            buscarLetra(letra);
            System.out.printf("Tiene %d fallos \n", contadorDeFallos);
            if (palabraOculta.equals(palabraAMostrar.toString())) {
                System.out.println(palabraAMostrar);
                System.out.println("Felicidades!!!!!!! has ganado");
                terminado = true;
            } else if (contadorDeFallos == NUM_FALLOS) {
                System.out.println(palabraOculta);
                System.out.println("Ha perdido");
                terminado = true;
            }
        }
    }

    public static void buscarLetra(char letra) {
        boolean letraEsta = false;

        for (int i = 0; i < palabraOculta.length(); i++) {

            if (palabraOculta.toLowerCase().charAt(i) == Character.toLowerCase(letra)) {
                palabraAMostrar.replace(i, i + 1, palabraOculta.substring(i, i + 1));
                letraEsta = true;
            }
        }
        if (!letraEsta) {
            contadorDeFallos++;
        }
    }
}
