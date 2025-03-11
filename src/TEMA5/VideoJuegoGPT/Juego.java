package TEMA5.VideoJuegoGPT;

public class Juego {

    private String titulo;
    private String estudio;
    private double costeBase;

    public Juego(String titulo, String estudio, double costeBase) {
        this.titulo = titulo;
        this.estudio = estudio;
        this.costeBase = costeBase;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getEstudio() {
        return estudio;
    }

    public void setEstudio(String estudio) {
        this.estudio = estudio;
    }

    public double getCosteBase() {
        return costeBase;
    }

    public void setCosteBase(double costeBase) {
        this.costeBase = costeBase;
    }
}
