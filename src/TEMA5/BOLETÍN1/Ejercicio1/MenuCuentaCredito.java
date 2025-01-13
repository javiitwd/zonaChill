package TEMA5.BOLETÍN1.Ejercicio1;

import java.util.Scanner;
import TEMA4.BOLETÍN1.Ejercicio2.CuentaException;

public class MenuCuentaCredito {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CuentaCredito cuenta = null;

        // Preguntar al usuario si quiere crear una cuenta con un crédito inicial o con el valor por defecto
        System.out.println("Bienvenido al sistema de cuentas de crédito.");
        System.out.println("1. Crear cuenta de crédito con crédito inicial.");
        System.out.println("2. Crear cuenta de crédito con crédito por defecto (100€).");

        int opcion = sc.nextInt();

        try {
            if (opcion == 1) {
                System.out.println("Ingrese el monto de crédito inicial (hasta 300€):");
                double credito = sc.nextDouble();
                cuenta = new CuentaCredito(credito); // Crear cuenta con crédito especificado
            } else if (opcion == 2) {
                cuenta = new CuentaCredito(); // Crear cuenta con crédito por defecto
            } else {
                System.out.println("Opción no válida.");
                return;
            }

            boolean continuar = true;
            while (continuar) {
                // Menú principal
                System.out.println("\nElige una opción:");
                System.out.println("1. Ingresar dinero.");
                System.out.println("2. Sacar dinero.");
                System.out.println("3. Mostrar saldo y crédito.");
                System.out.println("4. Salir.");
                int opcionMenu = sc.nextInt();

                switch (opcionMenu) {
                    case 1:
                        System.out.println("Ingrese la cantidad a depositar:");
                        double ingreso = sc.nextDouble();
                        cuenta.meterDinero(ingreso);
                        break;
                    case 2:
                        System.out.println("Ingrese la cantidad a retirar:");
                        double retirada = sc.nextDouble();
                        cuenta.sacarDinero(retirada);
                        break;
                    case 3:
                        cuenta.consultarSaldoYCredito();
                        break;
                    case 4:
                        System.out.println("¡Hasta luego!");
                        cuenta.finalizar();
                        continuar = false;
                        break;
                    default:
                        System.out.println("Opción no válida.");
                        break;
                }
            }
        } catch (CuentaException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
