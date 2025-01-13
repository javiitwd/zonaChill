package TEMA4.BOLETÍN4;

import java.util.Scanner;

public class Ejercicio12 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Digame la direccion de correo");
        String direccion = sc.nextLine();

        if (direccionCorrecta(direccion)) {
            System.out.println("Si");
        } else {
            System.out.println("No");
        }
    }

    public static boolean direccionCorrecta(String direccion) {

        //PARTE USUARIO
        //Si el primer caracter no es una letra return false
        if (!Character.isLetter(direccion.charAt(0))) {
            return false;
        }
        //Posicion en la que se encuentra el @
        int indiceDelArroba = direccion.indexOf('@');
        //Sino hay @ devuelvo false
        if (indiceDelArroba == -1) {
            return false;
        }
        //Recorro del 0 hasta el @ Si no es un numero o letra return false
        for (int i = 1; i < indiceDelArroba; i++) {
            char c = direccion.charAt(i);
            if (!Character.isLetter(c) && !Character.isDigit(c) && c != '.') {
                return false;
            }
        }
        //PARTE DE LA ORGANIZACION
        //Si el primer caracter despues del @ no es una letra return false
        if (!Character.isLetter(direccion.charAt(indiceDelArroba + 1))) {
            return false;
        }

        //Guardamos la posicion del ultimo punto que encontremos
        //¿? indexOf() nos da la posicion en la que se encuentra por primera vez
        int lugarUltimoPunto = direccion.lastIndexOf('.');

        //Sino hay . devuelvo false
        if (lugarUltimoPunto == -1) {
            return false;
        }
        //Recorro a partir del @ hasta el . Si no es un numero o letra return false
        for (int i = indiceDelArroba + 1; i < lugarUltimoPunto; i++) {
            char c = direccion.charAt(i);
            if (!Character.isLetter(c) && !Character.isDigit(c)) {
                return false;
            }
        }

        //PARTE DEL FIN
        //Recorro desde el punto hasta el final, si no es una letra o hay mas de 3 letras y menos que 2 return false
        int contarLetras = 0;
        for (int i = lugarUltimoPunto + 1; i < direccion.length(); i++) {
            char c = direccion.charAt(i);
            if (!Character.isLetter(c)) {
                return false;
            } else {
                contarLetras++;
            }
        }
        if (contarLetras != 2 && contarLetras != 3) {
            return false;
        }
        return true;
    }
}
/*
//Guardamos la posicion del primer . que encontramos
int posicion = direccion.indexOf('.');
//Guardamos la posicion del ultimo punto que encontremos
int posicionUltima = direccion.lastIndexOf('.');
*/