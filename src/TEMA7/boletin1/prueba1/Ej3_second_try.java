package TEMA7.boletin1.prueba1;

import java.io.*;

public class Ej3_second_try {
    public static void main(String[] args) {

        //Este BufferedReader recibe las lineas que intrduzca el usuario
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             PrintWriter pw = new PrintWriter(new FileWriter("src/TEMA7/boletin1/prueba1/salidaEj3", true), true)) {

            String l;

            while ((l = br.readLine()) != null && !l.equalsIgnoreCase("fin")) {

                pw.println(l);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }
}
