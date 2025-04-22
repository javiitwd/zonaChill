package TEMA7.boletin1;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ejercicio11 {
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

                //Cogemos la primera/segunda... parte de la linea que coincide con el primer grupo
                //entre paréntesis del Pattern -> (nombre, apellidos, curso)
                String nombre = matcher.group(1);
                String apellido1 = matcher.group(2);
                String apellido2 = matcher.group(3);

                //Guardamos también el curso para usarlo al crear la carpeta correspondiente (que se lo indicaremos en el Path)
                String curso = matcher.group(4);

                //Nombre que tendra el fichero
                String nombreDelAlumno = apellido1 + apellido2 + nombre;

                //Por ej -> src/TEMA7/boletin1/DAM1/PEREZGOMEZJUAN
                Path ruta = Paths.get("src/TEMA7/boletin1", curso, nombreDelAlumno);

                //Creamos el fichero en la ruta indicada
                //(si el directorio del curso no existe, tambien se creará automáticamente)
                Files.createDirectory(ruta);

            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
