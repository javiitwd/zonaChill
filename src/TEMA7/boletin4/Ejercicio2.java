package TEMA7.boletin4;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class Ejercicio2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Ponga la palabra: ");
        String palabra = sc.next();
        Path path = Path.of("src/TEMA7/boletin3/quijote.txt");
        System.out.println(contarPalabraEnFichero(path.toFile(), palabra));
    }

    public static int contarPalabraEnFichero(File file, String palabra) {

        Pattern pattern = Pattern.compile("\\b" + palabra + "\\b");
        try (Stream<String> lineas = Files.lines(file.toPath())) {

            return lineas.map(pattern::matcher)
                    .mapToInt(matcher ->{

                        int cont = 0;
                        while (matcher.find()){
                            cont++;
                        }
                        return cont;
                    })
                    .sum();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
