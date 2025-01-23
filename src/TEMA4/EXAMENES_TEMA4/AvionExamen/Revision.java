package TEMA4.EXAMENES_TEMA4.AvionExamen;

import java.time.LocalDate;
import java.time.Period;

public class Revision {
    private LocalDate fecha;
    private boolean estado;
    private Period periodoDeValidez;

    public Revision(LocalDate fecha, boolean estado, Period periodoDeValidez) {
        this.fecha = fecha;
        this.estado = estado;
        this.periodoDeValidez = periodoDeValidez;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public boolean isEstado() {
        return estado;
    }

    public Period getPeriodoDeValidez() {
        return periodoDeValidez;
    }
}
