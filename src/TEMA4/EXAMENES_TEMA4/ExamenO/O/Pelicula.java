package TEMA4.EXAMENES_TEMA4.ExamenO.O;

public class Pelicula {
    private String titulo;
    private int yearEstreno;
    private String director;
    private double presupuesto;
    private double recaudacion;
    private String siponsis;
    private String etiquetas;
    private double valoracion;

    public Pelicula(String titulo, int yearEstreno, String director, double presupuesto, double recaudacion, String siponsis, String etiquetas) {
        this.titulo = titulo;
        this.yearEstreno = yearEstreno;
        this.director = director;
        this.presupuesto = presupuesto;
        this.recaudacion = recaudacion;
        this.siponsis = siponsis;
        this.etiquetas = etiquetas;
        if (recaudacion == 0) {
            this.valoracion = 0;
        } else {
            this.valoracion = (recaudacion / presupuesto) * 5;  // Regla de 3 para calcular entre 0 y 10.
            if (this.valoracion > 10) this.valoracion = 10;  // Valoración máxima de 10.
        }

    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getYearEstreno() {
        return yearEstreno;
    }

    public void setYearEstreno(int yearEstreno) {
        this.yearEstreno = yearEstreno;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public double getPresupuesto() {
        return presupuesto;
    }

    public void setPresupuesto(double presupuesto) {
        this.presupuesto = presupuesto;
    }

    public double getRecaudacion() {
        return recaudacion;
    }

    public void setRecaudacion(double recaudacion) {
        this.recaudacion = recaudacion;
    }

    public String getSiponsis() {
        return siponsis;
    }

    public void setSiponsis(String siponsis) {
        this.siponsis = siponsis;
    }

    public String getEtiquetas() {
        return etiquetas;
    }

    public void setEtiquetas(String etiquetas) {
        this.etiquetas = etiquetas;
    }

    public double getValoracion() {
        return valoracion;
    }

    public void setValoracion(double valoracion) {
        this.valoracion = valoracion;
    }
}
