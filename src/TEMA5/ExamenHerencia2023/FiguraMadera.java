package TEMA5.ExamenHerencia2023;

public class FiguraMadera extends JugueteMadera implements Apilable{

    private String color;
    private int numLados;

    public FiguraMadera(double precio, String nombre, String marca, String origenMadera, int annoTala, String color, int numLados) {
        super(precio, nombre, marca, origenMadera, annoTala);
        this.color = color;
        this.numLados = numLados;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getNumLados() {
        return numLados;
    }

    public void setNumLados(int numLados) {
        this.numLados = numLados;
    }

    @Override
    public boolean apilar(Juguete juegueteAApilar) {

        if (juegueteAApilar instanceof FiguraMadera){
            return true;
        }
        return false;
    }
}
