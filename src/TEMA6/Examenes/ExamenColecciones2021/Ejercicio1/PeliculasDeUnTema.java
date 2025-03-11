package TEMA6.Examenes.ExamenColecciones2021.Ejercicio1;

import java.time.LocalDate;
import java.util.*;

public class PeliculasDeUnTema {

    private String tema;
    private LinkedList<Pelicula> listaPeliculasDeUnTema;

    public PeliculasDeUnTema(String tema) {
        this.tema = tema;
        listaPeliculasDeUnTema = new LinkedList<Pelicula>();
    }

    public String getTema() {
        return tema;
    }

    public LinkedList<Pelicula> getListaPeliculasDeUnTema() {
        return listaPeliculasDeUnTema;
    }

    public void addPelicula(Pelicula peliculaAAnadir) throws NetPleaseException {

        if (peliculaAAnadir.getAnnoEstreno() > LocalDate.now().getYear()) {
            throw new NetPleaseException("El año de la pelicula no puede ser mayor al actual");
        }
        if (listaPeliculasDeUnTema.contains(peliculaAAnadir)) {
            throw new NetPleaseException("La película ya está en la lista, no puede haber repetidas");
        }
        listaPeliculasDeUnTema.add(peliculaAAnadir);
    }

    public void borrarLasPeliculasDeUnAnno(int anno) throws NetPleaseException {

        if (listaPeliculasDeUnTema.isEmpty()) {
            throw new NetPleaseException("No hay peliculas");
        }

        //Creamos un booleanos para saber si hemos encontrado peliculas con ese año
        boolean hayPeliculasDelAnnoRequerido = false;

        //Creamos un iterator para en caso de encontrar peliculas con ese año borrar si  problemas
        Iterator<Pelicula> peliculaIterator = listaPeliculasDeUnTema.iterator();

        //Recorremos el listado de peliculas
        while (peliculaIterator.hasNext()) {
            Pelicula pelicula = peliculaIterator.next();
            //Sacamos el año de la pelicula, y si es el mismo que el del año del parametro eliminamos ese iterator
            if (pelicula.getAnnoEstreno() == anno) {
                peliculaIterator.remove();
                hayPeliculasDelAnnoRequerido = true; //marcamos que hemos encontrado peliculas con ese año
            }
        }
        //Si no hemos encontrado peliculas con el año requerido lanzamos excepcion
        if (!hayPeliculasDelAnnoRequerido) {
            throw new NetPleaseException("No hay peliculas de ese año");
        }
    }

    public void annadirOpinionAPelicula(String tituloPelicula, Opinion opinion) throws NetPleaseException {

        if (listaPeliculasDeUnTema.isEmpty()) {
            throw new NetPleaseException("No hay peliculas");
        }

        //Booleano para saber si hemos encotrado la pelicula
        boolean peliculaEncontrada = false;

        //Recorremos las peliculas y si coinciden con el nombre de la pelicula del parametro
        //Le añadimos una opinion y marcamos el booleano con verdadero
        for (Pelicula pelicula : listaPeliculasDeUnTema) {
            if (pelicula.getTitulo().equalsIgnoreCase(tituloPelicula)) {
                pelicula.annadirOpinion(opinion);
                peliculaEncontrada = true;
            }
        }
        //Si no hemos encotrado peliculas con ese titulo lanzamos excepcion
        if (!peliculaEncontrada) {
            throw new NetPleaseException("Pelicula no encontrada");
        }
    }

    public List<Pelicula> listadoDePeliculasOrdenadasPorMediaDeOpiniones() {

        //Creo la lista en la que voy a ordenar las peliculas para no modificar el orden normal
        List<Pelicula> listadoDePeliculasOrdenadas = new ArrayList<>(listaPeliculasDeUnTema);

        //Ordeno las peliculas por el metodo mediaDeOpiniones() de mayor a menor puntuacion
        listadoDePeliculasOrdenadas.sort(Comparator.comparing(Pelicula::mediaDeOpiniones).reversed());

        //Para buscar las peliculas sin valoraciones ecorro la lista de peliculas original
        for (Pelicula pelicula : listaPeliculasDeUnTema) {
            //Si no tiene valoraciones, añado la pelicula a la lista ya ordenada (se añadira automaticamente al final)
            if (pelicula.mediaDeOpiniones() == -1) {
                listadoDePeliculasOrdenadas.add(pelicula);
            }
        }
        return listadoDePeliculasOrdenadas;
    }


    public List<Pelicula> listaPeliculasDondeIntervieneUnActor(String actor) throws NetPleaseException {

        //Lista de peleliculas donde interviene el actor
        List<Pelicula> listaPeliculasDondeIntervieneElActor = new ArrayList<>();

        //Recorro las pelicula, y metemos las peliculas donde el actor haya participado en la lista creada
        for (Pelicula pelicula : listaPeliculasDeUnTema) {
            if (pelicula.intervieneActor(actor)) {
                listaPeliculasDondeIntervieneElActor.add(pelicula);
            }
        }
        //Si la lista de peliculas donde interviene el actor estaa vacia lanzamos una excepcion
        if (listaPeliculasDondeIntervieneElActor.isEmpty()) {
            throw new NetPleaseException("El acot no interviene en ninguna pelicula");
        }
        return listaPeliculasDondeIntervieneElActor;
    }

    public Pelicula buscarPeliculaPorTitulo(String titulo) {

        return null;
    }

    public boolean borrar(String titulo) {
        Iterator<Pelicula> iterator = listaPeliculasDeUnTema.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().getTitulo().equalsIgnoreCase(titulo)) {
                iterator.remove();
                return true;
            }
        }
        return false;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((tema == null) ? 0 : tema.hashCode());
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
        PeliculasDeUnTema other = (PeliculasDeUnTema) obj;
        if (tema == null) {
            if (other.tema != null)
                return false;
        } else if (!tema.equals(other.tema))
            return false;
        return true;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Tema " + tema + "\n");
        for (Pelicula pelicula : listaPeliculasDeUnTema) {
            sb.append(pelicula + "\n");
        }
        return sb.toString();
    }
}