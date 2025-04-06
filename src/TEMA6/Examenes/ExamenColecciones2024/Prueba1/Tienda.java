package TEMA6.Examenes.ExamenColecciones2024.Prueba1;

import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.stream.Collectors;

public class Tienda {

    //para evitar crear la clase Categoria, creamos un Map, que tiene como clave el nombre de la cateogria
    //y como valor el conjunto de productos de esa categoria;
    private Map<String, Set<Producto>> categoriasDeProductos;

    public Tienda() {
        this.categoriasDeProductos = new HashMap<>();
    }

    public void addCategoria(String nombreCategoria) throws TiendaProductosException {

        if (categoriasDeProductos.containsKey(nombreCategoria)) {
            throw new TiendaProductosException("La categoría ya existe");
        }

        categoriasDeProductos.put(nombreCategoria, new HashSet<>());
    }

    public void addProducto(List<String> listaCategorias, Producto productoAAnnadir) throws TiendaProductosException {

        for (String categoria : listaCategorias) {

            //si la categoria no existe lanzamos excepcion
            if (!categoriasDeProductos.containsKey(categoria)) {
                throw new TiendaProductosException("Una de las categorias no existen");
            }

            //como el valor de las categoriasDeProducto es un Set<Producto> y no admite duplicados,
            //añadimos directamente el producto a la categoria actual
            categoriasDeProductos.get(categoria).add(productoAAnnadir);
        }
    }

    public Set<String> categoriasConProductosSinStock() {

        return categoriasDeProductos.entrySet().stream()
                .filter(entry -> entry.getValue().stream()
                        .anyMatch(p -> p.getStock() == 0))
                .map(Map.Entry::getKey)
                .collect(Collectors.toSet());
    }

    public Set<String> categoriasDeProducto(Producto producto) {

        return categoriasDeProductos.entrySet().stream()
                .filter(entry -> entry.getValue().contains(producto))
                .map(Map.Entry::getKey)
                .collect(Collectors.toSet());
    }

    public List<Producto> getTodosLosProductosOrdenadosPorPrecio() {

        return categoriasDeProductos.values().stream()
                .flatMap(p -> p.stream())
                .sorted(Comparator.comparing(Producto::getPrecio).reversed())
                .distinct()
                .toList();
    }

    public void eliminaProducto(Producto productoAEliminar) {

        for (Map.Entry<String, Set<Producto>> entry : categoriasDeProductos.entrySet()) {

            entry.getValue().remove(productoAEliminar);
        }
    }

    public Set<Producto> productosUltimoAnno() {

        /*return categoriasDeProductos.entrySet().stream()
                .flatMap(entry -> entry.getValue().stream())
                .filter(producto -> Math.abs(ChronoUnit.DAYS.between(producto.getFechaIncorporacion(), LocalDate.now())) < 365)
                .collect(Collectors.toSet());*/

        return categoriasDeProductos.values().stream()
                .flatMap(productos -> productos.stream())
                .filter(producto -> Math.abs(ChronoUnit.DAYS.between(producto.getFechaIncorporacion(), LocalDate.now())) < 365)
                .collect(Collectors.toSet());
    }
}
