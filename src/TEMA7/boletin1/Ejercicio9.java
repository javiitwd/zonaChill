package TEMA7.boletin1;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ejercicio9 {
    public static void main(String[] args) {


    }

    public static void escribirMatriculasCorrectas(String rutaFichero) {

        //para indicar que termine con el patron pedido
        // usamos \\b al principio para indicar a partir de ahi el patron que queremos

        Pattern patron = Pattern.compile("\\b[0-9]{4}-[A-Z]{3}$");

        // Pattern patron = Pattern.compile("^[0-9]{4}-[A-Z]{3}$");

        //bufferedReader para leer y el BufferedWriter escribe donde le indiquemos
        try (BufferedReader br = new BufferedReader(new FileReader(rutaFichero));
             BufferedWriter bw = new BufferedWriter(new FileWriter("src/TEMA7/boletin1/matriculasCorrectas.txt"))) {

            String linea;
            while ((linea = br.readLine()) != null) {

                //si la linea esta vacia pasamos a la siguiente
                if (linea.trim().isEmpty()) {
                    continue; //si se cumple lo del if rompe esta vuelta del while (ignora lo de abajo) y pasa a la siguiente vuelta
                }

                //guardamos en un array cada parte de la linea que esta separa por espacios
                String[] arrayLinea = linea.split(" ");

                //guardamos del array de String que contiene las partes de texto de la linea la ultima (donde estara la matricula)
                String parteDeLaMatricula = arrayLinea[arrayLinea.length - 1];

                Matcher matcher = patron.matcher(parteDeLaMatricula);

                //Si coincide con el patron escribimos la matricula
                if (matcher.find()) {

                    bw.write(parteDeLaMatricula);
                    bw.newLine(); //tras escribir pasa a la siguiente linea (es como un "\n")
                }

                /**
                 * forma de hacerlo con metodo de matcher
                 *
                 * if (matcher.matches)){
                 *    bw.write(matcher.group().trim()) -> esto escribe solo la parte que concide con el patron,
                 *                                        eliminando los espacios con el .trim()
                 */
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
