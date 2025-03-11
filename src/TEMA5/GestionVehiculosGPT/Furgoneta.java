package TEMA5.GestionVehiculosGPT;

public class Furgoneta extends Vehiculo implements Cargable, Mantenible {

    public static final int KM_PARA_MANTENIMIENTO = 15000;
    private static final Tmercancia tmercancia = Tmercancia.AMBAS;

    private String etiqueta;
    private double volumenMaximo;

    public Furgoneta(String matricula, double kmDesdeLaUltimaRevision, boolean mantenimiento, String etiqueta, double volumen) {
        super(matricula, kmDesdeLaUltimaRevision, mantenimiento);
        this.etiqueta = etiqueta;
        this.volumenMaximo = volumen;
    }

    //Metodo que recorre las mercancias y devuelve la suma del peso de estas
    private double volumenActualesDeCarga() {
        double volumen = 0;

        //PARA ACCEDER AL MALETERO, QUE SOLO LO TIENE LA CLASE PADRE USE SUPER.GETMALETERO()
        for (Mercancia mercancia : super.getMaletero()) {

            volumen += mercancia.getTamano();
        }
        return volumen;
    }

    @Override
    public void cargar(Mercancia mercancia) throws AlmacenVehiculosException {

        //Si el peso de la mercancia sumado al que teniamos antes en el maletero no supera el limite de peso la añadimos
        if (volumenActualesDeCarga() + mercancia.getPesoEnKg() < volumenMaximo) {

            super.annadirMercancia(mercancia);
        } else {
            throw new AlmacenVehiculosException("No caben más mercancías");
        }
    }

    @Override
    public void mantener() throws AlmacenVehiculosException {
        
        setKmDesdeLaUltimaRevision(0);
        super.setMantenimiento(true);
    }
}
