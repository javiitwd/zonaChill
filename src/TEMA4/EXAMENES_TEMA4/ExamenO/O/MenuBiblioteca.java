package TEMA4.EXAMENES_TEMA4.ExamenO.O;

import java.util.Scanner;

public class MenuBiblioteca {
    public static void main(String[] args) throws BibliotecaException {
        Scanner sc = new Scanner(System.in);

        Biblioteca biblioteca = new Biblioteca();
        boolean salir = false;
        while (!salir) {

            System.out.println("Seleccione una opcion");
            System.out.println("1.- Añadir una nueva pelicula");
            System.out.println("2.- Mostrar biblioteca");
            System.out.println("3.- Buscar película por título");
            System.out.println("4.- Buscar película con presupuesto máximo");
            System.out.println("5.- Mostrar peliculas que contengan etiquetas");
            System.out.println("6.- Salir");
            int opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("Ponga los siguientes datos: ");
                    System.out.println("Título de la película");
                    String tituloPelicula = sc.nextLine();  // Lee el título
                    sc.nextLine();
                    System.out.println("Año de estreno");
                    int yearEstreno = sc.nextInt();
                    sc.nextLine();  // Limpiar el buffer después de nextInt()
                    System.out.println("El director");
                    String director = sc.nextLine();
                    System.out.println("Presupuesto");
                    double presupuesto = sc.nextDouble();
                    sc.nextLine();  // Limpiar el buffer después de nextDouble()
                    System.out.println("Recaudación");
                    double recaudacion = sc.nextDouble();
                    sc.nextLine();  // Limpiar el buffer después de nextDouble()
                    System.out.println("Sinopsis");
                    String sinopsis = sc.nextLine();  // Lee la sinopsis
                    System.out.println("Etiquetas");
                    String etiquetas = sc.nextLine();  // Lee las etiquetas

                    // Crear la película y agregarla a la biblioteca
                    Pelicula pelicula = new Pelicula(tituloPelicula, yearEstreno, director, presupuesto, recaudacion, sinopsis, etiquetas);
                    biblioteca.addNuevaPelicula(pelicula);
                    break;

                case 2:
                    biblioteca.consultarBiblioteca();
                    break;
                case 3:
                    System.out.println("Ponga el título exacto: ");
                    String tituloPeliculaABuscar = sc.nextLine();
                    sc.nextLine();
                    int posicionDeLabiblioteca = biblioteca.buscarPeliculaPorTitulo(tituloPeliculaABuscar);

                    System.out.println("El título es: " + biblioteca.biblioteca[posicionDeLabiblioteca].getTitulo());
                    System.out.println("El año de estreno es: " + biblioteca.biblioteca[posicionDeLabiblioteca].getYearEstreno());
                    System.out.println("El directo es: " + biblioteca.biblioteca[posicionDeLabiblioteca].getDirector());
                    System.out.println("El presupuesto es: " + biblioteca.biblioteca[posicionDeLabiblioteca].getPresupuesto());
                    System.out.println("La recaudacion es: " + biblioteca.biblioteca[posicionDeLabiblioteca].getRecaudacion());
                    System.out.println("El sinopsis es: " + biblioteca.biblioteca[posicionDeLabiblioteca].getSiponsis());
                    System.out.println("La etiquetas son: " + biblioteca.biblioteca[posicionDeLabiblioteca].getEtiquetas());
                    System.out.println("La valoracion es: " + biblioteca.biblioteca[posicionDeLabiblioteca].getValoracion());
                    break;
                case 4:
                    System.out.println("Pon el presupuesto");
                    double presupuestoMax = sc.nextDouble();
                    biblioteca.buscarPeliculaConMaxPresupuesto(presupuestoMax);
                    break;

                case 5:
                    System.out.println("Ponga la etiqueta");
                case 6:
                    salir = true;
            }
        }
    }
}
