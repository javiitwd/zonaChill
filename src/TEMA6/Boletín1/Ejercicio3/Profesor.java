package TEMA6.Boletín1.Ejercicio3;

public class Profesor extends Persona {

    public Profesor(String nombre, int edad) {
        super(nombre, edad);
    }

    @Override
    public void enviarMensaje(Persona destinatario, String textoMensaje) throws MensajeriaException {

        if (this.equals(destinatario)){
            throw new MensajeriaException("No puede enviarse mensajes a si mismo");
        }

        Mensaje msj = new Mensaje(this, textoMensaje);
        destinatario.getBuzonEntrada().add(msj);
    }
}
