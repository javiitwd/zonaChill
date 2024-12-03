package TEMA4.BOLETÍN1.Ejercicio2.Prueba1;

import java.util.Scanner;

public class CuentaPrincipal {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        Cuenta objetoCuenta = null; //Inicializas Cuenta objetoCuenta = null; al principio para asegurarte de que la variable existe,
                                   //y luego se inicializa dentro del bloque try cuando se obtiene un saldo válido.
        boolean estaGraciosoElNiño = true;

        do {
            try {
                System.out.println("Pon el saldo inicial");
                objetoCuenta = new Cuenta(entrada.nextFloat()); //Para acceder al constructor si no he definido es objeto aun
                estaGraciosoElNiño = false;
            } catch (CuentaException e) {
                System.out.println(e.getMessage());
            }
        } while (estaGraciosoElNiño);

        boolean malIngreso = true;
        boolean quiereSeguir = true;
        do {
            System.out.println("Que quieres hacer");
            System.out.println("1. Hacer un reintegro");
            System.out.println("2. Hacer un ingreso");
            System.out.println("3. Consultar el saldo y el número de reintegros e ingresos realizados");
            System.out.println("4. Finalizar las operaciones");
            int opcion = entrada.nextInt();

            if (opcion == 1) {
                do {
                    try {
                        System.out.println("Cuanto quieres retirar");
                        objetoCuenta.setRetirar(entrada.nextFloat());
                        malIngreso = false;
                    } catch (CuentaException e) {
                        System.out.println(e.getMessage());
                    }
                } while (malIngreso);

            }

            if (opcion == 2) {
                System.out.println("Cuanto quieres ingresar");
                objetoCuenta.setIngreso(entrada.nextFloat());
            }

            if (opcion == 3) {
                System.out.println("El saldo es " + objetoCuenta.consultarSaldo());
                System.out.println("Has ingresado dinero " + objetoCuenta.consultarVecesIngreso() + " veces");
                System.out.println("Has retirado dinero " + objetoCuenta.consultarVecesRetiro() + " veces");
            }

            if (opcion == 4) {
                System.out.println("De verdad quieres salir? 1) Si 2) No");
                int salir = entrada.nextInt();

                if (salir == 1) {
                    System.out.println("Tu saldo actual es de " + objetoCuenta.consultarSaldo());
                    quiereSeguir = false;
                }
            }


        } while (quiereSeguir);
    }
}