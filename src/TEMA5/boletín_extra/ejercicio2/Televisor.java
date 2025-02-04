package TEMA5.boletín_extra.ejercicio2;

public class Televisor implements Funcionable{
    @Override
    public void encender() {
        System.out.println("La TV está encendida");
    }

    @Override
    public void apagar() {
        System.out.println("La TV está apagada");
    }
}
