package TEMA5.LuchadoresGPT;

import java.util.Random;

public class Luchador {
    public static final int MIN_PUNTOS_APLICABLES = 0;
    public static final int MAX_PUNTOS_APLICABLES = 100;
    private final int SALUD_MAX;

    private String nombre;
    private int velocidad;
    private int ataque;
    private int defensa;
    private int saludActual;

    public Luchador(int SALUD_MAX, String nombre, int velocidad, int ataque, int defensa) throws TorneoException {
        this.SALUD_MAX = SALUD_MAX;
        setSaludActual(SALUD_MAX);
        this.nombre = nombre;
        setVelocidad(velocidad);
        setAtaque(ataque);
        setDefensa(defensa);
    }

    public int getSALUD_MAX() {
        return SALUD_MAX;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(int velocidad) throws TorneoException {
        if (velocidad < 0 || velocidad > 100) {
            throw new TorneoException("Los puntos deben estar entre 0 y 100");
        }
        this.velocidad = velocidad;
    }

    public int getAtaque() {
        return ataque;
    }

    public void setAtaque(int ataque) throws TorneoException {
        if (ataque < 0 || ataque > 100) {
            throw new TorneoException("Los puntos deben estar entre 0 y 100");
        }
        this.ataque = ataque;
    }

    public int getDefensa() {
        return defensa;
    }

    public void setDefensa(int defensa) throws TorneoException {
        if (defensa < 0 || defensa > 100) {
            throw new TorneoException("Los puntos deben estar entre 0 y 100");
        }
        this.defensa = defensa;
    }

    public int getSaludActual() {
        return saludActual;
    }

    public void setSaludActual(int SALUD_MAX) throws TorneoException {
        if (SALUD_MAX < 0 || SALUD_MAX > 100) {
            throw new TorneoException("Los puntos deben estar entre 0 y 100");
        }
        this.saludActual = SALUD_MAX;
    }

    //Metodo para infligir daño a otro luchador, devuelve true si logra derrotarlo en este ataque
    public boolean atacar(Luchador luchadorAAtacar) throws TorneoException {

        //Calculamos si el luchador que va a ser atacado puede esquivar el ataque
        Random random = new Random();
        int numRandom = random.nextInt(10);
        if (numRandom > 8) {
            throw new TorneoException("El lcuhador ha esquivado el ataque");
        }

        //La vida que le va a restar es el ataque del que emite el daño menos la defensa del otro
        int vidaARestar = this.ataque - luchadorAAtacar.defensa;

        //Si la defensa del luchadorAAtacar es menor que el ataque del luchador actual le quitamos la vida correspondiente
        if (this.ataque > luchadorAAtacar.defensa) {
            luchadorAAtacar.setSaludActual(luchadorAAtacar.getSaludActual() - vidaARestar);
            //Si la defensa del luchadorAAtacar es superior al ataque del personaje que ataca le quitamos una cuarta parte de lo que le ibamos a quitar
        } else {
            int vidaARestarSiElAtaqueEsMenor = (int) (vidaARestar * 0.5);
            luchadorAAtacar.setSaludActual(luchadorAAtacar.getSaludActual() - vidaARestarSiElAtaqueEsMenor);
        }

        //Si el luchador que ha atacado ha vencido al otro, se lo hacemos saber
        if (luchadorAAtacar.getSaludActual() < 0) {
            luchadorAAtacar.setSaludActual(0);
            return true;
        }
        return false;
    }
}
