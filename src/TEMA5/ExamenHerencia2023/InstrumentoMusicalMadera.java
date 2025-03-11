package TEMA5.ExamenHerencia2023;

public class InstrumentoMusicalMadera extends JugueteMadera{

    private int edadMinima;

    public InstrumentoMusicalMadera(double precio, String nombre, String marca, String origenMadera, int annoTala, int edadMinima) {
        super(precio, nombre, marca, origenMadera, annoTala);
        this.edadMinima = edadMinima;
    }

    public int getEdadMinima() {
        return edadMinima;
    }

    public void setEdadMinima(int edadMinima) {
        this.edadMinima = edadMinima;
    }
}
