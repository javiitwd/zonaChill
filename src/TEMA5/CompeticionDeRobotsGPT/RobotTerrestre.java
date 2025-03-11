package TEMA5.CompeticionDeRobotsGPT;

public class RobotTerrestre extends Robot implements Estable, Resistible {
    public static final double DANNO_REDUCIDO = 0.25;
    public static final double PENALIZACION_REDUCIDA = 0.5;

    public RobotTerrestre(String modeloRobot, int velocidadDesplazamiento, int capacidadDeAdaptacion, int nivelEnergia) throws RobotException {
        super(modeloRobot, velocidadDesplazamiento, capacidadDeAdaptacion, nivelEnergia);
    }

    @Override
    public void acelerar() {

        int distanciaARecorrer = getVelocidadDesplazamiento()*getNivelEnergia();
        setDistanciaRecorrida(distanciaARecorrer);
    }

    @Override
    public void frenar() {


    }

    @Override
    public int reducirPenalizacionTerreno(int penalizacion) {
        return (int) (penalizacion * 0.25);
    }

    @Override
    public int reducirDanno(int danno) {
        return (int) (danno * DANNO_REDUCIDO);
    }
}
