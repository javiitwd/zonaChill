package TEMA4.BOLETÍN4;

public class Ejercicio5 {

    public static void main(String[] args) {
        String texto = "El lenguaje Java es un lenguaje de alto nivel";
        String textoBuscar = "lenguaje";
        String textoReemplazar = "lenguaje de programación";

        // Llamamos al metodo replace
        String reemplazado = texto.replace(textoBuscar, textoReemplazar);

        System.out.printf("Texto reemplazado es; %s ", reemplazado);
    }
}