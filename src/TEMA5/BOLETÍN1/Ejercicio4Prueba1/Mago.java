package TEMA5.BOLETÍN1.Ejercicio4Prueba1;

import java.util.Arrays;

public class Mago extends Personaje {

    private static final int MIN_INTELIGENCIA_MAGO = 17;
    private static final int MAX_FUERZA_MAGO = 15;
    public static final int MAX_CAPACIDAD_HECHIZOS = 4;
    private static final int DANNO_HECHIZO = 10;
    private String[] hechizos;

    public Mago(String nombre, Traza raza, int fuerza, int inteligencia, int puntosDeVidaMaximos) throws JuegoRolException {
        super(nombre, raza, fuerza, inteligencia, puntosDeVidaMaximos);
        hechizos = new String[MAX_CAPACIDAD_HECHIZOS];
    }

    @Override
    public void setInteligencia(int inteligencia) throws JuegoRolException {
        if (inteligencia < MIN_INTELIGENCIA_MAGO) {
            throw new JuegoRolException("La inteligencia del mago es incorrecta");
        }
        super.setInteligencia(inteligencia);
    }

    @Override
    public void setFuerza(int fuerza) throws JuegoRolException {

        if (fuerza > MAX_FUERZA_MAGO) {
            throw new JuegoRolException("La fuerza del Mago es incorrecta");
        }
        super.setFuerza(fuerza);
    }

    private int contarHechizos() {

        int contadorDeHechizos = 0;
        for (int i = 0; i < hechizos.length; i++) {

            if (hechizos[i] != null) {
                contadorDeHechizos++;
            }
        }
        return contadorDeHechizos;
    }

    public String aprenderHechizo(String nombreHechizo) throws JuegoRolException {

        if (contarHechizos() >= MAX_CAPACIDAD_HECHIZOS) {
            throw new JuegoRolException("Ha superado su máximo de hechizos");
        }

        hechizos[contarHechizos()] = nombreHechizo;
        return "se ha aprendido el hechizo";
    }

    public String lanzarHechizo(Personaje personajeADannar, String hechizoALanzar) throws JuegoRolException {

        //Si a la vida que tiene el personaje le restamos el daño del hechizo y se queda en < 0 le ponemos la vida en 0
        if (personajeADannar.getPuntosDeVidaActuales() - DANNO_HECHIZO < 0) {
            personajeADannar.setPuntosDeVidaActuales(0);
            return "se ha debilitado al personaje";
        }

        //si la vida tras el hechizo no se queda en < 0 le actualizamos su vida
        personajeADannar.setPuntosDeVidaActuales(personajeADannar.getPuntosDeVidaActuales() - DANNO_HECHIZO);
        return "se ha lanzado al hechizo " + hechizoALanzar + " la vida del oponente es de " + personajeADannar.getPuntosDeVidaActuales();
    }

    @Override
    public String toString() {
        return "Mago{" +
                "hechizos=" + Arrays.toString(hechizos) +
                '}';
    }
}
