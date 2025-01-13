package TEMA4.BOLETÍN4;

import java.util.Scanner;

public class Ejercicio9MiManera {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Ponga su frase");
        String frase = sc.nextLine();

        int sumaDeNumerosEnFrase = sumarNumerosFrase(frase);
        System.out.printf("La suma de los numeros de la frase es %d", sumaDeNumerosEnFrase);
    }

    public static int sumarNumerosFrase(String frase) {
        StringBuilder numeroTemporal = new StringBuilder();
        int sumaNumeros = 0;

        for (int i = 0; i < frase.length(); i++) {
            if (Character.isDigit(frase.charAt(i))) {
                //Si es un numero lo añado al stringBuilder
                if (siguienteEsNumero(frase, i)){

                }
                numeroTemporal.append(frase.charAt(i));
                //Convierto el StringBuilder a String y lo paso a entero, despues lo sumo
                sumaNumeros += Integer.parseInt(numeroTemporal.toString());
                //Reinicio el StringBuilder para no acumular numeros y que la suma sea erroena
                numeroTemporal.setLength(0);
            }
        }
        return sumaNumeros;
    }
    public static boolean siguienteEsNumero(String frase, int posicionActual){
        if (Character.isDigit(frase.charAt(posicionActual+1))){
            return true;
        }
        return false;
    }
}
