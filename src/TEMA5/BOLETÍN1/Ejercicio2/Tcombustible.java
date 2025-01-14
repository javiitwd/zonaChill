package TEMA5.BOLETÍN1.Ejercicio2;

public enum Tcombustible {
    GASOLINA(3.5), DIESEL(2);
    protected double precioCombustible;

    Tcombustible(double precioCombustible){

        this.precioCombustible = precioCombustible;
    }
}
