package DocumentoCompartido.Tema6.Ejercicio3;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

public class EstacionMeteorologica {

    private int idUnico;
    private String ubicacion;
    private int altitudMetros;
    private Set<Sensor> sensoresInstalados;

    public EstacionMeteorologica(int idUnico, String ubicacion, int altitudMetros) {
        this.idUnico = idUnico;
        this.ubicacion = ubicacion;
        this.altitudMetros = altitudMetros;
        sensoresInstalados = new HashSet<>();
    }

    public int getIdUnico() {
        return idUnico;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public int getAltitudMetros() {
        return altitudMetros;
    }

    public Set<Sensor> getSensoresInstalados() {
        return sensoresInstalados;
    }

    public boolean instalarNuevoSensor(Sensor sensorAAnnadir) {

        return sensoresInstalados.add(sensorAAnnadir);
    }

    public boolean sensorAEliminar(Sensor sensorAEliminar) {

        return sensoresInstalados.remove(sensorAEliminar);
    }

    public void registrarNuevaMedicion(Sensor sensor, LocalDateTime fechaYHoraMedicion, Integer valorMedicion) throws RedEstacionesMeteorologicasException {

        if (!sensoresInstalados.contains(sensor)) {
            throw new RedEstacionesMeteorologicasException("El sensor no existe entre los actuales");
        }

        sensor.registrarMedicion(fechaYHoraMedicion, valorMedicion);
    }

    public String obtenerHistoricoDeMedicionesDeUnSensor(Sensor sensor) throws RedEstacionesMeteorologicasException {

        return sensor.obtenerHistoricoDeMediciones();
    }

    public double calcularMediaDeUltimasNMedicionesDeSensor(Sensor sensor, int numMedicionesDeseadas) throws RedEstacionesMeteorologicasException {

        return sensor.calcularMediaDeUltimasNMediciones(numMedicionesDeseadas);
    }

    // Hacemos un metodo que va a devolver un mapa con todos los sensores y la media, max y min valor de cada sensor
    public Map<Sensor, String> informeSensor() {
        return this.sensoresInstalados.stream()
                .sorted(Comparator.comparing(s -> s.getTipoSensor().name()))
                //CONVERTIMOS EL SET DE SENSOR A UN MAP
                //la 1a s es el sensor como entra
                // la segunda 2 es la clave del Map, que en este caso es el propio sensor que entra
                // la tercera son los valores del Map, que van a comtener los que indica dentro de -> {...}
                .collect(Collectors.toMap(s -> s, s -> {
                    //como valor del nuevo Map tendremos un String con la media, el max y el min de las mediciones
                    try {
                        return "Media: " + s.calcularMediaMediciones() + " Max: " + s.calcularMaxMediciones() + " Min: " + s.calcularMinMediciones();

                    } catch (RedEstacionesMeteorologicasException e) {
                        throw new RuntimeException(e.getMessage());
                    }
                }, (v1, v2) -> v1, LinkedHashMap::new));
    }

    public String generarInformeEXTREMO() {
        StringBuilder informe = new StringBuilder();

        sensoresInstalados.stream()
                .sorted(Comparator.comparing(Sensor::getTipoSensor)) // Ordenar por tipo
                .collect(Collectors.groupingBy(Sensor::getTipoSensor, LinkedHashMap::new, Collectors.toList())) // Agrupar
                .forEach((tipo, sensores) -> {
                    informe.append("Tipo de Sensor: ").append(tipo).append("\n");

                    for (Sensor sensor : sensores) {
                        List<Integer> mediciones = new ArrayList<>(sensor.getRegistroMediciones().values());

                        int min = mediciones.stream().min(Integer::compareTo).orElse(0);
                        int max = mediciones.stream().max(Integer::compareTo).orElse(0);
                        double media = mediciones.stream().mapToInt(i -> i).average().orElse(0.0);

                        informe.append("\tSensor ID: ").append(sensor.getCodigoUnico())
                                .append(" | Min: ").append(min)
                                .append(" | Max: ").append(max)
                                .append(" | Media: ").append(String.format("%.2f", media))
                                .append("\n");
                    }
                });

        return informe.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EstacionMeteorologica that = (EstacionMeteorologica) o;
        return idUnico == that.idUnico;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(idUnico);
    }
}
