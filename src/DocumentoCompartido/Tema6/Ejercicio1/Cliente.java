package DocumentoCompartido.Tema6.Ejercicio1;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Cliente {

    private String nombre;
    private int idCliente;
    private Map<String, Ruta> rutasAsignadas;

    public Cliente(String nombre, int idCliente) {
        this.nombre = nombre;
        this.idCliente = idCliente;
        rutasAsignadas = new HashMap<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public Map<String, Ruta> getRutasAsignadas() {
        return rutasAsignadas;
    }

    public void setRutasAsignadas(Map<String, Ruta> rutasAsignadas) {
        this.rutasAsignadas = rutasAsignadas;
    }

    public void annadirRutaACliente(Ruta rutaAAnnadir) throws AgenciaViajesException {

        if (!rutasAsignadas.containsKey(rutaAAnnadir.getNombre())) {
            rutasAsignadas.put(rutaAAnnadir.getNombre(), rutaAAnnadir);
            return;
        }

        throw new AgenciaViajesException("Ya tiene la ruta");
    }

    public void eliminarRutaACliente(Ruta rutaAEliminar) throws AgenciaViajesException {

        if (rutasAsignadas.containsKey(rutaAEliminar.getNombre())) {
            rutasAsignadas.remove(rutaAEliminar.getNombre());
            return;
        }

        throw new AgenciaViajesException("No tiene la ruta");
    }

    public void annadirParadaARutaConcreta(Ruta rutaConcreta, String paradaDeLaRuta) throws AgenciaViajesException {

        //obtenemos el valor de la clave que tiene el nombre de la recibida por parametro
        Ruta rutaBuscada = rutasAsignadas.get(rutaConcreta.getNombre()); //get devuelve null si no lo encuentra

        if (rutaBuscada == null) {

            throw new AgenciaViajesException("No se ha encontrado la ruta");
        }

        rutaBuscada.annadirParada(paradaDeLaRuta);

        /* 🔴 Antes cometi el error de meter un put() debajo, para añadir los valores a la clave del Map
         * rutasAsignadas.put(rutaConcreta.getNombre(), rutaBuscada);
         * ESTA LÍNEA ES INNECESARIA.
         *
         * Razón: rutaBuscada es una referencia a un objeto que ya está en el Map, así que modificarlo
         * ya afecta directamente a rutasAsignadas. No es necesario volver a hacer put().
         */

    }

    public void eliminarParadaARutaConcreta(Ruta rutaConcreta, String paradaDeLaRuta) throws AgenciaViajesException {

        Ruta rutaBuscada = rutasAsignadas.get(rutaConcreta.getNombre());

        if (rutaBuscada == null) {

            throw new AgenciaViajesException("No se ha encontrado la ruta");
        }

        rutaBuscada.eliminarParada(paradaDeLaRuta);
    }


    public String mostrarListaDeRutasDelCliente() {

        //Creamos un Stream de rutas
        return rutasAsignadas.values().stream()
                //Modificamos con un map para mostrar lo que queremos de las rutas
                .map(r -> "Nombre: " + r.getNombre()
                        + ", destino: " + r.getDestinoFinal()
                        //Cuando llegamos a las paradasIntermedias nos pide que la ordenemos por nombre
                        //Entonces lo convertimos en un Stream y lo ordenamos con sorted() nada entre () ya que queremos orden natura
                        + r.getParadasIntermedias().stream().
                        //Usamos un .collect(Collectors.joining()) para unir cada nombre de la parada (sino irian individual por cada posicion)
                                sorted().collect(Collectors.joining(", ")))
                //Cuando ya hemos creado nuestro map unimos cada elemento con un .collect(Collectors.joining())
                //ya que sino no podriamos devolver un UNICO String, debido a que habrian mas (uno por cada posicion)
                .collect(Collectors.joining(System.lineSeparator()));
    }

    //recordemos que flatMap() crea un flujo de otros flujos (Aplana los flujos)
    public List<String> listadosDeParadasDeCliente() {

        //Hago un flujo de rutas
        return getRutasAsignadas().values().stream()
                //Con flatMap() hago un flujo de las paradas (ya que antes habiamos hecho un flujo de paradas)
                .flatMap(ruta -> ruta.getParadasIntermedias().stream())
                //Guardamos la paradas distintas y ordenadas. Por ultimo devolvemos la lista
                .distinct().sorted().toList();
    }
}