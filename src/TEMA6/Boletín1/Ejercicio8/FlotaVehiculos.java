package TEMA6.Boletín1.Ejercicio8;

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

    public String listadoDeVehiculosOrdenadosPorMatricula() throws VehiculoException {

        //Si no hay vehiculos lanzamos excepcion
        if (vehiculos.isEmpty()) {
            throw new VehiculoException("No hay vehiculos en el almacen");
        }

        //Creamos una lista con los valores de los vehiculos
        List<Vehiculo> listaDeVehiculos = new ArrayList<>(vehiculos.values());

        //Ordeno la listaDeVehiculos por su matricula
        listaDeVehiculos.sort(Comparator.comparing(Vehiculo::getMatricula));

        //Creo un StringBuilder para devolver el String de los vehiculos
        StringBuilder vehiculosString = new StringBuilder();

        //Recorro la listaDeVehiculos y añado el vehiculo.toString()
        for (Vehiculo vehiculo : listaDeVehiculos) {
            vehiculosString.append(vehiculo.toString()).append(System.lineSeparator());
        }
        return vehiculosString.toString();
    }

    public String listadoDeFurgonetasOrdenadasPorPMA() throws VehiculoException {

        if (vehiculos.isEmpty()) {
            throw new VehiculoException("No hay vehiculos en el almacen");
        }

        //Creo una lista de tipo Furgoneta para añadir los vehiculos que sean Furgoneta
        List<Furgoneta> listadoDeFurgonetas = new ArrayList<>();

        //Recorro los vehiculos (values)
        for (Vehiculo vehiculo : vehiculos.values()) {

            //Si el vehiculo actual es una Furgoneta le hago un casting y la meto en la lista que hemos creado
            if (vehiculo instanceof Furgoneta) {

                Furgoneta furgoneta = (Furgoneta) vehiculo;
                listadoDeFurgonetas.add(furgoneta);
            }
        }

        //Si la lista que hemos creado esta vacia (no hay furgonetas) lanzamos excepcion
        if (listadoDeFurgonetas.isEmpty()) {
            throw new VehiculoException("No se han encontrado furgonetas");
        }

        //Ordenamos las furgonetas por su PMA (por defecto se crea de menor a mayor asi que podemos usar el reversed)
        listadoDeFurgonetas.sort(Comparator.comparing(Furgoneta::getPma).reversed());

        //Creamos el StringBuilder para mostrar las furgonetas encontradas
        StringBuilder listadoDeFurgonetasString = new StringBuilder();

        for (Furgoneta furgoneta : listadoDeFurgonetas) {
            //Vamos metiendo en el StringBuilder las furgonetas en toString()
            listadoDeFurgonetasString.append(furgoneta.toString()).append(System.lineSeparator());
        }
        return listadoDeFurgonetasString.toString();
    }

    public String listadoDeVhiculosOrnadosPorGama() throws VehiculoException {

        //Si no hay vehiculos lanzamos excepcion
        if (vehiculos.isEmpty()) {
            throw new VehiculoException("No hay vehiculos en el almacen");
        }

        //Creamos una lista con los valores de los vehiculos
        List<Vehiculo> listaDeVehiculos = new ArrayList<>(vehiculos.values());

        //Ordeno la listaDeVehiculos por su matricula
        listaDeVehiculos.sort(Comparator.comparing(Vehiculo::getGama));

        //Creo un StringBuilder para devolver el String de los vehiculos
        StringBuilder vehiculosString = new StringBuilder();

        //Recorro la listaDeVehiculos y añado el vehiculo.toString()
        for (Vehiculo vehiculo : listaDeVehiculos) {
            vehiculosString.append(vehiculo.toString()).append(System.lineSeparator());
        }
        return vehiculosString.toString();
    }

    @Override
    public String toString() {
        return "vehiculos: " + vehiculos;
    }
}
