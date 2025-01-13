package TEMA4.BOLETÍN3.Ejercicio2.Prueba3;

import java.time.LocalDate;

public class Persona {
    public static final int MAX_TAM_BUZON = 5;

    private String persona;
    private Mensaje[] mensajesRecibidos;
    private Mensaje[] mensajesEnviados;

    public Persona(String persona) {
        this.persona = persona;
        mensajesRecibidos = new Mensaje[MAX_TAM_BUZON];
        mensajesEnviados = new Mensaje[MAX_TAM_BUZON];
    }

    public void enviarMensaje(String asunto, String cuerpo, Persona destinatario) throws MensajeriaException {

        if (asunto == null || cuerpo == null || destinatario == null) {
            throw new MensajeriaException("Complete los campos antes de enviar");
        }
        if (this.contarMensajesBuzonEnviados() >= 5) {
            throw new MensajeriaException("Su buzón está lleno");
        }
        if (destinatario.contarMensajesBuzonRecibidos() >= 5) {
            throw new MensajeriaException("El buzón de la persona que trata de contactar está lleno");
        }
        if (destinatario.equals(this)) {
            throw new MensajeriaException("No puedes enviarte mensajesa ti mismo");
        }

        Mensaje mensaje = new Mensaje(asunto, cuerpo, this, destinatario, LocalDate.now());

        this.mensajesEnviados[contarMensajesBuzonEnviados()] = mensaje;
        destinatario.mensajesRecibidos[contarMensajesBuzonRecibidos()] = mensaje;
    }

    public int contarMensajesBuzonEnviados() {
        int contador = 0;
        for (int i = 0; i < MAX_TAM_BUZON; i++) {
            if (mensajesEnviados[i] != null) {
                contador++;
            }
        }
        return contador;
    }

    public int contarMensajesBuzonRecibidos() {
        int contador = 0;
        for (int i = 0; i < MAX_TAM_BUZON; i++) {
            if (mensajesRecibidos[i] != null) {
                contador++;
            }
        }
        return contador;
    }

    public void borrarMensajeRecibidoMasAntiguo() throws MensajeriaException {
        if (mensajesRecibidos[0] == null) {
            throw new MensajeriaException("Su buzon ya esta vacio");
        }
        mensajesRecibidos[0] = null;

        for (int i = 0; i < MAX_TAM_BUZON - 1; i++) {

            Mensaje temporal = mensajesRecibidos[i];
            mensajesRecibidos[i] = mensajesRecibidos[i + 1];
            mensajesRecibidos[i+1] = temporal;
        }

        // Poner el último mensaje a null, ya que se ha desplazado
        mensajesRecibidos[MAX_TAM_BUZON - 1] = null;
    }

    public void borrarMensajeMasEnviadoAntiguo() throws MensajeriaException {
        if (mensajesEnviados[0] == null) {
            throw new MensajeriaException("Su buzon ya esta vacio");
        }
        mensajesEnviados[0] = null;

        for (int i = 0; i < MAX_TAM_BUZON - 1; i++) {

            Mensaje temporal = mensajesEnviados[i];
            mensajesEnviados[i] = mensajesEnviados[i + 1];
            mensajesEnviados[i+1] = temporal;
        }

        // Poner el último mensaje a null, ya que se ha desplazado
        mensajesRecibidos[MAX_TAM_BUZON - 1] = null;
    }
}