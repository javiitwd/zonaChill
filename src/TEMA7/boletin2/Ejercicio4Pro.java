package TEMA7.boletin2;

import TEMA7.boletin1.ComprobarMatriculaException;

import java.io.*;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class Ejercicio4Pro {
    public static void main(String[] args) {
        try {
            //comprobarMatriculas("Matriculas.txt");
            comprobarMatriculasV2("Matriculas.txt");
        } catch (ComprobarMatriculaException e) {
            // Se muestra el mensaje personalizado si se lanza una excepción
            System.out.println(e.getMessage());
        }
    }

    /*
     * Este método lee un fichero de texto con nombres de modelos de coches y sus matrículas.
     * Extrae únicamente las matrículas que siguen el formato actual (####-AAA) y las guarda en otro fichero.
     */
    public static void comprobarMatriculas(String nombreDelFichero) throws ComprobarMatriculaException {
        // Ruta al archivo de entrada
        Path archivo = Path.of("tema7/AccesoFicherosExprReg/src/Relacion1/Ejercicio9Relacion1/", nombreDelFichero);
        // Expresión regular que representa una matrícula válida: 4 dígitos + guión + 3 letras mayúsculas
        String regex = "\\d{4,4}-[A-Z]{3,3}";

        // Verifica si el archivo existe
        if (!Files.exists(archivo)) {
            throw new ComprobarMatriculaException("El fichero no existe");
        }

        try (BufferedReader br = new BufferedReader(new FileReader(archivo.toFile()))) {
            String cadenaLeida;
            List<String> matriculasValidas = new LinkedList<>(); // Lista para almacenar matrículas válidas

            // Lectura línea a línea del fichero
            while ((cadenaLeida = br.readLine()) != null) {
                // Divide la línea por espacios (se espera que la matrícula esté al final)
                String[] parts = cadenaLeida.split(" ");

                // Compara la última parte de la línea (la matrícula) con el patrón
                Pattern patron = Pattern.compile(regex);
                Matcher comparador = patron.matcher(parts[parts.length - 1]);
                if (comparador.matches()) {
                    // Si coincide con el patrón, se añade a la lista
                    matriculasValidas.add(parts[parts.length - 1]);
                }
            }

            // Si no se encontró ninguna matrícula válida, se lanza una excepción
            if (matriculasValidas.isEmpty()) {
                throw new ComprobarMatriculaException("No existen coincidencias en las matriculas");
            }

            // Ruta del nuevo archivo de salida
            Path nuevoArchivo = Path.of("tema7/AccesoFicherosExprReg/src/Relacion1/Ejercicio9Relacion1/", "MatriculasCorrectas.txt");

            // Si el archivo ya existe, se lanza una excepción
            if (Files.exists(nuevoArchivo)) {
                throw new ComprobarMatriculaException("El fichero ya existe");
            }

            // Se crea el nuevo archivo
            Files.createFile(nuevoArchivo);

            // Se escribe cada matrícula válida en una nueva línea del fichero de salida
            try (PrintWriter pw = new PrintWriter(nuevoArchivo.toFile())) {
                matriculasValidas.forEach(pw::println);
            }

        } catch (FileAlreadyExistsException e) {
            // Esta excepción es redundante porque ya se comprobó antes
            throw new ComprobarMatriculaException("El archivo que se intenta crear ya existe");
        } catch (IOException e) {
            // Captura cualquier otro error de entrada/salida
            throw new ComprobarMatriculaException("Error en el buffer");
        }
    }

    public static void comprobarMatriculasV2(String nombreFichero) throws ComprobarMatriculaException {
        // Ruta del archivo de matriculas
        Path archivo = Path.of("tema7/AccesoFicherosExprReg/src/Relacion1/Ejercicio9Relacion1/", nombreFichero);

        // Ruta del archivo de matriculas correctas
        Path matriculasCorrectas = Path.of("tema7/AccesoFicherosExprReg/src/Relacion1/Ejercicio9Relacion1/MatriculasCorrectas.txt");

        // Expresion regular
        String regex = "\\p{L}+ (?<MATRICULA>\\d{4}-[A-Z&&[^AEIOU]]{3})";

        // Flujo con try-with-resources
        try(Stream<String> lineas = Files.lines(archivo)) {
            // Si existe se borra y se crea
            Files.deleteIfExists(matriculasCorrectas);
            Files.createFile(matriculasCorrectas);
            // Flujo de lineas
            Pattern patron = Pattern.compile(regex);
            // Convertimos la linea en el Matcher (que lleva la linea y el patron)
            lineas.map(s -> patron.matcher(s))
                    //filtramos los Matcher que cumplan en metodo matches (que coindicidan la linea con el patron entera)
                    .filter(Matcher::matches)
                    .forEach(matcher -> {
                        try {
                            Files.writeString(matriculasCorrectas,matcher.group("MATRICULA")+"\n", StandardOpenOption.APPEND);
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    });
        } catch (FileNotFoundException e) {
            // Excepción si no se encuentra el archivo
            throw new ComprobarMatriculaException("No se encuentra el archivo que estas intentando leer");
        } catch (IOException e) {
            // Cualquier otro error de entrada/salida
            throw new ComprobarMatriculaException("Otro tipo de error leyendo el fichero");
        }
    }
}


