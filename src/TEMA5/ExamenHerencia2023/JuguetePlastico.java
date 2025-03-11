package TEMA5.ExamenHerencia2023;

public class JuguetePlastico extends Juguete{

    private Tplastico tipoPlastico;

    public JuguetePlastico(double precio, String nombre, String marca, Tplastico tipoPlastico) {
        super(precio, nombre, marca);
        this.tipoPlastico = tipoPlastico;
    }

    public Tplastico getTipoPlastico() {
        return tipoPlastico;
    }

    public void setTipoPlastico(Tplastico tipoPlastico) {
        this.tipoPlastico = tipoPlastico;
    }
}
