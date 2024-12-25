package TEMA4.BOLETÍN2.Ejercicio5.Prueba;

public class Punto {

    private double coordenadaX = 0;
    private double coordenadaY = 0;

    public Punto() {
        this.coordenadaX = 0;
        this.coordenadaY = 0;
    }

    public double getCoordenadaX() {
        return coordenadaX;
    }

    public void setCoordenadaX(double coordenadaX) {
        this.coordenadaX = coordenadaX;
    }

    public double getCoordenadaY() {
        return coordenadaY;
    }

    public void setCoordenadaY(double coordenadaY) {
        this.coordenadaY = coordenadaY;
    }

    public Punto(double coordenadaX, double coordenadaY) throws LineaException {

        if (coordenadaX <= 0) {
            throw new LineaException("Ponga bien la coordenada X");
        }
        if (coordenadaY <= 0) {
            throw new LineaException("Ponga bien la coordenada Y");
        }
        this.coordenadaX = coordenadaX;
        this.coordenadaY = coordenadaY;
    }
}
