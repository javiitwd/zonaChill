package TEMA6.Boletín1.Ejercicio5ConMap.Prueba1;

import java.util.ArrayList;

public class Palabra {
    //Atributos
    private String  palabra;
    private ArrayList<String> significados;

    //Al crear un palabra, necesitamos saber su nombre y significado
    public Palabra(String palabra, String significado1) {
        this.palabra = palabra;
        significados = new ArrayList<>();
        significados.add(significado1);
    }

    public String getPalabra() {
        return palabra;
    }

    public void setPalabra(String palabra) {
        this.palabra = palabra;
    }

    public ArrayList<String> getSignificados() {
        return significados;
    }

    public void setSignificados(ArrayList<String> significados) {
        this.significados = significados;
    }

    public void annadirSignificado(String significado){
        significados.add(significado);
    }

    @Override
    public String toString() {
        return "Palabra: '" + palabra + '\'' +
                ", tiene los significados: " + significados +
                '.';
    }
}
