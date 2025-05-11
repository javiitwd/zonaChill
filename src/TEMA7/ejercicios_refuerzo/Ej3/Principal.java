package TEMA7.ejercicios_refuerzo.Ej3;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class Principal {
    public static void main(String[] args) {
        Path carpeta = Path.of("src/TEMA7/ejercicios_refuerzo/Ej3/carpeta");

        numPalabrasFicheros(carpeta);

        numPalabrasDeCadaArchivo(carpeta);
    }

    public static void numPalabrasFicheros(Path carpeta) {

        try (Stream<Path> flujoCarpeta = Files.list(carpeta)) {
            flujoCarpeta.filter(Files::isRegularFile)
                    .map(path -> path.getFileName() + ": " + numPalabras(path))
                    .forEach(System.out::println);

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static int numPalabras(Path path) {

        Pattern patron = Pattern.compile("\\p{L}{4,}");
        try (Stream<String> lineas = Files.lines(path)) {
            return lineas.mapToInt(linea -> {
                Matcher matcher = patron.matcher(linea);

                int cont = 0;
                while (matcher.find()) {
                    cont++;
                }
                return cont;
            }).sum();

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return 0;
    }

    public static void numPalabrasDeCadaArchivo(Path carpeta) {

        try (Stream<Path> flujoCarpeta = Files.list(carpeta)) {
            flujoCarpeta.filter(Files::isRegularFile)
                    .map(path -> "Palabras de " + path.getFileName() + ": \n" + palabrasYRepeticiones(path))
                    .forEach(System.out::println);

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static String palabrasYRepeticiones(Path fichero) {

        Pattern patronPalabras = Pattern.compile("(\\p{L}+)");

        Map<String, Integer> map = new HashMap<>();

        try (Stream<String> lineas = Files.lines(fichero)) {
            lineas.forEach(linea -> {
                String[] palabrasDeLaLinea = linea.split("\\s+");

                // Recorro las palabras y me aseguro de que son palabras (cumplen el patron)
                for (int i = 0; i < palabrasDeLaLinea.length; i++) {
                    String palabraActual = palabrasDeLaLinea[i];

                    Matcher matcher = patronPalabras.matcher(palabraActual);
                    if (matcher.find()) {
                        palabraActual = matcher.group();

                        // Si el map no contiene la palabra actual
                        if (!map.containsKey(palabraActual)) {
                            // La añadimos (con 1 vez encontrada)
                            map.put(palabraActual, 1);
                            // Si ya contenia la palabra, a las veces repetidas de antes (value) le sumamos 1
                        } else {
                            int vecesRepes = map.get(palabraActual);
                            vecesRepes += 1;
                            map.put(palabraActual, vecesRepes);
                        }
                    }
                }
            });
            return pasarMapAString(map);

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return "Error";
    }

    public static String pasarMapAString(Map<String, Integer> map) {

        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, Integer> palabraYRepeticiones : map.entrySet()) {

            sb.append(palabraYRepeticiones.getKey()).append(": ").append(palabraYRepeticiones.getValue()).append("\n");
        }
        return sb.toString();
    }
}
