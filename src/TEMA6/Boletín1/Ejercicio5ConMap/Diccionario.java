/*
 * El map es una coleccion que en cada posicion
 * tiene 2 elementos, la clave(k) y el valor(v) de dicha clave
 * */
package TEMA6.Boletín1.Ejercicio5ConMap;

import TEMA6.Boletín1.Ejercicio5.DiccionarioException;

import java.util.*;

public class Diccionario {

    //En Map, String es el nombre de la palabra y List<String> son los significados
    private Map<String, List<String>> diccionario;

    public Diccionario() {
        this.diccionario = new HashMap<>();
    }

    public Map<String, List<String>> getDiccionario() {
        return diccionario;
    }

    public void anadirPalabra(String palabra, String significado) {

        //Si contiene la palabra...
        if (diccionario.containsKey(palabra)) {
            //Cogo la lista asociada a esa palabra y le añado el significado
            diccionario.get(palabra).add(significado);
        }
        //El put es para meter un nuevo registro en el Map, es decir, una nueva clave
        //El get es para seleccionar una clave que ya existe y con eso podemos depues meterle mas valores

        /*
         * Es decir, abajo añado la nueva clave porque no existe la palabra
         * y despues cogo la clave y le meto el valor*/
        diccionario.put(palabra, new ArrayList<>());
        diccionario.get(palabra).add(significado);
    }

    public List<String> buscarPalabraEnElDiccionario(String palabra) throws DiccionarioException {

        //Si contiene la palabra devuelvo los valores de esta
        if (diccionario.containsKey(palabra)) {
            return diccionario.get(palabra);
        }
        throw new DiccionarioException("Palabra no encontrada");
    }

    public void borrarPalabra(String palabra) throws DiccionarioException {

        if (diccionario.containsKey(palabra)) {
            diccionario.remove(palabra);
        }
        throw new DiccionarioException("No se ha encontrado");
    }

    public List<String> listadoDePalabrasQueEmpiecenConLetra(String cadena) {

        List<String> palabras = new ArrayList<>();

        //Con entrySet() cogo la clave y el valor
        //Con keySet() cogo solo las claves
        //Con values() cogo los valores de la clave

        //Recorro las claves del diccionario y si alguna empieza con la cadena la añado a otra lista nueva
        for (String palabra : diccionario.keySet()) {
            if (palabra.startsWith(cadena)) {
                palabras.add(cadena);
            }
        }
        //Para ordenarlo llamo al metodo sort() de la clase Collection
        //Y en otra linea, devuelvo lo ordenado
        Collections.sort(palabras);
        return palabras;
    }


    @Override
    public String toString() {
        return "Diccionario: " + diccionario;
    }
}
