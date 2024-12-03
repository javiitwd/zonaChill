package ALEJANDRO_Tema1y2;

import java.util.Scanner;
/*
Ejercicio 13(Alenadro);
Pedir 10 números. Mostrar la media de los números positivos,
la media de los números negativos y la cantidad de ceros.
 */
public class ejercicio13alejandro {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int numero, cantidad;
        float mayor = 0, menor = 0, igual = 0;
        int cantmayor = 0, cantmenor = 0; cantidad = 10;

        do {
            System.out.println("Pon 10 números");
            numero = entrada.nextInt();
            cantidad--;
            if(numero>0){
                cantmayor++;
               mayor = (mayor+numero);
            }
            else if(numero<0){
                cantmenor++;
                menor = (menor+numero);
            }
            else if(numero==0){
                igual++;
            }
        } while (cantidad > 0);
        System.out.println("La media de los números positivos es " +mayor/cantmayor+ " la de los números negativos es " +menor/cantmenor+ " y has introducido " +igual+ " 0 " );
    }
}
