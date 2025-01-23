package TEMA4.EjercicioGimnasio;

public class ActividadFisica {

    private String descripcion;
    private int duracion;
    private int nivelDeIntensidad;
    private boolean actividadCompleta;

    public ActividadFisica(String descripcion, int duracion, int nivelDeIntensidad) {
        this.descripcion = descripcion;
        this.duracion = duracion;
        this.nivelDeIntensidad = nivelDeIntensidad;
        this.actividadCompleta = false;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public int getNivelDeIntensidad() {
        return nivelDeIntensidad;
    }

    public void setNivelDeIntensidad(int nivelDeIntensidad) {
        this.nivelDeIntensidad = nivelDeIntensidad;
    }

    public boolean isActividadCompleta() {
        return actividadCompleta;
    }

    public void setActividadCompleta(boolean actividadCompleta) {
        this.actividadCompleta = actividadCompleta;
    }
}
