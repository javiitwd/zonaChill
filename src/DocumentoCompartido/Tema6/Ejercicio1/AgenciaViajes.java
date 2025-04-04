package DocumentoCompartido.Tema6.Ejercicio1;

import java.util.ArrayList;
import java.util.List;

public class AgenciaViajes {

    List<Cliente> clientes;

    public AgenciaViajes() {
        clientes = new ArrayList<>();
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }

    public List<Cliente> listadoDeClientesConParada(String nombreParada) {

        //filtramos los clientes
        return clientes.stream()
                //que alguna de sus rutas tiene en sus paradas la parad del parametro
                //pero como lo hemos convertido a rutas el flujo debemos convertirlo de nuevo en toList()
                .filter(cliente -> cliente.getRutasAsignadas().values().stream()
                        //como el anyMatch esta dentro del filter, si se cumplea la condicion de los () del anyMatch lo filtrara, sino lo eliminara del filtro
                        .anyMatch(ruta -> ruta.contieneParada(nombreParada))).toList();
    }
}