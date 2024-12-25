package TEMA4.BOLETÍN3.Ejercicio1;

import java.util.Random;

public class Juego {
    //Creamos la baraja, que es un array de objetos tipo cartas
    private Carta[] baraja;

    public Juego() {
        //Sacamos el numero de cartas que tendra la baraja
        baraja = new Carta[12 * Carta.PALOS.length];
        for (int i = 0; i < Carta.PALOS.length; i++) {
            for (int j = 1; j <= 12; j++) {
                //Le metemos a la baraja la primera carta del primer palo que vamos a mirar...
                baraja[i * 12 + j - 1] = new Carta(Carta.PALOS[i], j);
            }
        }
    }

    public String mostrarBaraja() {
        //Creamos una varibale tipo StringBuilder
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < baraja.length; i++) {
            //en sb metemos append añade al StringBuilder lo que tenga (), por ejemplo en append.lineSeparator añade un salto de linea.
            sb.append(baraja[i]).append(System.lineSeparator());
        }
        return sb.toString();
    }

    public void barajar() {

        Random random = new Random();
        for (int i = 0; i < baraja.length; i++) {
            //guardamos un numero random entre la baraja.length en int nuevaPosicion
            int nuevaPosicion = random.nextInt(baraja.length);
            //Barajamos como en el metodo de la burbuja
            Carta temporal = baraja[i];
            baraja[i] = baraja[nuevaPosicion];
            baraja[nuevaPosicion] = temporal;
        }
    }
}