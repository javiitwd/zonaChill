package TEMA5.MuseoArteDigitalGPT;

import java.time.LocalDate;

public class ImagenDigitalExclusiva extends ImagenDigital{

    private LocalDate fechaFinalizacion;
    private int visitasRegistradas;
    private int numAccesosPermitidos;

    public ImagenDigitalExclusiva(String titulo, String autor, int anoCreacion, int codigoInventario, double valor, int resolucion, String formato, LocalDate fechaFinalizacion, int numAccesosPermitidos) {
        super(titulo, autor, anoCreacion, codigoInventario, valor, resolucion, formato);

        this.fechaFinalizacion = fechaFinalizacion;
        this.numAccesosPermitidos = numAccesosPermitidos;
        this.visitasRegistradas = 0;
    }

    public void setVisitasRegistradas(int visitasRegistradas) {
        this.visitasRegistradas = visitasRegistradas;
    }

    public LocalDate getFechaFinalizacion() {
        return fechaFinalizacion;
    }

    public int getVisitasRegistradas() {
        return visitasRegistradas;
    }

    public int getNumAccesosPermitidos() {
        return numAccesosPermitidos;
    }

    @Override
    public String toString() {
        return "ImagenDigitalExclusiva{" +
                "fechaFinalizacion=" + fechaFinalizacion +
                ", visitasRegistradas=" + visitasRegistradas +
                ", numAccesosPermitidos=" + numAccesosPermitidos +
                '}';
    }
}
