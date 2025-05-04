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
             BufferedWriter bw = new BufferedWriter(new FileWriter(fileNuevo, true))) {

            String l;
            while ((l = br.readLine()) != null) {
                Matcher matcher = patron.matcher(l);
                // Reemplaza todas las coincidencias por solo la parte de letras
                // El $ indica que vas a usar un grupo capturado.
                //Las llaves {} se usan cuando el nombre del grupo no es solo un número
                // (como $1, $2), sino un nombre de grupo que tú has definido en la expresión regular con (?<letras>...).
                String lineaModificada = matcher.replaceAll("${letras}");

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

        try (BufferedReader br = new BufferedReader(new FileReader(file));
             BufferedWriter bw = new BufferedWriter(new FileWriter(nuevoFile, true))) {

            String linea;
            while ((linea = br.readLine()) != null) {

                StringBuilder nuevaLinea = new StringBuilder();

                String[] palabras = linea.trim().split("\\s+");

                for (int i = 0; i < palabras.length; i++) {

                    //Como hay lineas vacias de por medio, debemos asegurarnos de que la palabra no esta vacia
                    if (!palabras[i].isEmpty()) {

                        String palabraActual = palabras[i];
                        String primeraLetraEnMayuscula = palabraActual.substring(0, 1).toUpperCase();

                        if (palabraActual.length() > 1) {

                            //no ponemos 2 segundo parametro para que llegue hasta el final de la palabra
                            String restoDeLaPalabra = palabraActual.substring(1).toLowerCase();
                            String palabraModificada = primeraLetraEnMayuscula + restoDeLaPalabra;
                            nuevaLinea.append(palabraModificada).append(" ");
                        } else {
                            nuevaLinea.append(primeraLetraEnMayuscula).append(" ");
                        }
                    }
                }

                bw.write(nuevaLinea.toString().trim());
                bw.newLine();
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static String frasesConMenos15Palabras(File file) throws QuijoteException {

        Pattern patronDePalabras = Pattern.compile("\\b\\p{L}+\\d*\\b");

        StringBuilder sb = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {

            String l;
            while ((l = br.readLine()) != null) {

                String[] frases = l.split("\\.");

                if (frases.length > 0) {
                    for (int i = 0; i < frases.length; i++) {

                        int contadorPalabrasDeLaFrase = 0;

                        //Guardamos la frase mas el patron
                        Matcher matcher = patronDePalabras.matcher(frases[i]);

                        //MIENTRAS ENCONTREMOS PALABRAS AUMENTAMOS EL CONTADOR, NO (IF)
                        while (matcher.find()) {
                            contadorPalabrasDeLaFrase++;
                        }

                        if (contadorPalabrasDeLaFrase > 15) {
                            sb.append(frases[i]).append(System.lineSeparator());
                        }
                    }
                }
            }
            return sb.toString();

        } catch (IOException e) {
            throw new QuijoteException("Ha ocurrido algún error");
        }
    }
}

