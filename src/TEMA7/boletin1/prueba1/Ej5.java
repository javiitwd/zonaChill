package TEMA7.boletin1.prueba1;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;
import java.util.stream.Stream;

public class Ej5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        boolean salir = false;

        while (!salir) {

            System.out.println("1. Crear directorio");
            System.out.println("2. Crear un fichero de texto");
            System.out.println("3. Borrar fichero de texto");
            System.out.println("4. Mostrar los ficheros que contiene una carpeta");
            System.out.println("5. Salir");

            int op = sc.nextInt();

            try {
                switch (op) {
                    case 1:
                        System.out.println("Ponga el nombre del directorio");
                        String nombreDirectorio = sc.next();

                        crearDirectorioNIO(nombreDirectorio);
                        break;

                    case 2:
                        System.out.println("Ponga el nombre del fichero");
                        String nombreFichero = sc.next();

                        System.out.println("Ponga su contenido");
                        String contenido = sc.next();

                        crearFichero(nombreFichero, contenido);
                        break;

                    case 3:
                        System.out.println("Ponga el nombre del fichero");
                        String nombreFicheroABorrar = sc.next();

                        borrarFichero(nombreFicheroABorrar);
                        break;

                    case 4:
                        System.out.println("Ponga el nombre de la carpeta");
                        String nombreCarpeta = sc.next();
                        System.out.println(mostrarFicherosDeCarpeta(nombreCarpeta));
                        break;

                    case 5:
                        salir = true;
                        break;
                }
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static void crearDirectorioNIO(String nombreDirectorio) throws IOException {

        Path path = Path.of("src/TEMA7/boletin1/prueba1/", nombreDirectorio);
        if (Files.notExists(path)) {
            Files.createDirectory(path);
        } else {
            throw new IOException("El directorio ya existe");
        }
    }

    public static void crearDirectorioIO(String nombreDirectorio) throws IOException {

        File file = new File(nombreDirectorio);

        //Si no se ha podido crear lanzamos excepcion, ya que .mkdir() devuleve false si no se ha podido crear
        if (!file.mkdir()) {
            throw new IOException("El directorio ya existe");
        }
    }

    public static void crearFichero(String nombreFichero, String contenido) throws IOException {

        Path path = Path.of(nombreFichero);

        if (Files.notExists(path)) {
            Files.createFile(path);
            Files.writeString(path, contenido);
        } else {
            throw new IOException("El fichero ya existe");
        }
    }

    public static void borrarFichero(String nombreFichero) throws IOException {

        Path path = Path.of(nombreFichero);

        if (!Files.deleteIfExists(path)) {
            throw new IOException("No se ha podido borrar");
        }
    }

    public static String mostrarFicherosDeCarpeta(String nombreCarpeta) throws IOException {

        Path path = Path.of("src/TEMA7/boletin1/", nombreCarpeta);

        if (Files.notExists(path) || !Files.isDirectory(path)) {
            throw new IOException("El directorio no existe o es un fichero");
        }

        //Creamos un Stream con los elementos que haya en la ruta (path) indicada
        try (Stream<Path> flujoDePath = Files.list(path)) {
            return flujoDePath
                    .filter(Files::isRegularFile)
                    //Convertimos el flujo de rutas a un flujo de nombres de los archivos
                    .map(Path::getFileName)
                    .sorted()
                    .toString();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return "error";
    }
}
