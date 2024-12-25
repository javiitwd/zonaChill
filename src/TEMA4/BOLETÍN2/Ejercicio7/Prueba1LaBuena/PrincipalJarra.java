package TEMA4.BOLETÍN2.Ejercicio7.Prueba1LaBuena;

import java.util.Scanner;

public class PrincipalJarra {
    public static void main(String[] args) throws JarraException {
        Scanner sc = new Scanner(System.in);

        Jarra jarraA = new Jarra(7);
        Jarra jarraB = new Jarra(4);

        boolean salir = false;
        while (!salir) {
            try {
                System.out.println("Qué quiere hacer");
                System.out.println("1.Llenar jarra");
                System.out.println("2.Vaciar jarra");
                System.out.println("3.Volcar jarra A en B");
                System.out.println("4.Volcar jarra B en A");
                System.out.println("5.Ver estado de las jarras");
                System.out.println("6.Salir");
                char op = sc.next().charAt(0);

                switch (op) {
                    case '1':
                        System.out.println("Qué jarra desea llenar (A/B)");
                        char op2 = sc.next().charAt(0);
                        switch (op2) {
                            case 'A':
                                jarraA.llenarJarra();
                                break;
                            case 'B':
                                jarraB.llenarJarra();
                                break;

                        }
                        break;
                    case '2':
                        System.out.println("Qué jarra desea vaciar (A/B)");
                        char op3 = sc.next().charAt(0);
                        switch (op3) {
                            case 'A':
                                jarraA.vaciarJarra();
                                break;
                            case 'B':
                                jarraB.vaciarJarra();
                                break;
                        }
                        break;
                    case '3':
                        jarraA.volcarJarra(jarraB);
                        break;

                    case '4':
                        jarraB.volcarJarra(jarraA);
                        break;

                    case '5':
                        System.out.printf("La jarra A tiene %.2f ", jarraA.getCantidad());
                        System.out.printf("La jarra B tiene %.2f ", jarraB.getCantidad());
                        break;

                    case '6':
                        System.out.printf("La cantidad que se ha gastado es de %.2f ", jarraA.consultarAguaConsumida());
                        salir = true;
                        break;
                }
            } catch (JarraException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
