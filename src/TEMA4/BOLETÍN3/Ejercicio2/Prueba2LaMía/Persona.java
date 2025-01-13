package TEMA4.BOLETÍN3.Ejercicio2.Prueba2LaMía;

public class Persona {
    public static final int TAM_BUZON = 5;

    private String nombre;
    private Mensaje[] mensajesRecibidos;
    private Mensaje[] mensajesEnviados;

    public Persona(String nombre) {

        this.nombre = nombre;
        this.mensajesEnviados = new Mensaje[TAM_BUZON];
        this.mensajesRecibidos = new Mensaje[TAM_BUZON];
    }

    public void enviarMensaje(String asunto, String cuerpo, Persona destinatario) throws MensajeriaException {

        //Compruebo que el mensaje tiene los requisistos pedidos
        if (asunto.isBlank() || cuerpo.isBlank() || destinatario == null) {
            throw new MensajeriaException("Algun campo está vacío");
        }

        //Compruebo si mi buzon de envio no está lleno
        if (cuentaMensajesEnviados() >= TAM_BUZON) {
            throw new MensajeriaException("Su buzón está lleno");
        }

        //Compruebo si el buzon de entrada del destinatario no esta lleno
        if (destinatario.cuentaMensajesRecibidos() >= TAM_BUZON) {
            throw new MensajeriaException("El buzón del destinatario está lleno");
        }

        //Si pasa los filtros en la posicion actual meto el mensaje
        mensajesEnviados[cuentaMensajesEnviados()] = new Mensaje(asunto, cuerpo, this, destinatario);

        //Tambien añado el mensaje al buzon del destinatario
        destinatario.mensajesRecibidos[destinatario.cuentaMensajesRecibidos()] = new Mensaje(asunto, cuerpo, this, destinatario);
    }

    public int cuentaMensajesEnviados() {
        //Recorro los mensajes y cada vez que no sea null (hay un mensaje) aumento el contador
        int contadorMensajesEnviados = 0;
        for (int i = 0; i < mensajesEnviados.length; i++) {
            if (mensajesEnviados[i] != null) {
                contadorMensajesEnviados++;
            }
        }
        return contadorMensajesEnviados;
    }

    public int cuentaMensajesRecibidos() {
        //Recorro los mensajes y cada vez que no sea null (hay un mensaje) aumento el contador
        int contadorMensajesRecibidos = 0;
        for (int i = 0; i < mensajesEnviados.length; i++) {
            if (mensajesEnviados[i] != null) {
                contadorMensajesRecibidos++;
            }
        }
        return contadorMensajesRecibidos;
    }

    public void borrarMensajeEnviadoMasAntiguo() throws MensajeriaException {

        if (cuentaMensajesEnviados() == 0) {
            throw new MensajeriaException("El buzón ya está vacío");
        }
        mensajesEnviados[0] = null;

        for (int i = 0; i < mensajesEnviados.length; i++) {
            Mensaje temporal = mensajesEnviados[i];
            mensajesEnviados[i] = mensajesEnviados[i + 1];
            mensajesEnviados[i + 1] = temporal;
        }
    }

    public void borrarMensajeRecibidoMasAntiguo() throws MensajeriaException {

        if (cuentaMensajesRecibidos() == 0) {
            throw new MensajeriaException("El buzón ya está vacío");
        }
        mensajesRecibidos[0] = null;

        for (int i = 0; i < mensajesRecibidos.length - 1; i++) {
            Mensaje temporal = mensajesRecibidos[i];
            mensajesRecibidos[i] = mensajesRecibidos[i + 1];
            mensajesRecibidos[i + 1] = temporal;
        }
    }
}
