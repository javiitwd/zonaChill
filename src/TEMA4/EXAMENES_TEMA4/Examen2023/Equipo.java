package TEMA4.EXAMENES_TEMA4.Examen2023;

public class Equipo {
    private String pais;
    private String nombreEntrenador;
    private Jugador[] listaJugadores;

    public Equipo(String pais, String nombreEntrenador, Jugador[] listaJugadores) {

        this.pais = pais;
        this.nombreEntrenador = nombreEntrenador;
        this.listaJugadores = listaJugadores;
    }

    public Jugador[] getListaJugadores() {
        return listaJugadores;
    }

    public void setListaJugadores(Jugador[] listaJugadores) {
        this.listaJugadores = listaJugadores;
    }

    //AÑADIR JUGADOR
    public void anadirJugadores(String nombre, int edad, int numGolesMarcados) {

        //Meto en la posicion final al nuevo jugador con sus características
        listaJugadores[totalJugadores()] = new Jugador(nombre, edad, numGolesMarcados);
    }

    //Metodo para contar los jugadores que hay en el equipo
    public int totalJugadores() {
        int contador = 0;
        for (int i = 0; i < listaJugadores.length; i++) {
            if (listaJugadores[i] != null) {
                contador++;
            }
        }
        return contador;
    }

    //ELIMINAR JUGADOR
    public void eliminarJugador(String nombre, int edad, int numGolesMarcado) {
        Jugador jugadorAEliminar = new Jugador(nombre, edad, numGolesMarcado);

        //Volvemos null la posicion en la qie está el jugador que estamos buscando
        listaJugadores[encontrarJugador(jugadorAEliminar)] = null;

        reajustarEquipo();
    }

    public int encontrarJugador(Jugador jugadorAEliminar) {
        int posicion = 0;

        for (int i = 0; i < listaJugadores.length; i++) {

            if (listaJugadores[i].equals(jugadorAEliminar)) {
                posicion = i;
                reajustarEquipo();
            }
        }
        return posicion;
    }

    //Metodo para ordenar las posiciones del equipo una vez de haya eliminado un jugador
    public void reajustarEquipo() {
        for (int i = 0; i < listaJugadores.length-1; i++) {

            Jugador temporal = listaJugadores[i];
            listaJugadores[i] = listaJugadores[i + 1];
            listaJugadores[i + 1] = temporal;
        }
    }

    //OBTENER NOMBRE DEL ENTRENADOR
    public String getNombreEntrenador() {
        return nombreEntrenador;
    }

    //OBTENER NUMERO DE GOLES TOTALES DEL EQUIPO
    public int numTotalesGolesEquipo(String pais, String nombreEntrenador, Jugador[] listaJugadores) {

        int contadorGoles = 0;
        for (int i = 0; i < listaJugadores.length; i++) {
            contadorGoles += listaJugadores[i].getNumGolesMarcados();
        }
        return contadorGoles;
    }
}
