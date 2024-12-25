/*
6. Crear una clase que represente Producto con las siguientes características:
● Tienen un código que los identifica de manera única y que se asigna
automáticamente en el momento de la creación.
● Guardan la descripción y el precio sin IVA.
● Todos los productos comparten el mismo IVA (supongamos el 20%), que puede
variar en función de las decisiones del gobierno.
La clase Producto debe proporcionar los métodos adecuados:
● Constructor.
● Métodos para consulta y modificación de los atributos.
● Metodo para calcular el precio de venta del producto que se obtiene sumándole al
precio el IVA correspondiente.
Realiza un programa principal que pruebe la clase anterior.
*/

package TEMA4.BOLETÍN2.Ejercicio6;

public class PrincipalProducto {
    public static void main(String[] args) {

        Producto producto1 = new Producto("Leche", 9.38);
        Producto producto2 = new Producto("Pan", 3.30);

        System.out.println(producto1); //Llama al metodo to.String
        System.out.println(producto1.calculoPrecio() + "€");

        System.out.println(producto2);
        System.out.println(producto2.calculoPrecio() + "€");
    }
}