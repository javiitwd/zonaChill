package TEMA7.boletin1.prueba1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class Ej4 {
    public static void main(String[] args) {

        Path path = Path.of("src/TEMA7/boletin1/prueba1/salidaEj3.txt");

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            String l;

            while ((l = br.readLine()) != null && !l.equalsIgnoreCase("fin")) {
                //**CREATE**: crea el archivo si no existe.
                //**APPEND**: escribe al final del archivo (no borra lo que ya hay).
                Files.writeString(path, l + "\n", StandardOpenOption.CREATE, StandardOpenOption.APPEND);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
