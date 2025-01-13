package TEMA4.BOLETÍN4;

import java.util.Scanner;

public class Ejercicio10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Pon su direccion web");
        String web = sc.nextLine();
        if (comprobarDIreccionWebValida(web)) {
            System.out.println("Su direccion es valida");
        } else {
            System.out.println("Su direccion no es valida");
        }
    }

    public static boolean comprobarDIreccionWebValida(String web) {
        String condicionInicio = "http://www.";
        String condicionInicio2 = "http:// www.";
        if (!web.substring(0, 11).equals(condicionInicio) && !web.substring(0, 12).equals(condicionInicio2)) {
            return false;
        }
        String web2 = web.replace(" ", "");
        //Si es la condicionDeInicio2 borramos el espacio
        /*StringBuilder sb = new StringBuilder(web);
        if (web.equals(condicionInicio2)) {
            sb.delete(7, 8);
        }*/
        for (int i = 11; i < web2.length(); i++) {
            if (Character.isDigit(web.charAt(11))) {
                return false;
            }
            if (web2.charAt(i) == ' ') {
                return false;
            }
            if (web2.charAt(i) == '.') {
                if (!comprobarValidez2(web2, i)) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean comprobarValidez2(String web, int i) {

        if (Character.isLetter(web.charAt(i + 1))) {
            return true;
        }
        return false;
    }
}
