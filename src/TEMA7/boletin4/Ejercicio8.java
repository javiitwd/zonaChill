package TEMA7.boletin4;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ejercicio8 {
    public static void main(String[] args) {

        Path rutaBitacoraTxt = Path.of("src/TEMA7/boletin4/bitacora.txt");
        System.out.println("Introduzca sus textos:");

        Pattern patron = Pattern.compile("\\bmargari\\b", Pattern.CASE_INSENSITIVE);

        try (Scanner sc = new Scanner(System.in)) {

            while (true) {

                String linea = sc.nextLine();

                if (linea.equals("fin")) {
                    break;
                }

                Matcher matcher = patron.matcher(linea);

                if (linea.trim().length() < 10 && matcher.find()) {

                    Files.writeString(rutaBitacoraTxt, linea, StandardOpenOption.APPEND, StandardOpenOption.CREATE);
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
