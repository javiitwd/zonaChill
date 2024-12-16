package TEMA4.BOLETÍN1.Ejercicio1.Prueba2;

import java.util.Scanner;

public class PrincipalMaquina {
    public static void main(String[] args) throws MaquinaException {
        Scanner sc = new Scanner(System.in);

        Maquina maquina = null;

        try {
            maquina = new Maquina(50);
        } catch (MaquinaException e) {
            System.out.println(e.getMessage());
        }

        boolean opcion5 = false;

        while (!opcion5) {
            try {

                System.out.println("1. Servir café solo (1 euro)");
                System.out.println("2. Servir leche (0,8 euros)");
                System.out.println("3. Servir café con leche (1,5 euros)");
                System.out.println("4. Consultar estado máquina. Aparecen los datos de los depósitos y del monedero");
                System.out.println("5. Apagar máquina y salir");

                int opcion = sc.nextInt();

                if (opcion == 1) {

                    System.out.println("Introduzca 1 euro porfavor");

                    float dinero = sc.nextFloat();
                    float cambio = maquina.servirCafeSolo(dinero);

                    System.out.println("Recoja su cambio de: " + cambio);
                }
                if (opcion == 2) {

                    System.out.println("Introduzca 0,80 centimos porfavor");

                    float dinero = sc.nextFloat();
                    float cambio = maquina.servirLeche(dinero);

                    System.out.println("Recoja su cambio de: " + cambio);
                }
                if (opcion == 3) {

                    System.out.println("Introduzca 1,5 euros porfavor");

                    float dinero = sc.nextFloat();
                    float cambio = maquina.servirCafeLeche(dinero);

                    System.out.println("Recoja su cambio de: " + cambio);
                }
                if (opcion == 4) {

                    System.out.println("El estado del depósito de café es de " + maquina.estadoCafe());
                    System.out.println("El estado del depósito de leche es de " +maquina.estadoLeche());
                    System.out.println("El estado del depósito de los vasos es de " +maquina.estadoVasos());
                    System.out.println("El estado del monedero es de  " +maquina.estadoMonedero());

                }

                if (opcion == 5){
                    opcion5 = true;
                }

            } catch (MaquinaException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
