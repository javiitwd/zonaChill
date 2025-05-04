package TEMA7.examenes.examen2022_2023_mejor;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class Ejercicio1 {
    public static void main(String[] args) {

        try {
            validarFicheros();
        } catch (Examen2022_2023Excepcion e) {
            System.out.println(e.getMessage());
        }
    }

    public static void validarFicheros() throws Examen2022_2023Excepcion {

        Path pathOrigen = Path.of("src/TEMA7/examenes/examen2022_2023_mejor/pruebaEj1");
        Path pathDestino = Path.of("src/TEMA7/examenes/examen2022_2023_mejor/pruebaEj1/destino");

        if (!Files.isDirectory(pathOrigen) || !Files.isReadable(pathOrigen)) {

            throw new Examen2022_2023Excepcion("La ruta de origen no es un directorio o no es legible");
        }
        if (!Files.isDirectory(pathDestino) || !Files.isWritable(pathDestino)) {

            throw new Examen2022_2023Excepcion("La ruta de destino no es un directorio o no es escribible");
        }

        Pattern pattern = Pattern.compile("(?i)^copiar.*");

        try (Stream<Path> rutas = Files.list(pathOrigen)) {
            //1) filtramos los ficheros regulares
            rutas.filter(Files::isRegularFile)
                    //2) filtramos los ficheros que pesen mas de 1024
                    .filter(path -> {

                        try {
                            return Files.size(path) > 1024;
                        } catch (IOException e) {
                            throw new RuntimeException();
                        }
                    })
                    //3) filtramos que la ruta termine con ".txt"
                    .filter(path -> path.toString().endsWith(".txt"))
                    //4) filtramos los ficheros que tengan como primera palabra "copiar"
                    .filter(path -> {
                        //Hacemos un flujo con las lineas del fichero
                        try (Stream<String> lineas = Files.lines(path)) {

                            //Guardamos la primera linea del flujo de lineas, sino. Guardamos una linea vacia
                            String primeraLinea = lineas.findFirst().orElse("");

                            //Guardamos la primera linea mas el patron
                            Matcher matcher = pattern.matcher(primeraLinea);

                            //Nos quedamos con los ficheros que den true en el find (que cumplan la expresion regular)
                            return matcher.find();

                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    })
                    //5) Ya tenemos todos los ficheros que queremos copiar
                    //enconces los recorremos (con .forEach()) y los vamos copiando al destino
                    .forEach(path -> {
                        try {
                            Files.copy(path, pathDestino.resolve(path.getFileName()));
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    });

        } catch (IOException e) {
            throw new Examen2022_2023Excepcion("Error: " + e.getMessage());
        }
    }
}
