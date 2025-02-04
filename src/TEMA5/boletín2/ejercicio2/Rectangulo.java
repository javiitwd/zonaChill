package TEMA5.boletín2.ejercicio2;

public class Rectangulo extends Forma implements Dibujable {
    private double alto;
    private double ancho;

    public Rectangulo(double alto, double ancho) {
        this.alto = alto;
        this.ancho = ancho;
    }

    @Override
    public void dibujar() {
        System.out.println("Dibujando rectángulo");
    }

    @Override
    public double calcularArea() {

        return alto * ancho;
    }
}
