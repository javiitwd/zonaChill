package TEMA7.boletin4;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;

public class Ejercicio7 {
    public static void main(String[] args) {

        Path registroTxt = Path.of("src/TEMA7/boletin4/registro.txt");

        try (Scanner sc = new Scanner(System.in)) {

            System.out.println("Ponga su texto:");
            while (true) {

                String linea = sc.nextLine();

                if (linea.equalsIgnoreCase("fin")) {
                    break;
                }

                if (linea.isEmpty()) {
                    System.out.println("La linea debe contener texto.");
                    continue;
                }

                Files.writeString(registroTxt, linea + "\n", StandardOpenOption.CREATE, StandardOpenOption.APPEND);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
