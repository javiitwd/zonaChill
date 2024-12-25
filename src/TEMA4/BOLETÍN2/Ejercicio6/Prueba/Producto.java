package TEMA4.BOLETÍN2.Ejercicio6.Prueba;

public class Producto {

    public static final double IVA = 0.20;
    public static int PRODUCTOS_CREADOS = 0;

    private String descripcion;
    private float precioBase;
    private int idProducto;


    public Producto(String descripcion, float precioBase) {

        this.descripcion = descripcion;
        this.precioBase = precioBase;
        this.idProducto = PRODUCTOS_CREADOS++;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public float getPrecioBase() {
        return precioBase;
    }

    public void setPrecioBase(float precioBase) {
        this.precioBase = precioBase;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public double calcularPrecioIva() {
        return precioBase + (precioBase * IVA);
    }
}
