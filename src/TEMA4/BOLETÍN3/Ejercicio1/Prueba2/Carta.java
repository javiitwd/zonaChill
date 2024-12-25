package TEMA4.BOLETÍN3.Ejercicio1.Prueba2;

public class Carta {
    public static final String [] PALOS = {"Oro", "Copas", "Bastos", "Espadas"};
    public static final int NUMEROS = 12;
    private String palo;
    private int numero;

    public Carta(String palo, int numero){
        this.palo = palo;
        this.numero = numero;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String toString(){
        return numero+ " de " +palo;
    }
}