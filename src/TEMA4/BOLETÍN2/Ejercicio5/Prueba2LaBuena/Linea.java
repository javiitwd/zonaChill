package TEMA4.BOLETÍN2.Ejercicio5.Prueba2LaBuena;

public class Linea {

    private Punto puntoA;
    private Punto puntoB;

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

    public void setPuntoA(Punto puntoA) {
        this.puntoA = puntoA;
    }

    public Punto getPuntoB() {
        return puntoB;
    }

    public void setPuntoB(Punto puntoB) {
        this.puntoB = puntoB;
    }

    public void movDer(double mov) {

        puntoA.setCoordenadaX(puntoA.getCoordenadaX() + mov);
        puntoB.setCoordenadaX(puntoB.getCoordenadaX() + mov);
    }

    public void movIzq(double mov) {

        puntoA.setCoordenadaX(puntoA.getCoordenadaX() - mov);
        puntoB.setCoordenadaX(puntoB.getCoordenadaX() - mov);
    }

    public void movAbajo(double mov) {

        puntoA.setCoordenadaY(puntoA.getCoordenadaY() - mov);
        puntoB.setCoordenadaY(puntoB.getCoordenadaY() - mov);
    }

    public void movArriba(double mov) {

        puntoA.setCoordenadaY(puntoA.getCoordenadaY() + mov);
        puntoB.setCoordenadaY(puntoB.getCoordenadaY() + mov);
    }
}
