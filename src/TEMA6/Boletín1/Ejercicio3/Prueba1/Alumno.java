package TEMA6.Boletín1.Ejercicio3.Prueba1;

public class Alumno extends Persona {

    public Alumno(String nombre, int edad) {
        super(nombre, edad);
    }

    @Override
    public void enviarMensaje(String textoMensajeAEnviar, Persona destinatario) throws MensajesException {
        //Comprobamos que se cumplen los requisitos para mandar mensajes
        if (getEdad() < 18 && destinatario instanceof Alumno) {
            throw new MensajesException("No puede enviar este mensaje ya que el alumno es menor de 18 y el destinatario otro alumno");
        }
        //Creamos el mensaje
        Mensaje mensajeAEnviar = new Mensaje(this, textoMensajeAEnviar);
        //Lo añadimos al buzon del destinatario
        destinatario.getBuzonDeMensajes().add(mensajeAEnviar);
    }
}
