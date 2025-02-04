package TEMA5.boletín_extra.ejercicio2;

public class Main {
    public static void main(String[] args) {

        Funcionable tv = new Televisor();
        Funcionable lampara = new Lampara();

        tv.encender();
        tv.apagar();

        lampara.encender();
        lampara.apagar();
    }
}
