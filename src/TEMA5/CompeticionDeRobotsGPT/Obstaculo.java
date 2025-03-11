package TEMA5.CompeticionDeRobotsGPT;

public class Obstaculo {
    public static final int MIN_DANNO_APLICABLE = 1;
    public static final int MAX_DANNO_APLICABLE = 6;

    private String nombre;
    private int danno;


    public Obstaculo(String nombre, int danno) throws RobotException {
        this.nombre = nombre;
        setDanno(danno);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getDanno() {
        return danno;
    }

    public void setDanno(int danno) throws RobotException {

        if (danno < MIN_DANNO_APLICABLE || danno > MAX_DANNO_APLICABLE) {
            throw new RobotException("El daño aplicable debes estar entre " + MIN_DANNO_APLICABLE + " y " + MAX_DANNO_APLICABLE);
        }
        this.danno = danno;
    }

    public void dannarRobot(Robot robot) throws RobotException {

        if (robot instanceof Resistible) {
            Resistible robotResistible = (Resistible) robot;
            //Calculamos la resistencia al daño por ser Resistible
            int energiaAReducirPorResistible = robotResistible.reducirDanno(danno);

            //Restamos la capacidad de adaptacion del robot a la resistencia por ser Resistible
            int energiaTotalArestar = robot.getCapacidadDeAdaptacion() - energiaAReducirPorResistible;

            //Si el resultado es menor que 0, terminamos ya que el robot resiste el daño del obstaculo
            if (energiaTotalArestar < 0) {
                return;
            }

            //Si aun queda daño a restarle se lo quitamos a la energia del robot
            robot.setNivelEnergia(robot.getNivelEnergia() - energiaTotalArestar);
        }
    }
}
