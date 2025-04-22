package TEMA7.boletin1.prueba1;

import java.io.*;

public class Ej3 {
    public static void main(String[] args) {

        //en br almacenamos lo que el usuario introduzca por teclado
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             //escribe en el archivo de su declaracion lo que recibe
             PrintWriter pr = new PrintWriter(new FileWriter("src/TEMA7/boletin1/prueba1/salidaEj3.txt", true), true)) {

            String l;

            //guardamos la linea en la variable "l"
            //mientras l (que tiene el contenido que haya escrito el tio) sea diferente de null y diferente de "fin"
            //seguimos el bucle
            //br.readLine() es cuando guardamos los que escribe, ya que es un BufferReader modificado para que sea de Input (entrada del texto)
            while ((l = br.readLine()) != null && !l.equalsIgnoreCase("fin")) {

                //enviamos lo que escribe el usuario (l) al PrintWriter (pr), y eso lo escribira el el fichero "salidaEj3.txt"
                pr.println(l);

                //podemos escribir lo que haya en el Buffer aunque no se haya llenado con -> pr.flush();
                //Pero en este caso no tiene sentido ya que en la declaracion del PrintWhitter ya lo hicimos

            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
