package TEMA4.BOLETÍN3.Ejercicio2.Prueba2LaMía;

import java.time.LocalDate;

public class Mensaje {
    private String asunto;
    private String cuerpo;
    private LocalDate fechaEnvio;
    private Persona remitente;
    private Persona destinatario;

    public Mensaje(String asunto, String cuerpo, Persona remitente, Persona destinatario) {
        this.asunto = asunto;
        this.cuerpo = cuerpo;
        this.fechaEnvio = LocalDate.now();
        this.remitente = remitente;
        this.destinatario = destinatario;
    }
}
