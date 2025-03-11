package TEMA6.Examenes.ExamenColecciones2022;

import java.util.Objects;

public class Cromo {

    private int codigoUnico;

    public Cromo(int codigoUnico) {
        this.codigoUnico = codigoUnico;
    }

    public int getCodigoUnico() {
        return codigoUnico;
    }

    public void setCodigoUnico(int codigoUnico) {
        this.codigoUnico = codigoUnico;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cromo cromo = (Cromo) o;
        return codigoUnico == cromo.codigoUnico;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(codigoUnico);
    }

    @Override
    public String toString() {
        return "Codigo unico del cromo: " + codigoUnico;
    }
}
