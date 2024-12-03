package TEMA2.TEMA2_BOLETÍN_2_1;

/*
EJERCICIO 9. Realizar un programa que muestre
todas las tablas de multiplicar (del 1 al 10).
Tabla del 0
        0 x 0=0
        ….
        0x10=10
Tabla del 1
        1 x 0=0
        ….
        1x10=10
*/
public class Ejercicio9 {
    public static void main(String[] args) {
        int i,j;
        for(i = 1; i <= 10; i++){;
            for(j=0; j<=10; j++){
                System.out.println(i+ " * " +j+ " = " +(i*j)); /*
                Después de que el bucle interno ha terminado
                (cuando j llega a 10), el bucle externo
                incrementa i a 1 y repite el proceso.
                 */
            }
            System.out.println(); //Poner lineas entre las tablas
        }
    }
}

