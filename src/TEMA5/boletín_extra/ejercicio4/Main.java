package TEMA5.boletín_extra.ejercicio4;

public class Main {
    public static void main(String[] args) {

        Descargable vehiculoDescargable = new Autobus();
        Movible vehiculoMovible = new Bicicleta();

        probarMovilidad(vehiculoMovible);
        probarCargaYDescagaPasajeros(vehiculoDescargable);
    }

    private static void probarMovilidad(Movible vehiculo) {

        vehiculo.acelerar();
        vehiculo.frenar();
    }

    private static void probarCargaYDescagaPasajeros(Descargable vehiculo) {

        vehiculo.acelerar();
        vehiculo.frenar();
        vehiculo.descargar();
    }
}
