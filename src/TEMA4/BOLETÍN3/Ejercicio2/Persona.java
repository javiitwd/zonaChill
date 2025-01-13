package TEMA4.BOLETÍN3.Ejercicio2;

public class Persona {
    private String nombre;
    private Mensaje[] mensajeRecibidos;
    private Mensaje[] mensajeEnviados;
    private static final int TAM_BUZON = 5;

    public Persona(String nombre) {
        this.nombre = nombre;
        this.mensajeRecibidos = new Mensaje[TAM_BUZON];
        this.mensajeEnviados = new Mensaje[TAM_BUZON];
    }

    public String getNombre() {
        return nombre;
    }

    public Mensaje[] getMensajeRecibidos() {
        return mensajeRecibidos;
    }

    public Mensaje[] getMensajeEnviados() {
        return mensajeEnviados;
    }

    public void enviarMensaje(String asunto, String cuerpo, Persona destinatario) throws MensajeException {
        if (asunto.isBlank() || cuerpo.isBlank()) {
            throw new MensajeException("El cuerpo el asunto o el cuerpo no puede estar vacío");
        }
        assert destinatario != null : "El destinatario no puede ser null"; // Esto en producción no pasa (hay que realizar la validacion)

        if (destinatario == this) {
            throw new MensajeException("No puedes enviarte un mensaje a ti mismo");
        }

        /* Si la bandeja de mensajes enviados esta llena o la bandeja de mensajes recibidos de destinatio esta llena
        no se puede enviar el mensaje */
        if (cuentaMensajes(mensajeEnviados) == TAM_BUZON || cuentaMensajes(destinatario.mensajeRecibidos) == TAM_BUZON) {
            throw new MensajeException("No puedes enviar el mensaje, porque la bandeja de mensajes enviados esta llena o\n" +
                    "la bandeja de mensajes recibidos del destinario esta llena");
        }

        boolean encontradoNullMensajeRecibidos = false;
        boolean encontradoNullMensajeEnviado = false;
        Mensaje mensaje = new Mensaje(asunto, cuerpo, this, destinatario);

        for (int i = 0; i < TAM_BUZON; i++) {
            if (destinatario.mensajeRecibidos[i] == null && !encontradoNullMensajeRecibidos) {
                destinatario.mensajeRecibidos[i] = mensaje;
                encontradoNullMensajeRecibidos = true;
            }

            if (mensajeEnviados[i] == null && !encontradoNullMensajeEnviado) {
                mensajeEnviados[i] = mensaje;
                encontradoNullMensajeEnviado = true;
            }
        }
    }

    public void borrarMensajeEnviadoMasAntiguo() throws MensajeException {
        if (cuentaMensajes(mensajeEnviados) == 0) {
            throw new MensajeException("El buzon de mensajes enviados está vacio, no se pueden borrar mensajes");
        }
        borrarMensaje(mensajeEnviados);
    }

    public void borrarMensajeRecibidoMasAntiguo() throws MensajeException {
        if (cuentaMensajes(mensajeRecibidos) == 0) {
            throw new MensajeException("El buzon de mensajes recibidos está vacio, no se pueden borrar mensajes");
        }
        borrarMensaje(mensajeRecibidos);
    }

    /**
     * Este metodo borra el ultimo mensaje del buzon que se le pase por parametro
     *
     * @param buzon se refiere al buzon sobre el que se borra el ultimo mensaje
     */
    private static void borrarMensaje(Mensaje[] buzon) {
         /* Nos hemos dado cuenta que esta operacion no es necesaria pero la dejamos
           para comentarla en clase */
        buzon[0] = null; // Igualo a null la posicion 0 para borrarla
        for (int i = 0; i < buzon.length - 1; i++) {
            buzon[i] = buzon[i + 1];
        }
        buzon[TAM_BUZON - 1] = null;
    }

    /**
     * Este metodo es general para ambos buzones y sirve para contar los mensajes segun se requiera
     *
     * @param buzon array de mensaje que puede ser (mensajeRecibidos / mensajeEnviados)
     * @return devuelve un entero con los mensajes que existen en la bandeja
     */
    private static int cuentaMensajes(Mensaje[] buzon) {
        for (int i = 0; i < buzon.length; i++) {
            if (buzon[i] == null) {
                return i;
            }
        }
        // Se retorna TAM_BUZON porque se cosidera que si no hay null es que la bandeja esta llena osea se devuelve 5
        return TAM_BUZON;
    }
}