package TEMA4.BOLETÍN1.Ejercicio3;

import java.util.Scanner;

public class PrincipalMaquinaCafe {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        MaquinaCafe objetoMaquinaCafe = null;

        try {
            objetoMaquinaCafe = new MaquinaCafe(50);
        } catch (MaquinaCafeException e) {
            System.out.println(e.getMessage());
        }

        boolean opcion5 = false;
        do {
            try {
                System.out.println("Que quieres hacer");
                System.out.println("1. Servir café solo (1 euro)");
                System.out.println("2. Servir leche (0,8 euros)");
                System.out.println("3. Servir café con leche (1,5 euros)");
                System.out.println("4. Consultar estado máquina.");
                System.out.println("5. Apagar máquina y salir");

                int opcion = sc.nextInt();

                if (opcion == 1) {
                    System.out.println("Ingrese el dinero");
                    float dinero = objetoMaquinaCafe.servirLeche(sc.nextFloat());
                    if (dinero > 0){
                        System.out.println("Recoge tus tristes " + dinero + " peniques"); //aqui quería poner objeto.getCafeSolo...
                    }
                }

                if (opcion == 2) {
                    System.out.println("Ingrese el dinero");
                    float dinero = objetoMaquinaCafe.servirLeche(sc.nextFloat());
                    if (dinero > 0){
                        System.out.println("Recoge tus tristes " + dinero + " peniques");
                    }
                }

                if (opcion == 3) {
                    System.out.println("Ingrese el dinero");
                    float dinero = objetoMaquinaCafe.servirCafeLeche(sc.nextFloat());
                    if (dinero>0){
                        System.out.println("Recoge tus tristes " + dinero + " peniques");
                    }
                }

                if (opcion == 4) {
                    System.out.println("El deposito de leche es de " + objetoMaquinaCafe.consultarEstadoLeche());
                    System.out.println("El deposito de cafe es de " + objetoMaquinaCafe.consultarEstadoCafe());
                    System.out.println("El deposito de vasos es de " + objetoMaquinaCafe.consultarEstadoVasos());
                    System.out.println("El monedero es de " + objetoMaquinaCafe.consultarMonedero());
                }

                if (opcion == 5) {
                    opcion5 = true;
                }

            } catch (MaquinaCafeException e) {
                System.out.println(e.getMessage());
            }
        } while (!opcion5);
    }
}
