package TEMA5.boletín_extra.ejercicio4;

public class Autobus implements Movible, Descargable{
    @Override
    public void acelerar() {
        System.out.println("Autobús acelerando");
    }

    @Override
    public void frenar() {
        System.out.println("Autobús frenando");
    }

    @Override
    public void descargar() {
        System.out.println("Autobus descargando");
    }
}
