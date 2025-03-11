package TEMA6.Examenes.ExamenColecciones2022;


public class CromoDeEscudos extends Cromo implements Comparable<CromoDeEscudos> {

    private String nombreEquipo;
    private int annoFundacion;
    private int numJugadores;

    public CromoDeEscudos(int codigoUnico, String nombreEquipo, int annoFundacion, int numJugadores) {
        super(codigoUnico);
        this.nombreEquipo = nombreEquipo;
        this.annoFundacion = annoFundacion;
        this.numJugadores = numJugadores;
    }

    public String getNombreEquipo() {
        return nombreEquipo;
    }

    @Override
    public String toString() {
        return nombreEquipo;
    }

    @Override
    public int compareTo(CromoDeEscudos o) {
        return getNombreEquipo().compareTo(o.nombreEquipo);
    }
}
