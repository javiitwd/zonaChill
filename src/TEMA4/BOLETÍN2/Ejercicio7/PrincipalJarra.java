package TEMA4.BOLETÍN2.Ejercicio7;

import java.util.Scanner;

public class PrincipalJarra {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Jarra jarraA = new Jarra(7);
        Jarra jarraB = new Jarra(4);
        int opcion = 0;

        do {
            opcion = seleccionaOpcion("Seleccione una opción",
                    new String[]{"Llenar jarra", "Vaciar jarra", "Volcar jarra A en B", "Volcar jarra B en A", "Ver estado de las jarras", "Salir"});
            switch (opcion) {
                case 1 -> llenarJarra(scanner, jarraA, jarraB);
                case 2 -> vaciarJarra(jarraA, jarraB);
                case 3 -> volcarJarraAenB(jarraA, jarraB);
                case 4 -> volcarJarraBenA(jarraA, jarraB);
                case 5 -> verEstadoJarra(jarraA, jarraB);
            }
        } while (opcion != 6);

        System.out.println("El total de agua que se ha gastado llenando jarras es " + jarraA.getCantidadConsumida() + " litros");
    }

    private static int seleccionaOpcion(String mensaje, String[] opciones) {
        System.out.println(mensaje);
        for (int i = 0; i < opciones.length; i++) {
            System.out.println((i + 1) + ". " + opciones[i]);
        }
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    private static void llenarJarra(Scanner scanner, Jarra jarraA, Jarra jarraB) {
        System.out.print("¿Qué jarra desea llenar (A/B)? ");
        String seleccion = scanner.next();
        if (seleccion.equalsIgnoreCase("A")) {
            jarraA.llenarJarra();
            System.out.println("Jarra A llenada. " + jarraA);
        } else if (seleccion.equalsIgnoreCase("B")) {
            jarraB.llenarJarra();
            System.out.println("Jarra B llenada. " + jarraB);
        }
    }

    private static void vaciarJarra(Jarra jarraA, Jarra jarraB) {
        System.out.print("¿Qué jarra desea vaciar (A/B)? ");
        Scanner scanner = new Scanner(System.in);
        String seleccion = scanner.next();
        if (seleccion.equalsIgnoreCase("A")) {
            jarraA.vaciarJarra();
            System.out.println("Jarra A vaciada. " + jarraA);
        } else if (seleccion.equalsIgnoreCase("B")) {
            jarraB.vaciarJarra();
            System.out.println("Jarra B vaciada. " + jarraB);
        }
    }

    private static void volcarJarraAenB(Jarra jarraA, Jarra jarraB) {
        double traspasada = jarraA.volcar(jarraB);
        System.out.println("Se han volcado " + traspasada + " litros de la jarra A a la jarra B.");
        System.out.println("Jarra A: " + jarraA);
        System.out.println("Jarra B: " + jarraB);
    }

    private static void volcarJarraBenA(Jarra jarraA, Jarra jarraB) {
        double traspasada = jarraB.volcar(jarraA);
        System.out.println("Se han volcado " + traspasada + " litros de la jarra B a la jarra A.");
        System.out.println("Jarra A: " + jarraA);
        System.out.println("Jarra B: " + jarraB);
    }

    private static void verEstadoJarra(Jarra jarraA, Jarra jarraB) {
        System.out.println("Estado de las jarras:");
        System.out.println("Jarra A: " + jarraA);
        System.out.println("Jarra B: " + jarraB);
    }
}