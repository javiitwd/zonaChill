package TEMA7.examenes.examen1_angelito;

import org.w3c.dom.Document;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Parte1 {
    public static void main(String[] args) {

        Path registroTxt = Path.of("src/TEMA7/examenes/examen1_angelito/registro.txt");

        System.out.println("Ponga sus lineas: ");

        try (Scanner sc = new Scanner(System.in)) {

            while (true) {

                String linea = sc.nextLine();

                if (linea.equals("fin")) {
                    break;
                }
                if (linea.length() > 10) {

                    Files.writeString(registroTxt, linea, StandardOpenOption.CREATE, StandardOpenOption.APPEND);

                    if (Files.size(registroTxt) > 2000) {

                        if (Files.notExists(Path.of("src/TEMA7/examenes/examen1_angelito/copias"))) {
                            Files.createDirectory(Path.of("src/TEMA7/examenes/examen1_angelito/copias"));
                        }
                        String registroTxtRenombrado = "src/TEMA7/examenes/examen1_angelito/copias/registro_" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));
                        Files.move(registroTxt, Path.of(registroTxtRenombrado));
                    }
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
