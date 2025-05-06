package TEMA7.boletin4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Ejercicio4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int TAM_MAX = 2000;

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            Path ruta = Path.of("src/TEMA7/boletin4/log.txt");
            Files.deleteIfExists(ruta);
            Files.createFile(ruta);

            System.out.println("Escriba el texto: ");

            String texto;
            while (!(texto = br.readLine()).equals("fin")) {

                int tamActual = (int) Files.size(ruta);

                if (tamActual > TAM_MAX) {
                    BasicFileAttributes atributosDelFichero = Files.readAttributes(ruta, BasicFileAttributes.class);

                    FileTime fechaYHoraDeCreacion = atributosDelFichero.creationTime();

                    LocalDateTime fechaYHoraDeCreacionFiltrado = LocalDateTime.ofInstant(fechaYHoraDeCreacion.toInstant(), ZoneId.systemDefault());

                    Path nuevaRuta = Path.of("src/TEMA7/boletin4/log_" + fechaYHoraDeCreacionFiltrado.format(DateTimeFormatter.ofPattern("dd-MM-yyyy_HH-mm-ss")) + ".txt");

                    Files.move(ruta, nuevaRuta);
                } else {
                    Files.writeString(ruta, texto, StandardOpenOption.APPEND);
                }
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
