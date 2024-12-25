package TEMA4.BOLETÍN2.Ejercicio5.Prueba2LaBuena;

import TEMA4.BOLETÍN2.Ejercicio5.Prueba.LineaException;

public class Punto {

    private double coordenadaX;
    private double coordenadaY;

    public Punto(){
        this.coordenadaX = 0;
        this.coordenadaY = 0;
    }

    public Punto(double coordenadaX, double coordenadaY) throws LineaException {
        if (coordenadaX < 0){
            throw new LineaException("X debe ser mayor a 0");
        }
        if (coordenadaY < 0){
            throw new LineaException("Y debe ser mayor a 0");
        }
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
}
