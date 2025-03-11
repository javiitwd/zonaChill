package TEMA6.Boletín1.Ejercicio4;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class Prueba2 {

    public static void main(String[] args) {

        ArrayList<String> lista = new ArrayList<> ();
        lista.add("Hola");
        lista.add("eres");
        lista.add("gay");

        ArrayList<String> listaReversa = reverse(lista);

        //Esto es un flujo y es para mostrar el recorrido
        listaReversa.stream().forEach(System.out :: println);
    }

    private static<T>ArrayList<T> reverse(ArrayList<T> arrayOriginal){

        //Creo en array vacio para meter el arrayOriginal al reves
        ArrayList<T> arrayReverso = new ArrayList<>(arrayOriginal.size());

        //Guardamos el arrayOriginal como listIterator, para poder recorrerlo al reves
        ListIterator<T> arrayARecorrer = arrayOriginal.listIterator();

        while (arrayARecorrer.hasPrevious()){
            arrayReverso.add(arrayARecorrer.previous());
        }
        return arrayReverso;
    }
}
