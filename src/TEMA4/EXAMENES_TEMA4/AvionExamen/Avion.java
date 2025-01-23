package TEMA4.EXAMENES_TEMA4.AvionExamen;

import java.time.LocalDate;
import java.time.Period;

public class Avion {

    public static final int REVISIONES_MAXIMAS = 4;
    public static final double CONSUMO_POR_KILOMETROS = 2;
    private String marca;
    private String modelo;
    private Deposito depositoDeCombustible;
    private Revision[] registroDeRevisiones;

    public Avion(String marca, String modelo, Deposito depositoDeCombustible) {
        this.marca = marca;
        this.modelo = modelo;
        this.registroDeRevisiones = new Revision[REVISIONES_MAXIMAS];
        this.depositoDeCombustible = depositoDeCombustible;
    }

    public int revisionesTotales(){
        int contadorDeRevisiones = 0;
        for (int i = 0; i < registroDeRevisiones.length; i++) {

            if (registroDeRevisiones[i] != null){
                contadorDeRevisiones++;
            }
        }
        return contadorDeRevisiones;
    }

    public void anadirRevision(Revision revision){

        registroDeRevisiones[revisionesTotales()] = revision;
    }

    private int ultimaRevision() {
        LocalDate ultimaRevision = registroDeRevisiones[0].getFecha();
        int lugarRevisionMasReciente = 0;
        for (int i = 1; i < registroDeRevisiones.length; i++) {

            //Si la fecha i es mas actual que la actual mas reciente la sustituye
            if (registroDeRevisiones[i] != null) {
                if (registroDeRevisiones[i].getFecha().isAfter(ultimaRevision)) {
                    ultimaRevision = registroDeRevisiones[i].getFecha();
                    lugarRevisionMasReciente = i;
                }
            }
        }
        return lugarRevisionMasReciente;
    }

    public boolean comprobarSiAvionPuedeRealizarRecorido(double distancia) throws AvionException {

        if (!registroDeRevisiones[ultimaRevision()].isEstado()) {
            return false;
        }
        LocalDate fechaActual = LocalDate.now();

        //Guardo los dias transcurridos entre la ffecha de la ultima revision y la actual
        int diasTranscurridos = Period.between(registroDeRevisiones[ultimaRevision()].getFecha(), fechaActual).getDays();

        //Si los dias que han pasado son mayores que los del plazo, es decir, el plazo ha pasado devuelvo falso
        if (diasTranscurridos > registroDeRevisiones[ultimaRevision()].getPeriodoDeValidez().getDays()){
            return false;
        }

        double cantidadAGastar = distancia * CONSUMO_POR_KILOMETROS;
        if (depositoDeCombustible.getCapacidadActual() < cantidadAGastar) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Avion{" +
                "marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", depositoDeCombustible actual=" + depositoDeCombustible.getCapacidadActual() +
                ", registroDeRevisiones=" + registroDeRevisiones[ultimaRevision()].getPeriodoDeValidez() +
                '}';
    }
}
