package TEMA5.BOLETÍN1.Ejercicio3;

public class Clerigo extends Personaje {

    private static int HECHIZO_DE_CURA = 10;
    public static final int MAX_INTELIGENCIA_CLERIGO = 16;
    public static final int MIN_INTELIGENCIA_CLERIGO = 12;
    public static final int MIN_FUERZA_CLERIGO = 18;
    private String diosDelQueEsDevoto;

    public Clerigo(int vidaMaxima, int inteligencia, int fuerza, Traza raza, String nombre, String nombreDios) throws JuegoRolException {

        super(vidaMaxima, inteligencia, fuerza, raza, nombre);
        diosDelQueEsDevoto = nombreDios;
    }

    @Override
    public void setFuerza(int fuerza) throws JuegoRolException {

        if (fuerza < MIN_FUERZA_CLERIGO) {
            throw new JuegoRolException("La fuerza del clerigo no puede ser menor a " + MIN_FUERZA_CLERIGO);
        }
        super.setFuerza(fuerza);
    }

    @Override
    public void setInteligencia(int inteligencia) throws JuegoRolException {

        if (inteligencia <= MIN_INTELIGENCIA_CLERIGO) {
            throw new JuegoRolException("La inteligencia del clerigo no puede ser menor a " + MIN_INTELIGENCIA_CLERIGO);
        }
        if (inteligencia >= MAX_INTELIGENCIA_CLERIGO) {
            throw new JuegoRolException("La inteligencia del clerigo no puede ser mayor a " + MAX_INTELIGENCIA_CLERIGO);
        }
        super.setInteligencia(inteligencia);
    }

    public String getDiosDelQueEsDevoto() {
        return diosDelQueEsDevoto;
    }

    //METODO CURAR
    public void curar(Personaje personajeACurar) {

        //Para asegurarme de que no le añado mas vida de la que puede tener, si la vida del personaje
        //mas el hechizo superan el maximo... Le pongo la vida del personaje al maximo
        if (personajeACurar.getPuntoVidaActuales() + HECHIZO_DE_CURA > personajeACurar.getVidaMaxima()) {
            personajeACurar.setPuntoVidaActuales(personajeACurar.getVidaMaxima());
        } else {
            //Sino, Le añado 10 de vida al personaje que voy a curar
            personajeACurar.setPuntoVidaActuales(personajeACurar.getPuntoVidaActuales() + HECHIZO_DE_CURA);
        }
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
                ", raza = " + getRaza() +
                ", inteligencia = " + getInteligencia() +
                ", fuerza = " + getFuerza()+
                ", Dios del que es devoto = " +getDiosDelQueEsDevoto();
    }

}
