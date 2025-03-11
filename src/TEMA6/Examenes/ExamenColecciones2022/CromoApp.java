package TEMA6.Examenes.ExamenColecciones2022;

import java.util.*;

public class CromoApp {

    //lo hice con un ArrayList, pero asi seria mas dificil llevar un contador de veces repetidas del cromo
    //Mejor solución: Usa un Map<Cromo, Integer>, donde la clave sea el cromo y el valor sea la cantidad de veces que lo tienes.
    private Map<Cromo, Integer> mazoDeCromos;

    public CromoApp() {
        this.mazoDeCromos = new HashMap<>();
    }

    public String annadirCromo(Cromo cromoAAnadir) {

        //si el mazo de los cromos no tenia el cromo, lo añadimos y se lo hacemos saber
        if (!mazoDeCromos.containsKey(cromoAAnadir)) {
            mazoDeCromos.put(cromoAAnadir, 1);
            return "Cromo " + cromoAAnadir.getCodigoUnico() + " añadido a la coleccion";
        }

        //si ya contenia el cromo recorremos el mazo de cromos para ver cuantas veces esta repetido
        int cromoVecesEncontrado = 1;

        for (Cromo cromo : mazoDeCromos.keySet()) {

            if (cromo.getCodigoUnico() == cromoAAnadir.getCodigoUnico()) {
                cromoVecesEncontrado++;
            }
        }
        //Añadimos el cromo y le hacemos saber cuantas veces esta repetido
        mazoDeCromos.put(cromoAAnadir, cromoVecesEncontrado);
        return "Se ha añadido el cromo " + cromoAAnadir.getCodigoUnico() + ", el cromo está repetido " + mazoDeCromos.get(cromoAAnadir) + " veces";
    }

    public void intercambiarCromoPorOtro(Cromo cromoAIntercambiar, Cromo cromoARecibir) throws CromoException {

        //Si el cromo no esta en el mazo lanzamos excepcion
        if (!mazoDeCromos.containsKey(cromoAIntercambiar)) {
            throw new CromoException("No tienes el cromo en tu mazo");
        }

        //Si tenemos ya el cromo del tio le añadimos 1 al valor de la clave
        if (mazoDeCromos.containsKey(cromoARecibir)) {

            int vecesRepetidas = mazoDeCromos.get(cromoARecibir);
            mazoDeCromos.put(cromoARecibir, vecesRepetidas + 1);

            //Sino lo añadimos con valor 1 en la clave
        } else {
            //Añadimos el cromoARecibir al mazo
            mazoDeCromos.put(cromoARecibir, 1);
        }

        //guardamos las veces que tenemos repetidas el cromo
        int cantidadDeCromo = mazoDeCromos.get(cromoAIntercambiar);

        //Si solo tenemos el cromo 1 vez lo eliminamos del mazo
        if (cantidadDeCromo == 1) {
            mazoDeCromos.remove(cromoAIntercambiar);
        } else if (cantidadDeCromo > 1) {
            // Si la cantidad es mayor a 1, reducimos su cantidad
            mazoDeCromos.put(cromoAIntercambiar, cantidadDeCromo - 1);
        }

        /* En un Map, cada clave debe ser única. Si usas put(cromo, valor), si la clave (cromo) ya existe en el mapa,
        el valor anterior se reemplaza por el nuevo valor proporcionado. Si la clave no existe, se añade al Map con el valor indicado.*/
    }

    public Map<Cromo, Integer> mezclarMazoConOtro(Map<Cromo, Integer> mazoDeCromosAMezclar) {

        Map<Cromo, Integer> mazosMezclados = new HashMap<>(mazoDeCromos);

        //Recorremos el otro mazo
        for (Cromo cromo : mazoDeCromosAMezclar.keySet()) {

            //Si el mazosMezclados tiene el cromo que estamos mirando, le sumamos la cantidad
            if (mazosMezclados.containsKey(cromo)) {
                //sumamos las veces que se repiten los cromos en ambos mazos para ponerlo en el mazo mezclado
                int vecesDelCromoEnElMazo1 = mazoDeCromos.get(cromo); //mazo 1 (nuestro)
                int vecesDelCromoEnElMazo2 = mazoDeCromosAMezclar.get(cromo); //mazo 2 (a mezclar)
                int vecesTotalesRepetidas = vecesDelCromoEnElMazo1 + vecesDelCromoEnElMazo2;

                mazosMezclados.put(cromo, vecesTotalesRepetidas);
            }
            //Sino estaba lo añadimos
            mazosMezclados.put(cromo, 1);
        }
        return mazosMezclados;
    }

    public String contarCantidadDeCromosDiferentes() throws CromoException {

        if (mazoDeCromos.isEmpty()) {
            throw new CromoException("No hay cromos");
        }

        //StringBuilder para mostrarle al usuario en String los cromos que tiene
        StringBuilder cromosTotales = new StringBuilder();

        //Recorro los cromos y voy haciendo casting para ir mostrando la cantidad de cromos diferentes que tiene el usuario
        for (Cromo cromo : mazoDeCromos.keySet()) {

            if (cromo instanceof CromoDeEscudos) {
                CromoDeEscudos cromoEscudo = (CromoDeEscudos) cromo;
                cromosTotales.append("Equipo: " + cromoEscudo.getNombreEquipo() + ": " + mazoDeCromos.get(cromo) + " cromos").append(System.lineSeparator());
            }

            if (cromo instanceof CromoDeJugadores) {
                CromoDeJugadores cromoJugador = (CromoDeJugadores) cromo;
                cromosTotales.append("Jugador: " + cromoJugador.getNombreJugador() + ": " + mazoDeCromos.get(cromo) + " cromos").append(System.lineSeparator());
            }
        }
        return cromosTotales.toString();
    }

