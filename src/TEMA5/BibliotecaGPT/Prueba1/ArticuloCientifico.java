package TEMA5.BibliotecaGPT.Prueba1;

public class ArticuloCientifico extends Documento{

    private int numCitas;
    private String revistaEnLaQueFuePublicado;

    public ArticuloCientifico(int idUnico, String autor, String titulo, int numCitas, String revistaEnLaQueFuePublicado) {
        super(idUnico, autor, titulo);
        this.numCitas = numCitas;
        this.revistaEnLaQueFuePublicado = revistaEnLaQueFuePublicado;
    }
}
