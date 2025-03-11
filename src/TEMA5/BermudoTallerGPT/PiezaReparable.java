package TEMA5.BermudoTallerGPT;

public class PiezaReparable extends Pieza implements Reparable {

    public static final double INCREMENTO_POR_REPARACION = 0.5;

    private boolean estaEnBuenEstado;

    public PiezaReparable(int codigo, String descripcion, double coste, boolean estaEnBuenEstado) {
        super(codigo, descripcion, coste);
        this.estaEnBuenEstado = estaEnBuenEstado;
    }

    public boolean isEstaEnBuenEstado() {
        return estaEnBuenEstado;
    }

    public void setEstaEnBuenEstado(boolean estaEnBuenEstado) {
        this.estaEnBuenEstado = estaEnBuenEstado;
    }

    @Override
    public void reparar() {
        //Incrementamos el coste por reparar la pieza
        setCoste(getCoste() * INCREMENTO_POR_REPARACION);
        setEstaEnBuenEstado(true);
    }
}
