package TEMA6.Boletín1.Ejercicio5.Prueba1;

import java.util.*;

public class Diccionario {

    private Map<String, ArrayList<String>> diccionarioDePalabras;

    public Diccionario() {
        this.diccionarioDePalabras = new HashMap<>();
    }

    public void annadirPalabra(String palabra, String significado) {

        //Si el diccionario contiene la palabra, cogo la palabra (clave) y se añado el significado
        if (diccionarioDePalabras.containsKey(palabra)) {
            diccionarioDePalabras.get(palabra).add(significado);
            return;
        }
        //Si no la tiene creamos la palabra y se damos un signifiacdo en la segunda linea
        diccionarioDePalabras.put(palabra, new ArrayList<>());
        diccionarioDePalabras.get(palabra).add(significado);
    }

    public String buscarPalabraEnElDiccionario(String palabraABuscar) throws DiccionarioException {

        StringBuilder listaDeSignificados = new StringBuilder();

        if (!diccionarioDePalabras.containsKey(palabraABuscar)) {
            throw new DiccionarioException("La palabra no está");
        }

        //Guardo los significados de la palabraABuscar, ya que se que existe
        ArrayList<String> significadosDeLaPalabra = diccionarioDePalabras.get(palabraABuscar);

        //Recorro los significados y los añado a un StringBuilder
        for (String significado : significadosDeLaPalabra) {
            listaDeSignificados.append(significado).append(System.lineSeparator());
        }
        return listaDeSignificados.toString();
    }

    public void borrarPalabraDelDiccionario(String palabraABorrar) throws DiccionarioException {

        if (diccionarioDePalabras.containsKey(palabraABorrar)) {
            diccionarioDePalabras.remove(palabraABorrar);
            return;
        }
        throw new DiccionarioException("La palabra no existe");
    }

    public String listadoDePalabraQueEmpiecenConCadena(String cadenaInicio) {

        //StringBuilder para meter las palabras y mostrarlas
        StringBuilder listaDePalabras = new StringBuilder();

        /*Estás añadiendo a TreeMap un valor vacío (una nueva ArrayList<>) para cada palabra,
        lo cual no es necesario si no vas a utilizar los valores. Si solo te interesa las claves,
        puedes usar un TreeSet, que es más adecuado cuando solo te interesan las claves únicas y ordenadas.*/

        TreeSet<String> palabrasOrdenadas = new TreeSet<>();

        //Recorro las palabras (claves) y todas las que empiecen con la cadena recibida por parametro
        //las añado al TreeSet, el cual ordenara automaticamente las palabras y se asegurara de que no se repitan
        for (String palabra : diccionarioDePalabras.keySet()) {
            if (palabra.startsWith(cadenaInicio)) {
                palabrasOrdenadas.add(palabra);
            }
        }
        //Recorro las palabras ya ordenadas y las meto en el StringBuilder
        for (String palabra : palabrasOrdenadas) {
            listaDePalabras.append(palabra).append(System.lineSeparator());
        }
        return listaDePalabras.toString();
    }

    @Override
    public String toString() {
        return "Diccionario: " + diccionarioDePalabras +
                '.';
    }
}
