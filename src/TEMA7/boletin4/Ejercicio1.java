package TEMA7.boletin4;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

public class Ejercicio1 {
    public static void main(String[] args) {

        Path path = Path.of("src/TEMA7/boletin3/quijote.txt");
        System.out.println(contarPalabrasDelArchivo(path.toFile()));
    }

    public static int contarPalabrasDelArchivo(File file) {

        try (Stream<String> lineas = Files.lines(file.toPath())) {
            return lineas.mapToInt(linea -> linea.split("\\s+").length)
                    .sum();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
