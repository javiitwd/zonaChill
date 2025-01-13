package TEMA4.BOLETÍN3.Ejercicio1.Prueba4.AMejorar;

import java.util.Scanner;

public class Juego_App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Venga, dirme los juegadores");
        int numJugadores = sc.nextInt();

        Juego juego = new Juego(numJugadores);

        juego.llenarBaraja();
        System.out.println("Baraja sin barajar:");
        System.out.println(juego.mostrarBaraja());
        System.out.println("Baraja barajada");
        System.out.println(juego.mostrarBaraja());
        juego.repartir();
        System.out.println("Quedan " + juego.cartasRestantes() + " cartas restantes");
    }
}
