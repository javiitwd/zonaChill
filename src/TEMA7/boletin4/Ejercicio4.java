package TEMA7.boletin4;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Ejercicio4 {
    public static void main(String[] args) {

        Path ruta = Path.of("src/TEMA7/boletin4/log.txt");

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

                    // Ruta en el que voy a guadar este fichero (que ya se ha llenado)
                    Path rutaNuevoLog = Path.of("src/TEMA7/boletin4/log_" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd-hhmmss")) + ".txt");

                    // Guardamos las lineas que tenemos del log actual en una lista (para escribirlas en el log a guardar)
                    // List<String> lineasLogActual = Files.readAllLines(ruta);

                    // Escribimos la lista de las lineas que guardamos en la ruta del nuevo log
                    // Files.write(rutaNuevoLog, lineasLogActual, StandardOpenOption.CREATE);

                    // Renombramos el fichero (por eso no hay que borrarlo abajo, tampoco hace falta
                    // crear un log nuevo ya que arriba hemos metdio Option.CREATE que crea en caso de que la ruta no exista)
                    // ya que .move() mueve y renombra
                    Files.move(ruta, rutaNuevoLog);

                    // Eliminamos el log actual (despues se creara automaticamente)
                    // Files.delete(ruta);
                }
            }
        } catch (IOException e) {
            System.out.println(e.toString());
        }
    }
}
