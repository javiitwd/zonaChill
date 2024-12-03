package TEMA4.BOLETÍN1.Ejercicio1.Prueba1;

import java.util.Scanner;

public class PrincipalRectangulo {
    static Scanner entrada = new Scanner(System.in);

    public static void main(String[] args) {

        //Creo objeto
        Rectangulo objetoRectangulo = new Rectangulo();

        boolean estaFueraLimites = true;

        do {
            try {
                System.out.println("Pon la longitud");
                objetoRectangulo.setLongitud(entrada.nextFloat());
                estaFueraLimites = false;

            } catch (RectanguloException e) {
                System.out.println(e.getMessage());
            }
        } while (estaFueraLimites);

        estaFueraLimites = true;

        do {
            try {
                System.out.println("Pon el ancho");
                objetoRectangulo.setAncho(entrada.nextFloat());
                estaFueraLimites = false;

            } catch (RectanguloException e) {
                System.out.println(e.getMessage());
            }
        } while (estaFueraLimites);

        System.out.println("El perimetro es " +objetoRectangulo.calcularPerimetro());
        System.out.println("El area es " +objetoRectangulo.calcularLArea());
    }
}
