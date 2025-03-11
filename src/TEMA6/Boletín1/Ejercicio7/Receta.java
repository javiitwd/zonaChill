package TEMA6.Boletín1.Ejercicio7;

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

    /*
    Recuerda que en un Hashet puedes aprovechar la busqueda rapida y no necesitas hacer un for
    Pero si usas la busqueda rapida debes implementar bien el metodo equals y hashCode en la clase ingrediente */
    public boolean necesitaIngrediente(String nombreIngrediente) {

        //Como vamos a usar el equals comparando solo por nombre ponemos cantidad 0, ya que no nos importa
        //No podemos comparar directamente con el nombre del parametro ya que el equals mira si son de la misma clase
        Ingrediente ingredienteABuscar = new Ingrediente(nombreIngrediente, 0);

        //Ya con todo preparado llamamos al metodo contains, que usa el equals y hashcode que hemos redefinido
        return ingredientes.contains(ingredienteABuscar);
    }

    public void annadirIngrediente(Ingrediente ingredienteNuevo) {

        //Debo usar un for si o si al parecer, y donde coincidan en nombre (equals redefinido)
        //Añado a la cantidad de ese ingrediente la cantidad del que recibimos por parametro
        for (Ingrediente i : ingredientes) {
            if (i.equals(ingredienteNuevo)) {
                i.setCantidad(i.getCantidad() + ingredienteNuevo.getCantidad());
                return; //!!!Si lo encuentra y ya he añadido la cantidad, finalizo con un return
            }
        }
        //Sino estaba lo añado
        ingredientes.add(ingredienteNuevo);
    }

    public void borrarIngrediente(Ingrediente ingredienteABorrar) throws RecetaException {
        boolean eliminado = false;

        //Creamos un Iterator porque queremos eliminar un elemento de la lista mientras lo recorremos
        Iterator<Ingrediente> iterator = ingredientes.iterator();
        while (iterator.hasNext()) {
            Ingrediente i = iterator.next();
            if (i.equals(ingredienteABorrar)) {
                iterator.remove();
                eliminado = true;
            }
        }

        Iterator<String> iterator1 = pasos.iterator();
        while (iterator1.hasNext()) {
            String paso = iterator1.next();

             /*la lista de pasos tiene varios pasos, por  ejemplo: batir huevos, echar harina, mezclar: ahi irian 3 pasos,
             ahora para borrarlo lo que estamos haciendo es, todos los pasos que contenga la palabra "harina" por ejemplo borrarlos */
            if (paso.contains(ingredienteABorrar.getNombre())) {
                iterator1.remove(); //Lo correcto es usar el iterator.remove() en lugar de pasos.remove(paso).
                eliminado = true;
            }
        }
        if (!eliminado) {
            throw new RecetaException("Ingrediente no encontrado");
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
