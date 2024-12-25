package TEMA4.BOLETÍN2.Ejercicio5.Prueba2LaBuena;

import TEMA4.BOLETÍN2.Ejercicio5.Prueba.LineaException;

import java.util.Scanner;

public class PrincipalLinea {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Punto punto = null;
        Punto punto2 = null;
        Linea linea = null;

        boolean parametroCorrecto = false;
        do {
            try {
                //Creo los 2 punto de la linea
                System.out.println("Dime la coordenada X");
                double coordenadaX = sc.nextDouble();
                System.out.println("Dime la coordenada Y");
                double coordenadaY = sc.nextDouble();

                punto = new Punto(coordenadaX, coordenadaY);

                System.out.println("Dime la coordenada X");
                double coordenadaX2 = sc.nextDouble();
                System.out.println("Dime la coordenada Y");
                double coordenadaY2 = sc.nextDouble();

                punto2 = new Punto(coordenadaX2, coordenadaY2);

                //Creo la linea mediante los 2 puntos
                linea = new Linea(punto, punto2);

                parametroCorrecto = true;
            } catch (LineaException e) {
                System.out.println(e.getMessage());
            }
        } while (!parametroCorrecto);

        boolean salir = false;

        while (!salir) {
            System.out.println("Qué quieres hacer");
            System.out.println("a.Mover Linea");
            System.out.println("b.Mostrar Linea");
            System.out.println("c.Salir");
            char op = sc.next().charAt(0);
            switch (op) {
                case 'a':
                    System.out.println("Qué quieres mover");
                    System.out.println("L.Mover izquierda");
                    System.out.println("R.Mover derecha");
                    System.out.println("U.Mover arriba");
                    System.out.println("D.Mover abajo");
                    char op2 = sc.next().charAt(0);
                    switch (op2) {
                        case 'L':
                            System.out.println("Cuanto quieres mover");
                            double movIzq = sc.nextDouble();
                            linea.movIzq(movIzq);
                            break;
                        case 'R':
                            System.out.println("Cuanto quieres mover");
                            double movDer = sc.nextDouble();
                            linea.movIzq(movDer);
                            break;
                        case 'U':
                            System.out.println("Cuanto quieres mover");
                            double movArriba = sc.nextDouble();
                            linea.movIzq(movArriba);
                            break;
                        case 'D':
                            System.out.println("Cuanto quieres mover");
                            double movAbajo = sc.nextDouble();
                            linea.movIzq(movAbajo);
                            break;
                        default:
                            System.out.println("La direccion no es valida");
                    }
                    break;
                case 'b':
                    System.out.println("La linea está en la posición");
                    System.out.printf("%s, %s \n", punto.getCoordenadaX(), punto.getCoordenadaY());
                    System.out.printf("%s, %s", punto2.getCoordenadaX(), punto2.getCoordenadaY());
                default:
                    System.out.println("La direccion no es valida");

                case 'c':
                    salir = true;
                    break;
            }
        }
    }
}
