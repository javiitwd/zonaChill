package TEMA4.BOLETÍN2.Ejercicio5.Prueba;

import java.util.Scanner;

public class PrincipalLinea {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Linea linea = null;
        Punto punto = null;
        Punto punto2 = null;

        boolean coordenadasCorrectas = false;

        do {
            try {
                System.out.println("Dirme la coordenada X");
                double coodernadaX = sc.nextDouble();

                System.out.println("Dirme la coordenada Y");
                double coodernadaY = sc.nextDouble();

                punto = new Punto(coodernadaX, coodernadaY);

                System.out.println("Dirme la coordenada X2");
                double coodernadaX2 = sc.nextDouble();

                System.out.println("Dirme la coordenada Y2");
                double coodernadaY2 = sc.nextDouble();

                punto2 = new Punto(coodernadaX, coodernadaY);

                linea = new Linea(new Punto(coodernadaX, coodernadaY), new Punto(coodernadaX2, coodernadaY2));

                coordenadasCorrectas = true;
            } catch (LineaException e) {
                System.out.println(e.getMessage());
            }


        } while (!coordenadasCorrectas);

        System.out.println("Qué quiere hacer");
        System.out.println("\n--- MENÚ ---");
        System.out.println("a. Mover línea");
        System.out.println("b. Mostrar línea");
        System.out.println("c. Salir");
        System.out.print("Seleccione una opción: ");
        char op = sc.next().charAt(0);

        switch (op) {
            case 'a':
                System.out.println("A dónde la quieres mover");
                System.out.print("Ingrese el movimiento (A-arriba, B-abajo, I-izquierda, D-derecha): ");
                char direccion = sc.next().charAt(0);
                switch (direccion) {
                    case 'A':
                        System.out.println("Cuanto quieres mover");
                        double moverArriba = sc.nextDouble();
                        linea.moverArriba(moverArriba);
                    case 'B':
                        System.out.println("Ingrese la distancia");
                        double moverAbajo = sc.nextDouble();
                        linea.moverAbajo(moverAbajo);
                    case 'I':
                        System.out.println("Ingrese la distancia");
                        double moverIzquierda = sc.nextDouble();
                        linea.moverIzquierda(moverIzquierda);
                    case 'D':
                        System.out.println("Ingrese la distancia");
                        double moverDerecha = sc.nextDouble();
                        linea.moverDerecha(moverDerecha);
                }
            case 'b':
                System.out.println("La liena está en la posición:");
                System.out.printf("%s, %s\n", punto.getCoordenadaX(), punto.getCoordenadaY());
                System.out.printf("%s, %s", punto2.getCoordenadaX(), punto2.getCoordenadaY());
            case 'c':
                System.out.println("Adios marica");
                break;
        }
    }
}
