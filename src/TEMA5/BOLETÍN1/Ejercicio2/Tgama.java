package TEMA5.BOLETÍN1.Ejercicio2;

public enum Tgama {
    BAJA(30), MEDIA(40), ALTA(50);
    protected double precioBase;

    Tgama(double precioBase){
        this.precioBase = precioBase;
    }
}
