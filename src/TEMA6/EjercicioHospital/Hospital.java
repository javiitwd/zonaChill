package TEMA6.EjercicioHospital;

import java.util.*;

public class Hospital {

    private List<Paciente> pacientesHospital;

    public Hospital() {
        pacientesHospital = new LinkedList<>();
    }

    public void nuevoPaciente(Paciente paciente) {

        pacientesHospital.add(paciente);
        Collections.sort(pacientesHospital);
    }

    public String listadosDePacientesEnOrdenDeAtencion() {
        StringBuilder listaDeLosPacientes = new StringBuilder();

        for (Paciente paciente : pacientesHospital) {
            listaDeLosPacientes.append(paciente.toString());
        }
        return listaDeLosPacientes.toString();
    }

    public String atenderCliente() {

        //Guardamos el cliente que vamos a eliminar
        Paciente pacienteAEliminar = pacientesHospital.getFirst();
        //Lo eliminamos
        pacientesHospital.removeFirst();
        //Mostramos los datos del cliente
        return pacienteAEliminar.toString();
    }

    public String datosEstadisticos() throws HospitalException {
        if (pacientesHospital.isEmpty()) {
            throw new HospitalException("No hay pacientes");
        }
        int pacientesConPrioridad1 = 0;
        int pacientesConPrioridad2 = 0;
        int pacientesConPrioridad3 = 0;
        int pacientesConPrioridad4 = 0;
        int pacientesConPrioridad5 = 0;

        for (Paciente paciente : pacientesHospital) {

            if (paciente.getPrioridad() == 1) {
                pacientesConPrioridad1++;
            } else if (paciente.getPrioridad() == 2) {
                pacientesConPrioridad2++;
            } else if (paciente.getPrioridad() == 3) {
                pacientesConPrioridad3++;
            } else if (paciente.getPrioridad() == 4) {
                pacientesConPrioridad4++;
            } else if (paciente.getPrioridad() == 5) {
                pacientesConPrioridad5++;
            }
        }

        return "Prioridad 1: " + pacientesConPrioridad1 +
                " Prioridad 2: " + pacientesConPrioridad2 +
                " Prioridad 3: " + pacientesConPrioridad3 +
                " Prioridad 4: " + pacientesConPrioridad4 +
                " Prioridad 5: " + pacientesConPrioridad5;
    }

    public String pacientesAAtenderOrdenadosPorEdad() {

        StringBuilder listaDePacientes = new StringBuilder();

        //Cremos otra linkedList para que no se modifique la original al ordenar por edad
        List<Paciente> pacientesOrdenadosPorEdad = new LinkedList<>(pacientesHospital);

        //Ordenamos la por la edad de los pacientes, metemos el .reversed() para que se ordene de mas edad a menos
        //Ya que por defecto se ordena de menor edad a mayor
        pacientesOrdenadosPorEdad.sort(Comparator.comparing(Paciente::getEdad).reversed());

        for (Paciente paciente : pacientesOrdenadosPorEdad) {
            listaDePacientes.append(paciente.toString());
        }
        return listaDePacientes.toString();
    }
}
