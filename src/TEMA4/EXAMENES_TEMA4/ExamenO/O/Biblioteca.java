package TEMA4.EXAMENES_TEMA4.ExamenO.O;

import java.util.Arrays;

public class Biblioteca {
    public static final int CAPACIDAD_MAX_PELICULAS = 20;
    public Pelicula[] biblioteca;

    public Biblioteca() {
        this.biblioteca = new Pelicula[20];
    }

    public Pelicula[] getBiblioteca() {
        return biblioteca;
    }

    public void setBiblioteca(Pelicula[] biblioteca) {
        this.biblioteca = biblioteca;
    }

    //Busca cuantas peliculas hay en la biblioteca
    public int peliculasEnBiblioteca() {
        int peliculas = 0;
        for (int i = 0; i < biblioteca.length; i++) {
            if (biblioteca[i] != null) {
                peliculas++;
            } else {
                return peliculas;
            }
        }
        return peliculas;
    }

    //AÑADIR NUEVA PELICULA
    public void addNuevaPelicula(Pelicula pelicula) throws BibliotecaException {

        //Si la hay 20 o mas peliculas tiramos excepcion
        if (peliculasEnBiblioteca() >= CAPACIDAD_MAX_PELICULAS) {
            throw new BibliotecaException("La biblioteca está llena");
        }
        //Sino, en la siguiente posicion al total de pelis que hay meto la nueva aceptada por parametro
        biblioteca[peliculasEnBiblioteca()] = pelicula;
    }

    //Recorremos todas las peliculas que hay en la biblioteca y mostramos sus datos
    public void consultarBiblioteca() {

        for (int i = 0; i < peliculasEnBiblioteca(); i++) {

            System.out.println("El título es: " + biblioteca[i].getTitulo());
            System.out.println("El año de estreno es: " + biblioteca[i].getYearEstreno());
            System.out.println("El directo es: " + biblioteca[i].getDirector());
            System.out.println("El presupuesto es: " + biblioteca[i].getPresupuesto());
            System.out.println("La recaudacion es: " + biblioteca[i].getRecaudacion());
            System.out.println("El sinopsis es: " + biblioteca[i].getSiponsis());
            System.out.println("La etiquetas son: " + biblioteca[i].getEtiquetas());
            System.out.println("La valoracion es: " + biblioteca[i].getValoracion());
        }
    }

    //Recorro las peliculas de la biblioteca, y si les saco el nombre,
    //Si coinciden con el aceptado por parametro returno sus posicion en la biblietca para despues usar los get
    public int buscarPeliculaPorTitulo(String tituloPeliculaABuscar) throws BibliotecaException {

        for (int i = 0; i < peliculasEnBiblioteca(); i++) {

            if (biblioteca[i].getTitulo().equals(tituloPeliculaABuscar)) {
                return i;
            }
        }
        throw new BibliotecaException("La película no se encuentra en la biblioteca");
    }

    public void buscarPeliculaConMaxPresupuesto(double presupesuto) throws BibliotecaException {

        boolean peliEncontrada = false;
        for (int i = 0; i < peliculasEnBiblioteca(); i++) {

            if (biblioteca[i].getPresupuesto() < presupesuto){
                System.out.println(biblioteca[i].toString());
                peliEncontrada = true;
            }
        }
        if (!peliEncontrada){
            throw new BibliotecaException("Peli no encontrada");
        }
    }
}
