package TEMA6.EjercicioHospital;

public class Principal {
    public static void main(String[] args) {

        try {
            Hospital hospital = new Hospital();
            Paciente paciente = new Paciente("qdefsv", "Carlos", 34, 1);
            Paciente paciente2 = new Paciente("qdefsv", "Pepe", 23, 2);
            Paciente paciente3 = new Paciente("qdefsv", "Juan", 80, 1);

            System.out.println("Metemos los pacientes: ");
            hospital.nuevoPaciente(paciente);
            hospital.nuevoPaciente(paciente2);
            hospital.nuevoPaciente(paciente3);

            System.out.println("Listado de pacientes ordenados por orden de atencion: ");
            System.out.println(hospital.listadosDePacientesEnOrdenDeAtencion());

            System.out.println("Atender cliente: ");
            System.out.println(hospital.atenderCliente());

            System.out.println("Datos estadisticos: ");
            System.out.println(hospital.datosEstadisticos());

            System.out.println("Clientes ordenados por edad: ");
            System.out.println(hospital.pacientesAAtenderOrdenadosPorEdad());
        } catch (HospitalException e){
            System.out.println(e.getMessage());
        }

    }
}
