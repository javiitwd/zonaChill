package TEMA5.ExamenHerencia2023;

public class VehiculoPlastico extends JuguetePlastico{

    private int numRuedas;

    public VehiculoPlastico(double precio, String nombre, String marca, int numRuedas) {
        super(precio, nombre, marca, Tplastico.PVC);
        this.numRuedas = numRuedas;
    }

    public int getNumRuedas() {
        return numRuedas;
    }

    public void setNumRuedas(int numRuedas) {
        this.numRuedas = numRuedas;
    }
}
