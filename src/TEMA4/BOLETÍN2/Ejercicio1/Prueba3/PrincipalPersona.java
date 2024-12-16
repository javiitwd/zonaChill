/*
package TEMA4.BOLETÍN2.Ejercicio1.Prueba3;

import java.time.LocalDate;
import java.util.Scanner;
import java.util.SortedMap;

public class PrincipalPersona {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        Persona persona = new Persona();

        System.out.println("Dirme tu nombre");
        String name = sc.next();

        System.out.println("Dirme tu fecha de nacimento");
        System.out.println("Año:");
        int year = sc.nextInt();
        System.out.println("Mes:");
        int month = sc.nextInt();
        System.out.println("Día:");
        int day = sc.nextInt();

        persona.setFechaNacimiento(year, month, day);

        boolean dniCorrecto = false;
        while (!dniCorrecto) {
            try {
                System.out.println("Dirme tu DNI");
                String dni = sc.next();
                persona.setDni(dni);
                dniCorrecto = true;
            } catch (PersonaException e) {
                System.out.println(e.getMessage());
            }
        }

        boolean sexoCorrecto = false;
        while (!sexoCorrecto) {
            try {
                System.out.println("Dirme tu sexo");
                char sexo = sc.next().charAt(0);
                persona.setSexoCorrecto(sexo);
                sexoCorrecto = true;
            } catch (PersonaException e) {
                System.out.println(e.getMessage());
            }
        }

        boolean alturaCorrecta = false;
        while (!alturaCorrecta) {
            try {
                System.out.println("Dirme tu altura");
                float altura = sc.nextFloat();
                persona.setAltura(altura);
                alturaCorrecta = true;
            } catch (PersonaException e) {
                System.out.println(e.getMessage());
            }
        }

        boolean pesoCorrecto = false;
        while (!pesoCorrecto) {
            try {
                System.out.println("Dirme tu peso");
                float peso = sc.nextFloat();
                persona.setAltura(peso);
                pesoCorrecto = true;
            } catch (PersonaException e) {
                System.out.println(e.getMessage());
            }
        }

        System.out.println("Su IMC es de " +persona.calcularIMC);
    }
}
*/
