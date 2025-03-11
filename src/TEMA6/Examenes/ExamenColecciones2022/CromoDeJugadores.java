package TEMA6.Examenes.ExamenColecciones2022;

public class CromoDeJugadores extends Cromo implements Comparable<CromoDeJugadores>{

    private String nombreJugador;
    private String equipoEnElQueJuega;
    private int alturaDelJugador;

    public CromoDeJugadores(int codigoUnico, String nombreJugador, String equipoEnElQueJuega, int alturaDelJugador) {
        super(codigoUnico);
        this.nombreJugador = nombreJugador;
        this.equipoEnElQueJuega = equipoEnElQueJuega;
        this.alturaDelJugador = alturaDelJugador;
    }

    public String getNombreJugador() {
        return nombreJugador;
    }

    public String getEquipoEnElQueJuega() {
        return equipoEnElQueJuega;
    }

    public int getAlturaDelJugador() {
        return alturaDelJugador;
    }

    @Override
    public String toString() {
        return nombreJugador;
    }

    @Override
    public int compareTo(CromoDeJugadores o) {
        return getNombreJugador().compareTo(o.nombreJugador);
    }
}
