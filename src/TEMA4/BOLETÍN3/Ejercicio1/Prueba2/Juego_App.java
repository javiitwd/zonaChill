package TEMA4.BOLETÍN3.Ejercicio1.Prueba2;

public class Juego_App {
    public static void main(String[] args) {
        Juego juego = new Juego();

        System.out.println(juego.mostrarCartas());
        juego.barajarCartas();
        System.out.println(juego.mostrarCartas());
    }
}