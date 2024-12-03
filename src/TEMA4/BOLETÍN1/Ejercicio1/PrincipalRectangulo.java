package TEMA4.BOLETÍN1.Ejercicio1;

import java.util.Scanner;

public class PrincipalRectangulo {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        //Objeto
        Rectangulo rectangulo1 = new Rectangulo();

        boolean parametroCorrecto = false;
        do {
            try {
                System.out.println("Introduce la longitud del rectangulo.");
                rectangulo1.setLongitud(entrada.nextInt()); //Longitud es enviado al metodo setLongitud de la clase Rectangulo (donde trata de atrapar la excepcion).
                                                            //Este metodo establece la longitud del rectangulo. Si el valor dado es valido (entre 1 y 20), la longitud del rectangulo se actualiza.

                parametroCorrecto = true; //Si no hay errores, se establece como verdadero, ya que de haber error iria directamente a la excepcionde abajo y el valor del boolean nunca cambiaria

            } catch (RectanguloException e) { //Si ocurre una excepción (valor inválido), se captura aquí con el nombre de "e"
                System.out.println(e.getMessage());  //Muestra el mensaje de error de la excepción
            }
        } while (!parametroCorrecto);
        parametroCorrecto = false;

        do {

            try {
                System.out.println("Introduce el ancho del rectangulo.");
                rectangulo1.setAncho(entrada.nextInt());
                parametroCorrecto = true;
            } catch (RectanguloException e) {
                System.out.println(e.getMessage());
            }
        } while (!parametroCorrecto);

        System.out.println("El perimetro del rectangulo 1 es: " + rectangulo1.calcularPerimetro());
        System.out.println("El area del rectangulo 1 es de " + rectangulo1.calcularArea());

    }
}