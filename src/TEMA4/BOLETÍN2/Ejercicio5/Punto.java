package TEMA4.BOLETÍN2.Ejercicio5;

public class Punto {

    private double coordenadaX;
    private double coordenadaY;

    public Punto() {
        coordenadaX = 0;
        coordenadaY = 0;
    }

    public Punto(double coordenadaX, double coordenadaY) {
        this.coordenadaX = coordenadaX;
        this.coordenadaY = coordenadaY;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Punto punto = (Punto) o;
        return this.coordenadaX == punto.coordenadaX && this.coordenadaY == punto.coordenadaY;
    }

    @Override
    public String toString() {
        return "(" + coordenadaX + ", " + coordenadaY + ")";
    }
}
