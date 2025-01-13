package TEMA4.BOLETÍN3.Ejercicio2.Prueba1;

public class Mensajeria_App {
    public static void main(String[] args) throws MensajeriaException {

        Persona remitente = new Persona("juan");
        Persona destinatario = new Persona("carlos");

        try {
            remitente.enviarMensaje("Me gusta tu hermana", "Lo siento bro", destinatario);
            remitente.enviarMensaje("Me gusta tu hermana", "Lo siento bro", destinatario);
            remitente.enviarMensaje("Me gusta tu hermana", "Lo siento bro", destinatario);
            remitente.enviarMensaje("Me gusta tu hermana", "Lo siento bro", destinatario);
            remitente.enviarMensaje("Me gusta tu hermana", "Lo siento bro", destinatario);
            remitente.enviarMensaje("Me gusta tu hermana", "Lo siento bro", destinatario);
        } catch (MensajeriaException e) {
            System.out.println(e.getMessage());
        }

        try {
            remitente.borrarMensajeEnviadoMasAntiguo();
            System.out.println("Mensaje borrado con éxito");
        } catch (MensajeriaException e) {
            System.out.println(e.getMessage());
        }
    }
}
