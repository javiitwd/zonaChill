package TEMA7.boletin1;

import java.io.*;

public class ejercicio3 {
    public static void main(String[] args) {

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             PrintWriter os = new PrintWriter(new FileWriter("salida.txt"))) {

            String contenido;
            while ((contenido = br.readLine()) != null) {

                os.println(contenido);
                os.flush();
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
