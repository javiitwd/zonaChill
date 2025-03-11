package TEMA6.Boletín1.Ejercicio5ConMap;

import TEMA6.Boletín1.Ejercicio5.Diccionario;
import TEMA6.Boletín1.Ejercicio5.DiccionarioException;

public class Main {
    public static void main(String[] args) {

        TEMA6.Boletín1.Ejercicio5.Diccionario diccionario = new Diccionario();

        //Añadir palabra
        diccionario.anadirPalabra("Juanfran", "El rey de la fiesta");
        diccionario.anadirPalabra("Juanfran", "Pa´ cualquier lao´meno´pa´la kasa");
        diccionario.anadirPalabra("Fernando", "El goat");

        try {
            System.out.println("Diccionario: " +diccionario);
            System.out.println();

            //Buscar palabra en diccionario
            System.out.println("Buscamos la palabra Juanfran y devolvemos su significado: ");
            diccionario.buscarPalabraEnElDiccionario("Juanfran");
            System.out.println();

            //Borrar una palabra del diccionario
            System.out.println("Borramos la palabra Juanfran");
            diccionario.borrarPalabra("Juanfran");
            System.out.println(diccionario);
            System.out.println();

            //Listado de palabras que empiecen por…
            System.out.println("Devolver una lista de plabras que empiezan con x cadena: ");
            System.out.println(diccionario.listadoDePalabrasQueEmpiecenConLetra("Fer"));

        } catch (DiccionarioException e) {
            System.out.println(e.getMessage());
        }
    }
}
