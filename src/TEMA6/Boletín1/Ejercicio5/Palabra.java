package TEMA6.Boletín1.Ejercicio5;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Palabra implements Comparable<Palabra> {

    private String palabra;
    private Set<String> significado;

    //Para que al menos tenga 1 significado, que es el que tiene al crear la palabra
    //Lo metemos en la linea siguiente de la Coleccion de significados
    public Palabra(String palabra, String significado) {
        this.palabra = palabra;
        this.significado = new HashSet<>();
        this.significado.add(significado);
    }

    public String getPalabra() {
        return palabra;
    }

    public void setPalabra(String palabra) {
        this.palabra = palabra;
    }

    public Set<String> getSignificado() {
        return significado;
    }

    public void setSignificado(Set<String> significado) {
        this.significado = significado;
    }

    @Override
    public String toString() {
        return "Palabra: " +
                "palabra='" + palabra + '\'' +
                ", significado=" + significado;
    }

    @Override
    public int compareTo(Palabra o) {
        return this.getPalabra().compareTo(o.getPalabra());
    }

    /**
     * redefinimos el equals para que le haga bien la comparacion
     * ya que si lo dejamos en normal compararia la palabra entera,
     * es decir con su nombre(que es lo que queremos comparar)
     * y su significado(que no lo queremos comparar)
     * por eso redefinimos y nos aseguramos de que solo estamos comparando el nombre de la palabra
     *
     * @param o es la palabra que recibimos por parametro
     * @return
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Palabra palabra1 = (Palabra) o;
        return Objects.equals(palabra, palabra1.palabra);
    }

    @Override
    public int hashCode() {
        return Objects.hash(palabra);
    }
}
