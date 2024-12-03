/*Metodo main
El programa comienza creando un objeto Cuenta (c1) con un saldo inicial de 100 y el titular "Manuel". Si ocurre un error al crear la cuenta (por ejemplo, saldo negativo), se captura y muestra un mensaje de error.
Un ciclo do-while permite interactuar con la cuenta. En cada iteración:
Se muestra un menú con opciones:
Ingresar dinero.
Retirar dinero.
Consultar saldo.
Finalizar la sesión.
Según la opción seleccionada, el programa pide la cantidad correspondiente y realiza la acción solicitada.
Si se selecciona una opción inválida o se produce un error (como ingresar o retirar una cantidad incorrecta), se captura la excepción y se muestra un mensaje de error.
*/

package TEMA4.BOLETÍN1.Ejercicio2;

import java.util.Scanner;

public class PrincipalCuenta {

    public static void main(String[] args) {
        int dineroAMeter;
        int dineroASacar;
        int opcion = 0;
        Scanner entrada = new Scanner(System.in);

        Cuenta c1;
        try {
            c1 = new Cuenta("4562", "Manuel", 100);
        } catch (CuentaException e) {
            System.out.println(e.getMessage());
            return;
        }

        do {
            try {
                System.out.println("pulsa 1 para meter dinero, pulsa 2 para sacar dinero, pulsa 3 para consultar saldo y pulsa 4 para finalizar");
                opcion = entrada.nextInt();

                if (opcion == 1) {
                    System.out.println("cuanto dinero quieres meter?");
                    dineroAMeter = entrada.nextInt();
                    c1.meterDinero(dineroAMeter);
                }
                if (opcion == 2) {

                    System.out.println("¿cuanto dinero quieres sacar?");
                    dineroASacar = entrada.nextInt();
                    c1.sacarDinero(dineroASacar);

                }
                if (opcion == 3) {

                    imprimirSaldo(c1);
                }

                if (opcion == 4) {
                    c1.finalizar();
                }

            } catch (CuentaException e) {
                System.out.println(e.getMessage());
            }

        } while (opcion != 4);
        entrada.close();//cierre Scanner

    }

    /*Metodo imprimirSaldo.
    Este metodo imprime el saldo actual de la cuenta, el número de retiradas realizadas y el número de ingresos
    realizados, utilizando printf para un formato más claro.
     */
    public static void imprimirSaldo(Cuenta cuenta) {
        System.out.printf("el saldo de su cuenta es %.2f€ \n ", cuenta.getSaldo());
        System.out.printf("el numero de retiradas es %d \n ", cuenta.getContadorRetirada());
        System.out.printf("el numero de ingresos es %d \n ", cuenta.getContadorIngreso());
    }
}


