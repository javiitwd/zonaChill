package TEMA4.EXAMENES_TEMA4.GPT_Examen;

public class Conductor {
    private String nombreCompleto;
    private String dni;
    private Vehiculo vehiculo;

    public Conductor(String nombreCompleto, String dni, Vehiculo vehiculo) {
        this.nombreCompleto = nombreCompleto;
        this.dni = dni;
        this.vehiculo = vehiculo;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    public void asignarVehiculo(Vehiculo vehiculoAAsignar){

        setVehiculo(vehiculoAAsignar);
    }

    public StringBuilder getDetalles(){
        StringBuilder detalles = new StringBuilder();

        String nombretxt = "Nombre: ";
        String dnitxt = "DNI: ";
        String vehiculotxt = "Vehiculo: : ";
        return detalles.append(nombretxt).append(nombreCompleto).append(System.lineSeparator()).append(dnitxt).append(dni).append(System.lineSeparator()).append(vehiculotxt).append(vehiculo.getDetalles());
    }
}
