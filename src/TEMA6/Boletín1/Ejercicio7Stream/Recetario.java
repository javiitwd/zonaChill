package TEMA6.Boletín1.Ejercicio7Stream;

import java.util.*;

public class Recetario {

    // HashMap que guarda las recetas, donde la clave es el nombre de la receta
    // y el valor es el objeto Receta.
    private Map<String, Receta> recetas;

    public Recetario() {
        recetas = new HashMap<>();
    }

    public Map<String, Receta> getRecetas() {
        return recetas;
    }

    public void setRecetas(Map<String, Receta> recetas) {
        this.recetas = recetas;
    }

    public void annadirReceta(Receta recetaAAnadir) throws RecetaException {

        //Si la alguna clave(nombre de la receta) tiene el nombre de la receta que voy a añadir tiro excepcion
        if (recetas.containsKey(recetaAAnadir.getNombre())) {
            throw new RecetaException("La receta ya existe");
        }
        recetas.put(recetaAAnadir.getNombre(), recetaAAnadir);
    }

    public String listadoRecetasOrdenadasAlfabeticamente() throws RecetaException {

        //ORDENAMOS POR NOMBRE LAS RECETAS
        //sorted implementa la interfaz Comparable, que debe tener implementado el metodo compareTo()
        //podemos darle entre los () del sorted por lo que queremos compararlo ej: .sorted(Comparator.comparing(Receta :: getNombre));
        return recetas.values().stream()
                .sorted((recetaA, recetaB) -> recetaA.getNombre().compareTo(recetaB.getNombre())) //asi tambien podemos ponerlo (compara 2 recetas por su nombre)
                //Una vez ordenado sigues teniendod un flujo, entonces lo necesitamos convertir a String para devolver el nombre y tiempo de preparacion
                .map(receta -> receta.getNombre() + ": " + receta.getTiempoDePreparacion())
                // El reduce esta concatenando 2 Strings En este caso, está concatenando las cadenas
                // de texto que representan los nombres de las recetas junto con sus tiempos de preparacion.
                .reduce((recetaA, recetaB) -> recetaA.concat(recetaB))
                .orElseThrow(() -> new RecetaException("No hay recetas disponibles"));
    }

    public String listadoRecetasConIngredienteOrdenadasPorTiempoPreparacion(String ingrediente) throws RecetaException {

        return recetas.values().stream()
                //primero filtramos las recetas que necesitan en ingrediente
                .filter(r -> r.necesitaIngrediente(ingrediente))
                //el sorted()  tambien puede ser: (receta1, receta2) -> receta1.getTiempoPreparacion() - receta2.getTiempoPreparacion()
                .sorted((Comparator.comparing(Receta::getTiempoDePreparacion))) //asi tambien podemos ponerlo (compara 2 recetas por su nombre)
                //Una vez ordenado sigues teniendod un flujo, entonces lo necesitamos convertir a String para devolver el nombre y tiempo de preparacion
                .map(receta -> receta.getNombre() + ": " + receta.getTiempoDePreparacion())
                // El reduce esta concatenando 2 Strings En este caso, está concatenando las cadenas
                // de texto que representan los nombres de las recetas junto con sus tiempos de preparacion.
                // aunque si fuese int() en vez de String deberiamos indicarle la operacion que queremos hacer con los 2 elementos
                // Ej: .reduce((1, 2) -> 1+2)
                .reduce((receta1, receta2) -> receta1.concat(System.lineSeparator().concat(receta2)))
                .orElseThrow(() -> new RecetaException("No hay recetas disponibles"));
    }
}