package TEMA4.BOLETÍN3.Ejercicio1.Prueba4.AMejorar;

import java.util.Random;

public class Juego {

    private Carta[] baraja = new Carta[Carta.NUMEROS * Carta.PALOS.length];
    private int numJugadores;
    private int numCartas = 6;

    public Juego(int numJugadores) {
        this.numJugadores = numJugadores;
    }

    public void llenarBaraja() {
        for (int i = 0; i < Carta.PALOS.length; i++) {
            for (int j = 1; j <= Carta.NUMEROS; j++) {
                baraja[Carta.NUMEROS * i + j - 1] = new Carta(Carta.PALOS[i], j);
            }
        }
    }

    public String mostrarBaraja() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < baraja.length; i++) {
            sb.append(baraja[i]).append(System.lineSeparator());
        }
        return sb.toString();
    }

    public void barajar() {
        Random random = new Random();
        for (int i = 0; i < baraja.length; i++) {
            int posicionAleatoria = random.nextInt(baraja.length);
            Carta temporal = baraja[i];
            baraja[i] = baraja[i + 1];
            baraja[i + 1] = temporal;
        }
    }

    public void repartir() {
        Random random = new Random();
        if (numJugadores * numCartas < baraja.length) {
            for (int i = 1; i <= numJugadores; i++) {
                for (int j = 0; j < numCartas; j++) {
                    int cartaRandom = random.nextInt(baraja.length);
                    //posicionAleatoria();
                    System.out.println("El jugador " + i + " tiene la carta " + baraja[cartaRandom]);
                }
                System.out.println();
            }
        }
    }

    public int cartasRestantes() {
        return baraja.length - (numCartas * numJugadores);
    }

    /*
    @mejora
    ***TRATANDO DE HACER QUE LAS CARTAS NO SE REPITAN ENTRE LOS JUGADORES***
    public int posicionAleatoria() {

        Random random = new Random();
        int cartaRandom = random.nextInt(baraja.length);
        if (noEsta(baraja[cartaRandom]))
    }

    public boolean noEsta(Carta cartaRandom) {
        Carta baraja2 = new Carta(Carta[cartaRandom], 1);
        for (int i = 0; i <; i++) {

        }
    }*/
}
