package TEMA7.boletin1.prueba1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Stream;

public class Ej7 {
    public static void main(String[] args) {


    }

    public static void listarDirectorio(String ruta) throws IOException {

        Path rutaDirectorio = Path.of(ruta);

        if (!Files.isDirectory(rutaDirectorio)) {
            throw new IOException("El archivo indicado no es un directorio");
        }

        try (Stream<Path> flujoDirectorio = Files.list(rutaDirectorio)) {
            flujoDirectorio.map(path -> {
                        try {

                            if (Files.isDirectory(path)) {
                                return "Directorio -> " + path.getFileName().toString();
                            } else {
                                return "Fichero -> " + path.getFileName().toString() + ", Peso: " + Files.size(path) / 1024 + " KB";
                            }
                        } catch (IOException e) {
                            return "Error";
                        }
                    })
                    .forEach(System.out::println);

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void listarDirectorioYFicheros(String ruta, String palabra) throws IOException {

        Path rutaDirectorio = Path.of(ruta);

        if (!Files.isDirectory(rutaDirectorio)) {
            throw new IOException("El archivo indicado no es un directorio");
        }

        try (Stream<Path> flujoDirectorio = Files.list(rutaDirectorio)) {
            flujoDirectorio.filter(path -> path.getFileName().toString().startsWith(palabra))
                    .map(path -> {
                        try {

                            if (Files.isDirectory(path)) {
                                return "Directorio -> " + path.getFileName().toString();
                            } else {
                                return "Fichero -> " + path.getFileName().toString() + ", Peso: " + Files.size(path) / 1024 + " KB";
                            }
                        } catch (IOException e) {
                            return "Error";
                        }
                    })
                    .forEach(System.out::println);

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void listarArchivosConExtension(String ruta, String extension) throws IOException {

        Path rutaDirectorio = Path.of(ruta);

        if (!Files.isDirectory(rutaDirectorio)) {
            throw new IOException("El archivo indicado no es un directorio");
        }

        try (Stream<Path> flujoDirectorio = Files.list(rutaDirectorio)) {
            flujoDirectorio.filter(path -> path.toString().endsWith(extension))
                    .map(path -> {
                        try {

                            if (Files.isDirectory(path)) {
                                return "Directorio -> " + path.getFileName().toString();
                            } else {
                                return "Fichero -> " + path.getFileName().toString() + ", Peso: " + Files.size(path) / 1024 + " KB";
                            }
                        } catch (IOException e) {
                            return "Error";
                        }
                    })
                    .forEach(System.out::println);

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void mostrarArchivoDeDirectorio(String ruta, String arhcivoABuscar) throws IOException {

        Path rutaDirectorio = Path.of(ruta);

        if (!Files.isDirectory(rutaDirectorio)) {
            throw new IOException("El archivo indicado no es un directorio");
        }

        try (Stream<Path> flujoDirectorio = Files.list(rutaDirectorio)) {
            flujoDirectorio.filter(Files::isRegularFile)
                    .filter(path -> path.getFileName().toString().equalsIgnoreCase(arhcivoABuscar))
                    .forEach(System.out::println);

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void mostrarArchivoDeDirectorioRecursivamente(String ruta, String arhcivoABuscar) throws IOException {

        Path rutaDirectorio = Path.of(ruta);

        if (!Files.isDirectory(rutaDirectorio)) {
            throw new IOException("El archivo indicado no es un directorio");
        }

        try (Stream<Path> flujoDirectorio = Files.walk(rutaDirectorio)) {
            flujoDirectorio.filter(Files::isRegularFile)
                    .filter(path -> path.getFileName().toString().equalsIgnoreCase(arhcivoABuscar))
                    .forEach(System.out::println);

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
