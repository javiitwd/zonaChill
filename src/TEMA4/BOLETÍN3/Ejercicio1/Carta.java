package TEMA4.BOLETÍN3.Ejercicio1;

public class Carta {
    public static final String[] PALOS = {"ORO", "ESPADA", "COPAS", "BASTOS"};
    private String palo;
    private int numero;

    public Carta(String palo, int numero) {
        this.palo = palo;
        this.numero = numero;
    }

    public String getPalo() {
        return palo;
    }

    public int getNumero() {
        return numero;
    }

    @Override
    public String toString() {
        return numero + " de " + palo;
    }
}