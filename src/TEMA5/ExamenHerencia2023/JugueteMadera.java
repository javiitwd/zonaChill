package TEMA5.ExamenHerencia2023;

public class JugueteMadera extends Juguete {

    private String origenMadera;
    private int annoTala;

    public JugueteMadera(double precio, String nombre, String marca, String origenMadera, int annoTala) {
        super(precio, nombre, marca);
        this.origenMadera = origenMadera;
        this.annoTala = annoTala;
    }

    public String getOrigenMadera() {
        return origenMadera;
    }

    public void setOrigenMadera(String origenMadera) {
        this.origenMadera = origenMadera;
    }

    public int getAnnoTala() {
        return annoTala;
    }

    public void setAnnoTala(int annoTala) {
        this.annoTala = annoTala;
    }
}
