package TEMA1;
import java.sql.SQLOutput;
import java.util.Scanner;
/*
TEMA 1. BOLETÍN 1.2, EJERCICIO 9:
Realizar un programa que lea un número entero positivo y
averigüe si es perfecto. Un número es perfecto cuando es
igual a la suma de sus divisores excepto él mismo.
Diseñar el programa de forma que si algún dato es incorrecto
vuelva a solicitarse. Ejemplos:
El número 6 es perfecto porque es igual que 1+2+3=6
El número 8 no es perfecto porque 1+2+4=7
 */
public class Ejercicio9 {
    public static void main(String[] args) {
        Scanner entrada = new Scanner (System.in);
        int n1, suma=0;
        //me aseguro de que el número es positivo
        do {
            System.out.println("Pon un número");
            n1 = entrada.nextInt();
        }while (n1<=0);

        /*
        Miro los número del 1 hasta el número -1
        (ya que el ejercicio te dice "excepto este")
        y si son múltiplos lo añado a un contador llamado suma
        */
        for(int i=1; i<=n1-1; i++){
            if (n1%i==0){
                suma += i; //sumar suma + i
            }

        }
        if(suma==n1){
            System.out.println("El número es perfecto");
        } else System.out.println("El número no es perfecto");
    }
}
