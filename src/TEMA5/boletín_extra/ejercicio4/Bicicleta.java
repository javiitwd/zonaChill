package TEMA5.boletín_extra.ejercicio4;

public class Bicicleta implements Movible{
    @Override
    public void acelerar() {
        System.out.println("Bicicleta acelerando");
    }

    @Override
    public void frenar() {
        System.out.println("Bicicleta frenando");
    }
}
