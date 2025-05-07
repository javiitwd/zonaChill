package TEMA7.boletin4;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.Scanner;

public class Ejercicio6 {
    public static void main(String[] args) {

        Path ruta = Path.of("src/TEMA7/boletin4/texto.txt");

        try (Scanner sc = new Scanner(System.in)) {

            System.out.println("Introduzca sus lineas: ");
            while (true) {
                String linea = sc.nextLine();

                if (linea.equals("fin")) {
                    break;
                }
                Files.writeString(ruta, linea, StandardOpenOption.APPEND, StandardOpenOption.CREATE);
                Files.writeString(ruta, "\n", StandardOpenOption.APPEND, StandardOpenOption.CREATE);

                if (Files.size(ruta) > 20) {
                    List<String> lineas = Files.readAllLines(ruta);

                    lineas.removeFirst();
                    Files.writeString(ruta, String.join("\n", lineas), StandardOpenOption.TRUNCATE_EXISTING);
                }
            }
        } catch (IOException e) {
            System.out.println(e.toString());
        }
    }
}
