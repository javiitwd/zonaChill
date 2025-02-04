package TEMA6.Boletín1.Ejercicio3;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Mensaje {

    private Persona remitente;
    private String texto;
    private LocalDateTime fechaYHora;

    public Mensaje(Persona remitente, String texto) {
        this.remitente = remitente;
        this.texto = texto;
        this.fechaYHora = LocalDateTime.now();
    }

    public Persona getRemitente() {
        return remitente;
    }

    public String getTexto() {
        return texto;
    }

    public LocalDateTime getFechaYHora() {
        return fechaYHora;
    }

    @Override
    public String toString() {
        return String.format("De: %s\nTexto: %s\nFecha y hora: %s\n",
                this.remitente.getNombre(), this.texto,
                this.fechaYHora.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm")));
    }
}
