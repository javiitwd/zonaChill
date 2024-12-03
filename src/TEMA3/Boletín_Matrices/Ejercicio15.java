/*
15. Crear un metodo que devuelva el número de casilla a la que corresponden unas
coordenadas. Es decir, el número de casilla empezando por la casilla [0,0], y recorriendo
primero por filas y luego por columnas. Por ejemplo, la casilla [1,5] en una matriz de 6x6
ocuparía el número 12. En la misma matriz, la casilla [4,0] ocuparía el número 25.
El metodo no debería recorrer el array con ningún tipo de bucle
1  2  3  4  5  6
7  8  9  10 11 12
13 14 15 16 17 18
19 20 21 25 23 24
25 26 27 28 29 30
*/
package TEMA3.Boletín_Matrices;

import java.util.Scanner;

public class Ejercicio15 {
    public static void main(String[] args) {
        int[][]matriz = {{1,2,3,4,5,6}, {7,8,9,10,11,12}, {13,14,15,16,17,18}, {19,20,21,22,23,24}, {25,26,27,28,29,30}};
        Scanner entrada = new Scanner(System.in);
        System.out.println("Pon la posición de la fila");
        int i = entrada.nextInt();
        System.out.println("Pon la posición de la columna");
        int j = entrada.nextInt();
        int numero = matriz[0].length*i+(j+1);

        System.out.println(numero);
    }
}
/*
La mayoría de problemas que hemos hecho (buen trabajo) hemos descompuesto un gran problema en pequeñas partes
perp hay otros, como este que para verlo a veces es mejor mirar que queremos tener al final, por ejemplo
tenemos la posición [0,0] y queremos que nos de 1
o tenemos la posición [4,5] y queremos tener el número 30
4*6 = 24 + 5+1 = 30
ahora podemos ver si esta última lógica se aplica a todos los demás, ej si queremos tener el número 29
(fila)4*6 = 24 + (columna)4+1 = 29
por lo tanto, la logica es correcta
*/