package TEMA4.BOLETÍN2.Ejercicio1.Prueba;

import java.time.LocalDate;

public class Persona {
    private String nombre;
    private LocalDate fechaNacimiento;
    private String dni;
    private char sexo;
    private float altura;
    private float peso;

    public Persona(String nombre, String dni, char sexo, float altura, float peso) throws Exception {

        this.nombre = nombre;

        if (dni.length() > 8) {
            this.dni = dni;
            throw new PersonaException("Porfavor introduzca bien su DNI");
        } else {
            this.dni = dni;
        }

        if (sexo != 'M' || sexo != 'F') {
            throw new PersonaException("Porfavor introduzca su sexo");
        } else {
            this.sexo = sexo;
        }

        if (altura < 1) {
            throw new PersonaException("No puedes medir menos de 1 cm");
        } else {
            this.altura = altura;
        }

        if (peso < 1) {
            throw new PersonaException("No puedes pesar menos de 1kg");
        }
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(int year, int month, int day) {
        this.fechaNacimiento = LocalDate.of(year, month, day);
    }

    public float IMC(){
        return (float)(peso/(Math.pow(altura, 2)));
    }

    public char letraDni() {
        int letraDNI = Integer.parseInt(dni) % 23;
        char letra;

        if (letraDNI == 0) {
            letra = 'T';
        } else if (letraDNI == 1) {
            letra = 'R';
        } else if (letraDNI == 2) {
            letra = 'W';
        } else if (letraDNI == 3) {
            letra = 'A';
        } else if (letraDNI == 4) {
            letra = 'G';
        } else if (letraDNI == 5) {
            letra = 'M';
        } else if (letraDNI == 6) {
            letra = 'Y';
        } else if (letraDNI == 7) {
            letra = 'F';
        } else if (letraDNI == 8) {
            letra = 'P';
        } else if (letraDNI == 9) {
            letra = 'D';
        } else if (letraDNI == 10) {
            letra = 'X';
        } else if (letraDNI == 11) {
            letra = 'B';
        } else if (letraDNI == 12) {
            letra = 'N';
        } else if (letraDNI == 13) {
            letra = 'J';
        } else if (letraDNI == 14) {
            letra = 'Z';
        } else if (letraDNI == 15) {
            letra = 'S';
        } else if (letraDNI == 16) {
            letra = 'Q';
        } else if (letraDNI == 17) {
            letra = 'V';
        } else if (letraDNI == 18) {
            letra = 'H';
        } else if (letraDNI == 19) {
            letra = 'L';
        } else if (letraDNI == 20) {
            letra = 'L';
        } else if (letraDNI == 21) {
            letra = 'K';
        } else {
            letra = 'E';
        }
        return letra;
    }
}

