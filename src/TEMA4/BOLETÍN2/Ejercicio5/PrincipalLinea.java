/*
5. Define una clase Linea con dos atributos: puntoA y puntoB. Son los dos puntos por
los que pasa la línea en un espacio de dos dimensiones. La clase dispondrá de los
siguientes métodos:
● Linea(): Constructor predeterminado que crea una línea con sus dos puntos como
(0,0) y (0,0).
● Linea(Punto, Punto): Constructor que recibe como parámetros dos objetos de la
clase Punto, que son utilizados para inicializar los atributos.
● gets y sets.
● Debe redefinir el metodo equals para comparar líneas.
● moverDerecha(double): Desplaza la línea a la derecha la distancia que se indique.
● moverIzquierda(double): Desplaza la línea a la izquierda la distancia que se
indique.
● moverArriba(double): Desplaza la línea hacia arriba la distancia que se indique.
● moverAbajo(double): Desplaza la línea hacia abajo la distancia que se indique.
● Metodo que nos permita mostrar la información de la línea de la siguiente forma:
[puntoA,puntoB]. Por ejemplo: [(0.0,0.0),(1.0,1.0)].
Realiza un programa que inicialmente cree una línea solicitando los datos por teclado.
Después debe mostrar un menú con las siguientes opciones:
a. Mover línea: Solicitará el movimiento (A-arriba, B-ABajo, I-Izquierda, D-Derecha)
y realice el movimiento
b. Mostrar línea
c. Salir
*/
package TEMA4.BOLETÍN2.Ejercicio5;

import java.util.Scanner;

public class PrincipalLinea {

    public static void main(String[] args) throws LineaException {
        Scanner scanner = new Scanner(System.in);

        // Crear una línea solicitando los puntos por teclado
        System.out.println("Ingrese las coordenadas del primer punto (x1, y1):");
        System.out.print("x1: ");
        double x1 = scanner.nextDouble();
        System.out.print("y1: ");
        double y1 = scanner.nextDouble();

        System.out.println("Ingrese las coordenadas del segundo punto (x2, y2):");
        System.out.print("x2: ");
        double x2 = scanner.nextDouble();
        System.out.print("y2: ");
        double y2 = scanner.nextDouble();

        Linea linea = new Linea(new Punto(x1, y1), new Punto(x2, y2));

        boolean salir = false;

        while (!salir) {
            System.out.println("\n--- MENÚ ---");
            System.out.println("a. Mover línea");
            System.out.println("b. Mostrar línea");
            System.out.println("c. Salir");
            System.out.print("Seleccione una opción: ");
            char opcion = scanner.next().toLowerCase().charAt(0);

            switch (opcion) {
                case 'a':
                    System.out.print("Ingrese el movimiento (A-arriba, B-abajo, I-izquierda, D-derecha): ");
                    char direccion = scanner.next().toLowerCase().charAt(0);
                    System.out.print("Ingrese la distancia a mover: ");
                    double distancia = scanner.nextDouble();

                    switch (direccion) {
                        case 'a':
                            linea.moverArriba(distancia);
                            break;
                        case 'b':
                            linea.moverAbajo(distancia);
                            break;
                        case 'i':
                            linea.moverIzquierda(distancia);
                            break;
                        case 'd':
                            linea.moverDerecha(distancia);
                            break;
                        default:
                            System.out.println("Dirección no válida.");
                    }
                    break;

                case 'b':
                    System.out.println("Línea actual: " + linea);
                    break;

                case 'c':
                    salir = true;
                    break;

                default:
                    System.out.println("Opción no válida.");
            }
        }

        System.out.println("Programa terminado.");
        scanner.close();
    }
}
