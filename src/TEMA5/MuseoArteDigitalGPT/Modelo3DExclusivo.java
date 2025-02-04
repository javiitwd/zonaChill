package TEMA5.MuseoArteDigitalGPT;

import java.time.LocalDate;

public class Modelo3DExclusivo extends Modelo3D{

    private LocalDate fechaFinalizacion;
    private int numAccesosPermitidos;
    private int contadorVisitas;

    public Modelo3DExclusivo(String titulo, String autor, int anoCreacion, int codigoInventario, double valor, int tam_mb, int numPoligonos, LocalDate fechaFinalizacion, int numAccesosPermitidos, int contadorVisitas) {
        super(titulo, autor, anoCreacion, codigoInventario, valor, tam_mb, numPoligonos);

        this.contadorVisitas = 0;
        this.numAccesosPermitidos = numAccesosPermitidos;
        this.fechaFinalizacion = fechaFinalizacion;
    }

    public LocalDate getFechaFinalizacion() {
        return fechaFinalizacion;
    }

    public int getNumAccesosPermitidos() {
        return numAccesosPermitidos;
    }

    public int getContadorVisitas() {
        return contadorVisitas;
    }

    public void setContadorVisitas(int contadorVisitas) {
        this.contadorVisitas = contadorVisitas;
    }

    @Override
    public String toString() {
        return "Modelo3DExclusivo{" +
                "fechaFinalizacion=" + fechaFinalizacion +
                ", numAccesosPermitidos=" + numAccesosPermitidos +
                ", contadorVisitas=" + contadorVisitas +
                '}';
    }
}
