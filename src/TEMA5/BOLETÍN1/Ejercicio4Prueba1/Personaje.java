package TEMA5.BOLETÍN1.Ejercicio4Prueba1;

import java.util.Comparator;

public class Personaje implements Comparable<Personaje> {

    public static final int MAX_PUNTOS_DE_VIDA = 100;
    public static final int MIN_PUNTOS_DE_VIDA = 0;
    public static final int MAX_FUERZA = 20;
    public static final int MIN_FUERZA = 0;
    public static final int MAX_INTELIGENCIA = 20;
    public static final int MIN_INTELIGENCIA = 0;

    private String nombre;
    private Traza raza;
    private int fuerza;
    private int inteligencia;
    private int puntosDeVidaMaximos;
    private int puntosDeVidaActuales;

    public Personaje(String nombre, Traza raza, int fuerza, int inteligencia, int puntosDeVidaMaximos) throws JuegoRolException {
        this.nombre = nombre;
        this.raza = raza;
        setFuerza(fuerza);
        setInteligencia(inteligencia);
        setPuntosDeVidaMaximos(puntosDeVidaMaximos);
        this.puntosDeVidaActuales = puntosDeVidaMaximos;
    }

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

    public void setFuerza(int fuerza) throws JuegoRolException {

        if (fuerza < MIN_FUERZA || fuerza > MAX_FUERZA){
            throw new JuegoRolException("Los puntos deben estar entre 0 y 20");
        }
        this.fuerza = fuerza;
    }

    public int getInteligencia() {
        return inteligencia;
    }

    public void setInteligencia(int inteligencia) throws JuegoRolException {
        if (inteligencia < MIN_INTELIGENCIA || inteligencia > MAX_INTELIGENCIA){
            throw new JuegoRolException("Los puntos deben estar entre 0 y 20");
        }
        this.inteligencia = inteligencia;
    }

    public int getPuntosDeVidaMaximos() {
        return puntosDeVidaMaximos;
    }

    public void setPuntosDeVidaMaximos(int puntosDeVidaMaximos) throws JuegoRolException {

        if (puntosDeVidaMaximos < MIN_PUNTOS_DE_VIDA || puntosDeVidaMaximos > MAX_PUNTOS_DE_VIDA){
            throw new JuegoRolException("Los puntos deben estar entre 0 y 100");
        }
        this.puntosDeVidaMaximos = puntosDeVidaMaximos;
    }

    public int getPuntosDeVidaActuales() {
        return puntosDeVidaActuales;
    }

    public void setPuntosDeVidaActuales(int puntosDeVidaActuales) throws JuegoRolException {
        if (puntosDeVidaActuales < MIN_PUNTOS_DE_VIDA || puntosDeVidaActuales > MAX_PUNTOS_DE_VIDA){
            throw new JuegoRolException("Los puntos deben estar entre 0 y 100");
        }
        this.puntosDeVidaActuales = puntosDeVidaActuales;
    }

    @Override
    public String toString() {
        return "Personaje{" +
                "nombre='" + nombre + '\'' +
                ", raza=" + raza +
                ", fuerza=" + fuerza +
                ", inteligencia=" + inteligencia +
                ", puntosDeVidaMaximos=" + puntosDeVidaMaximos +
                ", puntosDeVidaActuales=" + puntosDeVidaActuales +
                '}';
    }

    @Override
    public int compareTo(Personaje o) {
        return Integer.compare(puntosDeVidaActuales, o.puntosDeVidaActuales);
    }
}
