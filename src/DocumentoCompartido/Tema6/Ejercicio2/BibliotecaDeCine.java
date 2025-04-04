package DocumentoCompartido.Tema6.Ejercicio2;

import java.time.LocalDate;
import java.time.Period;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class BibliotecaDeCine {

    Set<Categoria> categoriasCine;

    public BibliotecaDeCine() {
        categoriasCine = new HashSet<>();
    }

    public Set<Categoria> getCategoriasCine() {
        return categoriasCine;
    }

    public void addCategoria(Categoria categoriaAAnnadir) throws FraseCineException {

        if (categoriasCine.contains(categoriaAAnnadir)) {
            throw new FraseCineException("La categoría ya existe");
        }
        categoriasCine.add(categoriaAAnnadir);
    }

    public void addFrase(List<Categoria> categoriasAAnnadirFrase, Frase fraseAAnnadir) throws FraseCineException {

        for (Categoria categoria : categoriasAAnnadirFrase) {

            if (!categoriasCine.contains(categoria)) {
                throw new FraseCineException("Una de las categorías no existe");
            }

            //como es un Set, podemos usar .add() directamente, no hace falta comprobar que no esté con el .contains()
            categoria.getFrasesDeLaCategoria().add(fraseAAnnadir);
        }
    }

    public Set<Categoria> annadirCategoriasConFrasesSinValoracion() {

        return categoriasCine.stream()
                //si encontramos alguna frase en la categoria que estamos mirando,
                // la filtramos (añadimos) a la coleccion
                .filter(categoria -> categoria.getFrasesDeLaCategoria().stream()
                        .anyMatch(frase -> frase.getValoracion() == 0))
                .collect(Collectors.toSet());
    }

    public Set<Categoria> categoriasDeFrase(Frase fraseABuscar) {

        return categoriasCine.stream()
                .filter(categoria -> categoria.getFrasesDeLaCategoria().contains(fraseABuscar))
                .collect(Collectors.toSet());

    }

    public List<Frase> getTodasLasFrasesOrdenadasPorValoracion() {

        return categoriasCine.stream()
                .flatMap(categoria -> categoria.getFrasesDeLaCategoria().stream())
                .distinct()
                .sorted(Comparator.comparing(Frase::getValoracion).reversed())
                .toList();
    }

    public void eliminaFrase(Frase fraseAEliminar) {

        for (Categoria categoria : categoriasCine) {

            categoria.getFrasesDeLaCategoria().remove(fraseAEliminar);
        }
    }

    public Set<Frase> frasesUltimoAnno() {

        return categoriasCine.stream()
                .flatMap(categoria -> categoria.getFrasesDeLaCategoria().stream())
                .filter(frase -> Period.between(frase.getFechaEnLaQueSeAnnadio(), LocalDate.now()).getDays() < 365)
                .collect(Collectors.toSet());
    }
}
