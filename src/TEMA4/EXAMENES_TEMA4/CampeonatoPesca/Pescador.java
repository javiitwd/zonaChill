package TEMA4.EXAMENES_TEMA4.CampeonatoPesca;

import java.util.Arrays;

public class Pescador {

    private String nombre;
    private int edad;
    private int experiencia;
    private double[] capturasTotales;

    public Pescador(String nombre, int edad, int experiencia) {
        this.nombre = nombre;
        this.edad = edad;
        this.experiencia = experiencia;
        capturasTotales = new double[5];
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getExperiencia() {
        return experiencia;
    }

    public void setExperiencia(int experiencia) {
        this.experiencia = experiencia;
    }

    public double[] getCapturasTotales() {
        return capturasTotales;
    }

    public void setCapturasTotales(double[] capturasTotales) {
        this.capturasTotales = capturasTotales;
    }

    private int mirarCapturasTotales() {
        int capturasEncontradas = 0;
        for (int i = 0; i < capturasTotales.length; i++) {

            if (capturasTotales[i] != 0) {
                capturasEncontradas++;
            } else {
                return capturasEncontradas;
            }
        }
        return capturasEncontradas;
    }

    public void anadirCaptura(double peso) throws CampeonatoPescaException {

        if (mirarCapturasTotales() >= capturasTotales.length) {
            throw new CampeonatoPescaException("No puede tener mas capturas");
        }
        capturasTotales[mirarCapturasTotales()] = peso;
    }

    public double capturaMaximaDelPescador(){
        double maximaCaptura = 0;

        //Recorro cada captura del pescador y devulevo la mas pesada
        for (int i = 0; i <capturasTotales.length; i++) {

            if (capturasTotales[i] > maximaCaptura){
                maximaCaptura = capturasTotales[i];
            }
        }
        return maximaCaptura;
    }

    //Metodo que devuelve la captura con mayor peso del pesacdor
    public double pesoTotalCapturasPescador() {

        double sumaPeso = 0;
        //Recorro todas las capturas del pescador y añado el peso de estas a una variable
        for (int i = 0; i < capturasTotales.length; i++) {

            //Me aseguro de que hay una captura
            if (capturasTotales[i] != 0) {
                sumaPeso += capturasTotales[i];
            }
        }
        return sumaPeso;
    }

    @Override
    public String toString() {
        return "Pescador: " +
                "nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", experiencia=" + experiencia;
    }
}
