package TEMA6.Boletín1.Ejercicio8Stream;

import java.util.Scanner;

public class Menu {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int opcion;

        do {
            mostrarMenu();
            opcion = obtenerOpcion();
            ejecutarOpcion(opcion);
        } while (opcion != 7);
    }

    private static void mostrarMenu() {
        System.out.println("\n--- MENÚ DE GESTIÓN DE VEHÍCULOS ---");
        System.out.println("1. Añadir vehículo");
        System.out.println("2. Eliminar vehículo");
        System.out.println("3. Buscar vehículo por matrícula");
        System.out.println("4. Listar vehículos");
        System.out.println("5. Alquilar vehículo");
        System.out.println("6. Devolver vehículo");
        System.out.println("7. Salir");
        System.out.print("Seleccione una opción: ");
    }

    private static int obtenerOpcion() {
        while (!scanner.hasNextInt()) {
            System.out.println("Error: Introduzca un número válido.");
            scanner.next(); // Limpiar entrada incorrecta
        }
        return scanner.nextInt();
    }

    private static void ejecutarOpcion(int opcion) {
        switch (opcion) {
            case 1:
                anadirVehiculo();
                break;
            case 2:
                eliminarVehiculo();
                break;
            case 3:
                buscarVehiculo();
                break;
            case 4:
                listarVehiculos();
                break;
            case 5:
                alquilarVehiculo();
                break;
            case 6:
                devolverVehiculo();
                break;
            case 7:
                System.out.println("Saliendo del programa...");
                break;
            default:
                System.out.println("Opción no válida. Intente nuevamente.");
        }
    }

    private static void anadirVehiculo() {
        System.out.println("Añadir un nuevo vehículo.");
        // Implementación aquí
    }

    private static void eliminarVehiculo() {
        System.out.println("Eliminar un vehículo.");
        // Implementación aquí
    }

    private static void buscarVehiculo() {
        System.out.println("Buscar un vehículo por matrícula.");
        // Implementación aquí
    }

    private static void listarVehiculos() {
        System.out.println("Listar todos los vehículos.");
        // Implementación aquí
    }

    private static void alquilarVehiculo() {
        System.out.println("Alquilar un vehículo.");
        // Implementación aquí
    }

    private static void devolverVehiculo() {
        System.out.println("Devolver un vehículo.");
        // Implementación aquí
    }
}

