package TEMA2.TEMA2_BOLETÍN_2_2;/*
TEMA 2. BOLETÍN 2.2, EJERCICIO 1;
Realizar un programa que, dado un número introducido por
el usuario, calcule su número a la inversa. Es decir,
dada la entrada: 123456, el programa debe devolver 654321.
*/
import java.util.Scanner;
public class Ejercicio1 {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Pon un numero:");
        String n1 = entrada.next();

        // Usamos StringBuilder para invertir el número
        String numAlReves = new StringBuilder(n1).reverse().toString();

        System.out.println(numAlReves);

        entrada.close(); // Cierra el escáner
    }
}
