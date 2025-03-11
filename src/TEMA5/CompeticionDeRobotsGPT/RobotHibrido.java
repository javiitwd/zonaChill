package TEMA5.CompeticionDeRobotsGPT;

public class RobotHibrido extends Robot implements Estable {

    public RobotHibrido(String modeloRobot, int velocidadDesplazamiento, int capacidadDeAdaptacion, int nivelEnergia) throws RobotException {
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
        return (int) (penalizacion * 0.5);
    }
}
