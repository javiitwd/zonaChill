package TEMA5.boletín2.ejercicio2;

public class Circulo extends Forma implements Dibujable {

    private double radio;

    public Circulo(double radio) {
        this.radio = radio;
    }

    @Override
    public void dibujar() {
        System.out.println("Dibujando circulo");
    }

    @Override
    public double calcularArea() {

        return Math.PI * Math.pow(radio, 2);
    }
}
