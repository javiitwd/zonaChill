package TEMA7.boletin3.ejercicio4.prueba1;

import TEMA7.boletin3.ejercicio4.QuijoteException;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {


        try {
            File file = new File("src/TEMA7/boletin3/ejercicio4/prueba1/quijote.txt");
            System.out.println("Contador de palabras razon -> " + contadorDePalabrasRazon(file));
            System.out.println("Contador de tildes y ñ -> " + contarTildesYNDeSpain(file));
            eliminarNumerosTrasPalabras(file);
            crearFicheroEnElQueTodasLasPalabrasEmpiecenPorMayusculas(file);
            //System.out.println("Frases con más de 15 palabras: \n" + frasesConMenos15Palabras(file));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static int contadorDePalabrasRazon(File file) {

        Pattern pattern = Pattern.compile("\\braz[oó]\\b", Pattern.CASE_INSENSITIVE);

        try (Stream<String> lineas = Files.lines(file.toPath())) {
            //Convertimos cada linea del fichero a linea + patron (matcher)
            return lineas.map(pattern::matcher)
                    //convertimos el matcher a int (mientras encuentre el patron
                    // en la linea, aumentamos el contador, que es a lo que convertimos)
                    .mapToInt(matcher -> {

                        int cont = 0;

                        while (matcher.find()) {
                            cont++;
                        }
                        return cont;
                    })
                    //sumamos las veces que se ha encontrado razon en todo el fichero
                    .sum();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static int contarTildesYNDeSpain(File file) {

        Pattern pattern = Pattern.compile("[áéíóúñ]", Pattern.CASE_INSENSITIVE);

        try (Stream<String> lineasDelFichero = Files.lines(file.toPath())) {
            return lineasDelFichero.map(pattern::matcher)
                    .mapToInt(m -> {

                        int cont = 0;
                        while (m.find()) {
                            cont++;
                        }
                        return cont;
                    })
                    .sum();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void eliminarNumerosTrasPalabras(File file) throws IOException {

        Pattern pattern = Pattern.compile("(?<letras>\\b\\p{L}+)\\d+", Pattern.CASE_INSENSITIVE);

        Path path = Path.of("src/TEMA7/boletin3/ejercicio4/prueba1/quijoteSinNumeros.txt");

        Files.deleteIfExists(path);
        Files.createFile(path);

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {

            String l;
            while ((l = br.readLine()) != null) {

                Matcher matcher = pattern.matcher(l);

                //String lineaModificada = matcher.replaceAll("$1");
                String lineaModificada = matcher.replaceAll("${letras}");

                Files.writeString(path, lineaModificada + "\n", StandardOpenOption.APPEND);
            }
        }
    }

    public static void crearFicheroEnElQueTodasLasPalabrasEmpiecenPorMayusculas(File file) throws IOException {

        Pattern pattern = Pattern.compile("((?i)\\b\\p{L})", Pattern.UNICODE_CHARACTER_CLASS);

        Path rutaAGuardarNuevoFichero = Path.of("src/TEMA7/boletin3/ejercicio4/prueba1/quijoteEnMayusculas.txt");

        Files.deleteIfExists(rutaAGuardarNuevoFichero);
        Files.createFile(rutaAGuardarNuevoFichero);

        try (Stream<String> lineasFichero = Files.lines(file.toPath())) {

            lineasFichero.forEach(lineaFichero -> {

                Matcher matcher = pattern.matcher(lineaFichero);

                // String nuevaLinea = matcher.replaceAll("$1".toUpperCase());
                // Asi en este caso no valdria, ya que estamos usando .toUpperCase()
                // Porque "$1".toUpperCase() se evalúa antes de llamar a replaceAll,
                // y solo pasa el texto literal "$1" en mayúsculas, sin sustituir el grupo capturado.
                String nuevaLinea = matcher.replaceAll(m -> m.group().toUpperCase());

                try {
                    Files.writeString(rutaAGuardarNuevoFichero, nuevaLinea + "\n", StandardOpenOption.APPEND);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });
        }
    }
}