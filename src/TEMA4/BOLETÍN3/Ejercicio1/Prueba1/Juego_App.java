/*
Vamos a crear un pequeño juego de cartas (en el que en realidad no se puede jugar
jeje). Consiste en crear la funcionalidad necesaria para crear una baraja de cartas y
realizar algunos métodos con ella. Para ello, necesitamos algunos elementos:
● Carta:
○ palo, String
○ número, cadena
● Juego:
○ baraja
○ metodo mostrarBaraja. Debe imprimir las cartas que están en la baraja, en
el orden en el que se encuentren.
○ metodo barajar. Debe barajar la baraja desordenando las cartas de la
misma.
○ metodo repartir (numJugadores, numCartas). Debe repartir a los jugadores
indicados (simplemente muestra por pantalla) el número de cartas que se
indica. Si no hay cartas suficientes para repartir a todos, debe indicarse el
error y no repartir a ninguno.
○ metodo cartasRestantes. Debe indicar cuántas cartas quedan en el mazo.
*/

package TEMA4.BOLETÍN3.Ejercicio1.Prueba1;

public class Juego_App {
    public static void main(String[] args) {
        Juego juego = new Juego();

        System.out.println(juego.mostrarBaraja());
        juego.barajar();
        System.out.println(juego.mostrarBaraja());

    }
}
