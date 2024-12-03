package TEMA4.Alejandro.Ejercicio1;

import java.util.Scanner;

public class PrincipalCuadrilatero {
    static Scanner entrada = new Scanner (System.in);

    public static void main(String[] args) {

        //Creo el objeto "ObjetoCuadrilatero" de la clase Cuadrilatero
        Cuadrilatero ObjetoCuadrilatero;

        System.out.println("Pon el lado A");
        float n1 = entrada.nextFloat();
        System.out.println("Ahora el lado B");
        float n2 = entrada.nextFloat();

        //Si es un cuadrado  solo le paso al ObjetoCuadrilatero 1 lado
       if (n1 == n2){
           ObjetoCuadrilatero = new Cuadrilatero(n1);

       //Sino es un cuadrado le paso los 2 lados
       } else {
           ObjetoCuadrilatero = new Cuadrilatero(n1, n2);
       }

        System.out.println("El area es " +ObjetoCuadrilatero.getArea());
        System.out.println("El perimetro es " +ObjetoCuadrilatero.getPerimetro());
    }
}