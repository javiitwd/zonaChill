package TEMA6.Boletín1.Ejercicio4;

import java.util.ArrayList;
import java.util.ListIterator;

public class Ejercicio4 {

    //Metodo para devolver un araayList en reverso
    //Devuelve un ArrayList generico(<T>) y acepta tambien un ArrayList generico
    private static <T> ArrayList<T> reverse(ArrayList<T> arrayOriginal) {

        //Me creo un nuevo ArrayList para no modificar el original,
        //y como se que va a tener la misma longitud que el original le pongo el .size
        ArrayList<T> nuevo = new ArrayList<>(arrayOriginal.size());

        //Lo que vamos a hacer el recorrer la lista al revés para ir poniendolos
        //en orden inverso en una nueva lista y así poder devolver al final la lista al revés, que es lo que nos pide el ejercicio

        ListIterator<T> it = arrayOriginal.listIterator(arrayOriginal.size()); //le paso el size para decirle por donde quiero empezar a recorrer

        //es como un iterator normal pero miramos si tiene anterior, si lo tiene lo añado al nuevo ArrayList
        while (it.hasPrevious()) {
            nuevo.add(it.previous());
        }
        return nuevo;
    }

    public static void main(String[] args) {

        //Para probarlo me creo un ArrayList
        ArrayList<Integer> array = new ArrayList<>();

        //Le meto valores al array
        array.add(1);
        array.add(2);
        array.add(3);
        array.add(4);
        array.add(5);

        //y llamo al metodo que hemos creado
        ArrayList<Integer> arrayRerverso = reverse(array);

        //Esto es un flujo y es para mostrar el recorrido
        arrayRerverso.stream().forEach(System.out :: println);
    }
}
