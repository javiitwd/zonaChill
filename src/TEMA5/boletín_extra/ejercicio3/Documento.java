package TEMA5.boletín_extra.ejercicio3;

public class Documento implements Enviable, Imprimible {
    @Override
    public void enviar() {
        System.out.println("Enviando el documento...");
    }

    @Override
    public void imprimir() {
        System.out.println("Imprimiendo el documento...");
    }
}
