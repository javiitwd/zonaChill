package TEMA7.boletin4;


import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class Ejercicio3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Ponga la palabra: ");
        String palabra = sc.next();
        Path path = Path.of("src/TEMA7/boletin3/quijote.txt");
        System.out.println(lineasDelFicheroConPalabra(path.toFile(), palabra));
    }

    public static String lineasDelFicheroConPalabra(File file, String palabra) {

        Pattern pattern = Pattern.compile("\\b" + palabra + "\\b");

        StringBuilder sb = new StringBuilder();

        try (Stream<String> lineas = Files.lines(file.toPath())) {

            lineas.filter(linea -> {

                        Matcher matcher = pattern.matcher(linea);

                        return matcher.find();
                    })
                    .forEach(linea -> sb.append(linea));

            return sb.toString();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
