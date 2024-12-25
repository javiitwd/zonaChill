package TEMA4.BOLETÍN3.Ejercicio1.Prueba2;

import java.util.Random;

public class Juego {

    //Creo la baraja con la longitud de palos*numeros de cartas que tiene cada palo
    Carta[] baraja = new Carta[Carta.PALOS.length * Carta.NUMEROS];

    public Juego() {
        for (int i = 0; i < Carta.PALOS.length; i++) {
            for (int j = 1; j <= Carta.NUMEROS; j++) {
                //Lleno la baraja con cada palo y sus respectivos numeros
                baraja[i * 12 + j - 1] = new Carta(Carta.PALOS[i], j);
            }
        }
    }

    public String mostrarCartas() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < baraja.length; i++) {
            sb.append(baraja[i]).append(System.lineSeparator());
        }
        return sb.toString();
    }

    public void barajarCartas() {
        Random random = new Random();
        for (int i = 0; i < baraja.length; i++) {
            //Nos la un numero random entre 0 y baraja.length que guardamos en una variable
            int posicionRandom = random.nextInt(baraja.length);
            Carta temporal = baraja[i];
            baraja[i] = baraja[posicionRandom];
            baraja[posicionRandom] = baraja[i];
        }
    }
}