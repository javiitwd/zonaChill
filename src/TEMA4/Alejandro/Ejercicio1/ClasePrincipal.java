package TEMA4.Alejandro.Ejercicio1;

import java.util.Scanner;

public class ClasePrincipal {
    static Scanner entrada = new Scanner(System.in);

    public static void main(String[] args) {

        //Creo el objeto sin definir su valor, ya que me lo dara el usuario
        Clase Objeto1;

        System.out.println("Pon lado 1");
        float l1 = entrada.nextFloat();
        System.out.println("Pon lado 2");
        float l2 = entrada.nextFloat();

        if (l1 == l2){
            Objeto1 = new Clase (l1);
        } else {
            Objeto1 = new Clase (l1, l2);
        }
                                                                                    //Puse +Objeto1.Perimetro, ya que no tuve en cuenta los getter y setter
        System.out.println("El perimetro es " +Objeto1.getPerimetro());
        System.out.println("El area es " +Objeto1.getArea());
    }
}
