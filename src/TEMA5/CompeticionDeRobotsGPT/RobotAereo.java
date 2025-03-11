package TEMA5.CompeticionDeRobotsGPT;

public class RobotAereo extends Robot {
    public static final int MIN_PUNTOS_APLICABLES_VELOCIDAD = 15;
    public static final int MAX_PUNTOS_APLICABLES_ADAPTACION = 8;

    public RobotAereo(String modeloRobot, int velocidadDesplazamiento, int capacidadDeAdaptacion, int nivelEnergia) throws RobotException {

        if (velocidadDesplazamiento < MIN_PUNTOS_APLICABLES_VELOCIDAD) {
            throw new RobotException("La velocidad debe ser al menos de " + MIN_PUNTOS_APLICABLES_VELOCIDAD);
        }
        if (capacidadDeAdaptacion > MAX_PUNTOS_APLICABLES_ADAPTACION) {
            throw new RobotException("La capacidad de adaptacion no puede ser mayor de " + MAX_PUNTOS_APLICABLES_ADAPTACION);
        }
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
}
