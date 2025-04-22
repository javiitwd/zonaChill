/*package TEMA4.EXAMENES_TEMA4.GPT_Examen2;

public class PrincipalInformatica {
    public static void Ejercicio4Pro(String[] args) throws InformaticaException {
        // Crear productos
        Producto producto1 = new Producto("Laptop", 800.50, 10);
        Producto producto2 = new Producto("Smartphone", 500.00, 15);

        // Crear un cliente
        Cliente cliente = new Cliente("Ana Gómez", "98765432B");

        // Mostrar productos disponibles
        System.out.println("Productos disponibles:");
        System.out.println(producto1.getDetalles());
        System.out.println(producto2.getDetalles());

        try {
            // El cliente compra productos
            cliente.comprarProducto(producto1, 2);
            cliente.comprarProducto(producto2, 1);
        } catch (InformaticaException e) {
            System.out.println(e.getMessage());
        }

        // Mostrar el resumen de la compra
        System.out.println("\nResumen de la compra:");
        System.out.println(cliente.toString());

        // Mostrar stock actualizado
        System.out.println("\nStock actualizado:");
        System.out.println(producto1.getDetalles());
        System.out.println(producto2.getDetalles());
    }
}
*/