package TEMA6.Examenes.ExamenColecciones2021.Ejercicio2;

import java.util.ArrayList;
import java.util.List;

public class ListaGenerica<T> {

    private List<T> lista;

    public ListaGenerica() {
        lista = new ArrayList<>();
    }

    // Metodo para agregar un elemento a la lista
    public void agregar(T elemento) {
        lista.add(elemento);
    }

    // Metodo que devuelve una sublista hasta el elemento buscado
    public ListaGenerica<T> listaHastaElemento(T elementoBuscado) {
        ListaGenerica<T> sublista = new ListaGenerica<>();

        // Recorremos la lista original
        for (T elemento : lista) {
            sublista.agregar(elemento);
            if (elemento.equals(elementoBuscado)) {
                return sublista;
            }
        }

        return null; // Si no se encuentra el elemento
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
        ListaGenerica<String> lista = new ListaGenerica<>();
        lista.agregar("A");
        lista.agregar("B");
        lista.agregar("C");
        lista.agregar("D");
        lista.agregar("E");
        lista.agregar("F");

        System.out.println("Lista original:");
        lista.mostrarLista();

        // Obtener la sublista hasta el elemento "D"
        ListaGenerica<String> sublista = lista.listaHastaElemento("D");

        if (sublista != null) {
            System.out.println("Lista hasta el elemento 'D':");
            sublista.mostrarLista();
        } else {
            System.out.println("Elemento no encontrado.");
        }
    }
}

