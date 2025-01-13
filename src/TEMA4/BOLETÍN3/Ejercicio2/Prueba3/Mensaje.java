package TEMA4.BOLETÍN3.Ejercicio2.Prueba3;

import java.time.LocalDate;

public class Mensaje {
    private String asunto;
    private String cuerpo;
    private LocalDate fechaEnvio;
    private Persona remitente;
    private Persona deatinatario;

    public Mensaje(String asunto, String cuerpo, Persona remitente, Persona deatinatario, LocalDate fechaEnvio) {
        this.asunto = asunto;
        this.cuerpo = cuerpo;
        this.fechaEnvio = LocalDate.now();
        this.remitente = remitente;
        this.deatinatario = deatinatario;
    }
}