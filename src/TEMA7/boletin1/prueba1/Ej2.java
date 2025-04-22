package TEMA7.boletin1.prueba1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Ej2 {
    public static void main(String[] args) {

        try {
            FileReader fr = new FileReader("src/TEMA7/boletin1/prueba1/fichero_ej1");
            BufferedReader br = new BufferedReader(fr);

            StringBuilder cadena = new StringBuilder();

            while (br.readLine() != null) {
                cadena.append(br.readLine()).append(" ");
            }

            System.out.println("Cadena: " + cadena);

            //Podemos meter los FileReader y Buffereader dentro de los () del try o cerrarlos despueS
            // PERO QUE NO SE TE OLVIDE CERRARLOS
            fr.close();
            br.close();

            /**
             * de la otra forma seria:
             * try(FileReader fr = new FileReader("src/TEMA7/boletin1/prueba1/fichero_ej1");
             *             BufferedReader br = new BufferedReader(fr)){}
             */

            //lanzamos la excepcion mas especifica necesaria
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
            //y tambien la excepcion padre de java io
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
