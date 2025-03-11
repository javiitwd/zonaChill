package TEMA5.GestionVehiculosGPT;

public class Mercancia {

    private int pesoEnKg;
    private boolean esRefrigerada;
    private int tamano;

    public Mercancia(int pesoEnKg, boolean esRefrigerada, int tamano) {
        this.pesoEnKg = pesoEnKg;
        this.esRefrigerada = esRefrigerada;
        this.tamano = tamano;
    }

    public int getPesoEnKg() {
        return pesoEnKg;
    }

    public void setPesoEnKg(int pesoEnKg) {
        this.pesoEnKg = pesoEnKg;
    }

    public boolean EsRefrigerada() {
        return esRefrigerada;
    }

    public void setEsRefrigerada(boolean esRefrigerada) {
        this.esRefrigerada = esRefrigerada;
    }

    public boolean isEsRefrigerada() {
        return esRefrigerada;
    }

    public int getTamano() {
        return tamano;
    }

    public void setTamano(int tamano) {
        this.tamano = tamano;
    }
}
