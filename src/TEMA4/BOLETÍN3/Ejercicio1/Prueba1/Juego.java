package TEMA4.BOLETÍN3.Ejercicio1.Prueba1;

import java.util.Random;

public class Juego {

    Carta[] baraja = new Carta[12 * Carta.PALOS.length];

    //Constructor de la clase juego, sirve para llenar la baraja con cartas
    public Juego() {
        for (int i = 0; i < Carta.PALOS.length; i++) {
            for (int j = 1; j <= 12; j++) {
                baraja[12 * i + j - 1] = new Carta(Carta.PALOS[i], j);
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
            int posicionRandom = random.nextInt(baraja.length);
            Carta temporal = baraja[i];
            baraja[i] = baraja[posicionRandom];
            baraja[posicionRandom] = temporal;
        }
    }


}
