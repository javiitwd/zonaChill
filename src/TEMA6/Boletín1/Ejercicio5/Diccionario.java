package TEMA6.Boletín1.Ejercicio5;

import java.util.HashSet;
import java.util.Set;

public class Diccionario {

    private Set<Palabra> diccionario;

    public Diccionario() {
        this.diccionario = new HashSet<>();
    }

    public Set<Palabra> getDiccionario() {
        return diccionario;
    }

    public void setDiccionario(Set<Palabra> diccionario) {
        this.diccionario = diccionario;
    }

    public void anadirPalabra(String palabra, String significado) {

        for (Palabra p : diccionario) {
            if (p.getPalabra().equalsIgnoreCase(palabra)) {
                p.getSignificado().add(significado);
            }
        }
        diccionario.add(new Palabra(palabra, significado));
    }

    public void buscarPalabraEnElDiccionario(String palabra) throws DiccionarioException {

        for (Palabra m : diccionario) {
            if (m.getPalabra().equalsIgnoreCase(palabra)) {
                System.out.println(m.getSignificado());
                return;
            }
        }
        throw new DiccionarioException("No se ha encontrado");
    }

    public void borrarPalabra(String palabra) throws DiccionarioException {

        for (Palabra p : diccionario) {
            if (p.getPalabra().equalsIgnoreCase(palabra)) {
                diccionario.remove(p);
                return;
            }
        }
        throw new DiccionarioException("No se ha encontrado");
    }

    public Set<Palabra> listadoDePalabrasQueEmpiecenConLetra(String cadena) {

        Set<Palabra> listaDePalabras = new HashSet<>();

        for (Palabra p : diccionario) {
            if (p.getPalabra().startsWith(cadena)) {
                listaDePalabras.add(p);
            }
        }
        return listaDePalabras;
    }

    @Override
    public String toString() {
        return "Diccionario: " + diccionario;
    }


}
