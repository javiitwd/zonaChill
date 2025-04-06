package DocumentoCompartido.Tema6.Ejercicio3;

import java.util.HashSet;
import java.util.Set;

public class RedEstacionesMeteorologicas {

    public static final int MAX_METROS_COMPATIBLES = 50;

    private Set<EstacionMeteorologica> restacionesMeteorologicas;

    public RedEstacionesMeteorologicas() {
        restacionesMeteorologicas = new HashSet<>();
    }

    public void transferirSensorAOtraEstacion(EstacionMeteorologica estacionConSensor, EstacionMeteorologica estacionAInstalarSensor, Sensor sensor) throws RedEstacionesMeteorologicasException {

        //calculamos la distancia en altitud y lo ponemos en valor absoluto con el Math.abs()
        int distancia = Math.abs(estacionConSensor.getAltitudMetros() - estacionAInstalarSensor.getAltitudMetros());

        if (distancia > MAX_METROS_COMPATIBLES) {
            throw new RedEstacionesMeteorologicasException("La distancia supera la permitida");
        }

        if ((!estacionConSensor.getSensoresInstalados().contains(sensor)) || estacionAInstalarSensor.getSensoresInstalados().contains(sensor)) {
            throw new RedEstacionesMeteorologicasException("La estacion de origen no contiene el sensor o el de destino ya lo tiene");
        }

        estacionAInstalarSensor.instalarNuevoSensor(sensor);
        estacionConSensor.sensorAEliminar(sensor);
    }
}
