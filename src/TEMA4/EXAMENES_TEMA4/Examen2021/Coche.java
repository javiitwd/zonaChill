package TEMA4.EXAMENES_TEMA4.Examen2021;

import java.time.LocalDate;

public class Coche {
    private String nombrePropietario;
    private String matriculaVehiculo;
    private double numeroKilometros;
    private String marca;
    private LocalDate fechaAparcamiento;

    public Coche(String nombrePropietario, String matriculaVehiculo, double numeroKilometros, String marca) throws ParkingException {

        if (nombrePropietario == null) {
            throw new ParkingException("El nombre del propietario no puede estar vacío");
        }
        this.nombrePropietario = nombrePropietario;
        if (!matriculaValida(matriculaVehiculo)) {
            throw new ParkingException("El formato de la matrícula no es válido");
        }
        this.matriculaVehiculo = matriculaVehiculo;
        if (numeroKilometros < 10 || numeroKilometros > 350000){
            throw new ParkingException("El numero de kilometros no es correcto");
        }
        this.numeroKilometros = numeroKilometros;
        if (marca.length() > 15 || marca.isEmpty()){
            throw new ParkingException("La marca no es válida");
        }
        this.marca = marca;
        this.fechaAparcamiento = LocalDate.now();
    }

    public String getNombrePropietario() {
        return nombrePropietario;
    }

    public String getMatriculaVehiculo() {
        return matriculaVehiculo;
    }

    public double getNumeroKilometros() {
        return numeroKilometros;
    }

    public String getMarca() {
        return marca;
    }

    public LocalDate getFechaAparcamiento() {
        return fechaAparcamiento;
    }

    public static boolean matriculaValida(String matriculaVehiculoSinConvertir) {
        //Convertimos todo a mayúsculas
        String matriculaVehiculo = matriculaVehiculoSinConvertir.toUpperCase();

        //Comprobar que tiene 4 numeros al principio
        for (int i = 0; i < 4; i++) {
            char c = matriculaVehiculo.charAt(i);

            if (!Character.isDigit(c)) {
                return false;
            }
        }
        //Comprobar que despues de los numeros hay 3 letras
        for (int i = 4; i < matriculaVehiculo.length(); i++) {
            char c = matriculaVehiculo.charAt(i);

            if (!Character.isLetter(c)) {
                return false;
            } else {
                //Si es una vocal, returnamos que no es valida
                if (c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U'){
                    return false;
                }
            }
        }
        //Si pasa todos los requisitos, es valida
        return true;
    }
}
