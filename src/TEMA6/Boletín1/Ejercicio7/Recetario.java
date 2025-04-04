package TEMA6.Boletín1.Ejercicio7;

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
        if (recetas.isEmpty()) {
            throw new RecetaException("No hay recetas disponibles.");
        }
        SortedMap<String, Double> recetasOrdenadas = new TreeMap<>();
        for (Receta receta : recetas.values()) {
            recetasOrdenadas.put(receta.getNombre(), receta.getTiempoDePreparacion());
        }
        StringBuilder resultado = new StringBuilder();
        for (Map.Entry<String, Double> entry : recetasOrdenadas.entrySet()) {
            resultado.append(entry.getKey()).append(" - ").append(entry.getValue()).append(" min\n");
        }
        return resultado.toString().trim();
    }


    public String listadoRecetasConIngredienteOrdenadasPorTiempoPreparacion(String ingrediente) throws RecetaException {
        //Collections.reverseOrder() ordena de mayor a menor en vez de menor a mayor
        Map<Double, String> lista = new TreeMap<>(Collections.reverseOrder());

        for (Receta receta : recetas.values()) {
            if (receta.necesitaIngrediente(ingrediente)) {
                lista.put(receta.getTiempoDePreparacion(), receta.getNombre());
            }
        }
        if (lista.isEmpty()) {
            throw new RecetaException("No hay recetas con el ingrediente: " + ingrediente);
        }
        StringBuilder resultado = new StringBuilder();

        //Map.Entry<K, V> representa un par clave-valor dentro de un Map<K, V>.
        //Es útil cuando quieres recorrer un Map y obtener tanto la clave como el valor en cada iteración sin hacer búsquedas adicionales.
        for (Map.Entry<Double, String> elemento : lista.entrySet()) { //el entrySet() obtiene clave y valor de un Map

            resultado.append(elemento.getValue()).append(": ").append(elemento.getKey()).append(" min\n");
        }


         /*
         FORMA MAS FACIL
         for (Double d : lista.keySet()) {

            resultado.append(lista.get(d)).append(": ").append(d);

            resultado.append(entry.getValue()).append(" - ").append(entry.getKey()).append(" min\n");
        } */
        return resultado.toString().trim(); // Eliminamos la última línea en blanco
    }
}
