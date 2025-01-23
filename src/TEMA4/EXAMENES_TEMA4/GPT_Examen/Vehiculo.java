package TEMA4.EXAMENES_TEMA4.GPT_Examen;

public class Vehiculo {
    private String marca;
    private String modelo;
    private int anio;
    private int kilometraje;

    public Vehiculo(String marca, String modelo, int anio) {
        this.marca = marca;
        this.modelo = modelo;
        this.anio = anio;
        kilometraje = 0;
    }

    public int getKilometraje() {
        return kilometraje;
    }

    public void setKilometraje(int kilometraje) {
        this.kilometraje = kilometraje;
    }

    public String getDetalles() {
        return "Marca: " + marca + ", Modelo: " + modelo + ", Año: " + anio;
    }

    public void actualizarKilometraje(int nuevosKm){

        setKilometraje(nuevosKm);
    }
}
