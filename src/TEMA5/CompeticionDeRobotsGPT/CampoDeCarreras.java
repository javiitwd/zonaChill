package TEMA5.CompeticionDeRobotsGPT;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class CampoDeCarreras {

    private int distanciaARecorrer;
    private List<Robot> listaDeRobots;
    private List<Terreno> terrenosDeLaCarrera;
    private List<Obstaculo> obstaculosDeLaCarrera;

    public CampoDeCarreras(int distanciaARecorrer) {
        this.distanciaARecorrer = distanciaARecorrer;
        listaDeRobots = new ArrayList<>();
        //Creamos y ponemos en aleatorio el los terrenos y obstaculos
        terrenosDeLaCarrera = new ArrayList<>();
        Collections.shuffle(terrenosDeLaCarrera);
        obstaculosDeLaCarrera = new ArrayList<>();
        Collections.shuffle(obstaculosDeLaCarrera);
    }

    public int getDistanciaARecorrer() {
        return distanciaARecorrer;
    }

    public void setDistanciaARecorrer(int distanciaARecorrer) {
        this.distanciaARecorrer = distanciaARecorrer;
    }

    public String empezarCarrera() throws RobotException {

        if (listaDeRobots.isEmpty()) {
            throw new RobotException("No hay robots");
        }

        boolean ganador = false;
        while (!ganador) {

            Robot robotGanador = darVuelta();
            if (robotGanador != null) {
                return "Ha ganado el robot " + robotGanador.getModeloRobot();
            }
        }
        throw new RobotException("Ha ocurrido un error");
    }

    public Robot darVuelta() throws RobotException {

        for (Robot robotActual : listaDeRobots) {

            robotActual.acelerar();
            entrarEnTerreno(terrenosDeLaCarrera.getFirst(), robotActual);

            if (robotActual.getDistanciaRecorrida() >= distanciaARecorrer) {
                return robotActual;
            }
        }
        return null;
    }

    public void entrarEnTerreno(Terreno terreno, Robot robot) throws RobotException {

        terreno.penalizarRobot(robot);
    }

    public void chocarConObstaculo(Obstaculo obstaculo, Robot robot) throws RobotException {

        obstaculo.dannarRobot(robot);
    }
}
