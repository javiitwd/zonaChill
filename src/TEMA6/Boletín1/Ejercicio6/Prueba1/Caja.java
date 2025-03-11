package TEMA6.Boletín1.Ejercicio6.Prueba1;

import java.util.LinkedList;

public class Caja {

    private int numCaja;
    private boolean estaAbierta;
    private LinkedList<Integer> colaClientes;

    public Caja(int numCaja, boolean estaAbierta) {
        this.numCaja = numCaja;
        this.estaAbierta = estaAbierta;
        colaClientes = new LinkedList<>();
    }

    public int getNumCaja() {
        return numCaja;
    }

    public boolean isEstaAbierta() {
        return estaAbierta;
    }

    public void setEstaAbierta(boolean estaAbierta) {
        this.estaAbierta = estaAbierta;
    }

    public LinkedList<Integer> getColaClientes() {
        return colaClientes;
    }

}
