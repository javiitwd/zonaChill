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
        for (Mensaje msj : buzonEntrada) {

            todosLosMensajes.append(msj.toString()).append(System.lineSeparator());
        }
        return todosLosMensajes.toString();
    }

    public String ordenarMensajes() {

        //Para no modificar los mensajes del buzon original al ordenarlos, creamos otro
        List<Mensaje> mensajesOrdenados = buzonEntrada;

        StringBuilder mensajesOrdenadosConjunto = new StringBuilder();

        //Llamos al metodo sort de la clase Collection para odernar los mensajes
        //por parametro le indicamos la coleccion y el comparador <con el tipo de objeto>
        Collections.sort(mensajesOrdenados, new Comparator<Mensaje>() {

            /**
             *
             * @param m1 mensaje actual
             * @param m2 mensaje con el que se va a comprar,
             *           que es el posterior a este
             * @return devuelve <0 si el primero va antes
             *           >0 si va después, y 0 si son iguales
             *           entonces internamente, te lo ordena
             *           según lo que hemos nombrado
             */
            @Override
            public int compare(Mensaje m1, Mensaje m2) {
                return m1.getRemitente().getNombre().compareTo(m2.getRemitente().getNombre());
            }
        });

        //Convertimos los mensajes a StringBuilder y los returnamos como String
        for (Mensaje m : mensajesOrdenados) {
            mensajesOrdenadosConjunto.append(m).append(System.lineSeparator());
        }
        return mensajesOrdenadosConjunto.toString();
    }

    public void borrarMensaje(int posicion) throws MensajeriaException {

        //Si el numero del mensaje es mayor que el buzon, no hay mensajes
        if (posicion >= buzonEntrada.size()) {
            throw new MensajeriaException("No se encuentra");
        }
        buzonEntrada.remove(posicion);
    }

    public String buscarMensajes(String frase) {

        StringBuilder mensajesConLaPalabra = new StringBuilder();

        for (Mensaje m : buzonEntrada) {

            if (m.getTexto().contains(frase)) {
                mensajesConLaPalabra.append(m.getTexto());
            }
        }
        return mensajesConLaPalabra.toString();
    }
}
