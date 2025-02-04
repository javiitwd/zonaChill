package TEMA5.EjercicioInterfaces;

import java.time.LocalDate;

public class Fichero {
    private String nombre;
    private long tamano;
    private LocalDate fechaCreacion;

    public Fichero(String nombre, long tamano) {
        this.nombre = nombre;
        this.tamano = tamano;
        this.fechaCreacion = LocalDate.now();
    }
}
