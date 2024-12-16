package TEMA4.BOLETÍN2.Ejercicio5;

public class Linea {

    private Punto puntoA, puntoB;

    public Linea() {
        this.puntoA = new Punto();
        this.puntoB = new Punto();
    }

    public Linea(Punto puntoA, Punto puntoB) {
        this.puntoA = puntoA;
        this.puntoB = puntoB;
    }

    public Punto getPuntoA() {
        return puntoA;
    }

    public Punto getPuntoB() {
        return puntoB;
    }

    public void setPuntoA(Punto puntoA) {
        this.puntoA = puntoA;
    }

    public void setPuntoB(Punto puntoB) {
        this.puntoB = puntoB;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Linea linea = (Linea) o;
        return (this.puntoA.equals(linea.puntoA) && this.puntoB.equals(linea.puntoB));
    }

    public void moverDerecha(double movDer) throws LineaException {
        if (movDer <= 0) {
            throw new LineaException("El movimiento debe ser mayor que 0");
        }
        puntoA.setCoordenadaX(puntoA.getCoordenadaX() + movDer);
        puntoB.setCoordenadaX(puntoB.getCoordenadaX() + movDer);
    }

    public void moverIzquierda(double movIz) throws LineaException {
        if (movIz <= 0) {
            throw new LineaException("El movimiento debe ser mayor que 0");
        }
        puntoA.setCoordenadaX(puntoA.getCoordenadaX() - movIz);
        puntoB.setCoordenadaX(puntoB.getCoordenadaX() - movIz);
    }

    public void moverArriba(double mov) throws LineaException {
        if (mov <= 0) {
            throw new LineaException("El movimiento debe ser mayor que 0");
        }
        puntoA.setCoordenadaY(puntoA.getCoordenadaY() + mov);
        puntoB.setCoordenadaY(puntoB.getCoordenadaY() + mov);
    }

    public void moverAbajo(double mov) throws LineaException {
        if (mov <= 0) {
            throw new LineaException("El movimiento debe ser mayor que 0");
        }
        puntoA.setCoordenadaY(puntoA.getCoordenadaY() - mov);
        puntoB.setCoordenadaY(puntoB.getCoordenadaY() - mov);
    }

    @Override
    public String toString() {
        return "[" + puntoA + ", " + puntoB + "]";
    }
}