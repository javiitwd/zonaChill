package TEMA4.BOLETÍN2.Ejercicio1.Prueba2LaBuena;

import TEMA4.BOLETÍN2.Ejercicio1.Prueba.PersonaException;

import java.util.Scanner;

public class PrincipalPersona {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws PersonaException {

        Persona persona = new Persona();

        System.out.println("Pon tu nombre");
        String nombre = sc.next();
        persona.setNombre();


        System.out.println("Pon tu año de nacimiento");
        int year = sc.nextInt();
        System.out.println("Pon tu mes de nacimiento");
        int month = sc.nextInt();
        System.out.println("Pon tu dia de nacimiento");
        int day = sc.nextInt();
        persona.setFechaNacimiento(year, month, day);

        boolean dniCorrecto = false;
        while (!dniCorrecto) {
            try {
                System.out.println("Ponga su dni");
                String dni = sc.next();
                persona.setdni(dni);
                dniCorrecto = true;
            } catch (PersonaException e) {
                System.out.println(e.getMessage());
            }
        }

        boolean sexoCorrecto = false;
        while (!sexoCorrecto) {
            try {
                System.out.println("Ponga su sexo");
                char sexo = sc.next().charAt(0);
                persona.setSexo(sexo);
                sexoCorrecto = true;
            } catch (PersonaException e) {
                System.out.println(e.getMessage());
            }
        }

        boolean alturaCorrecta = false;
        while (!alturaCorrecta) {
            try {
                System.out.println("Ponga su altura");
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
                System.out.println("Ponga su peso");
                float peso = sc.nextFloat();
                persona.setPeso(peso);
                pesoCorrecto = true;
            } catch (PersonaException e) {
                System.out.println(e.getMessage());
            }
        }

        System.out.println("Su IMC es de" + persona.calcularIMC());
        System.out.println("Su letra de DNI es la " +persona.letraDni());
    }
}


