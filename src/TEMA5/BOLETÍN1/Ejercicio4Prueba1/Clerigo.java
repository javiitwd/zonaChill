package TEMA5.BOLETÍN1.Ejercicio4Prueba1;

public class Clerigo extends Personaje {

    private static final int MIN_FUERZA_CLERIGO = 18;
    private static final int MAX_INTELIGENCIA_CLERIGO = 12;
    private static final int MIN_INTELIGENCIA_CLERIGO = 16;
    private static final int PODER_DE_CURA = 10;
    private String nombreDelDiosAlQueReza;

    public Clerigo(String nombre, Traza raza, int fuerza, int inteligencia, int puntosDeVidaMaximos, String nombreDelDiosAlQueReza) throws JuegoRolException {
        super(nombre, raza, fuerza, inteligencia, puntosDeVidaMaximos);
        this.nombreDelDiosAlQueReza = nombreDelDiosAlQueReza;
    }

    @Override
    public void setFuerza(int fuerza) throws JuegoRolException {

        if (fuerza < MIN_FUERZA_CLERIGO) {
            throw new JuegoRolException("La fuerza del clerigo es incorrecta");
        }
        super.setFuerza(fuerza);
    }

    @Override
    public void setInteligencia(int inteligencia) throws JuegoRolException {

        if (inteligencia < MIN_INTELIGENCIA_CLERIGO && inteligencia > MAX_INTELIGENCIA_CLERIGO) {
            throw new JuegoRolException("La inteligencia del clerigo es incorrecta");
        }
        super.setInteligencia(inteligencia);
    }

    public void curar(Personaje personajeACurar) throws JuegoRolException {

        //Si la vida del personaje tras la curacion supera el maximo actualizamos la vida al maximo
        if (personajeACurar.getPuntosDeVidaActuales() + PODER_DE_CURA > MAX_PUNTOS_DE_VIDA) {

            personajeACurar.setPuntosDeVidaActuales(MAX_PUNTOS_DE_VIDA);
        }

        //Sino supera el maximo le sumamos la cura a la vida
        personajeACurar.setPuntosDeVidaActuales(personajeACurar.getPuntosDeVidaActuales() + PODER_DE_CURA);
    }

    @Override
    public String toString() {
        return "Clerigo{" +
                "nombreDelDiosAlQueReza='" + nombreDelDiosAlQueReza + '\'' +
                '}';
    }
}
