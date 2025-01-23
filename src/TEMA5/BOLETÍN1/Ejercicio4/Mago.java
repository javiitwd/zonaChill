package TEMA5.BOLETÍN1.Ejercicio4;

public class Mago extends Personaje {
    private static final int SPELL_DAMAGE = 10;
    private static final int MAX_HECHIZOS = 4;
    public static final int MIN_INTELIGENCIA_MAGO = 17;
    public static final int MAX_FUERZA_MAGO = 15;
    private Hechizo[] hechizosAprendidos;

    public Mago(int vidaMaxima, int inteligencia, int fuerza, Traza raza, String nombre) throws JuegoRolException {

        super(vidaMaxima, inteligencia, fuerza, raza, nombre);

        hechizosAprendidos = new Hechizo[MAX_HECHIZOS];
    }

    @Override
    public void setInteligencia(int inteligencia) throws JuegoRolException {

        if (inteligencia < MIN_INTELIGENCIA_MAGO) {
            throw new JuegoRolException("La inteligencia del mago no puede ser menor a " + MIN_INTELIGENCIA_MAGO);
        }
        super.setInteligencia(inteligencia);
    }

    @Override
    public void setFuerza(int fuerza) throws JuegoRolException {
        if (fuerza > MAX_FUERZA_MAGO) {
            throw new JuegoRolException("La fuerza del mago no puede ser mayor a " + MAX_FUERZA_MAGO);
        }
        super.setFuerza(fuerza);
    }

    //Metodo para buscar si el mago aun puede aprender hechizo, devuelve la posicion libre
    public int huecoDisponibleAlmacenDeHechizos() throws JuegoRolException {

        for (int i = 0; i < hechizosAprendidos.length; i++) {
            if (hechizosAprendidos[i] == null) {
                return i;
            }
        }
        throw new JuegoRolException("Ya ha aprendido el maximo de hechizos disponibles");
    }

    //Metodo para buscar hechizo por nombre
    public int buscarHechizo(String nombreHechizo) throws JuegoRolException {
        //Recorro los hechizos del personaje, y sin coindicen en nombre, devuelvo posicion en la que lo hace
        for (int i = 0; i < hechizosAprendidos.length; i++) {

            //Me asaeguro que solo busco los diferentes a null, ya que sino, al usar el equals lanzaria un error
            if (hechizosAprendidos[i] != null) {
                if (hechizosAprendidos[i].getNombreHechizo().equals(nombreHechizo)) {
                    return i;
                }
            }
        }
        throw new JuegoRolException("El hechizo no existe en su personaje");
    }

    //METODO APRENDE HECHIZO
    public void aprendeHehizo(String hechizo) throws JuegoRolException {

        hechizosAprendidos[huecoDisponibleAlmacenDeHechizos()] = new Hechizo(hechizo);
    }

    //METODO LANZA HECHIZO
    public void lanzaHechizo(Personaje personajeQueRecibeHechizo, String hechizo) throws JuegoRolException {

        //Le resto 10 a la vida del personaje que ataco
        personajeQueRecibeHechizo.setPuntoVidaActuales(personajeQueRecibeHechizo.getPuntoVidaActuales() - SPELL_DAMAGE);
        //Borro el hechizo usado
        hechizosAprendidos[buscarHechizo(hechizo)] = null;
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
                ", fuerza = " + getFuerza();
    }
}



/*
PARA MEJORAR EL TOSTRING DE MAGO

esto recorre todos los hechizos y los va metiendo en un StringBuilder
para que a la hora de implimirlos, salga ordenado:

public String toString() {
    StringBuilder hechizos = new StringBuilder();
    for (Hechizo hechizo : hechizosAprendidos) {
        if (hechizo != null) {
            hechizos.append(hechizo.toString()).append(", ");
        }
    }
    return "Mago: " +
            "nombre= " + getNombre() +
            ", raza=" + getRaza() +
            ", fuerza=" + getFuerza() +
            ", inteligencia=" + getInteligencia() +
            ", vidaMaxima=" + getVidaMaxima() +
            ", puntoVidaActuales=" + getPuntoVidaActuales() +
            ", hechizosAprendidos=[" + hechizos.toString() + "]" +
            '.';
     */