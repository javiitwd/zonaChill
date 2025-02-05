package TEMA6.Boletín1.Ejercicio3;

import java.util.*;

public abstract class Persona {
    private String nombre;
    private int edad;
    private List<Mensaje> buzonEntrada;

    public Persona(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
        buzonEntrada = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public List<Mensaje> getBuzonEntrada() {
        return buzonEntrada;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", buzonEntrada=" + buzonEntrada +
                '}';
    }

    public abstract void enviarMensaje(Persona destinatario, String textoMensaje) throws MensajeriaException;

    public String leerMensajes() throws MensajeriaException {
        if (buzonEntrada.isEmpty()) {
            throw new MensajeriaException("No tiene mensajes");
        }

        StringBuilder todosLosMensajes = new StringBuilder();

        //Creo la interfaz iterator
        Iterator<Mensaje> it = buzonEntrada.iterator();

        int contador = 1;

        //hasNext te dice si hay siguiente
        while (it.hasNext()) {
            //Si hay siguiente avanzo
            Mensaje m = it.next();
            todosLosMensajes.append("Mensaje " + contador++ + ": \n");
            todosLosMensajes.append(m.toString()).append(System.lineSeparator());
        }
        return todosLosMensajes.toString();

        //Forma más facil y original
                           /* for (Mensaje msj : buzonEntrada) {

                               todosLosMensajes.append(msj.toString()).append(System.lineSeparator());
                            }
                            return todosLosMensajes.toString();*/
    }

    public String ordenarMensajes() {
        //Para no modificar los mensajes del buzon original al ordenarlos, creamos otro
        List<Mensaje> mensajesOrdenados = buzonEntrada;

        StringBuilder mensajesOrdenadosConjunto = new StringBuilder();

        /*
         * sort(): Es un metodo de la interfaz List que se utiliza para ordenar los
         * elementos de la lista en su orden natural, es decir, según el criterio de
         * ordenación que tenga cada tipo de objeto dentro de la lista. Si los objetos
         * en la lista implementan la interfaz Comparable, este metodo utilizara el método compareTo()
         * de los objetos para determinar su orden. null: En el contexto de este metodo,
         * null se pasa como parámetro al sort(). Esto indica que se quiere usar el orden natural
         * de los objetos de la lista, es decir, se ordenarán según el criterio que esté definido en
         * la clase de los elementos de la lista (en este caso, la clase Mensaje).
         * */

        mensajesOrdenados.sort(null);

        //Convertimos los mensajes a StringBuilder y los returnamos como String
        for (Mensaje m : mensajesOrdenados) {
            mensajesOrdenadosConjunto.append(m).append(System.lineSeparator());
        }
        return mensajesOrdenadosConjunto.toString();
    }

    public void borrarMensaje(int posicion) throws MensajeriaException {

        //Si el numero del mensaje es mayor que el tamaño del buzon, no existe ese mensaje
        if (posicion > buzonEntrada.size()) {
            throw new MensajeriaException("No se encuentra");
        }
        buzonEntrada.remove(posicion - 1);
    }

    public String buscarMensajes(String frase) throws MensajeriaException {

        StringBuilder mensajesConLaPalabra = new StringBuilder();

        for (Mensaje m : buzonEntrada) {

            if (m.getTexto().contains(frase)) {
                mensajesConLaPalabra.append(m.getTexto());
            }
        }
        if (mensajesConLaPalabra.isEmpty()) {
            throw new MensajeriaException("Si ningun mensaje tiene la frase lanzamos una excepcion");
        }
        return mensajesConLaPalabra.toString();
    }
}