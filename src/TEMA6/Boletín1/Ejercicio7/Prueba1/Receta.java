package TEMA6.Boletín1.Ejercicio7.Prueba1;

import TEMA6.Boletín1.Ejercicio7.RecetaException;

import java.util.*;

public class Receta implements Comparable<Receta>{

    private String nombreReceta;
    private int tiempoDePreparacion;
    private Set<Ingrediente> ingredientesDeLaReceta;
    private List<String> pasos;

    public Receta(String nombreReceta, int tiempoDePreparacion) {
        this.nombreReceta = nombreReceta;
        this.tiempoDePreparacion = tiempoDePreparacion;
        this.ingredientesDeLaReceta = new HashSet<>();
        this.pasos = new LinkedList<>();
    }

    public String getNombreReceta() {
        return nombreReceta;
    }

    public void setNombreReceta(String nombreReceta) {
        this.nombreReceta = nombreReceta;
    }

    public int getTiempoDePreparacion() {
        return tiempoDePreparacion;
    }

    public boolean necesitaIngrediente(String nombreIngrediente) {

        //Creamos el ingrediente, la cantidad da igual, porque solo vamos a comprobar si contiene el nombre
        Ingrediente ingredienteABuscar = new Ingrediente(nombreIngrediente, 0);

        //Devolvemos si contiene el ingrediente o no
        return ingredientesDeLaReceta.contains(ingredienteABuscar);
    }

    public void annadirIngrediente(Ingrediente ingredienteNuevo) {

        //Si el ingrediente no estaba lo añado
        if (!ingredientesDeLaReceta.contains(ingredienteNuevo)) {
            ingredientesDeLaReceta.add(ingredienteNuevo);
            return;
        }

        //Si esta, recorro los ingredientes
        for (Ingrediente ingrediente : ingredientesDeLaReceta) {
            //Y donde es igual que el ingredienteNuevo
            if (ingrediente.equals(ingredienteNuevo)) {
                //Le sumo a la cantidad del ingrediente la cantidad del ingredienteNuevo
                ingrediente.setCantidad(ingrediente.getCantidad() + ingredienteNuevo.getCantidad());
            }
        }
    }

    public void borrarIngrediente(Ingrediente ingredienteABorrar) throws RecetaException {

        //Sino esta lanzamos excepcion
        if (!ingredientesDeLaReceta.contains(ingredienteABorrar)) {
            throw new RecetaException("El ingrediente no existe");
        }
        //Si esta lo borramos
        ingredientesDeLaReceta.remove(ingredienteABorrar);

        //Ahora debemos borrar los pasos en los que aparezca el nombre del ingredienteABorrar
        //Para ello usaremos un Iterator

        Iterator<String> iteratorPasos = pasos.iterator();

        //Mientras haya pasos miramos si el paso actual contiene el nombre del ingredienteABorrar
        while (iteratorPasos.hasNext()) {
            String paso = iteratorPasos.next();
            //Si lo tiene borramos el Iterator de ese paso
            if (paso.contains(ingredienteABorrar.getNombreIngrediente())) {
                iteratorPasos.remove();
            }
        }
    }

    public void annadirPasoDetrasDe(String pasoNuevo, String pasoExistente) throws RecetaException {

        //Creamos el iterator de los pasos para poder recorrerlo mejor
        Iterator<String> iteratorPasos = pasos.iterator();

        //Contador de los pasos, para saber en el indice vamos a meter el pasoNuevo
        int contadorDePasos = 0;

        //Mientras el tenga mas pasos...
        while (iteratorPasos.hasNext()) {
            String pasoActual = iteratorPasos.next();
            //Si el paso actual es el mismo que el pasoExistente...
            if (pasoActual.equalsIgnoreCase(pasoExistente)) {
                //Añadimos a la lista de pasos el pasoNuevo, su posicion sera una mas al contador de pasos
                pasos.add(contadorDePasos + 1, pasoNuevo);
                return;
            }
            contadorDePasos++;
        }
    }


    @Override
    public String toString() {
        return "Receta: \n" +
                "nombre de la receta='" + nombreReceta + '\'' +
                ", tiempo De Preparacion=" + tiempoDePreparacion +
                ", ingredientes De L aReceta {" + ingredientesDeLaReceta +
                "} , pasos {" + pasos +
                '}';
    }

    @Override
    public int compareTo(Receta o) {
        return Integer.compare(tiempoDePreparacion, o.tiempoDePreparacion);
    }
}
