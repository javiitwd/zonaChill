package TEMA5.LuchadoresGPT.Prueba1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Torneo {

    private List<Luchador> luchadoresDelTorneo;

    public Torneo() {
        this.luchadoresDelTorneo = new ArrayList<>();
    }

    private boolean esValido(int luchadoresTotales) {

        while (luchadoresTotales > 1) {
            if (luchadoresTotales % 2 != 0) { // Si en algún punto el número no es divisible por 2, no es una potencia de 2
                return false;
            }
            // Actualizo los luchadoresTotales: Se divide entre 2 hasta llegar a 1
            luchadoresTotales = luchadoresTotales / 2;
        }
        return true;
    }

    public void iniciarTorneo(ArrayList<Luchador> luchadoresDelTorneo) throws TorneoException {

        //Si el numero de luchadores del torneo no es potencia de 2, lanzamos una excepcion.
        if (!esValido(luchadoresDelTorneo.size())) {
            throw new TorneoException("El torneo no es potencia de 2, por lo cual no puede iniciarse");
        }

        do {
            //mezclamos los enfrentamientos aleatoriamente
            Collections.shuffle(luchadoresDelTorneo);

            //Lista para guardar a los ganadores de cada ronda
            ArrayList<Luchador> ganadoresDeLaRonda = new ArrayList<>();

            //Recorremos los luchadores de 2 en 2 y los enfrentamos
            for (int i = 0; i < luchadoresDelTorneo.size(); i++) {

                Luchador luchador1 = luchadoresDelTorneo.get(i);
                Luchador luchador2 = luchadoresDelTorneo.get(i + 1);

                //Guardamos al ganador del enfrentamiento
                Luchador ganadorDelCombate = combate(luchador1, luchador2);

                //Añadimos el ganador del enfrentamiento a la list de ganadoresDeLaRonda
                ganadoresDeLaRonda.add(ganadorDelCombate);
            }

            //Sustituimos los luchadoresDelTorneo por los ganadoresDeLaRonda (para asegurarnos de que se han eliminado a los perdedores)
            luchadoresDelTorneo = ganadoresDeLaRonda;

        } while (luchadoresDelTorneo.size() > 1); //el torneo sigue hasta que solo quede 1
    }

    //Metodo que enfrenta a 2 luchadores, devuelve el ganador de dicho enfrentamiento
    public Luchador combate(Luchador luchador1, Luchador luchador2) throws TorneoException {

        Luchador atacante, defensor;

        //Definimos quien ataca primero según su velocidad
        if (luchador1.getVelocidad() > luchador2.getVelocidad()) {

            atacante = luchador1;
            defensor = luchador2;

        } else {

            atacante = luchador2;
            defensor = luchador1;
        }

        while (luchador1.getVidaActual() > 1 || luchador2.getVidaActual() > 1) {

            //Si el atacante derrota al que va a atacar devolvemos que ha ganado
            if (atacante.atacar(defensor)) {
                return atacante;
            }

            //Cambiamos los turnos (el que atacaba defiende y el que defendia ataca)
            Luchador temporal = atacante;
            atacante = defensor;
            defensor = temporal;
        }
        throw new TorneoException("Ha habido un error en el enfrentamiento");
    }
}