package TEMA1;

import java.util.Scanner;
/* TEMA 1. RELACIÓN 1.2, EJERCICIO 3.
 Realizar un programa que lea un número por teclado. El programa debe
imprimir en pantalla un mensaje con “El número xx es múltiplo de 2” o un
mensaje con “El número xx es múltiplo de 3”. Si es múltiplo de 2 y de 3
deben aparecer los dos mensajes. Si no es múltiplo de ninguno de los dos
el programa finaliza sin mostrar ningún mensaje.
 */
public class Ejercicio3 {
    public static void main(String[] args) {
        Scanner entrada = new Scanner (System.in);
        double numero = Math.random();
        numero = numero * 100;
        int respuesta, intentos;
        intentos = 5;
        do {
            System.out.println("Introduce un numero");
            respuesta = entrada.nextInt();
            intentos--;
            if (respuesta<=numero && respuesta <= 100 && respuesta >= 0) {
                System.out.println("Te has quedado corto");
              }else if (numero <= respuesta && respuesta<= 100 && respuesta >= 0) {
                System.out.println("Te has pasado");
              }else if (respuesta<1 || respuesta>100) {
                System.out.println("El numero debe estar entre 1 y 100");}

            }while (respuesta != numero && intentos > 0);

             if (respuesta == numero) {
                 System.out.println("Has ganado");
             }else{
                     System.out.println("Has perdido");
                 }

            }
        }






