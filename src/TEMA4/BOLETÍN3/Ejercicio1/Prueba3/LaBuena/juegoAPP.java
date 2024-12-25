package TEMA4.BOLETÍN3.Ejercicio1.Prueba3.LaBuena;

public class juegoAPP {
    public static void main(String[] args) {
        Juego juego = new Juego();

        juego.llenarBaraja();
        System.out.println("Baraja sin barajar:");
        System.out.println(juego.mostrarBaraja());
        juego.barajar();
        System.out.println("Baraja barajada:");
        System.out.println(juego.mostrarBaraja());
        System.out.println("Repartir jugadores:");
        juego.repartirJugadores();
        System.out.printf("Hay %s cartas restantes ", juego.cartasRestantes());
    }
}
