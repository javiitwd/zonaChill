/*
EJERCICIO 3.
Leer 5 números por teclado, almacenarlos en un arreglo y
a continuación realizar la media de los números positivos,
la media ded los negativos y contar el número de ceros.
 */
package TEMA3.Alejandro_Arrays;

import java.sql.SQLOutput;
import java.util.Scanner;

public class Ejercicio3 {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int[] numeros = new int[5];

        for (int i = 0; i < 5; i++) {
            System.out.println("Pon 5 números: ");
            numeros[i] = entrada.nextInt();
        }

        int positivosSuma = 0, positivosCant = 0;
        int negativosSuma = 0, negativosCant = 0;
        int cerosCant = 0;
        for (int i = 0; i<numeros.length; i++){
            if(numeros[i]>0){
                positivosSuma += numeros[i];
                positivosCant++;
            }
            if(numeros[i]<0){
                negativosSuma += numeros[i];
                negativosCant ++;
            }
            if(numeros[i]==0){
                cerosCant++;
            }
        }
        if (positivosCant==0){
            System.out.println("No hay números positivos");
        } else{
            float positivosMedia = positivosSuma/positivosCant;
            System.out.println("La media de los números positivos es " +positivosMedia);
        }

        if (negativosCant==0){
            System.out.println("No hay números negativos");
        } else{
            float negativosMedia = negativosSuma/negativosCant;
            System.out.println("La media de negativos es " +negativosMedia);
        }


        System.out.printf("La  cantidad de ceros es %d ",cerosCant);
    }
}