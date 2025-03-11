package TEMA5.VideoJuegoGPT;

public class JuegoDeAccion extends Juego implements Actualizable {

    private static final int MAX_PERSONAJES = 10;

    private int niveles;
    private Personaje[] personajes;

    public JuegoDeAccion(String titulo, String estudio, double costeBase, int niveles, Personaje[] personajes) {
        super(titulo, estudio, costeBase);
        this.niveles = niveles;
        this.personajes = new Personaje[MAX_PERSONAJES];
    }

    @Override
    public void actualizar() {
    }
}
