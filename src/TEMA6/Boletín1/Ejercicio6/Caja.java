package TEMA6.Boletín1.Ejercicio6;

import java.util.LinkedList;

public class Caja {

    private int numCaja;
    private boolean estaAbierta;
    private LinkedList<Integer> colaDeClientes;

    public Caja(int numCaja, boolean estaAbierta) {
        this.numCaja = numCaja;
        this.estaAbierta = estaAbierta;
        this.colaDeClientes = new LinkedList<>();
    }

    public int getNumCaja() {
        return numCaja;
    }

    public boolean estaAbierta() {
        return estaAbierta;
    }

    public void setEstaAbierta(boolean estaAbierta) {
        this.estaAbierta = estaAbierta;
    }

    public LinkedList<Integer> getColaDeClientes() {
        return colaDeClientes;
    }
}
