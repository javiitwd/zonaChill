/*
4. Soluciona el siguiente problema del anterior boletín utilizando arrays. Crea un
programa que cree 6000 números aleatorios de 0 a 100 (usa una constante para fijar
este número).
Muestra:
●4.1 La media de los números leídos.
●4.2 El dígito en el que más números terminan.
●4.3 En qué dígitos no ha terminado ningún número.
●4.4 Cuántos números terminan en cada uno de los dígitos (0 .. 9).
●4.5 Calcula a qué % del total de números creados equivale cada elemento del
punto anterior.
●4.6 Calcula también la suma total de todos los porcentajes calculados y la media
de porcentajes para los valores contados (es decir, la suma de todos los
porcentajes entre 6 (los valores 0, 1, 2, 3, 4 y 5))
*/
package TEMA3.Boletín_Arrays1;

import java.util.Arrays;

public class Ejercicio4 {
    public static final int TAMANO = 6000; // Número total de números aleatorios

    public static void main(String[] args) {
        int[] numerosAleatorios = new int[TAMANO]; // Creamos el array para los números aleatorios
        rellenarArray(numerosAleatorios); // 4.0 Rellenamos el array

        // 4.1 Calculamos y mostramos la media de los números
        double media = calcularMedia(numerosAleatorios);
        System.out.println("La media es: " + media);

        // 4.2 Encontramos y mostramos el dígito en el que más números terminan
        int digitoMaximo = encontrarDigitoMaximo(numerosAleatorios);
        System.out.println("El dígito en el que más números terminan es: " + digitoMaximo);

        // 4.3 Comprobamos si hay algún dígito que no se repita
        int digitoNulo = encontrarDigitoNulo(numerosAleatorios);
        if (digitoNulo == -1) {
            System.out.println("Todos los dígitos se repiten.");
        } else {
            System.out.println("El dígito " + digitoNulo + " no se repite.");
        }

        // 4.4 Contamos cuántas veces termina cada dígito (0 a 9)
        int[] conteoDigitos = contarDigitos(numerosAleatorios);

        System.out.println(Arrays.toString(conteoDigitos));

        // 4.5 Calculamos y mostramos los porcentajes
        calcularYMostrarPorcentajes(conteoDigitos);
    }


    //MÉTODOS APARTE.................................................................................................


    // 4.0 Metodo para rellenar el array con números aleatorios
    private static void rellenarArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * 101); // Números aleatorios de 0 a 100
        }
    }

    // 4.1 Metodo para calcular la media de los números en el array
    private static double calcularMedia(int[] array) {
        int suma = 0;
        for (int i = 0; i < array.length; i++) {
            suma += array[i];
        }
        return (double) suma / array.length; // Calculamos la media
    }

    // 4.2 Metodo para encontrar el dígito que más veces aparece como último dígito
    private static int encontrarDigitoMaximo(int[] array) {
        int[] conteoUltimosDigitos = new int[10]; // Array para contar ocurrencias de los últimos dígitos
        for (int i = 0; i < array.length; i++) {
            int ultimoDigito = array[i] % 10; // Obtenemos el último dígito
            conteoUltimosDigitos[ultimoDigito]++; // Incrementamos el conteo en esa posición
        }

        int mayor = conteoUltimosDigitos[0]; // Máximo conteo encontrado
        int NumeroMaximo = 0; // Dígito que corresponde al máximo
        for (int i = 1; i < conteoUltimosDigitos.length; i++) {
            if (conteoUltimosDigitos[i] > mayor) {
                mayor = conteoUltimosDigitos[i];
                NumeroMaximo = i; /* Esta es la posición del número, sin esto mostraría la de vecs que se repite pero no qué numero.
                                    Si i es 7 y conteoUltimosDigitos[7] es mayor que el máximo actual, significa que el dígito 7 es ahora
                                    el que más veces aparece al final de los números. Así, al guardar digitoMaximo, puedes mostrar al final
                                    que "el dígito que más aparece es 7". */
            }
        }
        return NumeroMaximo;
    }

    // 4.3 Metodo para encontrar un dígito que no se repita
    private static int encontrarDigitoNulo(int[] array) {
        int[] conteoUltimosDigitos = new int[10];
        for (int i = 0; i < array.length; i++) {
            int ultimoDigito = array[i] % 10;
            conteoUltimosDigitos[ultimoDigito]++;
        }

        for (int i = 0; i < conteoUltimosDigitos.length; i++) {
            if (conteoUltimosDigitos[i] == 0) {
                return i; // Retornamos el dígito que no se repite
            }
        }
        return -1; // Retornamos -1 si todos se repiten
    }

    // 4.4 Metodo para contar cuántas veces termina cada dígito
    private static int[] contarDigitos(int[] array) { //Recuerda poner el metodo como int[], no solo int
        int[] conteoDigitos = new int[10];
        for (int i = 0; i < array.length; i++) {
            int ultimoDigito = array[i] % 10;
            conteoDigitos[ultimoDigito]++;
        }
        return conteoDigitos;
    }

    // 4.5 Metodo para calcular y mostrar porcentajes
    private static void calcularYMostrarPorcentajes(int[] conteoDigitos) {
        double sumaPorcentajes = 0;

        for (int i = 0; i < conteoDigitos.length; i++) {
            double porcentaje = (double) conteoDigitos[i] / TAMANO * 100; // Calculamos el porcentaje
            sumaPorcentajes += porcentaje; // Sumamos para totalizar
            System.out.println("El dígito " + i + " se repite " + conteoDigitos[i] + " veces. El porcentaje es " + porcentaje + "%");
        }

        double mediaPorcentajes = sumaPorcentajes / conteoDigitos.length; // Media de porcentajes
        System.out.println("La suma de los porcentajes es " + sumaPorcentajes + "% y la media es " + mediaPorcentajes + "%");
    }
}
