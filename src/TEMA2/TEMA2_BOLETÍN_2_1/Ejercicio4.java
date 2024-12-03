/*
TEMA 2. BOLETÍN 2.1, EJERCICIO 4:
Se desea realizar un programa que implemente un juego que consiste en
acertar un número secreto. El ordenador deberá generar aleatoriamente un
número secreto entre 1 y 100 y el jugador tratará de acertarlo.
Cada vez que el jugador introduzca un número, se comprobará si es el
número secreto, en cuyo caso termina el juego. Si no lo es, se informará
que el número introducido es mayor o menor que el número secreto. El
programa termina cuando acierta el número (gana) o cuando agota el
número de intentos ( en nuestro caso 5) sin acertar el número , en cuyo
caso pierde.
Si es número no estuviese en el rango de 1-100, debe mostrar un mensaje
“El numero debe estar entre 1 y 100” y también debe contarse como un
fallo.
*/
package TEMA2.TEMA2_BOLETÍN_2_1;

import java.util.Scanner;

public class Ejercicio4 {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        int n1, i;
        double aleatorio; //Para usar la clase Math el número debe ser un double
        aleatorio = (int) (Math.random() * 100+1); //cambio el double a entero
        i = 5;

        do {
            i--;
            System.out.println("Adivina el númro");
            n1 = entrada.nextInt();
            if (n1 < aleatorio && n1 >= 0 && n1 <= 100) {
                System.out.println("Te has quedado corto");
            } else if (n1 > aleatorio && n1 >= 0 && n1 <= 100) {
                System.out.println("Te has pasado");
            } else if (n1 < 0 || n1 > 100) {
                System.out.println("El número debe estar entre 0 y 100");
            }

        } while (n1 != aleatorio || i > 0);

        if (n1 == aleatorio) {
            System.out.println("Lo has adivinado");
        } else System.out.println("Vaya, no has tenido suerte");
    }
}
