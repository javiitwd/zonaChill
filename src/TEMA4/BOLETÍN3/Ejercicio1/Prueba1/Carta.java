package TEMA4.BOLETÍN3.Ejercicio1.Prueba1;

public class Carta {

    public static final String[] PALOS = {"Oro", "Espada", "Basto", "Copa"};
    private String palo;
    private int numero;

    public Carta(String palo, int numero) {
        this.palo = palo;
        this.numero = numero;
    }

    public String getPalo() {
        return palo;
    }

    public void setPalo(String palo) {
        this.palo = palo;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String toString() {
        return numero + " de " + palo;
    }
}
