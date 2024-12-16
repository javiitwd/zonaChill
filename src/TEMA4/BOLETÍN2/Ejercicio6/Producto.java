package TEMA4.BOLETÍN2.Ejercicio6;

public class Producto {


    private static final double IVA = 0.20;
    private static int productosCreados = 0;

    private int idProducto;
    private String descripcion;
    private double precioBase;

    public Producto(String descripcion, double precioBase) {

        this.idProducto = productosCreados++;
        this.descripcion = descripcion;
        this.precioBase = precioBase;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecioBase() {
        return precioBase;
    }

    public void setPrecioBase(double precioBase) {
        this.precioBase = precioBase;
    }

    public double calculoPrecio() {

        return precioBase;
    }

    public String toString() {

        return "Producto{" +
                "id=" + idProducto +
                ", descripcion=" + descripcion +"\'" +
                ", precioBase=" + precioBase +
                "}";
    }
}

