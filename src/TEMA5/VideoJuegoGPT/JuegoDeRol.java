package TEMA5.VideoJuegoGPT;

public class JuegoDeRol extends Juego implements Actualizable{

    private Tcomplejidad complejidad;

    public JuegoDeRol(String titulo, String estudio, double costeBase, Tcomplejidad complejidad) {
        super(titulo, estudio, costeBase);
        this.complejidad = complejidad;
    }

    @Override
    public void actualizar() {
    }
}
