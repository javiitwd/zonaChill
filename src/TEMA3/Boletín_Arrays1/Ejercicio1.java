/*
1. Crea un programa que sume todas las
posiciones pares de un array de enteros.
*/
package TEMA3.Boletín_Arrays1;

import java.util.Arrays;

public class Ejercicio1 {
    public static void main(String[] args) {
        // Nombro al array
        int[] Array = {1, 2, 3, 4, 5, 6};
        // Muestro su contenido
        System.out.println(Arrays.toString(Array)); // La primera vez que lo hago solo >:)

        int resultado = suma(Array);

        System.out.printf("La suma es %d%n", resultado);
    }

    private static int suma(int[] xd) {
        int suma = 0;
        for (int i = 1; i < xd.length; i += 2) {
            suma += xd[i]; // Recuerda que es suma += xd[i], no suma += i
        }
        return suma; // Devolver la suma total, no pongas solo return.
    }
}
/*
Explicación Abajo





int resultado = suma(Array);
Basicamente lo que estoy haciendo es crear una variable (resultado)
donde almacenaré el resultado de un metodo aparte, este metodo lo
hemos llamado suma || Mediante el nombre "Resultado" imprimo el resultado
de lo que hemos hecho dentro de "Suma"
........................................................................
int resultado;
Aquí estamos declarando una variable llamada resultado
 que almacenará un número entero (el resultado de la suma)
.........................................................................
suma(Array);
Esta parte llama a un metodo llamado suma, que se encarga
de calcular la suma de los elementos en posiciones pares
del array que le pasamos como argumento. En este caso,
el argumento es Array, que es el array que definimos en main.
*/