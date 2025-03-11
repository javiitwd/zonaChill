package TEMA5.CompeticionDeRobotsGPT;

public class Terreno {
    public static final int MIN_PENALIZACION_APLICABLE = 1;
    public static final int MAX_PENALIZACION_APLICABLE = 6;

    private String nombre;
    private int penalizacion;

    public Terreno(String nombre, int penalizacion) throws RobotException {
        this.nombre = nombre;
        setPenalizacion(penalizacion);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPenalizacion() {
        return penalizacion;
    }

    public void setPenalizacion(int penalizacion) throws RobotException {

        if (penalizacion < MIN_PENALIZACION_APLICABLE || penalizacion > MAX_PENALIZACION_APLICABLE) {
            throw new RobotException("Los puntos de penalizaicon deben estar entre " + MIN_PENALIZACION_APLICABLE + " y " + MAX_PENALIZACION_APLICABLE);
        }
        this.penalizacion = penalizacion;
    }

    public void penalizarRobot(Robot robot) throws RobotException {

        //Si el robot es Estable, le hacemos un casting y usamos el metodo de la interfaz para saber
        //cuanta velocidad debemos penalizarle, una vez calculado, se lo restamos a la velocidad del robot
        if (robot instanceof Estable) {
            Estable robotEstable = (Estable) robot;
            int velocidadAPenalizar = robotEstable.reducirPenalizacionTerreno(penalizacion);
            robot.setVelocidadDesplazamiento(robot.getVelocidadDesplazamiento() - velocidadAPenalizar);
        }

        //Sino es Estable, le afectamos directamente a su velocidad
        robot.setVelocidadDesplazamiento(robot.getVelocidadDesplazamiento() - penalizacion);
    }
}
