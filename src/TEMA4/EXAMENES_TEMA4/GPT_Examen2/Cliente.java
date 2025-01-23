/*package TEMA4.EXAMENES_TEMA4.GPT_EXAMEN2;

import java.util.Arrays;

public class Cliente {

    private int productosComprados;
    private double totalGastado;
    private String nombreCompleto;
    private String dni;
    private Producto[] nombreProductosComprados;
    private int[] cantidadProductosComprados;

    public Cliente(String nombreCompleto, String dni) {
        productosComprados = 0;
        this.nombreCompleto = nombreCompleto;
        this.dni = dni;
        totalGastado = 0;
        nombreProductosComprados = new Producto[productosComprados];
        cantidadProductosComprados = new int[productosComprados];
    }

    public int getProductosComprados() {
        return productosComprados;
    }

    public void setProductosComprados() {
        this.productosComprados += 1;
    }

    public void comprarProducto(Producto productoAComprar, int cantidad) throws InformaticaException {

        if (productoAComprar.getStock() < cantidad){
            throw new InformaticaException("No hay stock suficiente");
        }

        //Añado el producto a la posicion correspondiente, es decir, modifico los arrays, del nombre y cantidad
        nombreProductosComprados[productosComprados] = productoAComprar;
        cantidadProductosComprados[productosComprados] = cantidad;

        setProductosComprados();

        //Resto la cantidad del stock a ese producto
        productoAComprar.setStock(productoAComprar.getStock() - cantidad);

        totalGastado += productoAComprar.getPrecio() * cantidad;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "totalGastado=" + totalGastado +
                ", nombreProductosComprados=" + Arrays.toString(nombreProductosComprados) +
                ", cantidadProductosComprados=" + Arrays.toString(cantidadProductosComprados) +
                '}';
    }
}
*/