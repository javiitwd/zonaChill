package TEMA7.boletin1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ejercicio8 {
    public static void main(String[] args) {

        try {
            if (ficheroCumpleFormato("src/TEMA7/boletin1")) {
                System.out.println("si");
            } else {
                System.out.println("NO");
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static boolean ficheroCumpleFormato(String fichero) throws IOException {

        //para leer caracter por caracter
        FileReader fileReader = new FileReader(fichero);

        //Para leer por lineas
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        Pattern p = Pattern.compile("^[a-zA-Z]{2,} [a-zA-Z]{2,} [a-zA-Z]{2,} [1-9][0-9]?$");

        String linea;
        while ((linea = bufferedReader.readLine()) != null) {

            //Guardamos el patron y lo que quieres que cumpla el patron (linea)
            Matcher m = p.matcher(linea);

            if (!m.matches()) {
                return false;
            }
        }
        return true;
    }
}
