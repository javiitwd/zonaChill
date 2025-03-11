package TEMA5.VideoJuegoGPT;

public class JuegoDeDeporte extends Juego implements Multijugable {

    private String tipoDeDeporte;
    private boolean licenciasOficiales;

    public JuegoDeDeporte(String titulo, String estudio, double costeBase, String tipoDeDeporte, boolean licenciasOficiales) {
        super(titulo, estudio, costeBase);
        this.tipoDeDeporte = tipoDeDeporte;
        this.licenciasOficiales = licenciasOficiales;
    }

    @Override
    public void mantener() {
    }
}
