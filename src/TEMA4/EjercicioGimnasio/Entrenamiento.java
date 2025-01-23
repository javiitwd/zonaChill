package TEMA4.EjercicioGimnasio;

public class Entrenamiento {
    private final int ACTIVIDADES_EN_EL_ENTRENAMIENTO;

    private StringBuilder actividadesTotalesCompletas;
    private ActividadFisica[] entrenamiento;

    public Entrenamiento(int actividadesEnElEntrenamiento) {

        this.ACTIVIDADES_EN_EL_ENTRENAMIENTO = actividadesEnElEntrenamiento;
        this.entrenamiento = new ActividadFisica[ACTIVIDADES_EN_EL_ENTRENAMIENTO];
        actividadesTotalesCompletas = new StringBuilder();
    }

    public ActividadFisica[] getEntrenamiento() {
        return entrenamiento;
    }

    public StringBuilder getActividadesTotalesCompletas() {
        return actividadesTotalesCompletas;
    }

    public void setActividadesTotalesCompletas(StringBuilder actividadesTotalesCompletas) {
        this.actividadesTotalesCompletas = actividadesTotalesCompletas;
    }

    public void setEntrenamiento(ActividadFisica[] entrenamiento) {
        this.entrenamiento = entrenamiento;
    }

    public void completarActividad(String descripcionActividad){

        for (int i = 0; i < entrenamiento.length; i++) {

            //Buscamos en el entrenamiento la actividad solicitada y cambiamos su valor a true
            if (entrenamiento[i].getDescripcion().equalsIgnoreCase(descripcionActividad)){

                entrenamiento[i].setActividadCompleta(true);

                //Si pongo la actividad como completada la añado a las actividades totales completadas
                actividadesTotalesCompletas.append(descripcionActividad).append(System.lineSeparator());
            }
        }
    }
}
