package TEMA5.LuchadoresGPT;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Torneo {
    private List<Luchador> luchadoresDelTorneo;

    public Torneo(List<Luchador> luchadores) throws TorneoException {
        if (!esPotenciaDeDos(luchadores.size())) {
            throw new TorneoException("El número de luchadores debe ser una potencia de 2.");
        }
        this.luchadoresDelTorneo = new ArrayList<Luchador>(luchadores);
    }

    //Recibe el numero de luchadores que hay
    private boolean esPotenciaDeDos(int luchadoresTotales) {
        while (luchadoresTotales > 1) {
            if (luchadoresTotales % 2 != 0) { // Si en algún punto el número no es divisible por 2, no es una potencia de 2
                return false;
            }
            // Actualizo los luchadoresTotales: Se divide entre 2 hasta llegar a 1
            luchadoresTotales = luchadoresTotales / 2;
        }
        return true; // Si llegamos a 1, significa que era una potencia de 2
    }

    //Metodo que hace el torneo, este va por ronda acortando los luchadores (con los ganadores de las rondas) hasta que solo quede 1 (ganador)
    public void iniciarTorneo() throws TorneoException {

        //Mientras quede mas de 1 peleador (ganador) se sigue el combate
        while (luchadoresDelTorneo.size() > 1) {
            // Mezcla los luchadores
            Collections.shuffle(luchadoresDelTorneo);

            //Creo una lista de luchadores con los ganadores de la ronda actual
            List<Luchador> ganadores = new ArrayList<>();

            //Recorro los luchadoresDelTorneo de 2 en 2, esos 2 luchadores que he avanzado seran los que se enfrenten
            for (int i = 0; i < luchadoresDelTorneo.size(); i += 2) {
                Luchador luchador1 = luchadoresDelTorneo.get(i);
                Luchador luchador2 = luchadoresDelTorneo.get(i + 1);
                System.out.println("⚔ Combate entre " + luchador1.getNombre() + " y " + luchador2.getNombre());

                //Enfrento a los 2 luchadores y guardo el ganador
                Luchador ganador = combate(luchador1, luchador2);

                //Añado el ganador del enfrentamiento a los ganadores de la ronda actual
                ganadores.add(ganador);
                System.out.println("🏆 Ganador: " + ganador.getNombre());
            }

            //Actualizo los luchadoresDelTorneo para que ahora solo tenga a los ganadores de la actual ronda
            luchadoresDelTorneo = ganadores;
        }

        System.out.println("🏆🔥 ¡El campeón del torneo es " + luchadoresDelTorneo.get(0).getNombre() + "!");
    }

    //Metodo para combatir, devuelve el ganador del enfrentamiento
    private Luchador combate(Luchador luchador1, Luchador luchador2) throws TorneoException {
        Luchador atacante, defensor;

        //defino quien sera el primero que ataque en funcion de su velocidad
        if (luchador1.getVelocidad() >= luchador2.getVelocidad()) {
            atacante = luchador1;
            defensor = luchador2;
        } else {
            atacante = luchador2;
            defensor = luchador1;
        }

        //mientras alguno de los 2 luchadores tengan vida el combate continua
        while (luchador1.getSaludActual() > 0 && luchador2.getSaludActual() > 0) {
            //si el atacante vence al defensor devolvemos que el atacante ha ganado
            if (atacante.atacar(defensor)) {
                return atacante;
            }
            // Sino, cambio de turnos, el defensor pasa a atacar y el atacante pasa a defender
            Luchador temporal = atacante;
            atacante = defensor;
            defensor = temporal;
        }
        throw new TorneoException("Ha habido un error");
    }
}

