package TEMA7.boletin3.ejercicio1;

import java.time.LocalDate;

public class Persona {
    private String nombre;
    private String dni;
    private String phone;
    private LocalDate fechaNacimiento;

    public Persona(String nombre, String dni, String phone, LocalDate fechaNacimiento) {
        this.nombre = nombre;
        this.dni = dni;
        this.phone = phone;
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDni() {
        return dni;
    }

    public String getPhone() {
        return phone;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }
}
