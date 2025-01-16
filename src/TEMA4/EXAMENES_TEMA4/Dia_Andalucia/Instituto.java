package TEMA4.EXAMENES_TEMA4.Dia_Andalucia;

public class Instituto {

    private int numAlumnos;
    private float dineroDisponible;
    private double cantidadDeAceite;
    private int cantidadOnzasChocolate;

    public Instituto(int numAlumnos, float dineroDisponible, double cantidadDeAceite, int cantidadOnzasChocolate) {
        this.numAlumnos = numAlumnos;
        this.dineroDisponible = dineroDisponible;
        this.cantidadDeAceite = cantidadDeAceite;
        this.cantidadOnzasChocolate = cantidadOnzasChocolate;
    }

    public int getNumAlumnos() {
        return numAlumnos;
    }

    public void setNumAlumnos(int numAlumnos) {
        this.numAlumnos = numAlumnos;
    }

    public float getDineroDisponible() {
        return dineroDisponible;
    }

    public void setDineroDisponible(float dineroDisponible) {
        this.dineroDisponible = dineroDisponible;
    }

    public double getCantidadDeAceite() {
        return cantidadDeAceite;
    }

    public void setCantidadDeAceite(double cantidadDeAceite) {
        this.cantidadDeAceite = cantidadDeAceite;
    }

    public int getCantidadOnzasChocolate() {
        return cantidadOnzasChocolate;
    }

    public void setCantidadOnzasChocolate(int cantidadOnzasChocolate) {
        this.cantidadOnzasChocolate = cantidadOnzasChocolate;
    }

    /**
     * @return devuelve los atributos de la clase instituto
     */
    @Override
    public String toString() {
        return "Instituto: " +
                "Alumnos: " + getNumAlumnos() +
                ", Dinero disponible: " + getDineroDisponible() +
                ", Cantidad de aceite" + getCantidadDeAceite() +
                ", Cantidad onzas de chocolate: ";

    }
}
