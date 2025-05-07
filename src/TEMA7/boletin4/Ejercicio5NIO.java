package TEMA7.boletin4;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Ejercicio5NIO {
    public static void main(String[] args) {

        try (Scanner sc = new Scanner(System.in)) {

            List<String> lineas = new LinkedList<>();

            System.out.println("Introduzca las lineas -> (fin) para terminar ");
            while (true) {

                String linea = sc.nextLine();

                if (linea.equalsIgnoreCase("fin")) {
                    break;
                }
                lineas.add(linea);
            }

            try {
                Path rutaAGuardarFichero = Path.of("src/TEMA7/boletin4/salida.txt");

                // StandardOpenOption.CREATE -> Indica que si el archivo no existe, se debe crear.
                Files.writeString(rutaAGuardarFichero, String.join("\n", lineas), StandardOpenOption.CREATE);
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}