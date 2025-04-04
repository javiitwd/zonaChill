package TEMA6.Boletín1.Ejercicio7.prueba2;

import java.util.*;
import java.util.stream.Collectors;

public class Recetario {

    private Map<String, Receta> recetas;

    public Recetario() {
        this.recetas = new HashMap<>();
    }

    public Map<String, Receta> getRecetas() {
        return recetas;
    }

    public void annadirReceta(Receta nuevaReceta) throws RecetarioException {

        if (recetas.containsKey(nuevaReceta.getNombreReceta())) {
            throw new RecetarioException("La receta y exite");
        }

        recetas.put(nuevaReceta.getNombreReceta(), nuevaReceta);
    }

    public String listadoRecetasOrdenadasAlfabeticamente() throws RecetarioException {

        if (recetas.isEmpty()) {
            throw new RecetarioException("No hay recetas");
        }

        return recetas.values().stream()
                .sorted(Comparator.comparing(Receta::getNombreReceta))
                .map(r -> "Nombre " + r.getNombreReceta() + ". Tiempo: " + r.getTiempoPreparacion())
                .collect(Collectors.joining("\n"));
    }

    public List<String> listadoRecetasOrdenadasPorTiempo() throws RecetarioException {

        /*if (recetas.isEmpty()) {
            throw new RecetarioException("No hay recetas");
        }

        return recetas.values().stream()
                .sorted(Comparator.comparingInt(Receta::getTiempoPreparacion))
                .map(r -> "Nombre " + r.getNombreReceta() + ". Tiempo: " + r.getTiempoPreparacion())
                .collect(Collectors.joining("\n"));*/

        /*Map<Double, String> listaOrdenada = new TreeMap<>(Collections.reverseOrder());

        for (Map.Entry<String, Receta> map : recetas.entrySet()) {

            listaOrdenada.put(map.getValue().getTiempoPreparacion(), map.getKey());
        }

        StringBuilder sb = new StringBuilder();

        for (Map.Entry<Double, String> map : listaOrdenada.entrySet()){

            sb.append("Nombre: " +map.getValue()+ ", Tiempo: " +map.getKey()).append(System.lineSeparator());
        }
        return sb.toString();*/

        return recetas.values().stream()
                .sorted(Comparator.comparing(Receta::getTiempoPreparacion))
                .map(receta -> "Nombre: " + receta.getNombreReceta() + ", tiempo: " + receta.getTiempoPreparacion())
                .toList();
    }

    @Override
    public String toString() {
        return "Recetario{" +
                "recetas=" + recetas +
                '}';
    }
}
