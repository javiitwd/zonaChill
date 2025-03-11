package TEMA5.VideoJuegoGPT;

public class JuegoDeEstrategia extends Juego implements  Multijugable{

    private String sistemaDeRecursos;
    private int duracionEnHoras;

    public JuegoDeEstrategia(String titulo, String estudio, double costeBase, String sistemaDeRecursos, int duracionEnHoras) {
        super(titulo, estudio, costeBase);
        this.sistemaDeRecursos = sistemaDeRecursos;
        this.duracionEnHoras = duracionEnHoras;
    }

    @Override
    public void mantener() {

    }
}
