package TEMA5.BibliotecaGPT.Prueba1;

public class Biblioteca {

    Documento[] documentos;

    public Biblioteca(Documento[] documentos) {
        this.documentos = new Documento[100];
    }

    public Documento[] getDocumentos() {
        return documentos;
    }

    public void setDocumentos(Documento[] documentos) {
        this.documentos = documentos;
    }

    public String documentosMasPopulares() {

        Documento documentoConMasVisitas = documentos[0];
        Documento documentoConMasDescargas = documentos[0];
        int visitasDocumentosConMasVisitas = 0;
        int descargasDocumentosConMasDescargas = 0;

        for (int i = 1; i < documentos.length; i++) {

            if (documentos[i] instanceof Leible leible) {

                if (visitasDocumentosConMasVisitas < leible.obtenerNumVisitas()) {
                    documentoConMasVisitas = documentos[i];
                    visitasDocumentosConMasVisitas = leible.obtenerNumVisitas();
                }
            }

            if (documentos[i] instanceof Descargable descargable) {

                if (descargasDocumentosConMasDescargas < descargable.obtenerNumDescargas()) {
                    documentoConMasDescargas = documentos[i];
                    descargasDocumentosConMasDescargas = descargable.obtenerNumDescargas();
                }
            }
        }

        return "Documento con mas visitas: " + documentoConMasVisitas + " y el Documento con mas descargas: " + descargasDocumentosConMasDescargas;
    }
}
