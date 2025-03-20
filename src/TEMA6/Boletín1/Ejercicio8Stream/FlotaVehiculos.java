package TEMA6.Boletín1.Ejercicio8Stream;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class FlotaVehiculos {

    public static final int CAPACIDAD_MAX_VEHICULOS = 10;

    private HashMap<String, Vehiculo> vehiculos;

    /**
     * Variable que guarda donde se insertará el siguiente vehiculo
     * Empieza con 0 y si vale vehiculos.length el almacen esta lleno
     */
    private int numeroRealDeVehiculos;

    public FlotaVehiculos() throws VehiculoException {

        vehiculos = new HashMap<>();
        numeroRealDeVehiculos = 0;
    }

    public void introducirVehiculo(Vehiculo vehiculo) throws VehiculoException {

        if (numeroRealDeVehiculos >= CAPACIDAD_MAX_VEHICULOS) {
            throw new VehiculoException("No caben más vahículos");
        }
        vehiculos.put(vehiculo.getMatricula(), vehiculo);
        numeroRealDeVehiculos++;
    }

    private Vehiculo buscarMatricula(String matricula) throws VehiculoException {

        //Si el almacen de vehiculos esta vacio lanzamos excepcion
        if (vehiculos.isEmpty()) {
            throw new VehiculoException("No hay vehiculos en el almacen");
        }

        //Sino, recorremos los vehiculos por su matricula (key)
        for (String vehiculo : vehiculos.keySet()) {

            //Si tiene la misma matricula que recibimos por parametro devolvemos el vehiculo con esa matricula
            //no return vehiculo, ya que eso devolveria solo la matricula (key), que es por lo que estamos recorriendo
            if (vehiculo.equalsIgnoreCase(matricula)) {
                return vehiculos.get(matricula);
            }
        }
        throw new VehiculoException("No se ha encontrado el vehiculo");
    }

    public double precioAlquiler(String matricula, int dias) throws VehiculoException {

        if (vehiculos.isEmpty()) {
            throw new VehiculoException("No hay vehiculos en el almacen");
        }
        for (String vehiculo : vehiculos.keySet()) {
            //Guardamos el vehiculos actual
            Vehiculo vehiculoActual = vehiculos.get(vehiculo);

            //Si la matricula del vehiculo coincide con la que hemos recibido por parametro, hemos encontrado el v ehiculo
            if (vehiculo.equalsIgnoreCase(matricula)) {

                //Vamos haciendo castings para identificar que tipo de vehiculo es y asi poder calcular el precio
                if (vehiculoActual instanceof Coche) {
                    Coche coche = (Coche) vehiculoActual;
                    return coche.calcularAlquiler(dias);
                }

                if (vehiculoActual instanceof Furgoneta furgoneta) {
                    return furgoneta.calcularAlquiler(dias);
                }

                if (vehiculoActual instanceof Microbus microbus) {
                    return microbus.calcularAlquiler(dias);
                }
            }
        }
        throw new VehiculoException("No se ha enontrado el coche");
    }

    public List<Vehiculo> listadoDeVehiculosOrdenadosPorMatricula1() {

        return vehiculos.values().stream()
                .sorted(Comparator.comparing(Vehiculo::getMatricula))
                .toList();
    }

    public String listadoDeVehiculosOrdenadosPorMatricula2() {

        return vehiculos.values().stream()
                .sorted(Comparator.comparing(Vehiculo::getMatricula))
                .map(Vehiculo::toString)
                //en la linea de arriba teniamos varios Strings (por cada posicion)
                //con lo de abajo lo convertimos en 1 solo String y entre cada String mete un salto de linea
                //Collectors.joining en sus () defines lo que quieres meter en la concatenacion de .collect()
                .collect(Collectors.joining(System.lineSeparator()));
    }

    public List<Furgoneta> listadoDeFurgonetasOrdenadasPorPMA() throws VehiculoException {

        return vehiculos.values().stream()
                .filter(v -> v instanceof Furgoneta)
                //convertimos con castings el vehiculo a furgoneta
                .map(vehiculo -> (Furgoneta) vehiculo)
                .sorted(Comparator.comparingInt(Furgoneta::getPma).reversed())
                .toList();

    }

    public List<Vehiculo> listadoDeVhiculosOrnadosPorGama() throws VehiculoException {

        return vehiculos.values().stream()
                //Si queremos por orden Alta->Media->Baja tendriamos que poner en ese orden los valores del Enum
                // ordena los vehículos según el precio base de su gama
                .sorted(Comparator.comparing(v -> v.getGama().getPrecioBasePorGama()))
                .toList();
    }

    @Override
    public String toString() {
        return "vehiculos: " + vehiculos;
    }
}
