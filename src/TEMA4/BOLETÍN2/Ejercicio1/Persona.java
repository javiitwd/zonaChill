package TEMA4.BOLETÍN2.Ejercicio1;

import java.time.LocalDate;

public class Persona {
    private String nombre;
    private LocalDate fechaNacimiento;
    private String dni;
    private char sexo;
    private float altura;
    private float peso;

    public Persona (String nombre, String  dni, char sexo, float altura, float peso) throws Exception{

        this.nombre = nombre;

        if (dni.length() > 8){
            this.dni = dni;
            throw new PersonaException("Porfavor introduzca bien su DNI");
        } else {
            this.dni = dni;
        }

        if (sexo != 'M' || sexo != 'F'){
            throw new PersonaException("Porfavor introduzca su sexo");
        } else{
            this.sexo = sexo;
        }

        if (altura < 1){
            throw new PersonaException("No puedes medir menos de 1 cm");
        } else {
            this.altura = altura;
        }

        if (peso < 1){
            throw new PersonaException("No puedes pesar menos de 1kg");
        }
    }

    public void LocalDate(int year, int month, int day){

        if (  != LocalDate.of(year, month, day)){
            throw new PersonaException("Pon bien su fecha de nacimiento");
        }
    }


}
