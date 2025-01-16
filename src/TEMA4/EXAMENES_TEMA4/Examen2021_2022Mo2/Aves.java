package TEMA4.EXAMENES_TEMA4.Examen2021_2022Mo2;

import java.time.LocalDate;

public class Aves {
    private static final int PESO_ALIMENTO_MINIMO = 180;
    private static final int PESO_ALIMENTO_MAXIMO = 450;
    private static final int MAX_LETRAS_PAIS_PROCEDENCIA = 20;
    private static final int LONGUITUD_CODIGO_IDENTIFICACION = 7;
    private static final LocalDate FECHA_MINIMA = LocalDate.of(2020, 3, 30);
    private String nombre;
    private String codigoIdentificacion;
    private double cantidadAlimento;
    private String origen;
    private LocalDate fechaEntradaALaSala;

    public Aves(String nombre, String codigoIdentificacion, double cantidadAlimento, String origen) throws AvesException {
        setNombre(nombre);
        setCodigoIdentificacion(codigoIdentificacion);
        setCantidadAlimento(cantidadAlimento);
        setOrigen(origen);
        this.fechaEntradaALaSala = LocalDate.now();
    }

    //Metodo para verificar que el codigo de un ave es valido
    public boolean codigoDeIdentificacionValido(String codigoIdentificacion) throws AvesException {

         /*
           La palabra "butano" tiene los siguientes índices: 0 1 2 3 4 5 correspondientes a los caracteres 'b' 'u' 't' 'a' 'n' 'o'.
           Cuando llamamos a palabra.substring(0, 4), la subcadena empieza desde el índice 0 (inclusive), es decir, desde 'b',
           y termina en el índice 4 (exclusivo), por lo que la subcadena será "buta".
         */

        if (codigoIdentificacion.length() == LONGUITUD_CODIGO_IDENTIFICACION) {
            //Guardamos la parte de las letras en mayusculas
            StringBuilder letras = new StringBuilder(codigoIdentificacion.substring(0, 4).toUpperCase());
            //Guardamos la parte de los numeros
            StringBuilder numeros = new StringBuilder(codigoIdentificacion.substring(4, 7));

            //StringBuilder en el que meteremos las vocales si esta vacio
            StringBuilder vocalesEncontradas = new StringBuilder();

            //Comprobar letras
            for (int i = 0; i < letras.length(); i++) {
                char c = letras.charAt(i);
                if (!Character.isLetter(c)) {
                    return false;
                } else {
                    if (c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U') {
                        if (vocalesEncontradas.isEmpty()) {
                            vocalesEncontradas.append(c);
                        } else {
                            return false;
                        }
                    }
                }
            }
            //Comprobar numeros
            for (int i = 0; i < numeros.length(); i++) {
                char c = numeros.charAt(i);
                if (!Character.isDigit(c)) {
                    return false;
                }
            }
        }
        //Si pasa todas las condiciones, el codigo es valido
        return true;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) throws AvesException {
        if (nombre == null) {
            throw new AvesException("El nombre no puede estar vacio");
        }
        this.nombre = nombre;
    }

    public String getCodigoIdentificacion() {
        return codigoIdentificacion;
    }

    public void setCodigoIdentificacion(String codigoIdentificacion) throws AvesException {

        if (!codigoDeIdentificacionValido(codigoIdentificacion)){
            throw new AvesException("Codigo no valido");
        }
        this.codigoIdentificacion = codigoIdentificacion;
    }

    public double getCantidadAlimento() {
        return cantidadAlimento;
    }

    public void setCantidadAlimento(double cantidadAlimento) throws AvesException {

        if (cantidadAlimento < PESO_ALIMENTO_MINIMO || cantidadAlimento > PESO_ALIMENTO_MAXIMO) {
            throw new AvesException("Peso incorrecto");
        }
        this.cantidadAlimento = cantidadAlimento;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) throws AvesException {

        if (origen.length() > MAX_LETRAS_PAIS_PROCEDENCIA) {
            throw new AvesException("Nombre de origen demasiado extenso");
        }
        this.origen = origen;
    }

    public LocalDate getFechaEntradaALaSala() {
        return fechaEntradaALaSala;
    }

    public void setFechaEntradaALaSala(LocalDate fechaEntradaALaSala) throws AvesException {
        if (!fechaEntradaALaSala.isAfter(FECHA_MINIMA)) {

            throw new AvesException("Fecha no valida");
        }
        this.fechaEntradaALaSala = fechaEntradaALaSala;
    }

    /**
     *
     * @return Del metodo toString, devuelve los datos del ave
     */
    @Override
    public String toString() {
        return "Datos del ave: " +
                "Nombre: " + getNombre() +
                ", Codigo Identificación: " + getCodigoIdentificacion() +
                ", Cantidad de Alimento: " + getCantidadAlimento() +
                ", Origen: " + getOrigen() +
                ", Fecha de entrada: " + getFechaEntradaALaSala();
    }
}
