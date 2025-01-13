package TEMA4.BOLETÍN3.Ejercicio2.Prueba3;

public class MensajeriaApp {
    public static void main(String[] args) {

        try {
            Persona remitente = new Persona("Angelito");
            Persona destinatario = new Persona("Antoñito");

            remitente.enviarMensaje("Hola :) ", "Podriamos quedar...", destinatario);
            remitente.enviarMensaje("Hola :) ", "Estas ahi?...", destinatario);
            remitente.enviarMensaje("Hola :) ", "Quiero el bocadillo", destinatario);
            remitente.enviarMensaje("Hola :) ", "Nena xula", destinatario);
            remitente.enviarMensaje("Hola :) ", "Porfavooor", destinatario);
            remitente.borrarMensajeMasEnviadoAntiguo();
            System.out.println("Mensaje del remitente borrado con exito");
            destinatario.borrarMensajeMasEnviadoAntiguo();
            System.out.println("Mensaje del destinatario borrado con exito");
            destinatario.borrarMensajeMasEnviadoAntiguo();
            System.out.println("Mensaje del destinatario borrado con exito");

            remitente.enviarMensaje("Hola :) ", "Podriamos quedar...", destinatario);
            System.out.println("Mensaje enviado con exito");
        } catch (MensajeriaException e) {
            System.out.println(e.getMessage());
        }
    }
}