package TEMA4.BOLETÍN3.Ejercicio2;

public class Mensajeria_App {
    public static void main(String[] args) {
        Persona personaA = new Persona("Maria");
        Persona personaB = new Persona("Antoñito");

        // Intentamos enviar varios mensajes
        try {
            personaA.enviarMensaje("Felicitaciones Navidad 1","Te deseo feliz navidad 1",personaB);
            personaA.enviarMensaje("Felicitaciones Navidad 2","Te deseo feliz navidad 2",personaB);
            personaA.enviarMensaje("Felicitaciones Navidad 3","Te deseo feliz navidad 3",personaB);
            personaA.enviarMensaje("Felicitaciones Navidad 4","Te deseo feliz navidad 4",personaB);
            personaA.enviarMensaje("Felicitaciones Navidad 5","Te deseo feliz navidad 5",personaB);
            personaA.enviarMensaje("Mensaje que no llega al buzon","Este mensaje no entra",personaB);
        } catch (MensajeException e) {
            System.out.println(e.getMessage());
        }

        // Array de mensajes para recuperar los mensajes recibidos de la personaB
        Mensaje [] mensajesRecibidos = personaB.getMensajeRecibidos();

        System.out.println("A continuacion se muestran todos los mensajes recibidos por personaB: "+personaB.getNombre()+":");

        // ¿Como hacer esto con toString?
        for (int i = 0; (i < mensajesRecibidos.length); i++) {
            System.out.printf("El asunto es: %s \n" +
                    "El cuerpo contiene: %s \n" +
                    "El destinatario es: %s \n" +
                    "El remitente es: %s \n" +
                    "La fecha de envio es %s",mensajesRecibidos[i].getAsunto(),mensajesRecibidos[i].getCuerpo(),mensajesRecibidos[i].getDestinatario().getNombre(),mensajesRecibidos[i].getRemitente().getNombre(),mensajesRecibidos[i].getFechaEnvio());
            System.out.println();
        }

        // Intentamos borrar los mensajes 5 y 1+ para probar la exception
        try {
            personaB.borrarMensajeRecibidoMasAntiguo();
            personaB.borrarMensajeRecibidoMasAntiguo();
            personaB.borrarMensajeRecibidoMasAntiguo();
            personaB.borrarMensajeRecibidoMasAntiguo();
            personaB.borrarMensajeRecibidoMasAntiguo();
            personaB.borrarMensajeRecibidoMasAntiguo();
        } catch (MensajeException e) {
            System.out.println(e.getMessage());
        }

    }
}
