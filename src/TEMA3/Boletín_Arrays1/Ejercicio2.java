/*
2. Crea un programa que detecte cuántos números
negativos hay en un array de enteros.
*/
package TEMA3.Boletín_Arrays1;

import java.util.Arrays;

public class Ejercicio2 {
    public static void main(String[] args) {
        // Defino el Array
        int[] Array = {1, 2, -3, 4, -5};
        // Muestro su contenido
        System.out.println(Arrays.toString(Array));

        //Defino una variable (Resultado) en la que guardaré el resultado del nuevo metodo (contarNegativos)
        int Resultado = cantidadNegativos(Array);

        //Muestro por pantalla el resultado
        System.out.printf("La cantidad de negativos es %d", Resultado);
    }

    //Llamo al nuevo metodo (contarNegativos) y defino dentro de este otro Array (xd)
    private static int cantidadNegativos(int[] xd) {
        int contador = 0;
        for (int i = 0; i < xd.length; i++) {
            if (xd[i] < 0) {
                contador++;
            }
        }
        //Devulevo la cantidad del contador
        return contador;
    }
}