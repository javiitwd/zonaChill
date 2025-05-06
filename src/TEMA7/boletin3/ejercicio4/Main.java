package TEMA7.boletin3.ejercicio4;

import java.io.*;
import java.nio.file.Files;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {


        try {
            File file = new File("src/TEMA7/boletin3/ejercicio4/quijote.txt");
            System.out.println("Contador de palabras razon -> " + contadorDePalabrasRazon(file));
            eliminarNumerosTrasPalabras(file);
            crearFicheroEnElQueTodasLasPalabrasEmpiecenPorMayusculas(file);
            System.out.println("Frases con más de 15 palabras: \n" + frasesConMenos15Palabras(file));
            palabrasConMas8Letras(file);
        } catch (QuijoteException e) {
            System.out.println(e.getMessage());
        }
    }

    public static int contadorDePalabrasRazon(File file) throws QuijoteException {

        Pattern pattern = Pattern.compile("(?i)\\braz[oó]n\\b");

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {

            String l;
            int contador = 0;
            while ((l = br.readLine()) != null) {

                Matcher matcher = pattern.matcher(l);

                while (matcher.find()) {
                    contador++;
                }
            }
            return contador;
        } catch (IOException e) {
            System.out.println(e.getMessage());
            throw new QuijoteException("Ha ocurrido un error");
        }
    }

    public static int contadorDePalabrasRazonNIO(File file) throws QuijoteException {

        Pattern pattern = Pattern.compile("(?i)\\braz[oó]n\\b");

        try (Stream<String> lineas = Files.lines(file.toPath())) {

            return lineas.map(pattern::matcher)
                    //de cada matcher(linea + patron) convertimos a int(segun el numero de coincidencias)
                    .mapToInt(m -> {

                        int contador = 0;
                        //mientras el matcher encunetre una coincidencia en esa linea, aumenta el contador
                        while (m.find()) {
                            contador++;
                        }
                        //convertimos el matcher en el numero de coincidencias encontradas
                        return contador;
                        //finalmente sumamos el numero de coincidencias encontradas por cada linea
                    }).sum();

        } catch (IOException e) {
            throw new QuijoteException("Ha ocurrido un error");
        }
    }

    public static void eliminarNumerosTrasPalabras(File file) throws QuijoteException {

        File fileNuevo = new File("src/TEMA7/boletin3/ejercicio4/quijote2.txt");

        // Letras seguidas de números. Solo se quedará con las letras.
        Pattern patron = Pattern.compile("(?<letras>\\p{L}+)(\\d+)", Pattern.CASE_INSENSITIVE);

        try (BufferedReader br = new BufferedReader(new FileReader(file));
             BufferedWriter bw = new BufferedWriter(new FileWriter(fileNuevo))) {

            String l;
            while ((l = br.readLine()) != null) {
                Matcher matcher = patron.matcher(l);
                // Reemplaza todas las coincidencias de la linea con la expresion regular por solo la parte de letras
                // El $ indica que vas a usar un grupo de captura.
                // Las llaves {} se usan cuando el nombre del grupo no es solo un número
                // (como $1, $2), sino un nombre de grupo que tú has definido en la expresión regular con (?<letras>...).
                String lineaModificada = matcher.replaceAll("$1");
                // String lineaModificada = matcher.replaceAll("${letras}");
                // String lineaModificada = matcher.replaceAll(m -> m.group(1));

                bw.write(lineaModificada);
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
            throw new QuijoteException("Ha ocurrido un error");
        }
    }

    public static void crearFicheroEnElQueTodasLasPalabrasEmpiecenPorMayusculas(File file) {

        File nuevoFile = new File("src/TEMA7/boletin3/ejercicio4/quijoteEnMayusculas.txt");

        //El patron coge una letra siempre y cuando este "aislada" (\\b), ya que e´ solo lo que queremos, la 1ºa letra
        Pattern patron = Pattern.compile("\\b(?<palabra>\\p{L})", Pattern.UNICODE_CHARACTER_CLASS);

        try (BufferedReader br = new BufferedReader(new FileReader(file));
             BufferedWriter bw = new BufferedWriter(new FileWriter(nuevoFile, true))) {

            String linea;
            while ((linea = br.readLine()) != null) {

                Matcher matcher = patron.matcher(linea);
                String nuevaLinea = matcher.replaceAll(m -> m.group(1).toUpperCase());

                bw.write(nuevaLinea);
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void palabrasConMas8Letras(File file) throws QuijoteException {

        Pattern pattern = Pattern.compile("\\p{L}{9,}", Pattern.UNICODE_CHARACTER_CLASS);

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {

            String linea;
            while ((linea = br.readLine()) != null) {
                Matcher matcher = pattern.matcher(linea);

                while (matcher.find()) {
                    System.out.println(matcher.group());
                }
            }

        } catch (IOException e) {
            throw new QuijoteException(e.getMessage());
        }
    }

    public static String frasesConMenos15Palabras(File file) throws QuijoteException {

        Pattern patronDePalabras = Pattern.compile("\\b\\p{L}+\\d*");

        StringBuilder sb = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {

            String l;
            while ((l = br.readLine()) != null) {

                //Hacemos un Array de frases, las frases estaran separadas por .
                String[] frases = l.split("\\.");

                for (int i = 0; i < frases.length; i++) {

                    if (frases[i].isBlank()) {
                        continue;
                    }

                    //Guardamos las palabrasDeLaFrase de la frase (el tamaño es el numero de palabrasDeLaFrase que hay)
                    String[] palabrasDeLaFrase = frases[i].split("\\s+");

                    if (palabrasDeLaFrase.length < 15) {
                        sb.append(frases[i].trim()).append(System.lineSeparator());
                    }
                }
            }
            return sb.toString();
        } catch (IOException e) {
            throw new QuijoteException("Ha ocurrido algún error");
        }
    }
}