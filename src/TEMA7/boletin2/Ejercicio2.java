package TEMA7.boletin2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class Ejercicio2 {
    public static void main(String[] args) {

        String rutaFichero = "src/TEMA7/boletin2/Ejercicio2Fichero";

        try {
            System.out.println("Palabras: " + contarPalabrasDeFichero(rutaFichero));
            buscarPalabra(rutaFichero, "antonio");

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static int contarPalabrasDeFichero(String rutaFichero) throws IOException {

        Path ruta = Path.of(rutaFichero);

        //Hacemos un flujo con las lineas del fichero
        try (Stream<String> filas = Files.lines(ruta)) {
            //1) Convertimos cada linea de texto a su numero de palabras
            //Para ello convertimos con el .split() a un Array de String (que seria 1 posicion por cada palabra)
            //2) y marcamos como separador uno o mas espacios -> ("\\s+")
            //3) Por ultimo como tenemos un Array de String de tamaño en funcion de las palabras que tenga con .lenght sabremos cuantas palabras tiene
            return filas.mapToInt(linea -> linea.split("\\s+").length)
                    .sum(); //sumamos el total de palabras de cada linea

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        throw new IOException("Ha ocurrido un error");
    }

    public static void buscarPalabra(String rutaFichero, String palabraABuscar) throws IOException {

        Path ruta = Path.of(rutaFichero);
        Path rutaNueva = Path.of("src/TEMA7/boletin2/BuscandoPalabra.txt");

        AtomicInteger atomicInteger = new AtomicInteger();

        Pattern patron = Pattern.compile(palabraABuscar);

        //Hacemos un flujo con las lineas del fichero
        try (Stream<String> filas = Files.lines(ruta)) {
            filas.forEach(s -> {
                //aumentamos el contador atomico
                atomicInteger.set(atomicInteger.get() + 1);
                Matcher matcher = patron.matcher(s);
                if (matcher.find()) {
                    try {
                        Files.writeString(rutaNueva, "Encontrada en linea: " + atomicInteger + " y columna: " + matcher.start() +"\n", StandardOpenOption.APPEND);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
            });

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}