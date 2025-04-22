package TEMA7.boletin1;
//no poner NUNCA import.* SOLO importa las necesarias

import java.io.*;

public class ejercicio1 {
    public static void main(String[] args) {

        //Creamos un FileReader que tendra el valor del archivo indicado en su declaracion (ruta)
        try (FileReader fr = new FileReader("src/TEMA7/boletin1/prueba1/fichero_ej1");
             //Metemos el FileReader creado en un BufferReader para poder leer por lineas
             BufferedReader br = new BufferedReader(fr)) {

            int contador = 0;

            //Mientras haya lineas, aumentamos el contador de lineas xd
            while (br.readLine() != null) {

                contador++;
            }

            System.out.println("El fichero tiene " + contador + " lineas");

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
