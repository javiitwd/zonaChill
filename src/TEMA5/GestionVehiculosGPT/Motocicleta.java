package TEMA5.GestionVehiculosGPT;

public class Motocicleta extends Vehiculo {

    public static final Tmercancia tmercancia = Tmercancia.NORMAL;
    private double limiteDePesoEnKg;

    public Motocicleta(String matricula, double kmDesdeLaUltimaRevision, boolean mantenimiento, double limiteDePesoEnKg) {
        super(matricula, kmDesdeLaUltimaRevision, mantenimiento);
        this.limiteDePesoEnKg = limiteDePesoEnKg;
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

        if (mercancia.EsRefrigerada()){
            throw new AlmacenVehiculosException("La motocicleta no puede ");
        }

        //Si el peso de la mercancia sumado al que teniamos antes en el maletero no supera el limite de peso la añadimos
        if (kgActualesDeCarga() + mercancia.getPesoEnKg() < limiteDePesoEnKg) {

            super.annadirMercancia(mercancia);
        } else {
            throw new AlmacenVehiculosException("No caben más mercancías");
        }
    }

    @Override
    public void mantener() {
        setKmDesdeLaUltimaRevision(0);
        super.setMantenimiento(true);
    }
}
