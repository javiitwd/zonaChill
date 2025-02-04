package TEMA5.boletín_extra.ejercicio2;

public class Lampara implements Funcionable{
    @Override
    public void encender() {
        System.out.println("La lampara está encendida");
    }

    @Override
    public void apagar() {
        System.out.println("La lampara está apaga");
    }
}
