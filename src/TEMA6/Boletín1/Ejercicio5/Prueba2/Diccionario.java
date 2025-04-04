package TEMA6.Boletín1.Ejercicio5.Prueba2;

import TEMA6.Boletín1.Ejercicio5.Palabra;

import java.util.*;
import java.util.stream.Collectors;

public class Diccionario {

    //Atributos
    private HashMap<String, EntradaDiccionario> entradas;

    public Diccionario() {

    }

    public void annadirPalabra(String palabra, String significado) {

        entradas.put(palabra, new EntradaDiccionario(palabra, significado));
    }


    public String buscarPalabra(String palabraABuscar) throws DiccionarioException {

        boolean estaLaPalabra = false;
        estaLaPalabra = entradas.keySet().stream()
                .anyMatch(palabra -> palabra.equalsIgnoreCase(palabraABuscar));

        if (!estaLaPalabra) {
            throw new DiccionarioException("No está la palabra");
        }

        return entradas.get(palabraABuscar).toString();
    }

    public void borrarPalabra(String palabraABorrar) throws DiccionarioException {

        entradas.remove(palabraABorrar);
    }

    public String listadoDePalabrasQueEmpiezanPor(String comienzo) throws DiccionarioException {

        return entradas.keySet().stream()
                .filter(palabra -> palabra.startsWith(comienzo))
                .sorted()
                .collect(Collectors.joining(", "));
    }
}
