package TEMA7.boletin1;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.util.Comparator;
import java.util.stream.Stream;

public class ejercicio5 {
    public static void main(String[] args) {

        try {
            crearDirectorioJavaIO("Javier con IO");
            crearDirectorioJavaNIO("Javier con NIO");

            crearFicheroDeTexto("Antoñito", "Me llamo antonio");

            borrarFicheroDeTexto("Antoñito");

            mostrarFicherosCarpeta("boletin1");

        } catch (DirectorioException e) {
            System.out.println(e.getMessage());
        }
    }

    public static File crearDirectorioJavaIO(String nombre) throws DirectorioException {

        //Guardamos en un File la direccion donde vamos a crear el fichero
        File directorio = new File("src/TEMA7/boletin1/" + nombre);

        //Si no puedo crear el directorio, lanzamos excepion (ya que .mkdir() devuleve true/false si la ha podido o no crear)
        if (!directorio.mkdir()) {
            throw new DirectorioException("No se ha podido crear el directorio");
        }
        return directorio;
    }

    public static Path crearDirectorioJavaNIO(String nombre) throws DirectorioException {


        try {
            Path directorioNio = Path.of("src/TEMA7/boletin1/", nombre);
            //Creamos el directorio
            Files.createDirectory(directorioNio);
            return directorioNio;
        } catch (IOException e) {
            throw new DirectorioException("No se ha podido crear el directorio");
        } catch (InvalidPathException e) {
            throw new DirectorioException("No se ha podido crear el directorio");
        }
    }

    public static Path crearFicheroDeTexto(String nombreFichero, String contenidoTexto) throws DirectorioException {

        try {
            Path ficheroNio = Path.of("src/TEMA7/boletin1/", nombreFichero);
            //Creamos el fichero
            Files.createFile(ficheroNio);
            Files.writeString(ficheroNio, contenidoTexto);
            return ficheroNio;
        } catch (IOException e) {
            throw new DirectorioException("No se ha podido crear el directorio");
        } catch (InvalidPathException e) {
            throw new DirectorioException("No se ha podido crear el directorio");
        }
    }

    public static void borrarFicheroDeTexto(String nombreFichero) throws DirectorioException {

        try {
            Path ficheroNio = Path.of("src/TEMA7/boletin1/", nombreFichero);

            //Borramos el fichero si existe
            if (!Files.deleteIfExists(ficheroNio)) {
                throw new DirectorioException("No se ha podido borrar el fichero");
            }
        } catch (IOException e) {
            throw new DirectorioException("No se ha podido borrar el directorio");
        } catch (InvalidPathException e) {
            throw new DirectorioException("No se ha podido borrar el directorio");
        }
    }

    public static void mostrarFicherosCarpeta(String nombreCarpeta) {

        Path carpeta = Path.of("src/TEMA7/", nombreCarpeta);

        try (Stream<Path> stream = Files.list(carpeta)) {
            //filtramos los que son solo ficheros
            stream.filter(Files::isRegularFile)
                    //los ordenamos por nombre del fichero
                    .sorted(Comparator.comparing(Path::getFileName))
                    //los mostramos por pantalla
                    .forEach(System.out::println);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}