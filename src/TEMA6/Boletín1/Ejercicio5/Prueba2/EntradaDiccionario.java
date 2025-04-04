package TEMA6.Boletín1.Ejercicio5.Prueba2;

import java.util.*;

public class EntradaDiccionario {

    //Atributos
    private String palabra;
    private ArrayList<String> significados;

    //Constructor
    public EntradaDiccionario(String palabraInicial, String significado) {

        this.palabra = palabraInicial;
        this.significados = new ArrayList<String>();
        this.annadirSignificado(significado);
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

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((palabra == null) ? 0 : palabra.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        EntradaDiccionario other = (EntradaDiccionario) obj;
        if (palabra == null) {
            if (other.palabra != null)
                return false;
        } else if (!palabra.equals(other.palabra))
            return false;
        return true;
    }

    @Override
    public String toString() {
        StringBuilder cadena = new StringBuilder();


        for (String definicion : significados) {
            cadena.append(definicion + "\n");
        }

        return palabra + " con significados: " + cadena.toString();
    }


    public void annadirSignificado(String significado) {

        significados.add(significado);
    }

}
