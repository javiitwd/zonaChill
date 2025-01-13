package TEMA4.EXAMENES_TEMA4.Examen2023;

public class Jugador {
    private String nombre;
    private int edad;
    private int numGolesMarcados;

    public Jugador(String nombre, int edad, int numGolesMarcados) {
        this.nombre = nombre;
        this.edad = edad;
        this.numGolesMarcados = numGolesMarcados;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    //OBTENER NUMERO TOTAL DE GOLES MARCADOS POR EL JUGADOR
    public int getNumGolesMarcados() {
        return numGolesMarcados;
    }

    public void setNumGolesMarcados(int numGolesMarcados) {
        this.numGolesMarcados = numGolesMarcados;
    }

    //ANADIR 1 GOL A LA LISTA DE GOLES MARCADOS
    public void anadirGol() {
        this.setNumGolesMarcados(this.getNumGolesMarcados() + 1);
    }
}
