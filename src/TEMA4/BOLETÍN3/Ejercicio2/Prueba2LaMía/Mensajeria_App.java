package TEMA4.BOLETÍN3.Ejercicio2.Prueba2LaMía;

public class Mensajeria_App {
    public static void main(String[] args) {

        Persona remitente = new Persona("Katchan");
        Persona destinatario = new Persona("Deku");

        try {
            remitente.enviarMensaje("Vas a morir", "Shineeee!!!", destinatario);
            remitente.enviarMensaje("Vas a morir", "Shineeee!!!", destinatario);
            remitente.enviarMensaje("Vas a morir", "Shineeee!!!", destinatario);
            remitente.enviarMensaje("Vas a morir", "Shineeee!!!", destinatario);
            remitente.enviarMensaje("Vas a morir", "Shineeee!!!", destinatario);
            remitente.enviarMensaje("Vas a morir", "Shineeee!!!", destinatario);
        } catch (MensajeriaException e) {
            System.out.println(e.getMessage());
        }
        try {
            remitente.borrarMensajeRecibidoMasAntiguo();
            remitente.borrarMensajeRecibidoMasAntiguo();
            System.out.println("Mensaje borrado con exito");
        } catch (MensajeriaException e) {
            System.out.println(e.getMessage());
        }

    }
}
