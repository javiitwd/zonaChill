package TEMA7.examenes.examen2022_2023;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

public class Ejercicio1 {
    public static void main(String[] args) {

    }

    public static boolean validar(String rutaOrigen, String rutaDestino) {

        Path pathOrigen = Path.of(rutaOrigen);
        if (!Files.isDirectory(pathOrigen) || !Files.isReadable(pathOrigen)) {
            return false;
        }

        Path pathDestino = Path.of(rutaDestino);

        if (!Files.isDirectory(pathDestino) || !Files.isWritable(pathDestino)) {
            return false;
        }

        try (Stream<Path> lineas = Files.list(pathOrigen)) {
            lineas.filter(path -> {
                        try {
                            return Files.size(path) > 1024;
                         } catch (IOException e) {
                            throw new RuntimeException(e.getMessage());
                        }
                    })
                    .filter(Files::isRegularFile)
                    .filter(path -> path.toString().endsWith(".txt"))
                    .filter(path -> path.getFileName().toString().toUpperCase().startsWith("COPIAR"))
                    .forEach(p -> {
                        try {
                            Files.copy(p, pathDestino);
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    });

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        return true;
    }

    /**ç
     * POR SI FUERA EN CONTENIDO DEL FICHERO QUE EMPEZASE POR "COPIAR"
     * public static boolean primeraPalabraEsCopiar(Path path) throws IOException {
     *         try (BufferedReader reader = Files.newBufferedReader(path)) {
     *             String linea = reader.readLine();
     *             if (linea != null) {
     *                 String[] palabras = linea.trim().split("\\s+");
     *                 return palabras.length > 0 && palabras[0].equalsIgnoreCase("copiar");
     *             }
     *         }
     *         return false;
     *     }
     */
}
