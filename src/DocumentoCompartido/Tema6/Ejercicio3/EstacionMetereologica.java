package DocumentoCompartido.Tema6.Ejercicio3;

import java.util.*;
import java.util.stream.Collectors;

public class EstacionMetereologica {
    // Creamos los atributos
    private int id;
    private static int valorId;
    private String ubicacion;
    private double metrosAltitud;
    private Set<Sensor> sensores;

    // Hacemos el constructor
    public EstacionMetereologica(String ubicacion, double metrosAltitud) {
        this.id = ++valorId;
        this.ubicacion = ubicacion;
        this.metrosAltitud = metrosAltitud;
        this.sensores = new HashSet<>();
    }

    // Hacemos un get y set
    public int getId() {
        return id;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public double getMetrosAltitud() {
        return metrosAltitud;
    }

    public Set<Sensor> getSensores() {
        return sensores;
    }

    // Hacemos un equals
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EstacionMetereologica that = (EstacionMetereologica) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    // Hacemos un toString
    @Override
    public String toString() {
        return String.format("ID: %d, Ubicación: %s, Metros altitud: %f, Sensores: %s", this.id, this.ubicacion,
                this.metrosAltitud, this.sensores);
    }

    // Hacemos un método para instalar un sensor
    public void instalarSensor(Sensor sensor) throws EstacionException {
        if (!sensores.add(sensor)) {
            throw new EstacionException("El sensor ya está instalado");
        }
    }

    // Hacemos un método para eliminar un sensor
    public void eliminarSensor(Sensor sensor) throws EstacionException {
        if (!sensores.remove(sensor)) {
            throw new EstacionException("El sensor no está registrado");
        }
    }

    // Hacemos un método para añadir una medición a un sensor concreto
    public void registrarMedicion(Sensor sensor, Medicion medicion) throws EstacionException {
        if (!sensores.contains(sensor)) {
            throw new EstacionException("El sensor no está registrado");
        }
        sensor.getMediciones().add(medicion);
    }

    // Hacemos un método para obtener una lista de las mediciones de un sensor ordenado por la fecha
    public List<Medicion> mostrarMediciones(Sensor sensor) throws EstacionException {
        if (!sensores.contains(sensor)) {
            throw new EstacionException("El sensor no está registrado");
        }
        return Optional.of(sensor.getMediciones().stream()
                        .sorted((m1, m2) -> {
                            if (m1.getFechaMuestra().isAfter(m2.getFechaMuestra())) {
                                return -1;

                            } else if (m1.getFechaMuestra().isBefore(m2.getFechaMuestra())) {
                                return 1;

                            } else {
                                return 0;
                            }
                        }).toList())
                .filter(l -> !l.isEmpty()).orElseThrow(() -> new EstacionException("El sensor está vacío"));
    }

    // Hacemos un método para calcular las N primeras mediciones de un sensor concreto
    public Double calcularMediaMediciones(Sensor sensor, int n) throws EstacionException {
        if (!sensores.contains(sensor)) {
            throw new EstacionException("El sensor no está registrado");
        }
        if (n < 1 || n > sensor.getMediciones().size()) {
            throw new EstacionException("La n no puede ser menor a 1 ni mayor a la cantidad de sensores que hay");
        }
        List<Medicion> medicionList = new ArrayList<>(sensor.getMediciones());
        medicionList.reversed();
        return medicionList.stream().limit(n)
                .mapToDouble(Medicion::getValorRegistrado).average()
                .orElseThrow(() -> new EstacionException("No hay mediciones"));
    }

    // Hacemos un método para trasferir un sensor a otra estación
    public void transferirSensor(EstacionMetereologica estacionMetereologica, Sensor sensor) throws EstacionException {
        if (!this.sensores.contains(sensor)) {
            throw new EstacionException("La estación no tiene el sensor");
        }
        if (Math.abs(this.metrosAltitud - estacionMetereologica.metrosAltitud) > 50) {
            throw new EstacionException("Las estaciones no tienen los mismos metros de altitud");
        }
        this.sensores.remove(sensor);
        estacionMetereologica.getSensores().add(sensor);
    }

    // Hacemos un método que va a devolver un mapa con todos los sensores y la media, max y min valor de cada sensor
    public Map<Sensor, String> informeSensor() {
        return this.sensores.stream().sorted(Comparator.comparing(s -> s.getTipo().name()))
                .collect(Collectors.toMap(s -> s, s -> {
                    try {
                        return "Media: " + s.calcularMedia() + " Max: " + s.obtenerMax() + " Min: " + s.obtenerMin();

                    } catch (EstacionException e) {
                        throw new RuntimeException(e.getMessage());
                    }
                }, (v1, v2) -> v1, LinkedHashMap::new));
    }
}