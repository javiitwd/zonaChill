package TEMA5.BermudoTallerGPT;

import java.util.Random;

public class PiezaReparableYExaminable extends Pieza implements Reparable, Examinable {

    public static final double INCREMENTO_POR_REPARACION = 0.5;
    public static final double INCREMENTO_POR_EXAMINAR = 0.10;

    private boolean estaEnBuenEstado;

    public PiezaReparableYExaminable(int codigo, String descripcion, double coste) {
        super(codigo, descripcion, coste);
    }

    public boolean isEstaEnBuenEstado() {
        return estaEnBuenEstado;
    }

    public void setEstaEnBuenEstado(boolean estaEnBuenEstado) {
        this.estaEnBuenEstado = estaEnBuenEstado;
    }

    @Override
    public boolean examinar() {
        //Incrementamos el coste por examinar la pieza
        setCoste(getCoste() * INCREMENTO_POR_EXAMINAR);
        Random random = new Random();
        return random.nextBoolean();
    }

    @Override
    public void reparar() {
        //Incrementamos el coste por reparar la pieza
        setCoste(getCoste() * INCREMENTO_POR_REPARACION);
        setEstaEnBuenEstado(true);
    }
}
