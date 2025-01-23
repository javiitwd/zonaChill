package TEMA4.EjercicioGimnasio;

public class Cliente {
    private String nombre;
    private String identificacion;
    private int edad;
    private int experienciaEnDeporte;
    private Entrenamiento planDeEntrenamiento;
    private int entrenamientosCompletados;
    private StringBuilder actividadesTotalesTerminadasEnEntrenamiento;

    public Cliente(String nombre, String identificacion, int edad, int experienciaEnDeporte, Entrenamiento planDeEntrenamiento) {
        this.nombre = nombre;
        this.identificacion = identificacion;
        this.edad = edad;
        this.experienciaEnDeporte = experienciaEnDeporte;
        this.planDeEntrenamiento = planDeEntrenamiento;
        entrenamientosCompletados = 0;
        actividadesTotalesTerminadasEnEntrenamiento = new StringBuilder();
    }

    public int getEntrenamientosCompletados() {
        return entrenamientosCompletados;
    }

    public void setEntrenamientosCompletados() {
        this.entrenamientosCompletados ++;
    }

    public void asignarNuevoPlanDeEntrenamiento(Entrenamiento planDeEntrenamientoNuevo) throws GimnasioException {

        for (int i = 0; i < planDeEntrenamiento.getEntrenamiento().length; i++) {

            //Llamo a la actividad que hay en el entrenamiento en posicion i, y miro si esta completa
            if (!planDeEntrenamiento.getEntrenamiento()[i].isActividadCompleta()){
                throw new GimnasioException("No ha terminado el plan de entrenamiento");
            }
        }
        //Si ha terminado todas las actividades del plan de entrenamiento
        //Añade a todas las actividades completas en general las actividades terminadas en el ese entrenamiento
        actividadesTotalesTerminadasEnEntrenamiento.append(planDeEntrenamiento.getActividadesTotalesCompletas());
        planDeEntrenamiento = planDeEntrenamientoNuevo;
        entrenamientosCompletados++;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "nombre='" + nombre + '\'' +
                ", identificacion='" + identificacion + '\'' +
                ", edad=" + edad +
                ", experienciaEnDeporte=" + experienciaEnDeporte +
                ", entrenamientosCompletados=" + entrenamientosCompletados +
                ", actividadesTotalesTerminadasEnEntrenamiento=" + actividadesTotalesTerminadasEnEntrenamiento +
                '}';
    }
}
