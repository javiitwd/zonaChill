package TEMA6.Examenes.ExamenColecciones2021.Ejercicio2;

import java.util.ArrayList;
import java.util.List;

public class ListaGenerica2<T extends Comparable<T>> {

    private List<T> lista;

    public ListaGenerica2() {
        lista = new ArrayList<>();
    }

    // Metodo para agregar un elemento a la lista
    public void agregar(T elemento) {
        lista.add(elemento);
    }

    // Metodo que devuelve una sublista hasta el elemento buscado
    public ListaGenerica2<T> listaHastaElemento(T elementoBuscado) {
        ListaGenerica2<T> sublista = new ListaGenerica2<>();

        // Recorremos la lista original
        for (T elemento : lista) {
            sublista.agregar(elemento);
            if (elemento.equals(elementoBuscado)) {
                return sublista;
            }
        }

        return null; // Si no se encuentra el elemento
    }

    // Metodo que devuelve una lista con los elementos menores que el elemento de referencia
    public ListaGenerica2<T> elementosMenores(T elementoReferencia) {
        ListaGenerica2<T> sublista = new ListaGenerica2<>();

        // Recorremos la lista original
        for (T elemento : lista) {
            if (elemento.compareTo(elementoReferencia) < 0) { // Comparamos los elementos
                sublista.agregar(elemento);
            }
        }

        // Si la sublista está vacía, devolvemos null
        if (sublista.lista.isEmpty()) {
            return null;
        }

        return sublista;
    }

    // Metodo para mostrar la lista
    public void mostrarLista() {
        for (T elemento : lista) {
            System.out.print(elemento + " → ");
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        // Crear una lista de ejemplo
        ListaGenerica2<Integer> lista = new ListaGenerica2<>();
        lista.agregar(10);
        lista.agregar(20);
        lista.agregar(5);
        lista.agregar(30);
        lista.agregar(15);

        System.out.println("Lista original:");
        lista.mostrarLista();

        // Obtener la sublista de elementos menores que 20
        ListaGenerica2<Integer> sublistaMenores = lista.elementosMenores(20);

        if (sublistaMenores != null) {
            System.out.println("Elementos menores que 20:");
            sublistaMenores.mostrarLista();
        } else {
            System.out.println("No hay elementos menores que 20.");
        }
    }
}


