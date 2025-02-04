package TEMA5.BibliotecaGPT;

public class ArticuloCientifico extends Documento {

    private int numCitas;
    private String revista;

    public ArticuloCientifico(String titulo, String autor, int identificador, int numCitas, String revista) {
        super(titulo, autor, identificador);
        this.numCitas = numCitas;
        this.revista = revista;
    }

    public int getNumCitas() {
        return numCitas;
    }

    public void setNumCitas(int numCitas) {
        this.numCitas = numCitas;
    }

    public String getRevista() {
        return revista;
    }

    public void setRevista(String revista) {
        this.revista = revista;
    }

    @Override
    public String toString() {
        return "ArticuloCientifico: " +
                "numCitas=" + numCitas +
                ", revista='" + revista + '\'';
    }
}
