package TEMA6.EjercicioHospital;

public class Paciente implements Comparable<Paciente> {
    public static final int MIN_PRIORIDAD = 1;
    public static final int MAX_PRIORIDAD = 5;

    private String dni;
    private String nombre;
    private int edad;
    private int prioridad;

    public Paciente(String dni, String nombre, int edad, int prioridad) throws HospitalException {
        this.dni = dni;
        this.nombre = nombre;
        this.edad = edad;
        setPrioridad(prioridad);
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
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

    public int getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(int prioridad) throws HospitalException {
        if (prioridad < MIN_PRIORIDAD || prioridad > MAX_PRIORIDAD) {
            throw new HospitalException("La prioridad debe estar entre 1 y 5");
        }
        this.prioridad = prioridad;
    }

    @Override
    public int compareTo(Paciente o) {
        return Integer.compare(prioridad, o.prioridad);
    }

    @Override
    public String toString() {
        return "Paciente: " +
                "dni='" + dni + '\'' +
                ", nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", prioridad=" + prioridad +
                '.' + "\n";
    }
}
