package TEMA4.BOLETÍN4;

public class Ejercicio9 {
    public static void main(String[] args) {
        String frase = "Frase con números, 12 entre las palabras 456 y al final 1000";

        int resultado = sumarNumeros(frase);

        System.out.printf("La suma es de %d", resultado);
    }

    public static int sumarNumeros(String frase) {
        int suma = 0;
        StringBuilder numeros = new StringBuilder();
        for (int i = 0; i < frase.length(); i++) {
            //Si el un numero lo añado a un StringBuilder
            if (Character.isDigit(frase.charAt(i))) {
                numeros.append(frase.charAt(i));
            } else {
                //Sino, si el StringBuilder no esta vacio lo convierto a entero y sumo lo acumulado al total
                if (numeros.length() > 0) {
                    suma += Integer.parseInt(numeros.toString());
                    //Vaciamos el StringBuilder hasta que encuentre otro numero y lo llene otra vez
                    numeros.setLength(0);
                }
            }
        }
        //Si el StringBuilder no esta vacio lo sumo a la sumaDeNumeros
        if (numeros.length() > 0) {
            suma += Integer.parseInt(numeros.toString());
        }
        return suma;
    }
}
