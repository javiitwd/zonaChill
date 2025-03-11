package TEMA6.Boletín1.Ejercicio6;

import java.util.Scanner;

public class Principal {

    private static final int OPCION_SALIR = 5;

    private static Scanner teclado = new Scanner(System.in);

    public static void main(String[] args) {

        int opcion;
        GranAlmacen almacen = new GranAlmacen();

        do {
            opcion = mostrarMenu();
            tratarMenu(opcion, almacen);
        } while (opcion != OPCION_SALIR);

    }

    private static void tratarMenu(int opc, GranAlmacen almacen) {

        int numeroCaja, numeroCliente;

        try {
            switch (opc) {
                case 1: {
                    numeroCaja = introducirNumeroEntero("Introduzca el numero de caja que desea abrir:");
                    almacen.abrirCaja(numeroCaja);
                    System.out.println("Se ha abierto la caja correctamente");
                    break;
                }
                case 2: {
                    numeroCaja = introducirNumeroEntero("Introduzca el numero de caja que desea cerrar:");
                    almacen.cerrarCaja(numeroCaja);
                    System.out.println("Se ha cerrado la caja correctamente");
                    break;
                }
                case 3: {
                    System.out.println(almacen.nuevoCliente());
                    System.out.println("Se ha annadido un nuevo cliente");
                    break;
                }
                case 4: {
                    numeroCaja = introducirNumeroEntero("Introduzca el numero de caja donde desea atender:");
                    numeroCliente = almacen.atenderCliente(numeroCaja);
                    System.out.println("Se ha atendido al cliente " + numeroCliente);
                    break;
                }

                case 5: {
                    System.out.println("FIN DEL PROGRAMA");
                    break;
                }
            }
        } catch (CajaException ex) {
            System.out.println(ex.getMessage());
        }

    }

    private static int mostrarMenu() {

        int opcion;

        do {
            System.out.println("1. Abrir caja");
            System.out.println("2. Cerrar caja");
            System.out.println("3. Nuevo cliente");
            System.out.println("4. Atender cliente");
            System.out.println("5. Salir");
            opcion = introducirNumeroEntero("Introduzca la opcion:");
        } while (opcion <= 0 || opcion > OPCION_SALIR);

        return opcion;
    }

    private static int introducirNumeroEntero(String enunciado) {

        int numero = 0;
        boolean hayFallo;

        do {
            try {
                System.out.print(enunciado);
                numero = Integer.parseInt(teclado.nextLine());
                hayFallo = false;
            } catch (NumberFormatException ex) {
                hayFallo = true;
                System.out.println("ERROR. Solo puedes introducir numeros");
            }
        } while (hayFallo);
        return numero;
    }
}
