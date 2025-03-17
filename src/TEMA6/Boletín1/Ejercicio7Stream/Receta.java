package TEMA6.Boletín1.Ejercicio7Stream;

import javax.swing.text.html.HTMLDocument;
import java.util.*;

public class Receta {

    private String nombre;
    private double tiempoDePreparacion;
    Set<Ingrediente> ingredientes;
    List<String> pasos;

    public Receta(String nombre, double tiempoDePreparacion) {
        this.nombre = nombre;
        this.tiempoDePreparacion = tiempoDePreparacion;
        ingredientes = new HashSet<>();
        pasos = new LinkedList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getTiempoDePreparacion() {
        return tiempoDePreparacion;
    }

    public void setTiempoDePreparacion(double tiempoDePreparacion) {
        this.tiempoDePreparacion = tiempoDePreparacion;
    }

    public Set<Ingrediente> getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(Set<Ingrediente> ingredientes) {
        this.ingredientes = ingredientes;
    }

    public List<String> getPasos() {
        return pasos;
    }

    public void setPasos(List<String> pasos) {
        this.pasos = pasos;
    }


    public boolean necesitaIngrediente(String nombreIngrediente) {

        //Comprobamos con anyMatch() que la receta necesita el ingrediente,
        //sacando el nombre de los ingredientes y comparandolos con el del parametro
        return ingredientes.stream()
                .anyMatch(i -> i.getNombre().equals(nombreIngrediente));
    }

    public void annadirIngrediente(Ingrediente ingredienteNuevo) throws RecetaException {

        //Guardamos si esta o no el ingreidnete, filtrandolo
        boolean estaIngrediente = ingredientes.stream()
                .anyMatch(i -> i.equals(ingredienteNuevo));

        if (estaIngrediente) {
            Ingrediente ingrediente = ingredientes.stream()
                    .filter(i -> i.equals(ingredienteNuevo))
                    .findFirst() //este metodo es un Optional por lo que debe tener un orElse()
                    .orElseThrow(() -> new RecetaException("Ha ocurrido un error"));

            ingrediente.setCantidad(ingrediente.getCantidad() + ingredienteNuevo.getCantidad());
        } else {

            ingredientes.add(ingredienteNuevo);
        }
    }

    public void borrarIngrediente(Ingrediente ingredienteABorrar) throws RecetaException {

        //Guardamos el ingrediente que queremos borrar o lanzamos excepcion si no lo encontramos
        Ingrediente ingrediente = ingredientes.stream()
                .filter(i -> i.equals(ingredienteABorrar))
                .findFirst().orElseThrow(() -> new RecetaException("No se ha encontrado ingrediente"));

        ingredientes.remove(ingrediente);

        //Creamos una lista de String con los pasos a borrar (pasos que contienen el nombre del ingredienteABorrar)
        List<String> pasosABorrar;

        pasosABorrar = pasos.stream()
                .filter(p -> p.contains(ingredienteABorrar.getNombre()))
                .toList(); //convertimos a lista

        //Creamos un Iterator de pasos para borrar mejor los pasos
        Iterator<String> iterator = pasos.iterator();

        //Recorremos el Iterator de pasos y miramos si la lista de pasosABorrar contiene el paso actual lo contiene
        while (iterator.hasNext()) {
            if (pasosABorrar.contains(iterator.next())) {
                iterator.remove();
            }
        }
    }

    public void annadirPasoDetrasDeOtro(String pasoNuevo, String pasoExistente) throws RecetaException {
        // Creamos un Iterator para recorrer la lista de pasos
        Iterator<String> iteratorPasos = pasos.iterator();
        int index = 0; // Inicializamos el índice, ya que necesitamos saber en qué posición vamos a meter el pasoNuevo
        boolean encontrado = false;

        // Recorremos la lista de pasos
        while (iteratorPasos.hasNext()) {
            String paso = iteratorPasos.next();
            // Si encontramos el paso existente...
            if (paso.equals(pasoExistente)) {
                // Añadimos el paso nuevo en la siguiente posición
                pasos.add(index + 1, pasoNuevo);
                encontrado = true; // Marcamos que hemos encontrado el paso para controlar las excepciones
                break; // Salimos del bucle después de añadir el nuevo paso
            }
            // El índice aumenta con cada iteración del while, no con el if
            // Así nos aseguramos de saber en qué posición vamos a meter el pasoNuevo (una más que la encontrada)
            index++;
        }
        // Si no encontramos el paso, lanzamos una excepción
        if (!encontrado) {
            throw new RecetaException("El paso existente no se encuentra en la receta");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Receta receta = (Receta) o;
        return Objects.equals(nombre, receta.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(nombre);
    }

    @Override
    public String toString() {
        return "Receta{" +
                "pasos=" + pasos +
                ", ingredientes=" + ingredientes +
                ", tiempoDePreparacion=" + tiempoDePreparacion +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}
