package TEMA7.boletin1.prueba1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ej11 {
    public static void main(String[] args) {


    }

    public static void transferirAlumnos(String rutaDelFicheroDeLosAlumnos) {

        try (BufferedReader br = new BufferedReader(new FileReader(rutaDelFicheroDeLosAlumnos))) {

            // -> Los paréntesis () en una expresión regular sirven para definir grupos de captura.
            // Esos grupos te permiten extraer partes específicas del texto que coinciden con el patrón.
            // ->El + en las expresiones regulares significa "uno o más" del carácter o grupo anterior.
            Pattern patron = Pattern.compile("^([A-Z]+) ([A-Z]+) ([A-Z]+) \\d$");

            String linea;
            while ((linea = br.readLine()) != null) {

                Matcher matcher = patron.matcher(linea);

                if (!matcher.find()) {
                    return;
                }

                String nombre = matcher.group(1);
                String apellido1 = matcher.group(2);
                String apellido2 = matcher.group(3);
                String curso = matcher.group(4);

                String nombreCompleto = nombre + apellido1 + apellido2;

                Path ruta = Path.of("src/TEMA7/boletin1", curso, nombreCompleto);

                Files.createDirectory(ruta);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}