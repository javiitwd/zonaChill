package TEMA4.BOLETÍN2.Ejercicio1.Prueba;

import java.time.LocalDate;
import java.util.Scanner;

public class PrincipalPersona {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Persona persona = null;

        boolean parametroCorrecto = false;

        do {
            try {
                System.out.println("Pon tu nombre");
                String nombre = sc.next();
                System.out.println("Pon tu dni");
                String dni = sc.next();
                System.out.println("Pon tu sexo");
                char sexo = sc.next().charAt(0);
                System.out.println("Pon tu altura");
                float altura = sc.nextFloat();
                System.out.println("Pon tu peso");
                float peso = sc.nextFloat();
                System.out.println("Pon tu fecha de nacimiento:");
                System.out.println("año:");
                int year = sc.nextInt();
                System.out.println("Mes:");
                int month = sc.nextInt();
                System.out.println("Día");
                int day = sc.nextInt();
                persona.setFechaNacimiento(year, month, day);

                persona = new Persona(nombre, dni, sexo, altura, peso);
                parametroCorrecto = true;

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } while (!parametroCorrecto);

        System.out.println("la letra del DNI es " + persona.letraDni());
        System.out.println("el imc es " + persona.IMC());
        System.out.println("tu fecha de nacimiento es " + persona.getFechaNacimiento());
    }
}