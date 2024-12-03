package TEMA4.BOLETÍN2.Ejercicio1;

import java.util.Scanner;

public class PrincipalPersona {

    public static void main(String[] args) {
        Persona persona = new Persona();
        Scanner entrada = new Scanner(System.in);
        String numerosDNI;
        float altura;
        float peso;
        boolean parametroCorrecto = false;
        int dia;
        int year;
        int mes;

        System.out.println("dime el dia en que naciste");
        dia = entrada.nextInt();
        System.out.println("dime en que mes naciste");
        mes = entrada.nextInt();
        System.out.println("dime en que año naciste");
        year = entrada.nextInt();
        persona.setFechaDeNacimiento(year, mes, dia);

        do {
            try {
                System.out.println("introduce los numeros del DNI");
                numerosDNI = entrada.next();
                persona.setDni(numerosDNI);
                parametroCorrecto = true;
            } catch (PersonaException e) {
                System.out.println(e.getMessage());
            }
        } while (!parametroCorrecto);

        parametroCorrecto = false;
        do {
            try {
                System.out.println("introduce tu altura");
                altura = entrada.nextFloat();
                persona.setAltura(altura);
                parametroCorrecto = true;
            } catch (PersonaException e) {
                System.out.println(e.getMessage());
            }
        } while (!parametroCorrecto);

        parametroCorrecto = false;
        do {
            try {
                System.out.println("introduce el peso");
                peso = entrada.nextFloat();
                persona.setPeso(peso);
                parametroCorrecto = true;
            } catch (PersonaException e) {
                System.out.println(e.getMessage());
            }
        } while (!parametroCorrecto);


        System.out.println("la letra del DNI es " + persona.letraDNI());
        System.out.println("el imc es " + persona.getIMC());
        System.out.println("tu fecha de nacimiento es " + persona.getFechaDeNacimiento());
    }
}
