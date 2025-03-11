package TEMA5.CompeticionDeRobotsGPT;

public abstract class Robot {
    public static final int MIN_PUNTOS_APLICABLES = 0;
    public static final int MAX_PUNTOS_APLICABLES = 20;

    private String modeloRobot;
    //La velocidad del robot, determina que tan rapido avanza, puede ser reducida por los terreno
    private int velocidadDesplazamiento;
    //Determina la penalizacion de energia que recibira el robot al ser afectado por determinados obstaculos
    private int capacidadDeAdaptacion;
    //La energia del robot, determina que si al robot le queda energia para seguir en la carrera, puede ser reducida por lo obstaculos
    private int nivelEnergia;
    private int distanciaRecorrida;

    public Robot(String modeloRobot, int velocidadDesplazamiento, int capacidadDeAdaptacion, int nivelEnergia) throws RobotException {
        this.modeloRobot = modeloRobot;
        setVelocidadDesplazamiento(velocidadDesplazamiento);
        setCapacidadDeAdaptacion(capacidadDeAdaptacion);
        setNivelEnergia(nivelEnergia);
        distanciaRecorrida = 0;
    }

    public int getDistanciaRecorrida() {
        return distanciaRecorrida;
    }

    public void setDistanciaRecorrida(int distanciaRecorrida) {
        this.distanciaRecorrida = distanciaRecorrida;
    }

    public String getModeloRobot() {
        return modeloRobot;
    }

    public int getVelocidadDesplazamiento() {
        return velocidadDesplazamiento;
    }

    public void setVelocidadDesplazamiento(int velocidadDesplazamiento) throws RobotException {

        if (velocidadDesplazamiento < MIN_PUNTOS_APLICABLES || velocidadDesplazamiento > MAX_PUNTOS_APLICABLES){
            throw new RobotException("los puntos deben estar entre 0 y 20");
        }
        this.velocidadDesplazamiento = velocidadDesplazamiento;
    }

    public int getCapacidadDeAdaptacion() {
        return capacidadDeAdaptacion;
    }

    public void setCapacidadDeAdaptacion(int capacidadDeAdaptacion) throws RobotException {
        if (capacidadDeAdaptacion < MIN_PUNTOS_APLICABLES || capacidadDeAdaptacion > MAX_PUNTOS_APLICABLES){
            throw new RobotException("los puntos deben estar entre 0 y 20");
        }
        this.capacidadDeAdaptacion = capacidadDeAdaptacion;
    }

    public int getNivelEnergia() {
        return nivelEnergia;
    }

    public void setNivelEnergia(int nivelEnergia) throws RobotException {
        if (nivelEnergia < MIN_PUNTOS_APLICABLES || nivelEnergia > MAX_PUNTOS_APLICABLES){
            throw new RobotException("los puntos deben estar entre 0 y 20");
        }
        this.nivelEnergia = nivelEnergia;
    }

    public abstract void acelerar();

    public abstract void frenar();
}

