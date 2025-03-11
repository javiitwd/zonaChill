package TEMA5.ExamenHerencia2023;

import TEMA6.EjercicioHospital.Paciente;

public class PiezaLego extends JuguetePlastico implements Apilable{

    private int longuitud;
    private String color;

    public PiezaLego(double precio, String nombre, String marca, int longuitud, String color) {
        super(precio, nombre, marca, Tplastico.ABS);
    }

    public int getLonguitud() {
        return longuitud;
    }

    public void setLonguitud(int longuitud) {
        this.longuitud = longuitud;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public boolean apilar(Juguete juegueteAApilar) {

        if (juegueteAApilar instanceof PiezaLego){
            return true;
        }
        return false;
    }
}
