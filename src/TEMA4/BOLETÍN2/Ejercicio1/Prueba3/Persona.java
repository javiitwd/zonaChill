package TEMA4.BOLETÍN2.Ejercicio1.Prueba3;

import java.time.LocalDate;

public class Persona {
    private String nombre;
    private LocalDate fechaNacimiento;
    private String dni;
    private char sexo;
    private float altura;
    private float peso;

    public Persona(){

    }

    public void setFechaNacimiento (int year, int month, int day){

        fechaNacimiento = LocalDate.of(year, month, day);
    }

    public void setDni(String dni) throws PersonaException{

        if (dni.length() < 8){
            throw new PersonaException("Ponga bien su dni");
        }
    }

    public void setSexoCorrecto(char sexo) throws PersonaException{

        if (sexo != 'm' && sexo !='f'){
            throw new PersonaException("Ponga bien su sexo");
        }
    }

    public void setAltura(float altura) throws PersonaException{
        if (altura < 1){
            throw new PersonaException("No puede medir menos de 1 cm");
        }
        this.altura = altura;
    }

    public void setPeso(float peso) throws PersonaException{
        if (peso < 1){
            throw new PersonaException("No puede pesar menos de 1 kg");
        }
        this.peso = peso;
    }

    public double calcularIMC(){
        return peso/Math.pow(altura, 2);
    }
}
