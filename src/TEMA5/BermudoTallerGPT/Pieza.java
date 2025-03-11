package TEMA5.BermudoTallerGPT;

public class Pieza {

    private int codigo;
    private String descripcion;
    private double coste;

    public Pieza(int codigo, String descripcion, double coste) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.coste = coste;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getCoste() {
        return coste;
    }

    public void setCoste(double coste) {
        this.coste = coste;
    }
}
