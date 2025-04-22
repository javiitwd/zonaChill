package TEMA7.boletin1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ejercicio2 {
    public static void main(String[] args) {

        try (FileReader fr = new FileReader("input.txt");
             BufferedReader br = new BufferedReader(fr)) {

            StringBuilder unirLineas = new StringBuilder();

            String l;
            while ((l = br.readLine()) != null) {

                unirLineas.append(l);
            }

            System.out.printf("El fichero tiene la siguiente liena %s \n", unirLineas);

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
