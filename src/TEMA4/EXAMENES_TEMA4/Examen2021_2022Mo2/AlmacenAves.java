package TEMA4.EXAMENES_TEMA4.Examen2021_2022Mo2;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class AlmacenAves {
    private static final int ESPACIO_MAX_AVES = 50;

    private int numeroDeTomas;
    private Aves[] avesAlmacenadas;

    public AlmacenAves(int numeroDeTomas) {
        this.numeroDeTomas = numeroDeTomas;
        avesAlmacenadas = new Aves[ESPACIO_MAX_AVES];
    }

    Aves ave = null;

    //Metodo que devuelve el total  de aves almacenadas
    private int totalAvesAlmacenadas() {
        int contadorAAvesEncontradas = 0;
        for (int i = 0; i < avesAlmacenadas.length; i++) {

            if (avesAlmacenadas[i] != null) {
                contadorAAvesEncontradas++;
            } else {
                return contadorAAvesEncontradas;
            }
        }
        return contadorAAvesEncontradas;
    }

    //METODO PARA INTRODUCIR AVE
    public void introducirAve(Aves aveAMeter) {

        avesAlmacenadas[totalAvesAlmacenadas()] = aveAMeter;
    }

    //METODO PARA VER LOS DATOS DEL AVE SITUADA EN EL LUGAR INDICADO
    public void verAveEnCompartimento(int posicionAve) throws AvesException {

        if (avesAlmacenadas[posicionAve] != null) {
            avesAlmacenadas[posicionAve].toString();
        } else {
            throw new AvesException("Ave no encontrada");
        }
    }

    public String buscarAvePorCodigoIdentificativo(String codigoIdentificativo) throws AvesException {

        //Antes de nada, compruebo que el codigo de identificacion tenga el formato correcto
        //Antes me he creado un objeto tipo Ave para poder acceder al metodo de comprobar validez
        if (!ave.codigoDeIdentificacionValido(codigoIdentificativo)) {
            throw new AvesException("Codigo indicado no valido");
        }
        //Recorro el total de aves almacenadas, y les saco el codigo de identificacion,
        //Si coincide con el introducido por parametro llamo al metodo toString de ese ave para mostrar sus datos
        for (int i = 0; i < totalAvesAlmacenadas(); i++) {
            if (avesAlmacenadas[i].getCodigoIdentificacion().equals(codigoIdentificativo)) {
                return avesAlmacenadas[i].toString();
            }
        }
        throw new AvesException("Ave con codigo indicado no encontrada");
    }

    public double calcularGramosPienso(String codigoIdentificativo) throws AvesException {

        if (!ave.codigoDeIdentificacionValido(codigoIdentificativo)) {
            throw new AvesException("Codigo indicado no valido");
        }
        //Recorro el total de aves almacenadas, y les saco el codigo de identificacion,
        //Si coincide con el introducido por parametro llamo al metodo toString de ese ave para mostrar sus datos
        for (int i = 0; i < totalAvesAlmacenadas(); i++) {
            if (avesAlmacenadas[i].getCodigoIdentificacion().equals(codigoIdentificativo)) {
                //Comparo los dias que han pasado desde que entro el ave, hasta ahora
                LocalDate fechaEntrada = avesAlmacenadas[i].getFechaEntradaALaSala();
                LocalDate fechaActual = LocalDate.now();

                int diasEstanciaAve = fechaEntrada.compareTo(fechaActual);
                                                                          //long diasEstancia = ChronoUnit.DAYS.between(ave.getFechaEntradaALaSala(), LocalDate.now());
                //Dias * la cantidad que toma en un dia es lo que se debe pagar
                double cantidadAPagar = diasEstanciaAve * avesAlmacenadas[i].getCantidadAlimento();
                return cantidadAPagar;
            }
        }
        throw new AvesException("Ave no encontrada");
    }
}
