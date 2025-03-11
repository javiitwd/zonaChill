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
        SortedMap<Double, String> lista = new TreeMap<>();

        for (Receta receta : recetas.values()) {
            if (receta.necesitaIngrediente(ingrediente)) {
                lista.put(receta.getTiempoDePreparacion(), receta.getNombre());
            }
        }
        if (lista.isEmpty()) {
            throw new RecetaException("No hay recetas con el ingrediente: " + ingrediente);
        }
        StringBuilder resultado = new StringBuilder();
        for (Map.Entry<Double, String> entry : lista.entrySet()) {
            resultado.append(entry.getValue()).append(" - ").append(entry.getKey()).append(" min\n");
        }
        return resultado.toString().trim(); // Eliminamos la última línea en blanco
    }
}
