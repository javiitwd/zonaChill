package TEMA6.Boletín1.Ejercicio3;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Mensaje implements Comparable<Mensaje> {
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
    /**
     * this mensaje actual
     *
     * @param o mensaje con el que se va a comprar,
     *          que es el posterior a este
     * @return devuelve <0 si el primero va antes
     * >0 si va después, y 0 si son iguales
     * entonces internamente, te lo ordena
     * según lo que hemos nombrado
     */
    @Override
    public int compareTo(Mensaje o) {
        return this.getRemitente().getNombre().compareTo(o.getRemitente().getNombre());
    }
}
