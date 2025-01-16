package TEMA4.EXAMENES_TEMA4.Examen2021_2022Mo2;

import java.util.Scanner;

public class Sala {

    public static void main(String[] args) {
        // Instancias necesarias
        AlmacenAves almacenAves = new AlmacenAves(10); // Cambia el tamaño según tus necesidades
        Scanner scanner = new Scanner(System.in);
        boolean salir = false;

        // Bucle del menú
        while (!salir) {
            System.out.println("\n*** Menú de Gestión de la Reserva de Aves ***");
            System.out.println("1. Introducir un ave en la sala");
            System.out.println("2. Ver datos del ave en un compartimento");
            System.out.println("3. Buscar un ave por código identificativo");
            System.out.println("4. Calcular gramos de pienso ingeridos por un ave");
            System.out.println("5. Salir");
            System.out.print("Selecciona una opción: ");

            String opcion = scanner.nextLine(); // Leer opción del usuario

            try {
                switch (opcion) {
                    case "1":
                        System.out.println("\nIntroducir un ave:");
                        System.out.print("Nombre: ");
                        String nombre = scanner.nextLine();
                        System.out.print("Código identificativo: ");
                        String codigo = scanner.nextLine();
                        System.out.print("Cantidad de alimento (en gramos): ");
                        double cantidadAlimento = Double.parseDouble(scanner.nextLine());
                        System.out.print("Origen: ");
                        String origen = scanner.nextLine();
                        System.out.print("Fecha de entrada (YYYY-MM-DD): ");
                        String fechaEntrada = scanner.nextLine();

                        // Crear instancia de Aves y añadirla al almacén
                        Aves nuevaAve = new Aves(nombre, codigo, cantidadAlimento, origen);
                        almacenAves.introducirAve(nuevaAve);
                        System.out.println("¡Ave introducida con éxito!");
                        break;

                    case "2":
                        System.out.print("\nNúmero de compartimento: ");
                        int compartimento = Integer.parseInt(scanner.nextLine());
                        almacenAves.verAveEnCompartimento(compartimento);
                        break;

                    case "3":
                        System.out.print("\nCódigo identificativo del ave: ");
                        String codigoBusqueda = scanner.nextLine();
                        almacenAves.buscarAvePorCodigoIdentificativo(codigoBusqueda);
                        break;

                    case "4":
                        System.out.print("\nCódigo identificativo del ave: ");
                        String codigoPienso = scanner.nextLine();
                        double gramosPienso = almacenAves.calcularGramosPienso(codigoPienso);
                        System.out.println("Gramos de pienso ingeridos: " + gramosPienso);
                        break;

                    case "5":
                        salir = true;
                        System.out.println("Saliendo del programa...");
                        break;

                    default:
                        System.out.println("Opción no válida. Por favor, elige entre las opciones del menú.");
                        break;
                }
            } catch (AvesException e) {
                System.out.println("Error: " + e.getMessage());
            } catch (NumberFormatException e) {
                System.out.println("Error: Entrada numérica inválida.");
            } catch (Exception e) {
                System.out.println("Error inesperado: " + e.getMessage());
            }
        }

        scanner.close(); // Cerrar el scanner al terminar
    }
}
