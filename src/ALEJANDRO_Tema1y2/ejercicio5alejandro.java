package ALEJANDRO_Tema1y2;

import java.util.Scanner;
/*
Ejercicio 5(Alejandro): Realizar un juego para adivinar un número.
 Para ello generar un número aleatorio ente 0-100, y luego ir pidiendo
 números indicando "Es mayor" o "Es menor" según sea mayor o menor
 respecto a N. El proceso termina cuando el usuario acierta y debe mostrar
 el número de intentos.
 */
public class ejercicio5alejandro {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int n1, i;
        double aleatorio;
        aleatorio = (int )(Math.random() * 100);
        i = 0;

        do {
            i++;
            System.out.println("Adivina el númro");
            n1 = entrada.nextInt();
            if (n1<aleatorio && n1>=0 && n1<=100){
                System.out.println("Te has quedado corto");
            } else if (n1>aleatorio && n1>=0 && n1<=100) {
                System.out.println("Te has pasado");
            } else if(n1<0 || n1>100){
                System.out.println("El número debe estar entre 0 y 100");
            }

        } while (n1 != aleatorio);

        System.out.println("Lo has intentado " +i+ " veces");

    }
}