package TEMA4.BOLETÍN2.Ejercicio5.Prueba;

public class Linea {
    private Punto punto1;
    private Punto punto2;

    public Linea() {
        this.punto1 = new Punto();
        this.punto2 = new Punto();
    }

    public Linea(Punto punto1, Punto punto2) {
        this.punto1 = punto1;
        this.punto2 = punto2;
    }

    public Punto getPunto1() {
        return punto1;
    }

    public void setPunto1(Punto punto1) {
        this.punto1 = punto1;
    }

    public Punto getPunto2() {
        return punto2;
    }

    public void setPunto2(Punto punto2) {
        this.punto2 = punto2;
    }

    public void moverDerecha(double moverDerecha) {
        punto1.setCoordenadaX(punto1.getCoordenadaX() + moverDerecha);
        punto2.setCoordenadaX(punto2.getCoordenadaX() + moverDerecha);
    }

    public void moverIzquierda(double moverIzquierda) {
        punto1.setCoordenadaX(punto1.getCoordenadaX() - moverIzquierda);
        punto2.setCoordenadaX(punto2.getCoordenadaX() - moverIzquierda);
    }

    public void moverArriba(double moverArriba) {
        punto1.setCoordenadaY(getPunto1().getCoordenadaY() + moverArriba);
        punto1.setCoordenadaY(getPunto1().getCoordenadaY() + moverArriba);
    }

    public void moverAbajo(double moverAbajo) {
        punto1.setCoordenadaY(getPunto1().getCoordenadaY() - moverAbajo);
        punto1.setCoordenadaY(getPunto1().getCoordenadaY() - moverAbajo);
    }
}
