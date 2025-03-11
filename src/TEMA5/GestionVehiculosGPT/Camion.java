package TEMA5.GestionVehiculosGPT;



public class Camion extends Vehiculo {

    public static final int KM_PARA_MANTENIMIENTO = 10000;
    public static final Tmercancia tmercancia = Tmercancia.AMBAS;

    private double capacidadMaxima;

    public Camion(String matricula, double kmDesdeLaUltimaRevision, boolean mantenimiento) {
        super(matricula, kmDesdeLaUltimaRevision, mantenimiento);
    }

    //Metodo que recorre las mercancias y devuelve la suma del peso de estas
    private double kgActualesDeCarga() {
        double kg = 0;

        //PARA ACCEDER AL MALETERO, QUE SOLO LO TIENE LA CLASE PADRE USE SUPER.GETMALETERO()
        for (Mercancia mercancia : super.getMaletero()) {

            kg += mercancia.getPesoEnKg();
        }
        return kg;
    }

    @Override
    public void cargar(Mercancia mercancia) throws AlmacenVehiculosException {

        //Si el peso de la mercancia sumado al que teniamos antes en el maletero no supera el limite de peso la añadimos
        if (kgActualesDeCarga() + mercancia.getPesoEnKg() < capacidadMaxima) {

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
