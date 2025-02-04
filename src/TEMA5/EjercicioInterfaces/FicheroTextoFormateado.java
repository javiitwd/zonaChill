package TEMA5.EjercicioInterfaces;

public class FicheroTextoFormateado extends FicheroTexto implements Analizable {

    private String fuente;
    private int tamFuente;
    private String color;


    public FicheroTextoFormateado(String nombre, long tamano, String fuente, int tamFuente, String color) {
        super(nombre, tamano);

        this.fuente = fuente;
        this.tamFuente = tamFuente;
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getTamFuente() {
        return tamFuente;
    }

    public void setTamFuente(int tamFuente) {
        this.tamFuente = tamFuente;
    }

    public String getFuente() {
        return fuente;
    }

    public void setFuente(String fuente) {
        this.fuente = fuente;
    }

    @Override
    public String toString() {
        return "FicheroTextoFormateado: " +
                "fuente='" + fuente + '\'' +
                ", tamFuente=" + tamFuente +
                ", color='" + color + '\'';
    }

    @Override
    public void analizar() {
        System.out.println("Analizando FicheroTextoFormateado");
    }
}
