package TEMA6.Boletín1.Ejercicio4;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class Prueba1 {

    public static void main(String[] args) {

        //Creamos una lista de enteros para probar
        ArrayList<Integer> lista = new ArrayList<>();

        //Le añado valores
        lista.add(1);
        lista.add(2);
        lista.add(3);
        lista.add(4);

        //Llamo al metodo que hemos creado para voltear el arrayList
        ArrayList<Integer> listaReversa = reverse(lista);

        //Esto es un flujo y es para mostrar el recorrido
        listaReversa.stream().forEach(System.out :: println);
    }

    private static <T> ArrayList<T> reverse(ArrayList<T> arrayOriginal) {

        //Creo el nuevo arrayList, que tendra el original en reverso
        ArrayList<T> arrayReverso = new ArrayList<>();

        //Para poder recorrer el arrayOriginal al reves, necesito convertirlo en ListIterator, y como sabemos la longuitud se la ponemos
        ListIterator<T> arrayOriginalEnIterator = arrayOriginal.listIterator(arrayOriginal.size());

        //Recorremos el listIterator al reves, mientras tenga anterior...
        while (arrayOriginalEnIterator.hasPrevious()){
            //Añado la posicion al arrayReverso que estamos creando
            arrayReverso.add(arrayOriginalEnIterator.previous());
        }
        return arrayReverso;
    }
}
