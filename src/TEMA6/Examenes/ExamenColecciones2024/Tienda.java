package TEMA6.Examenes.ExamenColecciones2024;

import java.time.LocalDate;
import java.time.Period;
import java.util.*;
import java.util.stream.Collectors;

public class Tienda {
    private String nombre;
    private Set<Categoria> categorias;

    public Tienda(String nombre) {
        this.nombre = nombre;
        this.categorias = new HashSet<>();
    }

    public String getNombre() {
        return nombre;
    }

    /**
     * Añade una nueva categoría. En caso de que exista, lanza una excepción
     *
     * @param nombre es el nombre de la nueva categoria
     * @throws TiendaException
     */
    public void addCategoria(String nombre) throws TiendaException {

        Categoria categoriaAAnnadir = new Categoria(nombre);

        if (categorias.contains(categoriaAAnnadir)) {
            throw new TiendaException("La categoría ya existe");
        }

        categorias.add(categoriaAAnnadir);
    }

    /**
     * Añade un producto a una lista de categorías. Se añadirá a aquellas categorías en las que todavía no exista. En
     * aquellas donde ya exista, no se hará nada.
     *
     * @param p
     * @param categorias
     */
    public void addProducto(Producto p, List<Categoria> categorias) throws TiendaException {

        Set<Categoria> categoriasAAnnadirElProducto;

        categoriasAAnnadirElProducto = categorias.stream()
                .filter(categoria -> this.categorias.contains(categoria))
                .filter(categoria -> !(categoria.getProductos().contains(p)))
                .collect(Collectors.toSet());

        if (categoriasAAnnadirElProducto.isEmpty()) {
            throw new TiendaException("No se puede añadir el producto");
        }

        for (Categoria categoria : this.categorias) {

            if (categoriasAAnnadirElProducto.contains(categoria)) {
                categoria.getProductos().add(p);
            }
        }
    }

    /**
     * Devuelve un conjunto con aquellas categorías que contienen algún producto sin stock
     *
     * @return
     */
    //parecido al flatMap() pero sin "aplanar" a atributos menores
    public Set<Categoria> categoriasConProductosSinStock() {

        return categorias.stream()  // Crea un flujo de categorías
                .filter(categoria -> categoria.getProductos().stream()  // Para cada categoría, crea un flujo de productos
                        .anyMatch(producto -> producto.getStock() == 0))  // Verifica si al menos un producto tiene stock 0
                .collect(Collectors.toSet());  // Recoge las categorías que cumplen la condición en un Set (sin duplicados)
    }

    /**
     * Devuelve un conjunto con las categorías a las que pertenece un producto determinado
     *
     * @param p
     * @return
     */
    public Set<Categoria> categoriasDeProducto(Producto p) {

        return categorias.stream()
                .filter(categoria -> categoria.getProductos().contains(p))
                .collect(Collectors.toSet());
    }

    /**
     * Devuelve un listado con todos los productos de la tienda (sin repetir) ordenados por precio de mayor a menor
     *
     * @return
     */
    public List<Producto> getTodosLosProductosOrdenadosPorPrecio() {

        return categorias.stream()
                .flatMap(categoria -> categoria.getProductos().stream())
                .sorted(Comparator.comparing(Producto::getPrecio).reversed())
                .toList();
    }

    /**
     * Elimina un producto de todas las categorías donde aparezca.
     *
     * @param p
     * @return true si el producto aparecía en alguna categoría
     */
    public boolean eliminaProducto(Producto p) {

        boolean productoEncontrado = false;
        for (Categoria categoria : categorias) {
            if (categoria.getProductos().remove(p)) {
                productoEncontrado = true;
            }
        }
        return productoEncontrado;
    }

    /**
     * Devuelve un conjunto con aquellos productos que han sido añadido en el último año (a partir de la fecha actual)
     *
     * @return
     */
    public Set<Producto> productosUltimoAnno() {

        return categorias.stream()
                .flatMap(categoria -> categoria.getProductos().stream())
                .filter(producto -> (Period.between(producto.getFechaIncorporacion(), LocalDate.now())).getDays() < 365)
                .collect(Collectors.toSet());
    }
}
