package TEMA4.BOLETÍN3.Ejercicio1.Prueba3.LaBuena;

public class Carta {

    public static final String[] PALO = {"Espadas", "Bastos", "Copas", "Oros"};
    public static final int NUMERO = 12;

    private String palo;
    private int numero;

    public Carta(String palo, int numero) {
        this.palo = palo;
        this.numero = numero;
    }

    @Override
    public String toString() {
        return numero+ " de " +palo;
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
}
