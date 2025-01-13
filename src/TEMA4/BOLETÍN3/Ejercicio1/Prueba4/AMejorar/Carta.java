package TEMA4.BOLETÍN3.Ejercicio1.Prueba4.AMejorar;

public class Carta {
    public static final String [] PALOS = {"Copas", "Bastos", "Espadas", "Oro"};
    public static final int NUMEROS = 12;
    private String palo;
    private int numero;

    public Carta(String palo, int numero) {
        this.palo = palo;
        this.numero = numero;
    }

    @Override
    public String toString() {
        return +numero+ " de " +palo;
    }
}
