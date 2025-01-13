package TEMA4.BOLETÍN3.Ejercicio2.Prueba1;

public class Persona {
    public static final int TAM_BUZON = 5;
    public static int cuentaMensajesEnviados = 0;
    public static int cuentaMensajesRecibidos = 0;

    private String nombre;
    private Mensaje[] mensajesRecibidos;
    private Mensaje[] mensajesEnviados;

    public Persona(String nombre) {
        this.nombre = nombre;
        this.mensajesRecibidos = new Mensaje[TAM_BUZON];
        this.mensajesEnviados = new Mensaje[TAM_BUZON];
    }

    public void enviarMensaje(String asunto, String cuerpo, Persona destinatario) throws MensajeriaException {

        if (asunto.isBlank() || cuerpo.isBlank() || destinatario == null) {
            throw new MensajeriaException("El mensaje no está completo");
        }

        if (cuentaMensajesEnviados() >= TAM_BUZON) {
            throw new MensajeriaException("El buzón está lleno");
        }

        // Crear el mensaje
        Mensaje mensaje = new Mensaje(asunto, cuerpo, this, destinatario);
        cuentaMensajesEnviados++;

        //Añado el mensaje al buzon
        mensajesEnviados[cuentaMensajesEnviados()] = mensaje;

        // Agregar al buzón del destinatario
        destinatario.mensajesRecibidos[cuentaMensajesRecibidos()] = mensaje;
    }

    public int cuentaMensajesEnviados() {
        int contadorMensajesEnviados = 0;
        for (int i = 0; i < mensajesEnviados.length; i++) {
            if (mensajesEnviados[i] != null) {
                contadorMensajesEnviados++;
            }
        }
        return contadorMensajesEnviados;
    }

    public int cuentaMensajesRecibidos() {
        int contadorMensajesRecibidos = 0;
        for (int i = 0; i < mensajesRecibidos.length; i++) {
            if (mensajesRecibidos[i] != null) {
                contadorMensajesRecibidos++;
            }
        }
        return contadorMensajesRecibidos;
    }

    public void borrarMensajeEnviadoMasAntiguo() throws MensajeriaException {

        if (cuentaMensajesEnviados == 0) {
            throw new MensajeriaException("No puede borrar mensajes, ya que su buzón está vacío");
        }
        // Borrar el primer mensaje, ya que es el más antiguo
        mensajesEnviados[0] = null;

        // Desplazar los mensajes hacia la izquierda para llenar el hueco
        for (int i = 0; i < mensajesEnviados.length - 1; i++) {
            mensajesEnviados[i] = mensajesEnviados[i + 1];
        }

        // El último mensaje ahora es nulo, lo ponemos a null por claridad
        mensajesEnviados[mensajesEnviados.length - 1] = null;
    }
}
