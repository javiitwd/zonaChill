package TEMA5.BibliotecaGPT;

public class ArticuloCientificoDescargabe extends ArticuloCientifico implements Descargable {

    private int tam_mb;
    private int descargasRealizadas;

    public ArticuloCientificoDescargabe(String titulo, String autor, int identificador, int numCitas, String revista, int tam_mb) {
        super(titulo, autor, identificador, numCitas, revista);

        this.tam_mb = tam_mb;
        descargasRealizadas = 0;
    }

    public int getTam_mb() {
        return tam_mb;
    }

    public void setTam_mb(int tam_mb) {
        this.tam_mb = tam_mb;
    }

    public int getDescargasRealizadas() {
        return descargasRealizadas;
    }

    public void setDescargasRealizadas() {
        this.descargasRealizadas++;
    }

    @Override
    public void descargar() {
        setDescargasRealizadas();
    }

    @Override
    public int consultarMB() {
        return tam_mb;
    }

    @Override
    public int consultarDescargas() {
        return descargasRealizadas;
    }

    @Override
    public String toString() {
        return "ArticuloCientificoDescargabe: " +
                "tam_mb=" + tam_mb +
                ", descargasRealizadas=" + descargasRealizadas;
    }
}
