package TEMA5.boletín2.ejercicio2;

public class CirculoMovible extends Forma implements Dibujable, Animable {
    @Override
    public void animar() {
        System.out.println("Animando circulo movible");
    }

    @Override
    public void dibujar() {
        System.out.println("Dibujando circulo movible");
    }

    @Override
    public double calcularArea() {

        return 1;
    }
}
