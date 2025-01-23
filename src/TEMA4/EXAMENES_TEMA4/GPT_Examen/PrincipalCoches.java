package TEMA4.EXAMENES_TEMA4.GPT_Examen;

public class PrincipalCoches {
    public static void main(String[] args) {
        // Crear un vehículo
        Vehiculo coche = new Vehiculo("Seat", "Ibiza", 2020);

        // Mostrar información del vehículo
        System.out.println(coche.getDetalles());

        // Actualizar el kilometraje
        coche.actualizarKilometraje(5000);
        coche.actualizarKilometraje(2500);

        // Mostrar kilometraje actual
        System.out.println("Kilometraje actual: " + coche.getKilometraje() + " km");

        // Crear un conductor
        Conductor conductor = new Conductor("Juan Perez", "12345678A", coche);

        // Asignar el vehículo al conductor
        conductor.asignarVehiculo(coche);

        // Mostrar información del conductor y su vehículo
        System.out.println(conductor.getDetalles());
    }
}
