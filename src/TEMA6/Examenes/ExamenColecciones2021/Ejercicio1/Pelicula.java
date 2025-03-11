package TEMA6.Examenes.ExamenColecciones2021.Ejercicio1;

import java.util.ArrayList;
import java.util.HashSet;

public class Pelicula {
    private String titulo;
    private int annoEstreno;
    private ArrayList<Opinion> opiniones;
    private HashSet<String> actores;

    public Pelicula(String titulo, int annoEstreno) {
        super();
        this.titulo = titulo;
        this.annoEstreno = annoEstreno;
        actores = new HashSet<String>();
        opiniones = new ArrayList<Opinion>();
    }

    public void annadirOpinion(Opinion opinion) {
        opiniones.add(opinion);
    }

    public void annadirActor(String actor) {
        actores.add(actor);
    }

    //Metodo para saber la media de opiniones de un pelicula
    public double mediaDeOpiniones() {
        //Si no tiene opiniones, devolvemos -1
        if (opiniones.isEmpty()) {
            return -1;
        }
        //Suma de todas las opiniones
        int sumaDeOpiniones = 0;

        //Recorro la lista de opiniones y les voy sumando sus valoraciones
        for (Opinion opinion : opiniones) {
            sumaDeOpiniones += opinion.getValoracion();
        }
        //Calculamos y devolvemos la media de las opiniones
        return (double) sumaDeOpiniones / opiniones.size();
    }

    //Metodo para buscar si un actor ha participado en esta pelicula,
    //recibe el nombre del actor y devuelve true o false si lo encuentra en la lista de actores
    public boolean intervieneActor(String actor) {

        for (String actorActual : actores) {
            if (actorActual.equalsIgnoreCase(actor)) {
                return true;
            }
        }
        return false;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getAnnoEstreno() {
        return annoEstreno;
    }

    public void setAnnoEstreno(int annoEstreno) {
        this.annoEstreno = annoEstreno;
    }

    @Override
    public String toString() {
        return "Pelicula [titulo=" + titulo + ", annoEstreno=" + annoEstreno + "]" + " Media de opiniones " + mediaDeOpiniones();
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((titulo == null) ? 0 : titulo.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Pelicula other = (Pelicula) obj;
        if (titulo == null) {
            if (other.titulo != null)
                return false;
        } else if (!titulo.equals(other.titulo))
            return false;
        return true;
    }
}