    public String devolverCromosDeUnEquipo(String equipo) throws CromoException {

        if (mazoDeCromos.isEmpty()) {
            throw new CromoException("No hay cromos");
        }

        //StringBuilder para mostrarle al usuario en String los cromos que tiene del equipo del parametro
        StringBuilder cromosTotalesDeEseEquipo = new StringBuilder();

        //Recorro el mazo y voy haciendo castings para segun sea el cromo de un tipo u otro comparar sus atributos de equipo con el del parametro
        for (Cromo cromo : mazoDeCromos.keySet()) {
            //Si el un Escudo miramos si el nombre coincide con el del equipo del parametro y lo añadimos al StringBuilder
            if (cromo instanceof CromoDeEscudos) {
                CromoDeEscudos cromoEscudo = (CromoDeEscudos) cromo;
                if (cromoEscudo.getNombreEquipo().equalsIgnoreCase(equipo)) {
                    cromosTotalesDeEseEquipo.append(cromoEscudo).append(System.lineSeparator());
                }
            }

            //Si el un Jugador miramos si el nombre del equipo en el eque juega coincide con el del equipo del parametro y lo añadimos al StringBuilder
            if (cromo instanceof CromoDeJugadores) {
                CromoDeJugadores cromoJugador = (CromoDeJugadores) cromo;
                if (cromoJugador.getEquipoEnElQueJuega().equalsIgnoreCase(equipo)) {
                    cromosTotalesDeEseEquipo.append(cromoJugador);
                }
            }
        }
        return cromosTotalesDeEseEquipo.toString();
    }

    public int calcularAlturaMedia(String nombreEquipo) throws CromoException {

        if (mazoDeCromos.isEmpty()) {
            throw new CromoException("No hay cromos");
        }

        //Variable que cuenta el total de jugadores del equipo del parametro
        int contadorDeJugadores = 0;

        //Variable para sumar todas las alturas
        int sumaDeAlturas = 0;

        //Recorro los cromos y si son de jugadores y pertenecen a equipo del parametro los meto en la lista
        for (Cromo cromo : mazoDeCromos.keySet()) {
            if (cromo instanceof CromoDeJugadores) {
                CromoDeJugadores cromoJugador = (CromoDeJugadores) cromo;
                if (cromoJugador.getEquipoEnElQueJuega().equalsIgnoreCase(nombreEquipo)) {
                    sumaDeAlturas += cromoJugador.getAlturaDelJugador();
                    contadorDeJugadores++;
                }
            }
        }

        //Devolvemos la media (suma de altura entre el total de jugadores)
        return sumaDeAlturas / contadorDeJugadores;
    }

    public String devolverListaDeCromos() throws CromoException {

        if (mazoDeCromos.isEmpty()) {
            throw new CromoException("No hay cromos");
        }

        //StringBuilder para mostrarle al usuario en String los cromos que tiene
        StringBuilder cromosTotales = new StringBuilder();

        //Recorro los cromos y voy haciendo casting para ir mostrando la cantidad de cromos diferentes que tiene el usuario
        for (Cromo cromo : mazoDeCromos.keySet()) {

            if (cromo instanceof CromoDeEscudos) {
                CromoDeEscudos cromoEscudo = (CromoDeEscudos) cromo;
                cromosTotales.append(cromoEscudo).append(System.lineSeparator());
            }

            if (cromo instanceof CromoDeJugadores) {
                CromoDeJugadores cromoJugador = (CromoDeJugadores) cromo;
                cromosTotales.append(cromoJugador).append(System.lineSeparator());
            }
        }
        return "LISTA DE CROMOS: \n " + cromosTotales.toString();
    }

    public String devolverListaDeCromosOrdenados() {

        //Creamos 2 listas, 1 para los cromos de Jugador y otra para los cromos de Escudo
        List<Cromo> cromosDeJugadorTotales = new ArrayList<>();
        List<Cromo> cromosDeEscudoTotales = new ArrayList<>();

        //Recorro el mazo y voy haciendo castings para segun sea el cromo de un tipo añadirlo a la lista
        for (Cromo cromo : mazoDeCromos.keySet()) {
            //Si el un Escudo miramos si el nombre coincide con el del equipo del parametro y lo añadimos al StringBuilder
            if (cromo instanceof CromoDeEscudos) {
                CromoDeEscudos cromoEscudo = (CromoDeEscudos) cromo;
                cromosDeEscudoTotales.add(cromoEscudo);
            }

            //Si el un Jugador miramos si el nombre del equipo en el eque juega coincide con el del equipo del parametro y lo añadimos al StringBuilder
            if (cromo instanceof CromoDeJugadores) {
                CromoDeJugadores cromoJugador = (CromoDeJugadores) cromo;
                cromosDeJugadorTotales.add(cromoJugador);
            }
        }

        //Ordeno las listas (En este caso en sus clases hemos puesto el compareTo() con el nombre del Equipo o Jugador)
        cromosDeEscudoTotales.sort(null);
        cromosDeJugadorTotales.sort(null);

        //Añado las listas por orden a otra nueva lista, que contendra ambas
        List<Cromo> listaDeCromosTotalesOrdenados = new ArrayList<>(cromosDeEscudoTotales);

        listaDeCromosTotalesOrdenados.addAll(cromosDeJugadorTotales);

        //Creamos un StringBuilder para devolver la lista ordenada
        StringBuilder listaDeCromosTotalesOrdenadosString = new StringBuilder();

        //Recorremos la nueva lista y metemos los cromos en el StringBuilder
        for (Cromo cromo : listaDeCromosTotalesOrdenados) {

            listaDeCromosTotalesOrdenadosString.append(cromo);
        }
        return listaDeCromosTotalesOrdenadosString.toString();
    }
}
