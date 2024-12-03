package TEMA4.BOLETÍN1.Ejercicio1.Prueba1.Cuadrado;

import java.util.Scanner;

public class PrincipalCuadrado {
    public static void main(String[] args) {
       Scanner entrada = new Scanner(System.in);

        Cuadrado objetoCuadrado = new Cuadrado();

        boolean estaFueraLimites = true;

        do {
            try{
                System.out.println("Pon la longitud");
                objetoCuadrado.setLongitud(entrada.nextInt());
                estaFueraLimites = false;
            }catch (CuadradoException e){
                System.out.println(e.getMessage());
            }
        } while (estaFueraLimites);

        estaFueraLimites = true;

        do{
            try {
                System.out.println("Pon el ancho");
                objetoCuadrado.setAncho(entrada.nextInt());
                estaFueraLimites = false;
            }catch (CuadradoException e){
                System.out.println(e.getMessage());
            }
        } while (estaFueraLimites);

        System.out.println("El perimetro es " +objetoCuadrado.calcularPerimetro());
        System.out.println("El area es " +objetoCuadrado.calculaArea());
    }
}
