package TEMA4.BOLETÍN2.Ejercicio6.Prueba;

import java.util.Scanner;

public class PrincipalProducto {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Producto producto = null;

        System.out.println("Dirme la descripcion");
        String descripcion = sc.next();
        System.out.println("Dirme el precio");
        float precio = sc.nextFloat();

        producto = new Producto(descripcion, precio);

        System.out.printf("El producto %s tiene un precio base %.2f y y con IVA de %.2f",descripcion,precio, +producto.calcularPrecioIva() );
    }
}
