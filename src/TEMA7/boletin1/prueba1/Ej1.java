package TEMA7.boletin1.prueba1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Ej1 {
    public static void main(String[] args) {

        int contador = 0;

        try (FileReader fr = new FileReader("src/TEMA7/boletin1/prueba1/fichero_ej1");
             BufferedReader br = new BufferedReader(fr)) {

            while (br.readLine() != null) {
                contador++;
            }

            System.out.printf("Tiene %d lineas", contador);

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}