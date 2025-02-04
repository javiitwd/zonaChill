package TEMA5.BibliotecaGPT;

public class Biblioteca {

    public static final int MAX_DOCUMENTOS = 100;
    Documento[] documentos;

    public Biblioteca() {
        this.documentos = new Documento[MAX_DOCUMENTOS];
    }

    public void listarDocumentos() {

        for (int i = 0; i < documentos.length; i++) {

            System.out.println(documentos[i].toString());
        }
    }

    public Documento documentosMasVisualizaciones() {

        int visualizacionesMaximas = 0;
        int posicionConDocumentoMasVisualizaciones = 0;
        for (int i = 0; i < documentos.length; i++) {
            if (documentos[i] != null) {
                if (documentos[i] instanceof Leible) {
                    Leible l = (Leible) documentos[i];
                    if (l.consultarVisualizaciones() > visualizacionesMaximas) {
                        visualizacionesMaximas = l.consultarVisualizaciones();
                        posicionConDocumentoMasVisualizaciones = i;
                    }
                }
            }
        }
        return documentos[posicionConDocumentoMasVisualizaciones];
    }

    public Documento documentosMasDescargas() {

        int descargasMaximas = 0;
        int posicionConDocumentoMasDescargas = 0;
        for (int i = 0; i < documentos.length; i++) {
            if (documentos[i] != null) {
                if (documentos[i] instanceof Descargable) {
                    Descargable l = (Descargable) documentos[i];
                    if (l.consultarDescargas() > descargasMaximas) {
                        descargasMaximas = l.consultarDescargas();
                        posicionConDocumentoMasDescargas = i;
                    }
                }
            }
        }
        return documentos[posicionConDocumentoMasDescargas];
    }

    public int posicionLibre(){
        for (int i = 0; i < documentos.length; i++) {
            if (documentos[i] == null){
                return i;
            }
        }
        return -1;
    }

    public void mostrarDocumentos(){

        for (int i = 0; i < documentos.length; i++) {

            if (documentos[i] != null){
                System.out.println(documentos[i].toString());
            }
        }
    }

    public void anadirDocumento(Documento doc){

        documentos[posicionLibre()] = doc;
    }
}
