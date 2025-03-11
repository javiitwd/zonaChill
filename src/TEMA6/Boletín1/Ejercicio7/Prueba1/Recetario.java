package TEMA6.Boletín1.Ejercicio7.Prueba1;

import java.util.*;

public class Recetario {

    private Map<String, Receta> recetas;

    public Recetario() {
        this.recetas = new HashMap<>();
    }

    public void annadirReceta(Receta nuevaReceta) throws RecetarioException {

        if (recetas.containsKey(nuevaReceta.getNombreReceta())) {
            throw new RecetarioException("La receta ya existe");
        }

        recetas.put(nuevaReceta.getNombreReceta(), nuevaReceta);
    }

    public String listadoRecetasOrdenadasAlfabeticamente() throws RecetarioException {

        if (recetas.isEmpty()) {
            throw new RecetarioException("No hay recetas");
        }

        //Creo un TreeMap para meter las recetas y que asi se ordenen automaticamente
        TreeMap<String, Integer> recetasOrdenadas = new TreeMap<>();

        //StringBuilder para devolver el String
        StringBuilder listaDeRecetas = new StringBuilder();

        //Recorro los nombres de las recetas (claves)
        for (String receta : recetas.keySet()) {
            //Y meto en el nuevo TreeMap de recetasOrdenadas el nombre y tiempo de preparacion de la receta actual
            recetasOrdenadas.put(receta, recetas.get(receta).getTiempoDePreparacion());
        }

        //Ahora recorro las recetas ordenadas
        for (String recetaOrdenada : recetasOrdenadas.keySet()){
            //Añado a la listDeRecetas el nombre de la receta actual
            listaDeRecetas.append(recetaOrdenada);
            //Tambien le añado el tiempo de preparacion de la receta y un salto de linea
            listaDeRecetas.append(recetas.get(recetaOrdenada).getTiempoDePreparacion());
            listaDeRecetas.append(System.lineSeparator());
        }
        return listaDeRecetas.toString();
    }

    public String listadoRecetasConIngredienteOrdenadasPorTiempoPreparacion(String ingrediente) throws RecetarioException {
        // Lista para almacenar las recetas que contienen el ingrediente
        List<Receta> recetasConIngrediente = new ArrayList<>();

        // Filtramos las recetas que contienen el ingrediente
        for (Receta receta : recetas.values()) {
            if (receta.necesitaIngrediente(ingrediente)) {
                recetasConIngrediente.add(receta);
            }
        }

        // Si no encontramos recetas con el ingrediente, lanzamos la excepción
        if (recetasConIngrediente.isEmpty()) {
            throw new RecetarioException("No se encontraron recetas con el ingrediente: " + ingrediente);
        }

        // Ordenamos las recetas por tiempo de preparación (en orden ascendente)
        recetasConIngrediente.sort(Comparator.comparingInt(Receta::getTiempoDePreparacion));

        // Construimos el String con las recetas ordenadas
        StringBuilder listadoDeRecetasOrdenadas = new StringBuilder();
        for (Receta receta : recetasConIngrediente) {
            listadoDeRecetasOrdenadas.append("Nombre: ").append(receta.getNombreReceta())
                    .append(", Tiempo de preparación: ").append(receta.getTiempoDePreparacion())
                    .append(System.lineSeparator());
        }

        return listadoDeRecetasOrdenadas.toString();
    }
}
/*
Ordenar la lista recetasConIngrediente de forma ascendente según el tiempo de preparación de las recetas.

¿Cómo lo sabe? Porque le pasas un Comparator, que le dice a Java cómo comparar los elementos de la lista.
En este caso, lo que le dices es: "Comparen las recetas por su tiempo de preparación".

Comparator.comparingInt(Receta::getTiempoDePreparacion) es solo una forma compacta de decirle a Java
que compare los elementos basándose en el valor que devuelve el metodo getTiempoDePreparacion() de cada receta.

Ya que (Receta :: getTiempoDePrepacion) es como un for-eich, en este caso el tipo es Receta y saca el valor del atributo: tiempoDePreparacion
Y el Comparator.comparingInt, compara enteros de los que le pidamos entre (), en este caso la linea de arriba
*/