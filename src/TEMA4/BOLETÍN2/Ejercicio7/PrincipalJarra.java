/*
7. Crear una clase Jarra que utilizaremos para simular algunas de las acciones que
podemos realizar con una jarra. Cada jarra tiene una determinada capacidad (en
litros). Además una jarra dispondrá de una cantidad de agua que podrá ir variando a
medida que realicemos operaciones con ellas. Las jarras se crearán siempre vacías.
Las acciones que podremos realizar sobre una jarra son:
Llenar la jarra por completo desde un grifo.
Vaciarla por completo.
Volcar el contenido de una jarra en otra.
Por ejemplo: Disponemos de dos jarras A y B de capacidades 7 y 4 litros
respectivamente. Podemos llenar la jarra A (no podemos echar menos del total de la
jarra porque no sabríamos a ciencia cierta cuánta agua tendría). Luego volcar A sobre B
(no cabe todo por lo que en A quedan 3 litros y B está llena). Ahora vaciar B. Despues
volver a volcar A sobre B. En esta situación, A está vacía y B tiene 3 litros.
Además se debe guardar en la clase Jarra el total de agua que se ha consumido
llenando objetos Jarra.
Realizar un programa que cree dos jarras A y B (solicitando las capacidades por teclado)
inicialmente vacías. Después se realizará un menú que permita:
a. Llenar jarra: Se solicitará con la pregunta “¿Qué jarra desea llenar (A/B)?” y se
llenará la jarra correspondiente.
b. Vaciar jarra: Se realizará la pregunta “¿Qué jarra desea vaciar (A/ B)?” y se
vaciará la jarra correspondiente.
c. Volcar jarra A en B .
d. Volcar jarra B en A.
e. Ver estado de las jarras: Se mostrará la capacidad y el agua que contiene,
tanto para la jarra A como para la B.
f. Salir: Cuando salga debe mostrarse un mensaje que indique "El total de agua
que se ha gastado llenando jarras es XXX litros".
*/

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