package TEMA6.Examenes.ExamenColecciones2021.Ejercicio1;

public class Pregunta {
    public static void main(String[] args) {
        Pregunta pregunta = new Pregunta();
        System.out.println("¿Crees que la elección de un LinkedList de Películas, un ArrayList de Opiniones\n" +
                "y un HashSet de actores es la adecuada? Justifica con argumentos la respuesta.\n");
        System.out.println(pregunta.respuesta());
    }

    public String respuesta() {
        return """
        La elección de las estructuras de datos parece estar basada en las necesidades de acceso, modificación y búsqueda:

        1. **LinkedList<Pelicula>**: No es la mejor opción si se necesita acceso rápido a elementos por índice,
        ya que la búsqueda es O(n). Sin embargo, es útil si las inserciones y eliminaciones son frecuentes y se hacen
        en posiciones intermedias, ya que no requieren desplazamientos como en un ArrayList.

        2. **ArrayList<Opinion>**: Es una buena elección, ya que las opiniones suelen añadirse al final de la lista y
        el acceso por índice es rápido (O(1)), lo que es útil si queremos recorrer todas las opiniones fácilmente.

        3. **HashSet<Actor>**: Es una buena opción para evitar duplicados de actores y garantizar búsquedas rápidas (O(1) en promedio).
        Si se necesita mantener un orden específico, un LinkedHashSet o TreeSet podría ser más adecuado.

        Posibles mejoras:
        - Si las películas deben accederse frecuentemente por índice, un **ArrayList** podría ser más eficiente.
        - Si las opiniones requieren inserciones en posiciones intermedias frecuentemente, un **LinkedList** podría ser mejor.
        - Si se necesita orden en los actores, un **TreeSet** podría ser más útil que un HashSet.
        """;
    }
}

