package TEMA4.BOLETÍN2.Ejercicio1.Prueba2LaBuena;

import TEMA4.BOLETÍN2.Ejercicio1.Prueba.PersonaException;

import java.time.LocalDate;

public class Persona {
    private String nombre;
    private LocalDate fechaNacimiento;
    private String dni;
    private char sexo;
    private float altura;
    private float peso;

    public Persona() {
    }

    private String getNombre() {
        return nombre;
    }

    public void setNombre() {
        this.nombre = nombre;
    }

    private LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(int year, int month, int day) {

        this.fechaNacimiento = LocalDate.of(year, month, day);
    }

    private String getdni() {
        return dni;
    }

    public void setdni(String dni) throws PersonaException {
        if (dni.length() > 8) {
            throw new PersonaException("Ponga bien su dni porfavor");
        }
        this.dni = dni;
    }

    private char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) throws PersonaException {
        if (sexo != 'm' && sexo != 'f') {
            throw new PersonaException("Ponga bien su sexo porfavor");
        }
        this.sexo = sexo;
    }

    private float getAltura() {
        return altura;
    }

    public void setAltura(float altura) throws PersonaException {
        if (altura < 1) {
            throw new PersonaException("Ponga bien su altura porfavor");
        }
        this.altura = altura;
    }

    private float getPeso() {
        return peso;
    }

    public void setPeso(float peso) throws PersonaException {
        if (peso < 1) {
            throw new PersonaException("Ponga bien su peso porfavor");
        }
        this.peso = peso;
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

    public float calcularIMC (){

        return (float) (peso / (Math.pow(altura, 2)));
    }

}