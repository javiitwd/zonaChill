package TEMA5.BOLETÍN1.Ejercicio3;

public class Personaje {
    public static final int MAX_PUNTOS_APLICABLES = 20;
    public static final int MIN_PUNTOS_APLICABLES = 0;
    public static final int MAX_PUNTOS_VIDA = 100;
    public static final int MIN_PUNTOS_VIDA = 0;
    private String nombre;
    private Traza raza;
    private int fuerza;
    private int inteligencia;
    private int vidaMaxima;
    private int puntoVidaActuales;

    public Personaje(int vidaMaxima, int inteligencia, int fuerza, Traza raza, String nombre) throws JuegoRolException {

        this.raza = raza;
        this.nombre = nombre;
        setVidaMaxima(vidaMaxima);
        this.puntoVidaActuales = vidaMaxima;
        setInteligencia(inteligencia);
        setFuerza(fuerza);
    }

    //SETTERS PARA VALIDAR EL CONSTRUCTOR
    public void setFuerza(int fuerza) throws JuegoRolException {
        if (fuerza < MIN_PUNTOS_APLICABLES || fuerza > MAX_PUNTOS_APLICABLES) {
            throw new JuegoRolException("Los puntos deben estar entre + " + MIN_PUNTOS_APLICABLES + " y " + MAX_PUNTOS_APLICABLES);
        }
        this.fuerza = fuerza;
    }

    public void setInteligencia(int inteligencia) throws JuegoRolException {
        if (inteligencia < MIN_PUNTOS_APLICABLES || inteligencia > MAX_PUNTOS_APLICABLES) {
            throw new JuegoRolException("Los puntos deben estar entre + " + MIN_PUNTOS_APLICABLES + " y " + MAX_PUNTOS_APLICABLES);
        }
        this.inteligencia = inteligencia;
    }

    public void setVidaMaxima(int vidaMaxima) throws JuegoRolException {
        if (vidaMaxima < MIN_PUNTOS_VIDA || vidaMaxima > MAX_PUNTOS_VIDA) {
            throw new JuegoRolException("Los puntos deben estar entre + " + MIN_PUNTOS_VIDA + " y " + MAX_PUNTOS_VIDA);
        }
        this.vidaMaxima = vidaMaxima;
    }

    //GETTER Y SETTER

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Traza getRaza() {
        return raza;
    }

    public void setRaza(Traza raza) {
        this.raza = raza;
    }

    public int getFuerza() {
        return fuerza;
    }

    public int getInteligencia() {
        return inteligencia;
    }

    public int getVidaMaxima() {
        return vidaMaxima;
    }

    public int getPuntoVidaActuales() {
        return puntoVidaActuales;
    }

    public void setPuntoVidaActuales(int puntoVidaActuales) {
        this.puntoVidaActuales = puntoVidaActuales;
    }

    /**
     * @toString devuelve las caracteristicas actuales del personaje
     */
    @Override
    public String toString() {
        return "Personaje " +
                "Nombre = " + getNombre() +
                ", Vida maxima = " + getVidaMaxima() +
                ", Vida actual = " + getPuntoVidaActuales() +
                ", raza = " +getRaza() +
                ", inteligencia = " +getInteligencia()+
                ", fuerza = " +getFuerza();
    }

}
