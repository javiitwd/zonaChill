package TEMA5.LuchadoresGPT.Prueba1;

import TEMA5.BOLETÍN1.Ejercicio4Prueba1.JuegoRolException;

import java.util.Random;

public class Luchador {
    public static final int MIN_PUNTOS_APLICABLES = 0;
    public static final int MAX_PUNTOS_APLICABLES = 100;

    private String nombre;
    private int ataque;
    private int velocidad;
    private int defensa;
    private int vidaMaxima;
    private int vidaActual;

    public Luchador(String nombre, int ataque, int velocidad, int defensa, int vidaMaxima) throws TorneoException {
        this.nombre = nombre;
        setAtaque(ataque);
        setVelocidad(velocidad);
        setDefensa(defensa);
        setVidaMaxima(vidaMaxima);
        vidaActual = vidaMaxima;
    }

    public String getNombre() {
        return nombre;
    }

    public int getAtaque() {
        return ataque;
    }

    public void setAtaque(int ataque) throws TorneoException {

        if (ataque < MIN_PUNTOS_APLICABLES || ataque > MAX_PUNTOS_APLICABLES) {
            throw new TorneoException("Los puntos salen de los limites");
        }
        this.ataque = ataque;
    }

    public int getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(int velocidad) throws TorneoException {
        if (velocidad < MIN_PUNTOS_APLICABLES || velocidad > MAX_PUNTOS_APLICABLES) {
            throw new TorneoException("Los puntos salen de los limites");
        }
        this.velocidad = velocidad;
    }

    public int getDefensa() {
        return defensa;
    }

    public void setDefensa(int defensa) throws TorneoException {
        if (defensa < MIN_PUNTOS_APLICABLES || defensa > MAX_PUNTOS_APLICABLES) {
            throw new TorneoException("Los puntos salen de los limites");
        }
        this.defensa = defensa;
    }

    public int getVidaMaxima() {
        return vidaMaxima;
    }

    public void setVidaMaxima(int vidaMaxima) throws TorneoException {

        if (vidaMaxima < MIN_PUNTOS_APLICABLES || vidaMaxima > MAX_PUNTOS_APLICABLES) {
            throw new TorneoException("Los puntos salen de los limites");
        }
        this.vidaMaxima = vidaMaxima;
    }

    public int getVidaActual() {
        return vidaActual;
    }

    public void setVidaActual(int vidaActual) {
        this.vidaActual = vidaActual;
    }

    public boolean atacar(Luchador luchadorAAtacar) {

        //Si el luchador al que vamos a atacar nos esquiva devolvemos falso, finalizando automaticamente el metodo
        if (luchadorAAtacar.esquiva()){
            return false;
        }

        int vidaARestar = 0;

        //Si nuestro ataque es inferior o igual a la defensa del que vamos a atacar, le restaremos solo la mitad del ataque del luchador qeu ataca
        if (ataque <= luchadorAAtacar.getDefensa()) {

            //Guardamos la mitad del daño
            vidaARestar = (int) (ataque / 2);

            //Le restamos a la vida del oponente el daño que le hemos hecho
            luchadorAAtacar.setVidaActual(luchadorAAtacar.getVidaActual() - vidaARestar);
        }

        //Si nuestro ataque es superior a la defensa del oponente le hacemos el daño completo
        luchadorAAtacar.setVidaActual(luchadorAAtacar.getVidaActual() - ataque);

        if (luchadorAAtacar.getVidaActual() < 1){
            return true;
        }
        return false;
    }

    //Metodo que le da aleatoriamente al luchador la posibilidad del equivar
    public boolean esquiva(){

        Random random = new Random();
        int numRandom = random.nextInt(10);

        if (numRandom < 2){
            return true;
        }
        return false;
    }
}
