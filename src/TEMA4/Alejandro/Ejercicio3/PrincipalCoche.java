package TEMA4.Alejandro.Ejercicio3;

import java.util.Scanner;

public class PrincipalCoche {

    static Scanner entrada = new Scanner (System.in);

    public static void main(String[] args) {

        //Pido valores coche 1
        System.out.println("Pon la marca");
        String disemarca = entrada.next();
        System.out.println("Pon el modelo");
        String disemodelo = entrada.next();
        System.out.println("Pon el precio");
        int presio = entrada.nextInt();

        //Pido valores coche 2
        System.out.println("Pon la marca");
        String disemarca2 = entrada.next();
        System.out.println("Pon el modelo");
        String disemodelo2 = entrada.next();
        System.out.println("Pon el precio");
        int presio2 = entrada.nextInt();

        //Se los meto
        Coche ObjetoCoche = new Coche(disemarca, disemodelo, presio);
        Coche ObjetoCoche2 = new Coche(disemarca2, disemodelo2, presio2);

        if (ObjetoCoche.getPrecio() > ObjetoCoche2.getPrecio()){

            System.out.println(disemarca);
        } else {
            System.out.println(disemarca2);
        }

    }
}
