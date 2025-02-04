package TEMA6.Boletín1.Ejercicio3;

public class Alumno extends Persona {

    public Alumno(String nombre, int edad) {
        super(nombre, edad);
    }

    @Override
    public void enviarMensaje(Persona destinatario, String textoMensaje) throws MensajeriaException {

        if (this.equals(destinatario)){
            throw new MensajeriaException("No puede enviarse mensajes a si mismo");
        }

        if (this.getEdad() < 18 && !(destinatario instanceof Profesor)) {
            throw new MensajeriaException("No puede enviar este mensaje");
        }

        Mensaje msj = new Mensaje(this, textoMensaje);
        destinatario.getBuzonEntrada().add(msj);
    }
}
