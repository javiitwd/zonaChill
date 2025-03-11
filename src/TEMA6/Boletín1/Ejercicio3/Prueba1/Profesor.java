package TEMA6.Boletín1.Ejercicio3.Prueba1;

public class Profesor extends Persona {

    public Profesor(String nombre, int edad) {
        super(nombre, edad);
    }

    @Override
    public void enviarMensaje(String textoMensajeAEnviar, Persona destinatario) {
        //Creo el mensaje
        Mensaje mensajeAEnviar = new Mensaje(this, textoMensajeAEnviar);
        //Lo añado al buzon del destinatario
        destinatario.getBuzonDeMensajes().add(mensajeAEnviar);
    }
}
