/*
Se desea desarrollar una aplicación para gestionar una biblioteca digital que almacena diferentes tipos de documentos.
Todos los documentos tienen un título, un autor y un identificador único. Existen dos tipos principales de documentos:
libros y artículos científicos.

Los libros tienen un número de páginas y una editorial.
Los artículos científicos tienen un número de citas y la revista en la que fueron publicados.

Adicionalmente, algunos documentos pueden ser descargables, mientras que otros solo pueden leerse en línea.
Un documento descargable permite obtener su tamaño en MB y la cantidad de descargas realizadas.
Un documento en línea permite conocer su URL y el número de veces que ha sido visualizado.

Se debe implementar una funcionalidad que permita listar todos los documentos de la biblioteca,
mostrando su información relevante. También se debe permitir obtener una lista de los documentos más populares,
considerando el número de descargas en el caso de los descargables y el número de visualizaciones en el caso de los documentos en línea.

El programa debe incluir un menú con las siguientes opciones:

Agregar un nuevo documento (permitiendo especificar si es un libro o un artículo, y si es descargable o solo en línea).
Mostrar la lista de documentos almacenados.
Consultar los documentos más populares.
Salir.
Se trabajará con un máximo de 100 documentos en la biblioteca.
*/

package TEMA5.BibliotecaGPT;

import Comun.MiEntradaSalida;

import java.util.Scanner;

public class BibliotecaPrincipal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Biblioteca biblioteca = new Biblioteca();

        boolean salir = false;
        while (!salir) {

            System.out.println("Seleccione una opción: ");
            System.out.println("1. Agregar Documento");
            System.out.println("2. Agregar Mostrar documentos almacenados");
            System.out.println("3. Consultar docuemntos más populares");

            int op = sc.nextInt();

            switch (op) {

                case 1:
                    Documento doc = null;
                    Libro libro = null;

                    System.out.println("Dime los datos: ");
                    String titulo = MiEntradaSalida.solicitarCadena("Pon el titulo: ");
                    String autor = MiEntradaSalida.solicitarCadena("Pon el autor: ");
                    int id = MiEntradaSalida.solicitarEntero("Id: ");

                    System.out.println("Seleccione el tipo de documento: ");
                    System.out.println("1. Libro");
                    System.out.println("2. Articulo cientifico");

                    int tipoDocumento = MiEntradaSalida.solicitarEnteroEnRango("Seleccione el tipo de documento:", 1, 2);

                    if (tipoDocumento == 1) {
                        System.out.println("Ponga los datos del libro: ");
                        int numPaginas = MiEntradaSalida.solicitarEnteroEnRango("Páginas", 0, 500);
                        String editorial = MiEntradaSalida.solicitarCadena("Editorial: ");

                        System.out.println("Elija la funcionalidad de este");
                        System.out.println("1. Descargable");
                        System.out.println("2. Leible");

                        int funcionalidad = MiEntradaSalida.solicitarEnteroEnRango("Funcionalidad: ", 1, 2);

                        if (funcionalidad == 1) {
                            System.out.println("Pon los datos: ");
                            String url = MiEntradaSalida.solicitarCadena("url");

                            Documento documento = new LibroLeible(titulo, autor, id, numPaginas, editorial, url);

                            biblioteca.anadirDocumento(documento);
                        } else {
                            System.out.println("Pon los datos: ");
                            int mb = MiEntradaSalida.solicitarEntero("MB: ");

                            Documento documento = new LibroDescargable(titulo, autor, id, numPaginas, editorial, mb);

                            biblioteca.anadirDocumento(documento);
                        }
                    }
                    break;
            }
        }
    }
}
