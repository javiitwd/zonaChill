package TEMA5.GestionVehiculosGPT;

import java.util.ArrayList;
import java.util.List;

public abstract class Vehiculo implements Cargable, Mantenible{

    private String matricula;
    private double kmDesdeLaUltimaRevision;
    private boolean mantenimiento;
    private List<Mercancia> maletero;

    public Vehiculo(String matricula, double kmDesdeLaUltimaRevision, boolean mantenimiento) {
        this.matricula = matricula;
        this.kmDesdeLaUltimaRevision = kmDesdeLaUltimaRevision;
        this.mantenimiento = mantenimiento;
        maletero = new ArrayList<>();
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public double getKmDesdeLaUltimaRevision() {
        return kmDesdeLaUltimaRevision;
    }

    public void setKmDesdeLaUltimaRevision(double kmDesdeLaUltimaRevision) {
        this.kmDesdeLaUltimaRevision = kmDesdeLaUltimaRevision;
    }

    public boolean isMantenimiento() {
        return mantenimiento;
    }

    public void setMantenimiento(boolean mantenimiento) {
        this.mantenimiento = mantenimiento;
    }

    public List<Mercancia> getMaletero() {
        return maletero;
    }

    public void setMaletero(List<Mercancia> maletero) {
        this.maletero = maletero;
    }

    public void annadirMercancia(Mercancia mercancia){

        maletero.add(mercancia);
    }

    @Override
    public abstract void cargar(Mercancia mercancia) throws AlmacenVehiculosException;

    @Override
    public abstract void mantener() throws AlmacenVehiculosException;
}
