package TEMA6.Examenes.ExamenColecciones2021.Ejercicio1;

import java.util.HashMap;

public class NetPlease {
    //Hashmap donde por cada tema, podemos acceder a las películas de ese tema
    private HashMap<String, PeliculasDeUnTema> mapPeliculas;


    public NetPlease() {
        mapPeliculas = new HashMap<String, PeliculasDeUnTema>();

    }

    public void annadirTema(String tema) throws NetPleaseException {

        tema = tema.toUpperCase();
        if (mapPeliculas.containsKey(tema)) {
            throw new NetPleaseException("Ya existe ese tema");
        }

        mapPeliculas.put(tema, new PeliculasDeUnTema(tema));
    }

    public void addPelicula(String tema, Pelicula pelicula) throws NetPleaseException {
        PeliculasDeUnTema listaPeliculasDeUnTema = mapPeliculas.get(tema);

        if (listaPeliculasDeUnTema == null) {
            throw new NetPleaseException("No existe el tema " + tema);
        }
        listaPeliculasDeUnTema.addPelicula(pelicula);
    }

    public void listadoDeTodasPeliculasDeTodosLosTemas() {

        for (PeliculasDeUnTema listaPelisTema : mapPeliculas.values()) {
            System.out.println(listaPelisTema);
        }
    }

    public void borrarPeliculaDeUnTema(String tema, String titulo) throws NetPleaseException {

        // Recorro los temas (claves) del mapPeliculas
        for (String temaPelicula : mapPeliculas.keySet()) {
            // Si la película actual contiene el tema de la película que estamos buscando (recibida por parámetro)
            if (temaPelicula.equalsIgnoreCase(tema)) {
                // Cogemos los valores de la clave donde lo hemos encontrado y borramos la película
                // que tenga el título que hemos recibido por parámetro
                if (!mapPeliculas.get(temaPelicula).borrar(titulo)) {
                    throw new NetPleaseException("Pelicula no encontrada"); //Si la película no está, lanzamos excepción
                }
                //Si esta (no devuelve false), se borra en la linea de arriba y finalizamos el metodo con un return
                return;
            }
        }
    }


    public String temaDePelicula(String titulo) throws NetPleaseException {

        //Recorro todos los temas (lo llamaremos x)
        for (PeliculasDeUnTema peliculaDeUnTema : mapPeliculas.values()) {
            //y de cada tema voy mirando las peliculas que hay (lo llamaremos y)
            for (Pelicula pelicula : peliculaDeUnTema.getListaPeliculasDeUnTema()) {
                //Si alguna pelicula tiene el titulo que hemos recibido por parametro devolvemos su tema (x)
                if (pelicula.getTitulo().equalsIgnoreCase(titulo)) {
                    return peliculaDeUnTema.getTema();
                }
            }
        }
        throw new NetPleaseException("Pelicula no encontrada");
    }
}
