package DocumentoCompartido.Tema6.Ejercicio1;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class Cliente {

    private String nombre;
    private int idCliente;
    private Set<Ruta> rutasAsignadas;

    public Cliente(String nombre, int idCliente) {
        this.nombre = nombre;
        this.idCliente = idCliente;
        rutasAsignadas = new HashSet<>();
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

    public Set<Ruta> getRutasAsignadas() {
        return rutasAsignadas;
    }

    public void setRutasAsignadas(Set<Ruta> rutasAsignadas) {
        this.rutasAsignadas = rutasAsignadas;
    }

    public void annadirRutaACliente(Ruta rutaAAnnadir) throws AgenciaViajesException {

        //Guardamos si tiene la ruta o no, para ello creamos un Stream para convertirlo
        // a Ruta (rutas asociadas) y despues a String (nombre de las rutas)
        // finalmente comparamos los nombres de las rutas si alguna coincide con el de la ruta del parametro
        boolean tieneLaRuta = rutasAsignadas.stream()
                .flatMap(cliente -> getRutasAsignadas().stream())
                .map(Ruta::getNombre)
                // Verifica si algún nombre en ese Stream<String> es igual al de rutaAEliminar.
                .anyMatch(nombre -> nombre.equals(rutaAAnnadir.getNombre()));

        if (tieneLaRuta) {
            throw new AgenciaViajesException("La ruta ya está");
        }

        rutasAsignadas.add(rutaAAnnadir);
    }

    public void eliminarRutaACliente(Ruta rutaAEliminar) throws AgenciaViajesException {

        boolean tieneLaRuta = rutasAsignadas.stream()
                .flatMap(cliente -> getRutasAsignadas().stream())
                .map(Ruta::getNombre)
                .anyMatch(nombre -> nombre.equals(rutaAEliminar.getNombre()));

        if (!tieneLaRuta) {
            throw new AgenciaViajesException("La ruta no está");
        }

        rutasAsignadas.remove(rutaAEliminar);
    }

    public void annadirParadaARutaConcreta(Ruta rutaConcreta, String paradaDeLaRuta) throws AgenciaViajesException {

        //Filtramos la ruta que es igual que es igual a la que recibimos por parametro
        Ruta rutaAAnnadirParada = rutasAsignadas.stream()
                .filter(ruta -> ruta.equals(rutaConcreta))
                .findFirst() //seleccionamos la primera
                .orElseThrow(() -> new AgenciaViajesException("No se encuentra la ruta"));

        //añadimos la parada a la ruta que hemos obtenido de Stream
        rutaAAnnadirParada.getParadasIntermedias().add(paradaDeLaRuta);
    }

    public void eliminarParadaARutaConcreta(Ruta rutaConcreta, String paradaDeLaRuta) throws AgenciaViajesException {

        //Filtramos la ruta que es igual que es igual a la que recibimos por parametro
        Ruta rutaAEliminarParada = rutasAsignadas.stream()
                .filter(ruta -> ruta.equals(rutaConcreta))
                .findFirst() //seleccionamos la primera
                .orElseThrow(() -> new AgenciaViajesException("No se encuentra la ruta"));

        //añadimos la parada a la ruta que hemos obtenido de Stream
        rutaAEliminarParada.getParadasIntermedias().remove(paradaDeLaRuta);
    }

    public String mostrarListaDeRutasDelCliente() {

        //Creamos un Stream de rutas
        return rutasAsignadas.stream()
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
}
