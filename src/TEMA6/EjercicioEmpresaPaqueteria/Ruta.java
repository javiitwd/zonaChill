package TEMA6.EjercicioEmpresaPaqueteria;

import java.util.*;

public class Ruta {

    public static int ordenInserccionPaquetes = 1;

    private String nombre;
    private Queue<Paquete> paquetesAEntregar;

    public Ruta(String nombre) {
        this.nombre = nombre;
        //Nuestra Queue ordenara por el numPrioridad, y en caso de empate por el orden en el que se hayan añadido
        paquetesAEntregar = new PriorityQueue<>(Comparator.comparingInt(Paquete::getNumPrioridad).reversed()
                .thenComparing((Paquete::getOrdenDeInserccion)));
    }

    public void annadirPaquete(Paquete paqueteAAnnadir) throws PaqueteriaException {

        if (paqueteAAnnadir == null) {
            throw new PaqueteriaException("Porfavor indique el paquete");
        }

        paqueteAAnnadir.setOrdenDeInserccion(ordenInserccionPaquetes++);

        paquetesAEntregar.add(paqueteAAnnadir);
    }

    public void eliminarPaquete(Paquete paqueteAEliminar) throws PaqueteriaException {

        if (paquetesAEntregar.poll() == null) {
            throw new PaqueteriaException("No hay paquetes disponibles");
        }
    }

    public Queue<Paquete> ordenarPaquetes() throws PaqueteriaException {

        if (paquetesAEntregar.isEmpty()) {
            throw new PaqueteriaException("No hay paquetes");
        }
        /* Si preferimos podemos devolver tambien una lista
         List<Paquete> paquetes = new ArrayList<>(paquetesAEntregar); */

        //como ya hemos ido ordenando segun ibamos metiendo los paquetes podemos devolverlo tal caul
        return paquetesAEntregar;
    }

    public String listarPaquetes() throws PaqueteriaException {

        if (paquetesAEntregar.isEmpty()) {
            throw new PaqueteriaException("No hay paquetes");
        }

        return paquetesAEntregar.stream()
                .map(paquete -> paquete.toString())
                .toString();
    }

    public Paquete siguientePaqueteAEntregar() {

        //A diferencia del .poll() el .peek() devuelve el primer elemento sin eliminarlo
        return paquetesAEntregar.peek();
    }

    public List<Paquete> paquetesQueLlevanMasDe24h() throws PaqueteriaException {

        if (paquetesAEntregar.isEmpty()) {
            throw new PaqueteriaException("No hay paquetes");
        }

        //Devolvemos los paquetes que lleven mas de 24h en espera (metodo en clase Paquete)
        List<Paquete> paquetesCon24DeEspera = paquetesAEntregar.stream()
                .filter(paquete -> paquete.llevaMasDe24hConDuration())
                .toList();

        if (paquetesCon24DeEspera.isEmpty()) {
            throw new PaqueteriaException("No hay paquetes que lleven mas de 24h en espera");
        }

        return paquetesCon24DeEspera;
    }

    public void fusionarRutas(Ruta rutaAFusionar) throws PaqueteriaException {

        if (rutaAFusionar.paquetesAEntregar.isEmpty()) {
            throw new PaqueteriaException("No hay paquetes que lleven mas de 24h en espera");
        }

        paquetesAEntregar.addAll(rutaAFusionar.paquetesAEntregar);
    }
}
