package TEMA6.Boletín1.Ejercicio7.prueba2;

import java.util.*;

public class Receta {

    private String nombreReceta;
    private double tiempoPreparacion;
    private Set<Ingrediente> ingredientes;
    private List<String> pasos;

    public Receta(String nombreReceta, int tiempoPreparacion) {
        this.nombreReceta = nombreReceta;
        this.tiempoPreparacion = tiempoPreparacion;
        this.ingredientes = new HashSet();
        pasos = new LinkedList<>();
    }

    public String getNombreReceta() {
        return nombreReceta;
    }

    public void setNombreReceta(String nombreReceta) {
        this.nombreReceta = nombreReceta;
    }

    public double getTiempoPreparacion() {
        return tiempoPreparacion;
    }

    public void setTiempoPreparacion(int tiempoPreparacion) {
        this.tiempoPreparacion = tiempoPreparacion;
    }

    public Set getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(Set ingredientes) {
        this.ingredientes = ingredientes;
    }

    public List<String> getPasos() {
        return pasos;
    }

    public void setPasos(List<String> pasos) {
        this.pasos = pasos;
    }

    public boolean necesitaIngrediente(String nombreIngrediente) {

        return ingredientes.contains(nombreIngrediente);
    }

    public void addIngredienteAReceta(Ingrediente ingredienteNuevo) {

        if (!ingredientes.contains(ingredienteNuevo)) {
            ingredientes.add(ingredienteNuevo);
            return;
        }

        for (Ingrediente ingrediente : ingredientes) {

            if (ingrediente.equals(ingredienteNuevo)) {
                ingrediente.setCantidad(ingrediente.getCantidad() + ingredienteNuevo.getCantidad());
                return;
            }
        }
    }

    public void borrarIngrediente(Ingrediente ingredienteABorrar) throws RecetarioException {

        if (!ingredientes.contains(ingredienteABorrar)) {
            throw new RecetarioException("No se encuentra el ingrediente");
        }

        ingredientes.remove(ingredienteABorrar);

        Iterator<String> pasosIterator = pasos.reversed().iterator();

        if (pasosIterator.hasNext()) {

            if (pasosIterator.next().contains(ingredienteABorrar.getNombreIngrediente())) {
                pasosIterator.remove();
            }
        }
    }

    public void annadirPasoDetrasDe(String pasoNuevo, String pasoExistente) throws RecetarioException {

        int indiceDelPaso = pasos.indexOf(pasoExistente);

        if (indiceDelPaso == -1) {
            throw new RecetarioException("El paso no existe");
        }

        // Si te dice "añade el paso 5 posicion detras del pasoExistente" y este esta al final
        // (ej: 10 elemento y te dice que lo metas en el 15) puede dar error, por eso si el indice
        // en el que deberiamos meter el paso es mayor al tamaño de la coleccion lo añadimos al final directamente, sin indice
        if (indiceDelPaso + 1 >= pasos.size()) {
            pasos.add(pasoNuevo);
        }

        pasos.add(indiceDelPaso + 1, pasoNuevo);
    }


    @Override
    public String toString() {
        return "Receta{" +
                "nombreReceta='" + nombreReceta + '\'' +
                ", tiempoPreparacion=" + tiempoPreparacion +
                ", ingredientes=" + ingredientes +
                '}';
    }
}
