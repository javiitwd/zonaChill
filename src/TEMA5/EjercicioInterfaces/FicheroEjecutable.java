package TEMA5.EjercicioInterfaces;

public class FicheroEjecutable extends FicherosBinarios implements Analizable {

    private int permisos;

    public FicheroEjecutable(String nombre, int tamano, Byte[] bytes, int permisos) {
        super(nombre, tamano, bytes);
        this.permisos = permisos;
    }

    public int getPermisos() {
        return permisos;
    }

    public void setPermisos(int permisos) {
        this.permisos = permisos;
    }

    @Override
    public String toString() {
        return "FicheroEjecutable: " +
                "permisos=" + permisos;
    }

    @Override
    public void analizar() {
        System.out.println("Analizando FicheroEjecutable");
    }
}
