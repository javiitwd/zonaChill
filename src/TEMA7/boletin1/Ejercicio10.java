package TEMA7.boletin1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ejercicio10 {

    public static void main(String[] args) {


    }

    public static String validarFicheros(String rutaDelFichero) {

        int contador = 1;
        boolean esValido = true;

        //. es cualquier caracter, entonces si queremos indicar un . literal  es con \\.
        Pattern patron = Pattern.compile("^F [a-zA-Z]{3,}\\.[a-zA-Z]{3}$");

        try (BufferedReader br = new BufferedReader(new FileReader(rutaDelFichero))) {

            String linea;
            while ((linea = (br.readLine())) != null) {

                if (linea.trim().isEmpty()) {
                    continue;
                }

                Matcher matcher = patron.matcher(linea);

                if (!matcher.matches()) {

                    esValido = false;
                }

                Files.createFile(Path.of("src/TEMA7/boletin1/error" + contador++ + ".txt"));
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        if (esValido) {
            return "Es válido y se han creado " + contador + " ficheros";
        } else {
            return "No es válido y se han creado " + contador + " ficheros";
        }
    }
}
