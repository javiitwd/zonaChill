package TEMA5.BOLETÍN1.Ejercicio2;

public class empresaVehiculos {
    public static final int MAX_VEHICULOS = 200;
    protected Vehiculo[] almacenDeVehiculos;

    public empresaVehiculos() {
        almacenDeVehiculos = new Vehiculo[200];
    }

    public int totalDeVehiculosActuales(){
        int vehiculosEncontrados = 0;
        for (int i = 0; i < almacenDeVehiculos.length; i++) {

            if (almacenDeVehiculos[i] != null){
                vehiculosEncontrados++;
            } else {
                return vehiculosEncontrados;
            }
        }
        return vehiculosEncontrados;
    }

    public double calcularPrecioAlquiler(String matricula, int diasAquilado) throws VehiculosException {

        for (int i = 0; i < totalDeVehiculosActuales(); i++) {
            String matriculaDelCocheActual = almacenDeVehiculos[i].getMatricula();
            if (matricula.equals(matriculaDelCocheActual)){

                return almacenDeVehiculos[i].calcularPrecioDeAlquiler(diasAquilado);
            }
        }
        throw new VehiculosException("No se ha encontrado un coche con dicha matricula");
    }
}
