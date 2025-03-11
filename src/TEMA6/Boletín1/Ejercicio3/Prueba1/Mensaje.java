package TEMA6.Boletín1.Ejercicio3.Prueba1;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Mensaje implements Comparable<Mensaje>{
    private Persona remitente;
    private String textoMensaje;
    private LocalDateTime fechaDeEnvio;

    public Mensaje(Persona remitente, String textoMensaje) {
        this.remitente = remitente;
        this.textoMensaje = textoMensaje;
        this.fechaDeEnvio = LocalDateTime.now();
    }

    public Persona getRemitente() {
        return remitente;
    }

    public void setRemitente(Persona remitente) {
        this.remitente = remitente;
    }

    public String getTextoMensaje() {
        return textoMensaje;
    }

    public void setTextoMensaje(String textoMensaje) {
        this.textoMensaje = textoMensaje;
    }

    public LocalDateTime getFechaDeEnvio() {
        return fechaDeEnvio;
    }

    public void setFechaDeEnvio(LocalDateTime fechaDeEnvio) {
        this.fechaDeEnvio = fechaDeEnvio;
    }



    @Override
    public String toString() {
        return "De: " +remitente.getNombre()+ " Texto: " +textoMensaje+ " Fecha y hora: " +fechaDeEnvio.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm "));
    }

    @Override
    public int compareTo(Mensaje o) {
        //Comparo el nombre del remitente de este mensaje con el nombre del remitente del otro mensajes
        return this.remitente.getNombre().compareTo(o.getRemitente().getNombre());
    }
}
