package TEMA6.Examenes.examen_colecciones2023stream;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class Jugador {
    private String nombre;
    private TDemarcacion demarcacion;
    private LocalDate fechaNacimiento;
    private String paisNacimiento;


    public Jugador(String nombre, TDemarcacion demarcacion, LocalDate fechaNacimiento, String paisNacimiento) {
        super();
        this.nombre = nombre;
        this.demarcacion = demarcacion;
        this.fechaNacimiento = fechaNacimiento;
        this.paisNacimiento = paisNacimiento;
    }

    public String getNombre() {
        return nombre;
    }

    public TDemarcacion getDemarcacion() {
        return demarcacion;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public String getPaisNacimiento() {
        return paisNacimiento;
    }

    public int calcularEdad() {

        LocalDate fechaActual = LocalDate.now();

        Period periodo = Period.between(fechaNacimiento, fechaActual);
        int edad = periodo.getYears();

        return edad;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Jugador jugador = (Jugador) o;
        return Objects.equals(nombre, jugador.nombre) && Objects.equals(fechaNacimiento, jugador.fechaNacimiento);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, fechaNacimiento);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(nombre).append(": ");

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        sb.append(fechaNacimiento.format(formatter)).append(". ")
                .append(demarcacion).append(" (").append(paisNacimiento).append(")");

        return sb.toString();
    }
}
