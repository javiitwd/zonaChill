package DocumentoCompartido.Tema6.Ejercicio3;

import java.time.LocalDateTime;
import java.util.*;

public class Sensor {

    private int codigoUnico;
    private TtipoSensor tipoSensor;
    // Representa un historico de mediciones, la clave sera la fecha en la que se hizo la medicion
    // y los valores de tipo Integer el valor que se registro en la medicion
    private Map<LocalDateTime, Integer> registroMediciones;

    public Sensor(int codigoUnico, TtipoSensor tipoSensor) {
        this.codigoUnico = codigoUnico;
        this.tipoSensor = tipoSensor;
        registroMediciones = new HashMap<>();
    }

    public int getCodigoUnico() {
        return codigoUnico;
    }

    public TtipoSensor getTipoSensor() {
        return tipoSensor;
    }

    public Map<LocalDateTime, Integer> getRegistroMediciones() {
        return registroMediciones;
    }

    public void registrarMedicion(LocalDateTime fechaYHora, Integer valorMedicion) {

        registroMediciones.put(fechaYHora, valorMedicion);
    }

    public String obtenerHistoricoDeMediciones() throws RedEstacionesMeteorologicasException {

        if (registroMediciones.isEmpty()) {
            throw new RedEstacionesMeteorologicasException("No hay mediciones");
        }
        return registroMediciones.entrySet().stream()
                //Cogemos cada medicion (conjunto clave-valor) y la ordenamos segun los valores del mapa
                .sorted(Comparator.comparing(Map.Entry<LocalDateTime, Integer>::getKey))
                .toString();
    }

    public double calcularMediaDeUltimasNMediciones(int numMedicionesDeseadas) throws RedEstacionesMeteorologicasException {

        //convertimos en treeMap() para poder acceder a al metodo .descendingMap(), que le da la vuelta al Map()
        TreeMap<LocalDateTime, Integer> medicionesAlReves = new TreeMap<>(registroMediciones);

        return medicionesAlReves.descendingMap().values().stream()
                .limit(numMedicionesDeseadas)
                //para sacar la media necesitamos usar .average() que a su vez necesita que el flujo sea numerico
                //por eso usamos .mapToInt(), ya que sino el sistema se raya
                .mapToInt(i -> i)
                .average()
                .orElseThrow(() -> new RedEstacionesMeteorologicasException("Ha ocurrido un erroe al calcular la media"));
    }

    public double calcularMediaMediciones() throws RedEstacionesMeteorologicasException {

        return getRegistroMediciones().values().stream()
                .mapToInt(m -> m)
                .average()
                .orElseThrow(() -> new RedEstacionesMeteorologicasException("Error al calcular la media"));
    }

    public double calcularMaxMediciones() throws RedEstacionesMeteorologicasException {

        return getRegistroMediciones().values().stream()
                .mapToInt(m -> m)
                .max()
                .orElseThrow(() -> new RedEstacionesMeteorologicasException("Error al calcular la media"));
    }

    public double calcularMinMediciones() throws RedEstacionesMeteorologicasException {

        return getRegistroMediciones().values().stream()
                .mapToInt(m -> m)
                .min()
                .orElseThrow(() -> new RedEstacionesMeteorologicasException("Error al calcular la media"));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sensor sensor = (Sensor) o;
        return codigoUnico == sensor.codigoUnico;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(codigoUnico);
    }
}
