package TEMA7.boletin4;

import java.io.*;

public class Ejercicio5IO {
    public static void main(String[] args) {

        File salida = new File("src/TEMA7/boletin4/datos.txt");

        salida.delete();

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             PrintWriter pw = new PrintWriter(new FileWriter(salida, true))) {

            String linea;
            while ((linea = br.readLine()) != null && !linea.equalsIgnoreCase("fin")) {

                pw.println(linea);
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}