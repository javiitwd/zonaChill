package TEMA7.boletin2;

import TEMA6.EjercicioHospital.Paciente;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

public class Ejercicio1 {
    public static void main(String[] args) {


    }

    public static void crearDirectorio(String nombre) throws IOException {

        Path ruta = Path.of(nombre);

        if (Files.notExists(ruta)) {
            Files.createDirectory(ruta);
        } else {
            throw new IOException("El directorio ya existe");
        }
    }

    public static void crearFicheroTexto(String nombre, String texto) throws IOException {

        Path ruta = Path.of(nombre);

        if (Files.notExists(ruta)) {
            Files.createFile(ruta);
            Files.writeString(ruta, texto);
        } else {
            throw new IOException("El fichero ya existe");
        }
    }

    public static void borrarFicheroTexto(String nombre) throws IOException {

        Path ruta = Path.of(nombre);

        if (!Files.deleteIfExists(ruta)) {
            throw new IOException("El fichero no se ha podido borrar");
        }
    }

    public static void mostrarFicherosDeCarpeta(String rutaCarpeta) {

        try (BufferedReader br = new BufferedReader(new FileReader(rutaCarpeta));
             Stream<Path> flujo = Files.list(Path.of(rutaCarpeta))) {
            flujo.filter(Files::isRegularFile)
                    .map(Path::getFileName)
                    .sorted()
                    .forEach(System.out::println);

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
