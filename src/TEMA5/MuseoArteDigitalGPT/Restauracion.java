package TEMA5.MuseoArteDigitalGPT;

import java.time.LocalDate;

public class Restauracion {

    private LocalDate fechaModificacion;
    private String motivo;

    public Restauracion(LocalDate fechaModificacion, String motivo) {
        this.fechaModificacion = fechaModificacion;
        this.motivo = motivo;
    }

    public LocalDate getFechaModificacion() {
        return fechaModificacion;
    }

    public void setFechaModificacion(LocalDate fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }
}
