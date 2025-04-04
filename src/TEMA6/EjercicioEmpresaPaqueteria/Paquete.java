package TEMA6.EjercicioEmpresaPaqueteria;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class Paquete {

    //Paquete con minima prioridad
    public static final int MIN_PRIORIDAD = 1;
    //Paquete con maxima prioridad
    public static final int MAX_PRIORIDAD = 3;

    private int numSeguimiento;
    private String nombreRemitente;
    private String nombreDestinatario;
    private int numPrioridad;
    private int ordenDeInserccion;
    private LocalDateTime fechaLlegada;

    public Paquete(int numSeguimiento, String nombreRemitente, String nombreDestinatario, int numPrioridad) {
        this.numSeguimiento = numSeguimiento;
        this.nombreRemitente = nombreRemitente;
        this.nombreDestinatario = nombreDestinatario;
        this.numPrioridad = numPrioridad;
        ordenDeInserccion = 0;
        fechaLlegada = LocalDateTime.now();
    }

    public int getNumPrioridad() {
        return numPrioridad;
    }

    public int getOrdenDeInserccion() {
        return ordenDeInserccion;
    }

    public void setOrdenDeInserccion(int ordenDeInserccion) {
        this.ordenDeInserccion = ordenDeInserccion;
    }

    /*
    La diferencia entre Duration y Period es que Duration se usa para medir unidades mas pequeñas (horas, min, seg) ->Mejor en LocalDateTime
    Period se usa para medir grantes cantidades de tiempo (dias, meses, años) -> mejor en LocalDate
     */
    public boolean llevaMasDe24hConDuration() {

        /**
         * FORMA MAS CORTA
         * return Duration.between(fechaLlegada, LocalDateTime.now()).toHours() > 24;
         */

        //Guardamos el tiempo transcurrido entre la fecha de llegada y la actual
        Duration tiempoTranscurrido = Duration.between(fechaLlegada, LocalDateTime.now());

        //Guardamos las horas del tiempo transcurrido (como long ya que no acepta int, aunque es lo mismo solo que long guarda mas cantidad de numeros)
        long horasTranscurridas = tiempoTranscurrido.toHours();

        //Devolvemos true/false si han pasado mas de 24h desde que llego el paquete
        return horasTranscurridas > 24;
    }

    public boolean llevaMasDe24hConPeriod() {

        // Convertimos las fechas a LocalDate (sin tiempo) ya que Period solo trabaja con fechas
        Period periodoTranscurrido = Period.between(fechaLlegada.toLocalDate(), LocalDate.now());

        //Si los das transcurridos es 1 o mas (24>=) devolvemos true (lleva mas de 24h) sino se devuelve false
        return periodoTranscurrido.getDays() >= 1;
    }

    @Override
    public String toString() {
        return "Paquete{" +
                "numSeguimiento=" + numSeguimiento +
                ", nombreRemitente='" + nombreRemitente + '\'' +
                ", nombreDestinatario='" + nombreDestinatario + '\'' +
                ", numPrioridad=" + numPrioridad +
                ", ordenDeInserccion=" + ordenDeInserccion +
                ", fechaLlegada=" + fechaLlegada.format(DateTimeFormatter.ofPattern("dd/MM/yyyy.HH:mm")) +
                '}';
    }
}
