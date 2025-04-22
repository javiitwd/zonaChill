package TEMA7.boletin1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

public class Ejercicio7 {
    public static void main(String[] args) {


    }

    public static void buscarDirectorioYArchivosQueComiencenPorUnaPalabra(String ruta, String palabra) {

        Path path = Path.of(ruta);

        try (Stream<Path> flujo = Files.list(path)) {
            flujo.filter(path1 -> path1.getFileName().toString().startsWith(palabra))
                    .map(path1 -> {
                        try {
                            if (Files.isRegularFile(path)) {
                                return "(Fichero) Nombre: " + path1.getFileName() + " Peso: " + Files.size(path) / 1024;
                            } else {
                                return "(Directorio) Nombre: " + path1.getFileName();
                            }
                        } catch (IOException e) {
                            return "Error " + e.getMessage();
                        }
                    }).forEach(System.out::println);

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void buscarArchivoEnDirectorio(String nombreDirecotrio, String nombreArchivo) {

        Path rutaDirectorio = Path.of(nombreDirecotrio);

        try (Stream<Path> flujoPath = Files.list(rutaDirectorio)) {

            flujoPath.filter(Files::isRegularFile)
                    .filter(path -> path.getFileName().toString().equals(nombreArchivo))
                    .map(path -> {
                        try {
                            return "Ruta: " + path.toAbsolutePath() + ", Peso: " + Files.size(path) / 1024;
                        } catch (IOException e) {
                            return "Error" + e.getMessage();
                        }
                    })
                    .forEach(System.out::println);

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void buscarRecursivamenteArchivoDeDirectorio(String nombreDirectorio, String nombreArchivoABuscar) {

        Path ruta = Path.of(nombreDirectorio);

        try (Stream<Path> flujoPath = Files.walk(ruta)) {

            flujoPath.filter(Files::isRegularFile)
                    .filter(path -> path.getFileName().toString().equals(nombreArchivoABuscar))
                    .map(path -> {
                        try {
                            return "Ruta: " + path.toAbsolutePath() + ", Peso: " + Files.size(path) / 1024;
                        } catch (IOException e) {
                            return "Error" + e.getMessage();
                        }
                    })
                    .forEach(System.out::println);

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
