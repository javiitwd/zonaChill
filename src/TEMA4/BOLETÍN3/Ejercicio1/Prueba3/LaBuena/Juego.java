package TEMA4.BOLETÍN3.Ejercicio1.Prueba3.LaBuena;

import java.util.Random;
import java.util.Scanner;

public class Juego {
    public static final int CARTAS_A_REPARTIR = 6;
    private int numJugadores = 0;
    Scanner sc = new Scanner(System.in);

    private Carta[] baraja = new Carta[Carta.PALO.length * Carta.NUMERO];

    public void llenarBaraja() {

        for (int i = 0; i < Carta.PALO.length; i++) {
            for (int j = 1; j <= Carta.NUMERO; j++) {
                baraja[Carta.NUMERO * i + j - 1] = new Carta(Carta.PALO[i], j);
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
            baraja[i] = baraja[posicionAleatoria];
            baraja[posicionAleatoria] = temporal;
        }
    }

    public void repartirJugadores() {
        System.out.println("Introduzca el número de jugadores");
        numJugadores = sc.nextInt();

        String[] jugadores = new String[numJugadores];

        if (numJugadores * CARTAS_A_REPARTIR > baraja.length) {
            System.out.println("No hay suficiente cartas");
        }
        Random random = new Random();
        for (int i = 1; i <= numJugadores; i++) {
            for (int j = 1; j <= CARTAS_A_REPARTIR; j++) {
                int cartaDelJugador = random.nextInt(baraja.length);
                System.out.println("El jugador " + i + " tendrá las cartas: " + baraja[cartaDelJugador]);
            }
            System.out.println();
        }
    }

    public int cartasRestantes() {
        return baraja.length - numJugadores * CARTAS_A_REPARTIR;
    }
}
