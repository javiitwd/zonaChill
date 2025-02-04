package TEMA5.boletín_extra.ejercicio4;

public class Coche implements Movible, Descargable {
    @Override
    public void acelerar() {
        System.out.println("Coche acelerando");
    }

    @Override
    public void frenar() {
        System.out.println("Coche frenando");
    }

    @Override
    public void descargar() {
        System.out.println("Coche descargando");
    }
}
