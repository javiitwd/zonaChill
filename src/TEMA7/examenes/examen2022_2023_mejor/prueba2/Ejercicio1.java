package TEMA7.examenes.examen2022_2023_mejor.prueba2;

import TEMA7.examenes.prueba_bermudo.ExamenException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class Ejercicio1 {
    public static void main(String[] args) {

        Path origen = Path.of("src/TEMA7/examenes/examen2022_2023_mejor/prueba2/pruebaEj1");
        Path destino = Path.of("src/TEMA7/examenes/examen2022_2023_mejor/prueba2/pruebaEj1/destino");

        try {
            validarFicheros(origen, destino);
        } catch (ExamenException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void validarFicheros(Path origen, Path destino) throws ExamenException {

        if (!Files.isDirectory(origen) || !Files.isReadable(origen)) {
            throw new ExamenException("La ruta de origen no es un directorio o no tiene permisos de lectura");
        }

        if (!Files.isDirectory(destino) || !Files.isWritable(destino)) {
            throw new ExamenException("La ruta de destino no es un directorio o no tiene permisos de escritura");
        }

        try (Stream<Path> archivosDirectorio = Files.list(origen)) {

            archivosDirectorio.filter(Files::isRegularFile)
                    .filter(path -> pesaMas1024Bytes(path))
                    .filter(path -> path.toString().endsWith(".txt"))
                    .filter(path -> primeraPalabraEsCopiar(path))
                    .forEach(path -> {
                        try {
                            Files.copy(path, Path.of("src/TEMA7/examenes/examen2022_2023_mejor/prueba2/pruebaEj1/destino/" + path.getFileName()));
                        } catch (IOException e) {
                            System.out.println(e.getMessage());
                        }
                    });
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static boolean pesaMas1024Bytes(Path fichero) {
        try {
            return Files.size(fichero) > 1024;
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    public static boolean primeraPalabraEsCopiar(Path fichero) {

        Pattern patron = Pattern.compile("^copiar\\b", Pattern.CASE_INSENSITIVE);

        try (Stream<String> lineas = Files.lines(fichero)) {
            String primeraLinea = lineas.findFirst().orElse("");

            Matcher matcher = patron.matcher(primeraLinea);
            return matcher.find();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
