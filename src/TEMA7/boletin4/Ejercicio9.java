package TEMA7.boletin4;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Ejercicio9 {
    public static void main(String[] args) {

        Path rutaNotasTxt = Path.of("src/TEMA7/boletin4/notas.txt");
        try (Scanner sc = new Scanner(System.in)) {
            List<String> lineas = new LinkedList<>();
            System.out.println("Ponga sus lineas: ");
            while (true) {

                String linea = sc.nextLine();

                if (linea.equalsIgnoreCase("fin")) {
                    break;
                }

                lineas.add(linea.trim());
            }
            lineas.sort(null);

            Files.write(rutaNotasTxt, lineas, StandardOpenOption.CREATE);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
