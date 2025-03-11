package TEMA6.Boletín1.Ejercicio3.Prueba1;

import java.util.ArrayList;
import java.util.List;

public abstract class Persona {

    private String nombre;
    private int edad;
    private List<Mensaje> buzonDeMensajes;

    public Persona(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
        buzonDeMensajes = new ArrayList<>();
    }

    public List<Mensaje> getBuzonDeMensajes() {
        return buzonDeMensajes;
    }

    public void setBuzonDeMensajes(List<Mensaje> buzonDeMensajes) {
        this.buzonDeMensajes = buzonDeMensajes;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public abstract void enviarMensaje(String textoMensajeAEnviar, Persona destinatario) throws MensajesException;

    public String leerMensajesDelBuzon() throws MensajesException {

        if (buzonDeMensajes.isEmpty()) {
            throw new MensajesException("No hay mensajes para leer");
        }

        StringBuilder conjuntoDeMensajes = new StringBuilder();

        //No podemos usar buzonDeMensajes[i] sino que hay que poner buzonDeMensajes.get(i)
        for (int i = 0; i < buzonDeMensajes.size(); i++) {
            conjuntoDeMensajes.append("Mensaje " + (i + 1) + " ").append(buzonDeMensajes.get(i).toString()).append(System.lineSeparator());
        }
        return conjuntoDeMensajes.toString();
    }

    public String leerMnesajesDelBuzonAlfabeticamente() {
        //Para saber qué mensaje le estamos enviando
        int contadorDeMensajes = 1;

        //StringBuilder para meter todos los mensajes
        StringBuilder conjuntoDeMensajesOrdenados = new StringBuilder();

        //Creo una nueva lista para ordenar los mensajes sin que altere el orden original
        List<Mensaje> mensajesOrdenados = new ArrayList<>(buzonDeMensajes);

        //Como hemos redefinido el compareTo(), el metodo sort() sabe que debe ordenar por nombre
        mensajesOrdenados.sort(null);

        for (Mensaje mensaje : mensajesOrdenados) {
            //1) Añado el numero del mensaje (lo se por el contador) | 2) Añado el mensaje convertido en toString() 3) Añado un salto de linea
            conjuntoDeMensajesOrdenados.append("Mensaje " +contadorDeMensajes++ +" ").append(mensaje.toString()).append(System.lineSeparator());
        }
        return conjuntoDeMensajesOrdenados.toString();
    }

    public void borrarMensajeDelBuzon(int numMensajeABorrar) throws MensajesException {

        //Si el tamaño del buzon es menor que el numero del mensaje a borrar no existe
        //Ya que recordemos que en las List no habian heucos vacios, ya que se ajustaban automaticamente
        if (buzonDeMensajes.size() < numMensajeABorrar){
            throw new MensajesException("No existe ese mensaje");
        }
        //Si existe lo elimino
        buzonDeMensajes.remove(numMensajeABorrar);
    }

    public String buscarMensajesQueContienenUnaFrase(String frase){
        StringBuilder mensajesQueContienenLaFrase = new StringBuilder();

        //Recorro los mensajes
        for (Mensaje mensaje : buzonDeMensajes){
            //Si el texto del mensaje actual contiene la frase lo añado al StrinBuilder
            if (mensaje.getTextoMensaje().contains(frase)){
                mensajesQueContienenLaFrase.append(mensaje).append(System.lineSeparator());
            }
        }
        return mensajesQueContienenLaFrase.toString();
    }

    @Override
    public String toString() {
        return "Persona: " +
                "nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", buzonDeMensajes=" + buzonDeMensajes +
                '}';
    }
}
